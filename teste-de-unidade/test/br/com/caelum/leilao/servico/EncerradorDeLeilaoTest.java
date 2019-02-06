package br.com.caelum.leilao.servico;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.infra.dao.LeilaoDao;
import br.com.caelum.leilao.infra.dao.LeilaoDaoFalso;

public class EncerradorDeLeilaoTest {
	@Test
	public void deveEncerrarLeiloesQueComecaramUmaSemanaAntes() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(1999, 1, 20);
		
		Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma").naData(antiga).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(antiga).constroi();
		
		//Aqui e preciso salvar no banco de dados os dois leiloes criados...no banco dao
		
		LeilaoDaoFalso dao = new LeilaoDaoFalso();
		dao.salva(leilao1);
		dao.salva(leilao2);
		
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao();
		encerrador.encerra();
		
		List<Leilao> encerrados = dao.encerrados();
		
		assertEquals(2, encerrados.size());
		assertTrue(encerrados.get(0).isEncerrado());
		assertTrue(encerrados.get(1).isEncerrado());
		
	}
}

package br.com.caelum.leilao.servico;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
		
		List<Leilao> leiloesAntigos = Arrays.asList(leilao1, leilao2);
		
		//A partir de agora utilizarei o Mockito para nos auxiliar na criacao de objetos falsos.
		
		// agora pedidos ao Mockito que crie um mock da classe leilaoDao
		
		LeilaoDao daoFalso = mock(LeilaoDao.class);
		
		// Precisamos ensinar o Mock agora, a reagir como esperamos
		
		when(daoFalso.correntes()).thenReturn(leiloesAntigos:)
		
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao();
		encerrador.encerra();
		
		//Nao precisamos mais do dao.encerrados List<Leilao> encerrados = dao.encerrados();
		/*
		pois o dao falso retorna a mesma instancia de valor
		*/
		
		assertEquals(2, encerrados.size());
		assertTrue(leilao1.isEncerrado());
		assertTrue(leilao2.isEncerrado());
		
	}
}

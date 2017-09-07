package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class GerenciadorSessaoTest {

	@Test
	public void DeveRetornarFalsoQuandoNaoCabe() {
		LocalTime duasEMeia = LocalTime.of(14,30);
		Filme f1 = new Filme("Os trapalhoes", Duration.ofMinutes(120),"Aventura", BigDecimal.ONE);
		Sala sala = new Sala("3D", BigDecimal.ONE);
		Sessao s1 = new Sessao(duasEMeia, f1, sala);
		List<Sessao> sessoesExistentes = Arrays.asList(
					new Sessao (LocalTime.of(10,00),new Filme("Titanic",Duration.ofMinutes(90),"Drama", BigDecimal.ONE), sala),
					new Sessao (LocalTime.of(13,00),new Filme("DuckTales",Duration.ofMinutes(120),"Aventura", BigDecimal.ONE), sala),
					new Sessao (LocalTime.of(20,00),new Filme("Hora do Pesadelo",Duration.ofMinutes(120),"Terror", BigDecimal.ONE), sala)
					);
		GerenciadorSessao gs = new GerenciadorSessao(sessoesExistentes);
		Assert.assertFalse(gs.cabe(s1));
	}
	
	@Test
	public void DeveRetornarTrueQuandoVazio() {
		LocalTime duasEMeia = LocalTime.of(14,30);
		Filme f1 = new Filme("Os trapalhoes", Duration.ofMinutes(120),"Aventura", BigDecimal.ONE);
		Sala sala = new Sala("3D", BigDecimal.ONE);
		Sessao s1 = new Sessao(duasEMeia, f1, sala);
		List<Sessao> sessoesExistentes = Arrays.asList();
		GerenciadorSessao gs = new GerenciadorSessao(sessoesExistentes);
		Assert.assertTrue(gs.cabe(s1));	}
}

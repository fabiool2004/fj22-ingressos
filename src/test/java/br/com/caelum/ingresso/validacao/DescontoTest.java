package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.descontos.DescontoBanco;
import br.com.caelum.ingresso.model.descontos.DescontoEstudante;
import br.com.caelum.ingresso.model.descontos.SemDesconto;
public class DescontoTest {

	@Test
	public void Desconto30 () {
		Sala sala = new Sala("Eldorado", new BigDecimal("20.5"));
		Filme filme1 = new Filme("Rogue One", Duration.ofMinutes(90), "SCI-FI", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.now(), filme1, sala);
		Ingresso ingresso = new Ingresso(sessao, new DescontoBanco()); 

		BigDecimal precoEsperado = new BigDecimal("22.75");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	
	@Test
	public void Desconto50 () {
		Sala sala = new Sala("Eldorado", new BigDecimal("20.5"));
		Filme filme1 = new Filme("Rogue One", Duration.ofMinutes(90), "SCI-FI", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.now(), filme1, sala);
		Ingresso ingresso = new Ingresso(sessao, new DescontoEstudante()); 

		BigDecimal precoEsperado = new BigDecimal("16.25");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
	
	@Test
	public void semDesconto() {
		Sala sala = new Sala("Eldorado", new BigDecimal("20.5"));
		Filme filme1 = new Filme("Rogue One", Duration.ofMinutes(90), "SCI-FI", new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.now(), filme1, sala);
		Ingresso ingresso = new Ingresso(sessao, new SemDesconto()); 

		BigDecimal precoEsperado = new BigDecimal("32.5");
		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}
}

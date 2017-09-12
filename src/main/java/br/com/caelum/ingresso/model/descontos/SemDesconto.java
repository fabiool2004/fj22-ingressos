package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.Desconto;

public class SemDesconto implements Desconto{
	
	@Override
	public BigDecimal Aplica (BigDecimal valorOriginal) {
		return valorOriginal;
	}
	
	@Override
	public String getDescricao() {
		return "Normal";
	}
}

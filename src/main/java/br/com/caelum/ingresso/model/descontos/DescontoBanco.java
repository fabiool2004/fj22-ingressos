package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.Desconto;

public class DescontoBanco implements Desconto{
	private BigDecimal desconto = new BigDecimal("0.3");
	
	@Override
	public BigDecimal Aplica (BigDecimal valorOriginal) {
		return valorOriginal.subtract(percentual(valorOriginal));
	}
	
	private BigDecimal percentual (BigDecimal valorOriginal) {
		return valorOriginal.multiply(desconto);
	}
	
	@Override
	public String getDescricao() {
		return "Estudante";
	}
}

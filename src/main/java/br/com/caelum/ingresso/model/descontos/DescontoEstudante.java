package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.Desconto;

public class DescontoEstudante implements Desconto{

	private BigDecimal desconto = new BigDecimal("2.0");
		
	@Override
	public BigDecimal Aplica (BigDecimal valorOriginal) {
		return valorOriginal.divide(desconto);
	}
		
	@Override
	public String getDescricao() {
		return "Estudante";
	}
}

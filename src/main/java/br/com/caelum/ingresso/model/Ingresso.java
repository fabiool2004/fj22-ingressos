package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

public class Ingresso {

	private Sessao sessao;
	private BigDecimal preco;
	
	public Ingresso() {
		
	}
	
	public Ingresso (Sessao sessao, Desconto tipoDesconto) {
		this.sessao = sessao;
		this.preco = tipoDesconto.Aplica(sessao.getPreco());
		
	}
	public BigDecimal getPreco() {
		return preco;
	}

	public Sessao getSessao() {
		return sessao;
	}
}

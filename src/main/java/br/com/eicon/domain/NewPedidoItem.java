package br.com.eicon.domain;

import java.math.BigDecimal;

public class NewPedidoItem {

	private String nome_Produto;
	private BigDecimal valor;
	private Integer quantidade;
	
	public NewPedidoItem(String nome_Produto, BigDecimal valor, Integer quantidade) {
		super();
		this.nome_Produto = nome_Produto;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	public NewPedidoItem() {
	}

	public String getNome_Produto() {
		return nome_Produto;
	}

	public void setNome_Produto(String nome_Produto) {
		this.nome_Produto = nome_Produto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}

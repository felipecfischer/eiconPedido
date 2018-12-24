package br.com.eicon.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class NewPedido {

	private Integer numero_Controle;
	private Timestamp data_Cadastro;
	private List<NewPedidoItem> item;
	private Integer codigo_Cliente;

	public NewPedido(Integer numero_Controle, Timestamp data_Cadastro, List<NewPedidoItem> item, BigDecimal valor,
			Integer quantidade, Integer codigo_Cliente) {
		super();
		this.numero_Controle = numero_Controle;
		this.data_Cadastro = data_Cadastro;
		this.item = item;
		this.codigo_Cliente = codigo_Cliente;
	}

	public NewPedido() {
	}

	public Integer getNumero_Controle() {
		return numero_Controle;
	}

	public void setNumero_Controle(Integer numero_Controle) {
		this.numero_Controle = numero_Controle;
	}

	public Timestamp getData_Cadastro() {
		return data_Cadastro;
	}

	public void setData_Cadastro(Timestamp data_Cadastro) {
		this.data_Cadastro = data_Cadastro;
	}

	public List<NewPedidoItem> getItem() {
		return this.item;
	}

	public void setItem(List<NewPedidoItem> item) {
		this.item = item;
	}

	public Integer getCodigo_Cliente() {
		return codigo_Cliente;
	}

	public void setCodigo_Cliente(Integer codigo_Cliente) {
		this.codigo_Cliente = codigo_Cliente;
	}

	public BigDecimal getValor_Total_Item() {
		BigDecimal vlr_total = this.item.stream()
							    .map(NewPedidoItem::getValor)
							    .reduce(BigDecimal.ZERO, BigDecimal::add);
		return vlr_total;
	}
}

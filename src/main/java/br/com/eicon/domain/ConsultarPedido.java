package br.com.eicon.domain;

public class ConsultarPedido {
	
	private Integer num_pedido;
	private String dt_cadastro;
	
	public ConsultarPedido() {}

	public ConsultarPedido(Integer num_pedido, String dt_cadastro) {
		super();
		this.num_pedido = num_pedido;
		this.dt_cadastro = dt_cadastro;
	}


	public Integer getNum_pedido() {
		return num_pedido;
	}

	public void setNum_pedido(Integer num_pedido) {
		this.num_pedido = num_pedido;
	}

	public String getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(String dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
}

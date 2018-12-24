package br.com.eicon.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="ped_pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ped_n_id;
	
    @OneToOne
	@JoinColumn(name="ped_cli_n_id")
	private Cliente clientepedido;	
	
	private Integer ped_n_num_controle;
	private Timestamp ped_d_dt_cadastro;
	
	@JsonManagedReference
	@OneToMany(mappedBy="pedidoItem")
	private List<Item> itens = new ArrayList<>();
	
	private BigDecimal ped_n_vlr_total;
	private Integer ped_n_desconto;
	private Character ped_c_situacao;
	
	public Pedido() {}

	public Pedido(Integer ped_n_id, Cliente clientePedido, Integer ped_n_num_controle, Timestamp ped_d_dt_cadastro,
			 BigDecimal ped_n_vlr_total, Integer ped_n_desconto, Character ped_c_situacao) {
		super();
		this.ped_n_id = ped_n_id;
		this.clientepedido = clientePedido;
		this.ped_n_num_controle = ped_n_num_controle;
		this.ped_d_dt_cadastro = ped_d_dt_cadastro;
		this.ped_n_vlr_total = ped_n_vlr_total;
		this.ped_n_desconto = ped_n_desconto;
		this.ped_c_situacao = ped_c_situacao;
	}

	public Integer getPed_n_id() {
		return ped_n_id;
	}

	public void setPed_n_id(Integer ped_n_id) {
		this.ped_n_id = ped_n_id;
	}

	public Cliente getClientePedido() {
		return clientepedido;
	}

	public void setClientePedido(Cliente clientePedido) {
		this.clientepedido = clientePedido;
	}

	public Integer getPed_n_num_controle() {
		return ped_n_num_controle;
	}

	public void setPed_n_num_controle(Integer ped_n_num_controle) {
		this.ped_n_num_controle = ped_n_num_controle;
	}

	public Timestamp getPed_d_dt_cadastro() {
		return ped_d_dt_cadastro;
	}

	public void setPed_d_dt_cadastro(Timestamp ped_d_dt_cadastro) {
		this.ped_d_dt_cadastro = ped_d_dt_cadastro;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public BigDecimal getPed_n_vlr_total() {
		return ped_n_vlr_total;
	}

	public void setPed_n_vlr_total(BigDecimal ped_n_vlr_total) {
		this.ped_n_vlr_total = ped_n_vlr_total;
	}

	public Integer getPed_n_desconto() {
		return ped_n_desconto;
	}

	public void setPed_n_desconto(Integer ped_n_desconto) {
		this.ped_n_desconto = ped_n_desconto;
	}

	public Character getPed_c_situacao() {
		return ped_c_situacao;
	}

	public void setPed_c_situacao(Character ped_c_situacao) {
		this.ped_c_situacao = ped_c_situacao;
	}
	
	public void setDesconto() {
		Integer qtd = new Integer(0);
		for (Item item : this.itens) {
			qtd += item.getItm_ped_n_quantidade();
		}
		if (qtd >= 10) {
			this.ped_n_desconto = new Integer(10);
		} else if (qtd > 5) {
			this.ped_n_desconto = new Integer(5);
		} else {
			this.ped_n_desconto = new Integer(0);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ped_n_id == null) ? 0 : ped_n_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (ped_n_id == null) {
			if (other.ped_n_id != null)
				return false;
		} else if (!ped_n_id.equals(other.ped_n_id))
			return false;
		return true;
	}	
}

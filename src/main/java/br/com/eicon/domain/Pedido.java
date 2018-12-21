package br.com.eicon.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ped_pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ped_n_id;
	private Integer ped_cli_n_id;
	private Integer ped_n_num_controle;
	private Timestamp ped_d_dt_cadastro;
	private BigDecimal ped_n_vlr_total;
	private BigDecimal ped_n_desconto;
	private Character ped_c_situacao;

	public Pedido() {
	}

	public Pedido(Integer ped_n_id, Integer ped_cli_n_id, Integer ped_n_num_controle, Timestamp ped_d_dt_cadastro,
			BigDecimal ped_n_vlr_total, BigDecimal ped_n_desconto, Character ped_c_situacao) {
		super();
		this.ped_n_id = ped_n_id;
		this.ped_cli_n_id = ped_cli_n_id;
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

	public Integer getPed_cli_n_id() {
		return ped_cli_n_id;
	}

	public void setPed_cli_n_id(Integer ped_cli_n_id) {
		this.ped_cli_n_id = ped_cli_n_id;
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

	public BigDecimal getPed_n_vlr_total() {
		return ped_n_vlr_total;
	}

	public void setPed_n_vlr_total(BigDecimal ped_n_vlr_total) {
		this.ped_n_vlr_total = ped_n_vlr_total;
	}

	public BigDecimal getPed_n_desconto() {
		return ped_n_desconto;
	}

	public void setPed_n_desconto(BigDecimal ped_n_desconto) {
		this.ped_n_desconto = ped_n_desconto;
	}

	public Character getPed_c_situacao() {
		return ped_c_situacao;
	}

	public void setPed_c_situacao(Character ped_c_situacao) {
		this.ped_c_situacao = ped_c_situacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ped_n_id == null) ? 0 : ped_n_id.hashCode());
		result = prime * result + ((ped_n_num_controle == null) ? 0 : ped_n_num_controle.hashCode());
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
		if (ped_n_num_controle == null) {
			if (other.ped_n_num_controle != null)
				return false;
		} else if (!ped_n_num_controle.equals(other.ped_n_num_controle))
			return false;
		return true;
	}
	
}

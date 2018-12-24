package br.com.eicon.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "itm_ped_item_pedido")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itm_ped_item_pedido_n_id;
	private String itm_ped_itm_c_descricao;
	private BigDecimal itm_ped_n_vlr_itm;
	private Integer itm_ped_n_quantidade;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "itm_ped_ped_n_id")
	private Pedido pedidoItem;

	public Item() {
	}

	public Item(Integer itm_ped_item_pedido_n_id, String itm_ped_itm_c_descricao, BigDecimal itm_ped_n_vlr_itm,
			Integer itm_ped_n_quantidade, Pedido pedidoItem) {
		super();
		this.itm_ped_item_pedido_n_id = itm_ped_item_pedido_n_id;
		this.itm_ped_itm_c_descricao = itm_ped_itm_c_descricao;
		this.itm_ped_n_vlr_itm = itm_ped_n_vlr_itm;
		this.itm_ped_n_quantidade = itm_ped_n_quantidade;
		this.pedidoItem = pedidoItem;
	}

	public Integer getItm_ped_item_pedido_n_id() {
		return itm_ped_item_pedido_n_id;
	}

	public void setItm_ped_item_pedido_n_id(Integer itm_ped_item_pedido_n_id) {
		this.itm_ped_item_pedido_n_id = itm_ped_item_pedido_n_id;
	}

	public String getItm_ped_itm_c_descricao() {
		return itm_ped_itm_c_descricao;
	}

	public void setItm_ped_itm_c_descricao(String itm_ped_itm_c_descricao) {
		this.itm_ped_itm_c_descricao = itm_ped_itm_c_descricao;
	}

	public BigDecimal getItm_ped_n_vlr_itm() {
		return itm_ped_n_vlr_itm;
	}

	public void setItm_ped_n_vlr_itm(BigDecimal itm_ped_n_vlr_itm) {
		this.itm_ped_n_vlr_itm = itm_ped_n_vlr_itm;
	}

	public Integer getItm_ped_n_quantidade() {
		return itm_ped_n_quantidade;
	}

	public void setItm_ped_n_quantidade(Integer itm_ped_n_quantidade) {
		this.itm_ped_n_quantidade = itm_ped_n_quantidade;
	}

	public Pedido getPedidoItem() {
		return pedidoItem;
	}

	public void setPedidoItem(Pedido pedidoItem) {
		this.pedidoItem = pedidoItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itm_ped_item_pedido_n_id == null) ? 0 : itm_ped_item_pedido_n_id.hashCode());
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
		Item other = (Item) obj;
		if (itm_ped_item_pedido_n_id == null) {
			if (other.itm_ped_item_pedido_n_id != null)
				return false;
		} else if (!itm_ped_item_pedido_n_id.equals(other.itm_ped_item_pedido_n_id))
			return false;
		return true;
	}
}

package br.com.eicon.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cli_cliente")
public class Cliente implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cli_n_id;
	private String cli_c_nome;
	private String cli_c_email;
	private Character cli_c_situacao;
		
	public Cliente(Integer cli_n_id) {
		super();
		this.cli_n_id = cli_n_id;
	}
	
	public Cliente() {
	}

	public Cliente(Integer cli_n_id, String cli_c_nome, String cli_c_email, Character cli_c_situacao) {
		super();
		this.cli_n_id = cli_n_id;
		this.cli_c_nome = cli_c_nome;
		this.cli_c_email = cli_c_email;
		this.cli_c_situacao = cli_c_situacao;
	}

	public Integer getCli_n_id() {
		return cli_n_id;
	}

	public void setCli_n_id(Integer cli_n_id) {
		this.cli_n_id = cli_n_id;
	}

	public String getCli_c_nome() {
		return cli_c_nome;
	}

	public void setCli_c_nome(String cli_c_nome) {
		this.cli_c_nome = cli_c_nome;
	}

	public String getCli_c_email() {
		return cli_c_email;
	}

	public void setCli_c_email(String cli_c_email) {
		this.cli_c_email = cli_c_email;
	}

	public Character getCli_c_situacao() {
		return cli_c_situacao;
	}

	public void setCli_c_situacao(Character cli_c_situacao) {
		this.cli_c_situacao = cli_c_situacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cli_n_id == null) ? 0 : cli_n_id.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cli_n_id == null) {
			if (other.cli_n_id != null)
				return false;
		} else if (!cli_n_id.equals(other.cli_n_id))
			return false;
		return true;
	}	
	
	
}

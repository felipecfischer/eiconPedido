package br.com.eicon.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eicon.DAO.DAO;
import br.com.eicon.domain.ConsultarPedido;
import br.com.eicon.domain.Pedido;
import br.com.eicon.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public boolean inserirAtualizar(Pedido newPedido) {
		boolean k_ok = true;
		try {
			pedidoRepository.save(newPedido);
		} catch (Exception e) {
			k_ok = false;
		}
		return k_ok;
	}

	public Pedido consultar(Integer id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido.orElse(null);
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> consultarPedido(ConsultarPedido c_pedido) {
		Session sess = DAO.getSession();

		Query consult = sess.createSQLQuery("CALL consulta_pedido(:dtCadastro, :numPedido)");
		consult.setParameter("dtCadastro", c_pedido.getDt_cadastro());
		consult.setParameter("numPedido", c_pedido.getNum_pedido());

		List<Pedido> pedidos = pedidoRepository.findAllById(consult.getResultList());
		sess.close();
		return pedidos;
	}
}
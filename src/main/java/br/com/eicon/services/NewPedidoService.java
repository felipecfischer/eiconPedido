package br.com.eicon.services;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eicon.DAO.DAO;
import br.com.eicon.domain.Item;
import br.com.eicon.domain.NewPedido;
import br.com.eicon.domain.NewPedidoItem;
import br.com.eicon.domain.Pedido;

@Service
public class NewPedidoService {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private ItemService itemService;

	public void inserirPedido(List<NewPedido> newPedidos) {
		
		if (newPedidos.size() > 0 && newPedidos.size() < 11) {
			Session sess = DAO.getSession();
			
			for (NewPedido newPedido : newPedidos) {
				Pedido pedido = new Pedido(null, clienteService.consultar(newPedido.getCodigo_Cliente()),
						newPedido.getNumero_Controle(),
						newPedido.getData_Cadastro() == null ? new java.sql.Timestamp(System.currentTimeMillis()) : newPedido.getData_Cadastro(),
						newPedido.getValor_Total_Item(), new Integer(0), 'A');

				Query consult = sess.createSQLQuery("SELECT count(*) FROM ped_pedido WHERE ped_n_num_controle = :numControle");
				consult.setParameter("numControle", newPedido.getNumero_Controle());
				int k_result = Integer.parseInt(consult.getResultList().get(0).toString());
				
				if (k_result == 0) {
					Transaction tran = sess.beginTransaction();
					try {
						pedidoService.inserirAtualizar(pedido);
						for (NewPedidoItem itm : newPedido.getItem()) {
							pedido.getItens().add(new Item(null, itm.getNome_Produto(), itm.getValor(),
									itm.getQuantidade() == null ? 1 : itm.getQuantidade(), pedido));
						}						
						if ( itemService.inserir(pedido.getItens())) {							
							if (pedido.getItens().size() > 1) {
								pedido.setDesconto();
								pedidoService.inserirAtualizar(pedido);
							}
							tran.commit();
						} else {
							tran.rollback();
						}
					} catch (HibernateException exObj) {
						if (tran != null) {
							tran.rollback();
						}
					}
				}
			}
			sess.close();
		}
	}
}
package br.com.eicon.services;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		/**
		 * Pedidos até 10
		 */
		if (newPedidos.size() > 0 
				&& newPedidos.size() < 11) {
			
			for (NewPedido newPedido : newPedidos) {
				Pedido pedido = new Pedido(null, 
											clienteService.consultar(newPedido.getCodigo_Cliente()),
											newPedido.getNumero_Controle(), 
											newPedido.getData_Cadastro() == null ? new java.sql.Timestamp(System.currentTimeMillis()) : newPedido.getData_Cadastro(),
											newPedido.getValor_Total_Item(), 
											new Integer(0), 
											'A');
				
				pedidoService.inserirAtualizar(pedido);
				
				for (NewPedidoItem itm : newPedido.getItem()) {					
					pedido.getItens().add(new Item(null, itm.getNome_Produto(), itm.getValor(), itm.getQuantidade() == null ? 1 : itm.getQuantidade(), pedido));
				}
				//Criteria crit = sess.createCriteria(Pedido.class);
				if (newPedido.getItem().size() > 1) {
					pedido.setDesconto();
					pedidoService.inserirAtualizar(pedido);
				}
				itemService.inserir(pedido.getItens());
			}
		}
	}
}
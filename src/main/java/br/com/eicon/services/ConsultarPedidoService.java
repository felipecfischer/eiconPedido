package br.com.eicon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eicon.domain.ConsultarPedido;
import br.com.eicon.domain.Pedido;

@Service
public class ConsultarPedidoService {
	
	@Autowired
	private PedidoService pedidoService;
	
	public List<Pedido> consultarPedido(ConsultarPedido c_pedido) {		
		return pedidoService.consultarPedido(c_pedido);
	}
}
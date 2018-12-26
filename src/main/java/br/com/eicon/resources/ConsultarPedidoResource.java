package br.com.eicon.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eicon.domain.ConsultarPedido;
import br.com.eicon.domain.Pedido;
import br.com.eicon.services.ConsultarPedidoService;

@RestController
public class ConsultarPedidoResource {

	@Autowired
	private ConsultarPedidoService consultarPedidoService;
	
	@RequestMapping(value="/consultarPedido", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> consultaPedidos(@RequestBody ConsultarPedido c_pedido) {
		List<Pedido> pedido = consultarPedidoService.consultarPedido(c_pedido);		
		return ResponseEntity.ok().body(pedido);
	}
}

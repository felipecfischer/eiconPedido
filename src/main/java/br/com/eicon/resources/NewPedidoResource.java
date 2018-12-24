package br.com.eicon.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.eicon.domain.NewPedido;
import br.com.eicon.services.NewPedidoService;

@RestController
public class NewPedidoResource {

	@Autowired
	private NewPedidoService pedidoService;	
	
	@PostMapping(value="/newPedido", 
			     produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void newPedido(@RequestBody List<NewPedido> newPedido) {
		pedidoService.inserirPedido(newPedido);
	}	
}

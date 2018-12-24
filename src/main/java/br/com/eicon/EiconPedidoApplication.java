package br.com.eicon;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.eicon.domain.Item;
import br.com.eicon.domain.Pedido;
import br.com.eicon.repositories.ItemRepository;
import br.com.eicon.repositories.PedidoRepository;

//import br.com.eicon.repositories.ItemRepository;
//import br.com.eicon.repositories.PedidoRepository;

@SpringBootApplication
public class EiconPedidoApplication implements CommandLineRunner{

	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EiconPedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//Pedido pedido = new Pedido(null, 3, 150, new java.sql.Timestamp(System.currentTimeMillis()), new BigDecimal(300), new BigDecimal(0), 'A');
	//pedidoRepository.save(pedido);
	//
	//Item itm1 = new Item(null, "HAMBURGUER", new BigDecimal(15.50), pedido);
	//Item itm2 = new Item(null, "COCA-COLA", new BigDecimal(6.50), pedido);
	//itemRepository.saveAll(Arrays.asList(itm1, itm2));
	}

}


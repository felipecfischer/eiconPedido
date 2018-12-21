package br.com.eicon;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.eicon.domain.Pedido;
import br.com.eicon.repositories.PedidoRepository;

@SpringBootApplication
public class EiconPedidoApplication implements CommandLineRunner{

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EiconPedidoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pedido pedido1 = new Pedido(null, 3, 3, new java.sql.Timestamp(System.currentTimeMillis()), new BigDecimal(300), new BigDecimal(0), 'A');
		Pedido pedido2 = new Pedido(null, 4, 4, new java.sql.Timestamp(System.currentTimeMillis()), new BigDecimal(300), new BigDecimal(0), 'A');
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
	}

}


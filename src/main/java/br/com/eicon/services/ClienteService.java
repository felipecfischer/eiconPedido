package br.com.eicon.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eicon.domain.Cliente;
import br.com.eicon.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente consultar(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElse(null);
	}
}
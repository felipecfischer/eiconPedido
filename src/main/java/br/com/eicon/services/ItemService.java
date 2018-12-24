package br.com.eicon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eicon.domain.Item;
import br.com.eicon.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public void inserir(List<Item> PedidoItem) {
		itemRepository.saveAll(PedidoItem);
	}
}
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
	
	public boolean inserir(List<Item> PedidoItem) {
		boolean k_ok = true;
		try {
			itemRepository.saveAll(PedidoItem);
		} catch (Exception e) {
			k_ok = false;
		} 
		return k_ok;
	}
}
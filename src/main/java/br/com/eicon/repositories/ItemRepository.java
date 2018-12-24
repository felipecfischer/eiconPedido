package br.com.eicon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eicon.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}

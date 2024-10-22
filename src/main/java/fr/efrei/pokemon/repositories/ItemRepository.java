package fr.efrei.pokemon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.pokemon.modele.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>{

}

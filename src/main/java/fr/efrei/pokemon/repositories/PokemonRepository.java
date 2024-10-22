package fr.efrei.pokemon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import fr.efrei.pokemon.modele.Pokemon;
import org.springframework.stereotype.*;


@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, String>{

}

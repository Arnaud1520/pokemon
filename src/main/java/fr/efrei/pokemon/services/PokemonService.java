package fr.efrei.pokemon.services;

import org.springframework.stereotype.Service;

import fr.efrei.pokemon.modele.Pokemon;
import fr.efrei.pokemon.repositories.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PokemonService {
	
	private PokemonRepository pokemonRepository;
	
	@Autowired
	public PokemonService(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}
	
	public List<Pokemon> findAll(){
		
		return pokemonRepository.findAll();
	}
	
	public Pokemon findById(String id) {
		//optional : soit l'objet soit null
		//SELECT * FROM id WHERE id = :id
		return pokemonRepository.findById(id).orElse(null);
	}
	//trajet de la donnée
	//Controller -> Service -> Repository -> Entité -> BDD
	public void save(Pokemon pokemon) {
		pokemonRepository.save(pokemon);
	}
	
	public void delete(String id) {
		pokemonRepository.deleteById(id);
	}
	
	public void update(String id, Pokemon pokemonBody) {
		Pokemon pokemonAModifier = findById(id);
		pokemonAModifier.setType(pokemonBody.getType());
		pokemonAModifier.setName(pokemonBody.getName());
		pokemonAModifier.setHp(pokemonBody.getHp());
		pokemonAModifier.setLevel(pokemonBody.getLevel());
		pokemonRepository.save(pokemonAModifier);
	}
	
	public void partialUpdate(String id, Pokemon pokemonBody) {
		Pokemon pokemonAModifier = findById(id);
		if (pokemonBody.getType() != null) {
			pokemonAModifier.setType(pokemonBody.getType());
		}
		if (pokemonBody.getName() != null) {
			pokemonAModifier.setName(pokemonBody.getName());
		}
		if (pokemonBody.getHp() != 0) {
			pokemonAModifier.setHp(pokemonBody.getHp());
		}
		if (pokemonBody.getLevel() != 0) {
			pokemonAModifier.setLevel(pokemonBody.getLevel());
		}
		
		pokemonRepository.save(pokemonAModifier);
	}

}

package fr.efrei.pokemon.dto;

import java.util.List;

public class BattleDto {
    private String trainer1Id;
    private String trainer2Id;
    private List<String> pokemonIds; // Liste des IDs des Pokémon à associer au combat
    
	public String getTrainer1Id() {
		return trainer1Id;
	}
	public void setTrainer1Id(String trainer1Id) {
		this.trainer1Id = trainer1Id;
	}
	public String getTrainer2Id() {
		return trainer2Id;
	}
	public void setTrainer2Id(String trainer2Id) {
		this.trainer2Id = trainer2Id;
	}
	public List<String> getPokemonIds() {
		return pokemonIds;
	}
	public void setPokemonIds(List<String> pokemonIds) {
		this.pokemonIds = pokemonIds;
	}

    
}

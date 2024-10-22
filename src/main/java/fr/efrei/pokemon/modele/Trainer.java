package fr.efrei.pokemon.modele;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID) //AUTO INCREMENT
	private String id;
	
	private String name;

	@OneToMany
	private List<Pokemon> team;
	
	@OneToMany
	private List<Item> item;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pokemon> getTeam() {
		return team;
	}

	public void setTeam(List<Pokemon> team) {
		this.team = team;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
	
	
	
}

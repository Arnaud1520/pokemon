package fr.efrei.pokemon.dto;

import java.util.List;

public class UpdateTrainer {

	private String name;
	
	private List<String> team;
	
	private List<String> item;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTeam() {
		return team;
	}

	public void setTeam(List<String> team) {
		this.team = team;
	}

	public List<String> getItem() {
		return item;
	}

	public void setItem(List<String> item) {
		this.item = item;
	}
	
	
}

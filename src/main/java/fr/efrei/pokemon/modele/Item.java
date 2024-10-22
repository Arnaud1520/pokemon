package fr.efrei.pokemon.modele;


import fr.efrei.pokemon.constants.NameItem;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID) //AUTO INCREMENT
	private String id;
	
	@Enumerated(EnumType.STRING)
	private NameItem name;
	
	private String description;
	
	private int price;
	
	private int quantity;
	
	
	public Item() {
		
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public NameItem getName() {
		return name;
	}

	public void setName(NameItem name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}

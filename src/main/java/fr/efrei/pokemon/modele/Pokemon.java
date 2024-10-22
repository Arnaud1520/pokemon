package fr.efrei.pokemon.modele;
import jakarta.persistence.*;
import fr.efrei.pokemon.constants.Type;

@Entity
public class Pokemon {

@Id
@GeneratedValue(strategy = GenerationType.UUID) //AUTO INCREMENT
private String id;
	
private String name;

@Enumerated(EnumType.STRING)
private Type type;
	
private int level;
	
private int hp;

public Pokemon() {
	
}

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

public Type getType() {
	return type;
}

public void setType(Type type) {
	this.type = type;
}

public int getLevel() {
	return level;
}

public void setLevel(int level) {
	this.level = level;
}

public int getHp() {
	return hp;
}

public void setHp(int hp) {
	this.hp = hp;
}


}

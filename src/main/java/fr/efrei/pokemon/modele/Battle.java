package fr.efrei.pokemon.modele;


import java.util.List;

import jakarta.persistence.*;

@Entity
public class Battle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "trainer1_id", nullable = false)
    private Trainer trainer1;

    @ManyToOne
    @JoinColumn(name = "trainer2_id", nullable = false)
    private Trainer trainer2;

    @ManyToMany
    @JoinTable(
        name = "battle_pokemon",
        joinColumns = @JoinColumn(name = "battle_id"),
        inverseJoinColumns = @JoinColumn(name = "pokemon_id")
    )
    private List<Pokemon> pokemonAuCombat;


    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Trainer getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(Trainer trainer1) {
        this.trainer1 = trainer1;
    }

    public Trainer getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(Trainer trainer2) {
        this.trainer2 = trainer2;
    }

    public List<Pokemon> getPokemonAuCombat() {
        return pokemonAuCombat;
    }

    public void setPokemonAuCombat(List<Pokemon> pokemonInBattle) {
        this.pokemonAuCombat = pokemonInBattle;
    }

    
}

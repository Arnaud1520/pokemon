package fr.efrei.pokemon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon.dto.CreateTrainer;
import fr.efrei.pokemon.dto.UpdateTrainer;
import fr.efrei.pokemon.modele.Item;
import fr.efrei.pokemon.modele.Pokemon;
import fr.efrei.pokemon.modele.Trainer;
import fr.efrei.pokemon.repositories.TrainerRepository;
import jakarta.transaction.Transactional;

@Service
public class TrainerService {

    private final TrainerRepository repository;
    private final PokemonService pokemonService;
    private final ItemService itemService; 

    @Autowired
    public TrainerService(TrainerRepository repository, PokemonService pokemonService, ItemService itemService) {
        this.repository = repository;
        this.pokemonService = pokemonService;
        this.itemService = itemService; 
    }

    public List<Trainer> findAll() {
        return repository.findAll();
    }

    public Trainer findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void save(CreateTrainer trainerBody) {
        Trainer trainer = new Trainer();
        trainer.setName(trainerBody.getName());
        List<String> pokemonIds = trainerBody.getTeam();

        List<Pokemon> pokemonAAjouter = new ArrayList<>();
        for (String idPokemon : pokemonIds) {
            Pokemon pokemon = pokemonService.findById(idPokemon);
            if (pokemon != null) {
                pokemonAAjouter.add(pokemon);
            }
        }

        trainer.setTeam(pokemonAAjouter);
        repository.save(trainer);
    }

    @Transactional
    public void update(String id, UpdateTrainer trainerBody) {
        Trainer trainer = findById(id);
        

        if (trainerBody.getName() != null) {
            trainer.setName(trainerBody.getName());
        }

        
        if (trainerBody.getTeam() != null && !trainerBody.getTeam().isEmpty()) {
            List<Pokemon> pokemonList = new ArrayList<>();
            List<String> pokemonIds = trainerBody.getTeam();

            for (String idPokemon : pokemonIds) {
                Pokemon pokemon = pokemonService.findById(idPokemon);
                if (pokemon != null) {
                    pokemonList.add(pokemon);
                }
            }
            pokemonList.addAll(trainer.getTeam());
            trainer.setTeam(pokemonList);
        }

        if (trainerBody.getItem() != null && !trainerBody.getItem().isEmpty()) { 
            List<Item> itemList = new ArrayList<>();
            List<String> itemIds = trainerBody.getItem(); 

            for (String idItem : itemIds) {
                Item item = itemService.findById(idItem);
                if (item != null) {
                    itemList.add(item);
                }
            }
            trainer.getItem().addAll(itemList); 
        }
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}

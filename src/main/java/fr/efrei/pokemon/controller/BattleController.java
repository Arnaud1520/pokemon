package fr.efrei.pokemon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.efrei.pokemon.dto.BattleDto;
import fr.efrei.pokemon.modele.Battle;
import fr.efrei.pokemon.modele.Pokemon;
import fr.efrei.pokemon.modele.Trainer;
import fr.efrei.pokemon.services.BattleService;
import fr.efrei.pokemon.services.PokemonService; 
import fr.efrei.pokemon.services.TrainerService; 

@RestController
@RequestMapping("/battles")
public class BattleController {

    private final BattleService battleService;
    private final TrainerService trainerService; 
    private final PokemonService pokemonService; 

    @Autowired
    public BattleController(BattleService battleService, TrainerService trainerService, PokemonService pokemonService) {
        this.battleService = battleService;
        this.trainerService = trainerService; 
        this.pokemonService = pokemonService; 
    }

    @GetMapping
    public ResponseEntity<List<Battle>> findAll() {
        return new ResponseEntity<>(battleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Battle> findById(@PathVariable String id) {
        Battle battle = battleService.findById(id);
        if (battle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(battle, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Battle> createBattle(@RequestBody BattleDto battleDTO) {
        Trainer trainer1 = trainerService.findById(battleDTO.getTrainer1Id());
        Trainer trainer2 = trainerService.findById(battleDTO.getTrainer2Id());

        if (trainer1 == null || trainer2 == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Battle battle = new Battle();
        battle.setTrainer1(trainer1);
        battle.setTrainer2(trainer2);

        
        List<Pokemon> pokemonsInBattle = new ArrayList<>();
        for (String pokemonId : battleDTO.getPokemonIds()) {
            Pokemon pokemon = pokemonService.findById(pokemonId);
            if (pokemon != null) {
                pokemonsInBattle.add(pokemon);
            }
        }

        battle.setPokemonAuCombat(pokemonsInBattle); 

        battleService.save(battle); 
        return new ResponseEntity<>(battle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Battle battleDetails) {
        battleService.update(id, battleDetails);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        battleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package fr.efrei.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon.dto.CreateTrainer;
import fr.efrei.pokemon.dto.UpdateTrainer;
import fr.efrei.pokemon.modele.Pokemon;
import fr.efrei.pokemon.modele.Trainer;
import fr.efrei.pokemon.services.TrainerService;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

	private final TrainerService trainerService;
	
	@Autowired
	public TrainerController(TrainerService trainerService) {
		this.trainerService = trainerService;
	}
	
	@GetMapping
	public ResponseEntity<List<Trainer>> findAll(){
		return new ResponseEntity<>(trainerService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Trainer> findById(@PathVariable String id){
		Trainer trainer = trainerService.findById(id);
		if (trainer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(trainer, HttpStatus.OK);
	}
	
	
	//Recup les pokemons du dresseur
	@GetMapping("/{id}/pokemons")
	public ResponseEntity<List<Pokemon>> getPokemonsByTrainerId(@PathVariable String id) {
	    Trainer trainer = trainerService.findById(id);
	    if (trainer == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(trainer.getTeam(), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody CreateTrainer trainer){
		trainerService.save(trainer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody UpdateTrainer trainerBody) {
		Trainer trainer = trainerService.findById(id);
		if (trainer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		trainerService.update(id, trainerBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		Trainer trainer = trainerService.findById(id);
		if (trainer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		trainerService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}



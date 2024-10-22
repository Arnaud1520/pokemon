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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon.modele.Pokemon;
import fr.efrei.pokemon.services.PokemonService;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

	private final PokemonService service;
	
	
	@Autowired
	public PokemonController(PokemonService service) {
		this.service = service;
	}
	
	//GET 
	
	 @GetMapping
	 public ResponseEntity<List<Pokemon>> findAll(){
		 return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Pokemon> findById(@PathVariable String id){
		 Pokemon pokemon = service.findById(id);
		 if (pokemon == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	 }
	 
	 
	 
	 //POST
	 
	 @PostMapping
	 public ResponseEntity<?> create(@RequestBody Pokemon pokemon) {
		 service.save(pokemon);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	 }
	 
	 //PUT
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<?> update(@PathVariable String id, @RequestBody Pokemon pokemon){
		 Pokemon pokemonAModifier = service.findById(id);
		 if (pokemonAModifier == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 
	 //DELETE
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<?> delete (@PathVariable String id){
		 Pokemon pokemon = service.findById(id);
		 if (pokemon == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		 }
		 service.delete(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 
	 //PATCH
	 
	 @PatchMapping("{id}")
	 public ResponseEntity<?> partialUpdate(@PathVariable String id, @RequestBody Pokemon pokemonBody){
		 Pokemon pokemon = service.findById(id);
		 if (pokemon == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 
		 service.partialUpdate(id, pokemonBody);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
}

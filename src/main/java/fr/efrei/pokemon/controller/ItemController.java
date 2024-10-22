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


import fr.efrei.pokemon.modele.Item;
import fr.efrei.pokemon.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    
 // POST
    @PostMapping
	 public ResponseEntity<?> create(@RequestBody Item item) {
		 itemService.save(item);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	 }
    
 // GET
    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Item> findById(@PathVariable String id) {
        Item item = itemService.findById(id);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
 // PUT
    @PutMapping("/{id}")
	 public ResponseEntity<?> update(@PathVariable String id, @RequestBody Item item){
		 Item itemUpdate = itemService.findById(id);
		 if (itemUpdate == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
    
    //PATCH
    @PatchMapping("{id}")
	 public ResponseEntity<?> partialUpdate(@PathVariable String id, @RequestBody Item itemBody){
		Item item = itemService.findById(id);
		 if (item == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 
		 itemService.partialUpdate(id, itemBody);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }

    
 // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
    	Item item = itemService.findById(id);
		 if (item == null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		 }
		 itemService.delete(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    
}

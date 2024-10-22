package fr.efrei.pokemon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon.modele.Item;
import fr.efrei.pokemon.repositories.ItemRepository;


@Service
public class ItemService {

	 private final ItemRepository itemRepository;
	 
	 @Autowired
	    public ItemService(ItemRepository itemRepository) {
	        this.itemRepository = itemRepository;
	    }
	 
	 public List<Item> findAll() {
	        return itemRepository.findAll();
	    }
	 
	 public void save(Item item) {
	         itemRepository.save(item);
	    }
	 
	 public Item findById(String id) {
			//optional : soit l'objet soit null
			//SELECT * FROM id WHERE id = :id
			return itemRepository.findById(id).orElse(null);
		}
	 
	 public void update(String id, Item itemDetails) {
	        Item item = findById(id);
	        
	            item.setName(itemDetails.getName());
	            item.setDescription(itemDetails.getDescription());
	            item.setQuantity(itemDetails.getQuantity());
	            itemRepository.save(item);
	             
	    }
	 
	 public void partialUpdate(String id, Item itemBody) {
		    Item itemAModifier = findById(id); 
		    
		    if (itemBody.getName() != null) {
		        itemAModifier.setName(itemBody.getName());
		    }
		    if (itemBody.getDescription() != null) {
		        itemAModifier.setDescription(itemBody.getDescription());
		    }
		    if (itemBody.getPrice() != 0) {
		        itemAModifier.setPrice(itemBody.getPrice());
		    }
		    
		    if (itemBody.getQuantity() != 0) {
		        itemAModifier.setQuantity(itemBody.getQuantity());
		    }

		    
		    itemRepository.save(itemAModifier);
		}

	 
	 public void delete(String id) {
	        itemRepository.deleteById(id);
	    }
}

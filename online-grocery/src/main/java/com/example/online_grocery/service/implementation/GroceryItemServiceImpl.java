package com.example.online_grocery.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_grocery.exception.ResourceNotFoundException;
import com.example.online_grocery.model.GroceryItem;
import com.example.online_grocery.repository.GroceryItemRepository;
import com.example.online_grocery.service.GroceryItemService;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {
  
  @Autowired  
  private GroceryItemRepository groceryItemRepository;
  
  @Override
  public List<GroceryItem> getAllGroceryItems() {
   return groceryItemRepository.findAll();
  }
  
  @Override
  public GroceryItem getGroceryItemById(Long id) {
    return groceryItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Grocery item not found with id: " + id));
  }

  @Override
  public GroceryItem createGroceryItem(GroceryItem groceryItem) {
    return groceryItemRepository.save(groceryItem);
  }

  @Override
  public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItemDetails) {
    GroceryItem existingItem = getGroceryItemById(id);
    existingItem.setName(groceryItemDetails.getName());
    existingItem.setCategory(groceryItemDetails.getCategory());
    existingItem.setPrice(groceryItemDetails.getPrice());
    existingItem.setQuantity(groceryItemDetails.getQuantity());
    return groceryItemRepository.save(existingItem);
  }

  @Override
  public void deleteGroceryItem(Long id) {
    GroceryItem existingItem = getGroceryItemById(id);
    groceryItemRepository.delete(existingItem);    
  }






  
}

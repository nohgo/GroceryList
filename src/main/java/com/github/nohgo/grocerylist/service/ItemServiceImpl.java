package com.github.nohgo.grocerylist.service;

import com.github.nohgo.grocerylist.models.GroceryItem;
import com.github.nohgo.grocerylist.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Override
    public String save(GroceryItem item) {
        return itemRepository.save(item).getId();
    }
    @Override
    public List<GroceryItem> getItemsFromName(String name) {
        return itemRepository.findByName(name);
    }
    @Override
    public void delete(String id) {
        itemRepository.deleteById(id);
    }
    @Override
    public List<GroceryItem> getByCategory(String category) {
        return itemRepository.findByCategory(category);
    }
}

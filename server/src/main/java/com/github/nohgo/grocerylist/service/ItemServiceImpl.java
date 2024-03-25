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
    public List<GroceryItem> getItemsFromIds(List<String> ids) {
        return itemRepository.findAllItems(ids);
    }
    @Override
    public String addItem(GroceryItem item) {
        return itemRepository.save(item).getId();
    }

    @Override
    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }


}

package com.github.nohgo.grocerylist.service;

import com.github.nohgo.grocerylist.models.GroceryItem;

import java.util.List;

public interface ItemService {
    String save (GroceryItem item);
    List<GroceryItem> getItemsFromName(String name);
    void delete(String id);
    List<GroceryItem> getByCategory(String category);
}

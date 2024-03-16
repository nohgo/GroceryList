package com.github.nohgo.grocerylist.service;

import com.github.nohgo.grocerylist.models.GroceryItem;

import java.util.List;

public interface ItemService {

    List<GroceryItem> getItemsFromIds(List<String> ids);

    String addItem(GroceryItem item);

    void deleteItem(String id);
}

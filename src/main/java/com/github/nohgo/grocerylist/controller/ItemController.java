package com.github.nohgo.grocerylist.controller;

import com.github.nohgo.grocerylist.models.GroceryItem;
import com.github.nohgo.grocerylist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public String save(@RequestBody GroceryItem item){
        return itemService.save(item);
    }
}

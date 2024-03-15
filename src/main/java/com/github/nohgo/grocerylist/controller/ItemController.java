package com.github.nohgo.grocerylist.controller;

import com.github.nohgo.grocerylist.models.GroceryItem;
import com.github.nohgo.grocerylist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String save(@RequestBody GroceryItem item){
        return itemService.save(item);
    }
    @GetMapping("/getItemsFromName")
    public List<GroceryItem> getItemsFromName(@RequestParam("name") String name){
        return itemService.getItemsFromName(name);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") String id){
        itemService.delete(id);
    }
    @GetMapping("/getByCategory")
    public List<GroceryItem> getByCategory(@RequestParam("category") String category){
        return itemService.getByCategory(category);
    }

}

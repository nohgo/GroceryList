package com.github.nohgo.grocerylist.controller;

import com.github.nohgo.grocerylist.models.GroceryItem;
import com.github.nohgo.grocerylist.models.User;
import com.github.nohgo.grocerylist.security.services.AuthService;
import com.github.nohgo.grocerylist.service.ItemService;
import com.github.nohgo.grocerylist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    @GetMapping("/getItems")
    public List<GroceryItem> getItems(){

        User user = authService.getAuthenticatedUser();
        return itemService.getItemsFromIds(user.getItems());
    }
    @PostMapping("/addItem")
    public ResponseEntity<?> addItem(@RequestBody(required = false) GroceryItem item){

        if (item == null || item.isNull()) {
            return ResponseEntity.badRequest().body("Item cannot be null");
        }

        User user = authService.getAuthenticatedUser();
        user.addItem(itemService.addItem(item));
        userService.save(user);

        return ResponseEntity.ok("Item added successfully");
    }
    @DeleteMapping("/deleteItem")
    public ResponseEntity<?> deleteItem(@RequestParam String id){
        User user = authService.getAuthenticatedUser();

        if (user.hasItem(id)) {
            itemService.deleteItem(id);
            user.removeItem(id);
            userService.save(user);

            return ResponseEntity.ok("Item deleted successfully");
        }
        return ResponseEntity.badRequest().body("Item not found");
    }

}

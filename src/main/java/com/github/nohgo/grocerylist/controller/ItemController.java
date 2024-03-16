package com.github.nohgo.grocerylist.controller;

import com.github.nohgo.grocerylist.models.GroceryItem;
import com.github.nohgo.grocerylist.models.User;
import com.github.nohgo.grocerylist.security.services.UserDetailsImpl;
import com.github.nohgo.grocerylist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.github.nohgo.grocerylist.service.UserService;

import java.util.List;

@RestController
@RequestMapping("")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;

    @GetMapping("/getItems")
    public List<GroceryItem> getItems(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String username = userDetails.getUsername();

        User user = userService.getByUsername(username);

        return itemService.getItemsFromIds(user.getItems());
    }
    @PostMapping("/addItem")
    public ResponseEntity<?> addItem(@RequestBody GroceryItem item){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String username = userDetails.getUsername();

        User user = userService.getByUsername(username);
        user.addItem(itemService.addItem(item));
        userService.save(user);

        return ResponseEntity.ok("Item added successfully");
    }
    @DeleteMapping("/deleteItem")
    public ResponseEntity<?> deleteItem(@RequestParam String id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String username = userDetails.getUsername();

        User user = userService.getByUsername(username);
        itemService.deleteItem(id);
        user.removeItem(id);
        userService.save(user);

        return ResponseEntity.ok("Item deleted successfully");
    }

}

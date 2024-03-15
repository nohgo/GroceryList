package com.github.nohgo.grocerylist.repository;

import com.github.nohgo.grocerylist.models.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, String> {

    List<GroceryItem> findByName(String name);
    List<GroceryItem> findByCategory(String category);
}

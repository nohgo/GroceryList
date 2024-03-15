package com.github.nohgo.grocerylist.repository;

import com.github.nohgo.grocerylist.models.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, String> {
}

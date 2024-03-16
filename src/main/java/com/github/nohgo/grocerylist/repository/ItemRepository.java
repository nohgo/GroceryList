package com.github.nohgo.grocerylist.repository;

import com.github.nohgo.grocerylist.models.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, String> {

    @Query(value = "{ '_id' : {'$in' : ?0 } }")
    List<GroceryItem> findAllItems(List<String> ids);

}

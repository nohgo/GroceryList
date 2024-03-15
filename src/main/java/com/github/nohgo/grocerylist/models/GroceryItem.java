package com.github.nohgo.grocerylist.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@Builder
@Document(collection = "grocery-item")
public class GroceryItem {

    @Id
    private String id;
    private String name;
    private int quantity;
    private String category;

    @Override
    public String toString() {
        return "GroceryItem [id=" + id + ", name=" + name + ", quantity=" + quantity + ", category=" + category + "]";
    }
}

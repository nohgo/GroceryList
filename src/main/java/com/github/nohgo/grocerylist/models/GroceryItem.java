package com.github.nohgo.grocerylist.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@Document(collection = "grocery-item")
@AllArgsConstructor
public class GroceryItem {
    @MongoId
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;
    private String name;
    private int quantity;
    private String category;
}

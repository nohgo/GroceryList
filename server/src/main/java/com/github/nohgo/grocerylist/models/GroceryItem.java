package com.github.nohgo.grocerylist.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "grocery-item")
@AllArgsConstructor
public class GroceryItem {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;
    private String name;
    private int quantity;
    private String category;

    public String toString() {
        return "GroceryItem(id=" + this.getId() + ", name=" + this.getName() + ", quantity=" + this.getQuantity() + ", category=" + this.getCategory() + ")";
    }
    public boolean isNull() {
        return this.getId() == null || this.getName() == null || this.getQuantity() == 0 || this.getCategory() == null;
    }
}

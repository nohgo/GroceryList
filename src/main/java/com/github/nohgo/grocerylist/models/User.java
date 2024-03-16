package com.github.nohgo.grocerylist.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@Document("users")
public class User {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    List<String> items;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        items = new ArrayList<>();
    }
    public void addItem(String id){
        items.add(id);
    }
    public void removeItem(String id){
        items.remove(id);
    }

}

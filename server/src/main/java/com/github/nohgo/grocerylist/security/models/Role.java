package com.github.nohgo.grocerylist.security.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document("roles")
public class Role {
    @Id
    private String id;

    private ERole name;

}

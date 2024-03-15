package com.github.nohgo.grocerylist.repository;

import com.github.nohgo.grocerylist.models.AuthUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends MongoRepository<AuthUser, String>{
    AuthUser findByUsername(String username);
}

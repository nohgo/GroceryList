package com.github.nohgo.grocerylist.repository;

import com.github.nohgo.grocerylist.models.ERole;
import com.github.nohgo.grocerylist.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String>
{
    Optional<Role> findByName(ERole name);
}

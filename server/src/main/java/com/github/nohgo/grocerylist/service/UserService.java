package com.github.nohgo.grocerylist.service;

import com.github.nohgo.grocerylist.models.User;

public interface UserService {

    User getByUsername(String username);

    void save(User user);
}

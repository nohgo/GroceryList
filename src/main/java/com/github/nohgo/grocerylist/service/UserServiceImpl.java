package com.github.nohgo.grocerylist.service;

import com.github.nohgo.grocerylist.models.User;
import com.github.nohgo.grocerylist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    public User getByUsername(String username) throws UsernameNotFoundException{
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    }
    public void save(User user){
        userRepository.save(user);
    }
}

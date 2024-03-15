package com.github.nohgo.grocerylist.service;

import com.github.nohgo.grocerylist.models.AuthUser;
import com.github.nohgo.grocerylist.repository.AuthUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserRepository.findByUsername(username);

        //! DO GROCERYLIST AGGREGATION HERE

        return new AuthUser(authUser.getUsername(), authUser.getPassword());
    }
}

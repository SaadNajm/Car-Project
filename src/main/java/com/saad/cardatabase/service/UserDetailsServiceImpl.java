package com.saad.cardatabase.service;

import com.saad.cardatabase.domain.AppUser;
import com.saad.cardatabase.domain.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
               Optional<AppUser>user=repository.findByUsername(username);
               User.UserBuilder builder=null;
               if(user.isPresent()){
                  AppUser currentUser=user.get();
                  builder=User.withUsername(username);
                  builder.password(currentUser.getPassword());
                  builder.roles(currentUser.getRole());
               }
        return builder.build();
    }
}

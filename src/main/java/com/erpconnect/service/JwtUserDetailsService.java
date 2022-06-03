package com.erpconnect.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //$2a$12$FD/6DoGYRIqiwCr5VMkkm.2x2BC7jvU/M9oWFVbEHzvbkx8GAv2O6 = "encodedpass"
        if ("bangnghh".equals(username)) {
            return new User("bangnghh", "$2a$12$17qBTPJC4pwfcSGoB3Qa1.gR0WOJWlJdSFZooiepYo8ass.9JUUcG",
                    new ArrayList<>());
        } else {
            System.out.println("User not found with username: " + username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
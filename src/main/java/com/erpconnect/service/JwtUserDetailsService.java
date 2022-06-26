package com.erpconnect.service;

import com.erpconnect.model.CustomerEntity;
import com.erpconnect.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //$2a$12$FD/6DoGYRIqiwCr5VMkkm.2x2BC7jvU/M9oWFVbEHzvbkx8GAv2O6 = "encodedpass"
        Optional<CustomerEntity> customerEntity = customerRepository.findById(username);
        if (customerEntity != null) {
            return new User(customerEntity.get().getCustomer_id()+"", customerEntity.get().getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
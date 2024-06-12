package com.example.banking_app.utils;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DummyUserDetailsService implements UserDetailsService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Create a dummy user with a BCrypt-encoded password
        if ("user".equals(username)) {
            // The password is "password" encoded using BCrypt
            String encodedPassword = passwordEncoder.encode("password");
            return User.withUsername(username)
                .password(encodedPassword)
                .roles("USER")
                .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}

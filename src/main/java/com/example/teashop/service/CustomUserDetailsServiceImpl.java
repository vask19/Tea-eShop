package com.example.teashop.service;


import com.example.teashop.entitty.User;
import com.example.teashop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {


    private final UserRepository userRepository;

    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOptionalUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found with username " + username));


        return build(user);
    }

    public User loadUserById(Long id) {
        return userRepository.findUserById(id)
                .orElse(null);
    }

    public static User build(User user) {
        List<GrantedAuthority> authorities = user
                .getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());

        return new User(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );

    }
}

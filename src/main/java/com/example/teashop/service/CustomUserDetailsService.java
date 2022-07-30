package com.example.teashop.service;

import com.example.teashop.entitty.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserDetailsService extends UserDetailsService {
    User loadUserById(Long id);

}

package com.example.teashop.service;

import com.example.teashop.entitty.User;
import com.example.teashop.entitty.role.ERole;
import com.example.teashop.exception.UserExistException;
import com.example.teashop.payload.request.SignupRequest;
import com.example.teashop.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.teashop.security.JWTAuthenticationEntryPoint.LOG;


@Service
public class UserService {


    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findUserByUsername(String name) {


        return userRepository.findUserByUsername(name);

    }

    public void save(User user) {
        userRepository.save(user);
    }



    public User createUser(SignupRequest userIn) throws UserExistException {
        User user = new User();
        user.setUsername(userIn.getUsername());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));
        user.getRoles().add(ERole.ROLE_USER);

        try {
            LOG.info("Saving User {}", userIn.getUsername());
            return userRepository.save(user);
        } catch (Exception e) {
            LOG.error("Error during registration. {}", e.getMessage());
            throw new UserExistException("The user " + user.getUsername() + " already exist. Please check credentials");
        }
    }
}


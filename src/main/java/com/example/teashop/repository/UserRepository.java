package com.example.teashop.repository;

import com.example.teashop.entitty.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String username);

    Optional<User> findUserById(Long id);

    Optional<User> findOptionalUserByUsername(String username);
}

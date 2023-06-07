package com.example.blogbackend.repository;

import com.example.blogbackend.entity.Role;
import com.example.blogbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String user);
}

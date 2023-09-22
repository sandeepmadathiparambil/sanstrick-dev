package com.example.sanstrick.repository;


import com.example.sanstrick.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can define custom query methods here if needed
}

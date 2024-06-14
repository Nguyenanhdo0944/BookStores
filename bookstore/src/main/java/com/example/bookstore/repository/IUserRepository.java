package com.example.bookstore.repository;

import com.example.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("SELECT User FROM User WHERE username = ?1")
    User findByUsername(String username);
}

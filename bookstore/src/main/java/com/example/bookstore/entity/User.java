package com.example.bookstore.entity;

import com.example.bookstore.Validator.annotation.ValidUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Username không phù hợp")
    @Size(max = 50, message = "Username không thể vượt quá 50 ký tự")
    @ValidUsername
    private String username;
    @Column(name = "password", length = 250, nullable = false)
    @NotBlank(message = "Password không phù hợp")
    private String password;
    @Column(name = "email", length = 50)
    @Size(max = 50, message = "Email không thể vượt quá 50 ký tự")
    private String email;
    @Column(name = "name", length = 50, nullable = false)
    @Size(max = 50, message = "Name không thể vượt quá 50 ký tự")
    @NotBlank(message = "Name không hợp lệ")
    private String name;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
}


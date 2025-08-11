package com.example.enterprise_resource_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="users", indexes = {
        @Index(name = "idx_username", columnList = "username"),
        @Index(name = "idx-email", columnList = "email")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true, length=100)
    private String username;

    @Column(nullable = false, unique=true, length=255)
    private String email;

    @Column(nullable = false, length=255)
    private String password_hash;

    @Column(length=200)
    private String full_name;

    @Enumerated(EnumType.STRING)
    @Column(length=50)
    private Role role;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @PrePersist
    public void prePersist(){
        created_at = LocalDateTime.now();
        updated_at = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updated_at = LocalDateTime.now();
    }

    public enum Role {
        ADMIN,
        MANAGER,
        EMPLOYEE
    }

}

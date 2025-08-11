package com.example.enterprise_resource_management.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users", indexes = {
        @Index(name = "idx_username", columnList = "username"),
        @Index(name = "idx-email", columnList = "email")
})
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

    public User() {
    }

    public User(Long id, String username, String email, String password_hash, String full_name, Role role, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password_hash = password_hash;
        this.full_name = full_name;
        this.role = role;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @PrePersist
    public void prePersist(){
        created_at = LocalDateTime.now();
        updated_at = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updated_at = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    // Builder pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String username;
        private String email;
        private String password_hash;
        private String full_name;
        private Role role;
        private LocalDateTime created_at;
        private LocalDateTime updated_at;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password_hash(String password_hash) {
            this.password_hash = password_hash;
            return this;
        }

        public Builder full_name(String full_name) {
            this.full_name = full_name;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder created_at(LocalDateTime created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder updated_at(LocalDateTime updated_at) {
            this.updated_at = updated_at;
            return this;
        }

        public User build() {
            return new User(id, username, email, password_hash, full_name, role, created_at, updated_at);
        }
    }

    public enum Role {
        ADMIN,
        MANAGER,
        EMPLOYEE
    }
}
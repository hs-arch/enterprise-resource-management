package com.example.enterprise_resource_management.repository;

import com.example.enterprise_resource_management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

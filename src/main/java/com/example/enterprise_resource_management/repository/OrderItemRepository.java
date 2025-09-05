package com.example.enterprise_resource_management.repository;

import com.example.enterprise_resource_management.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

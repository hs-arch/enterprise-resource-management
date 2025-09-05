package com.example.enterprise_resource_management.dto;

import lombok.Data;
import java.util.List;

public class CreateOrderRequest {

    public CreateOrderRequest(Long userId, List<OrderItemRequest> items) {
        this.userId = userId;
        this.items = items;
    }

    private Long userId;
    private List<OrderItemRequest> items;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public List<OrderItemRequest> getItems() {
        return items;
    }
    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}

class OrderItemRequest {

    public OrderItemRequest(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    private Long productId;
    private int quantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}


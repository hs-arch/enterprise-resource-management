package com.example.enterprise_resource_management.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ProductResponseDTO {

    private Long id;
    private String sku;
    private String name;
    private String description;
    private Double price;
    private int stockQty;
    private int reorderThreshold;
    private String supplier;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductResponseDTO(){}

    public ProductResponseDTO(Long id, String sku, String name, String description, Double price, int stockQty, int reorderThreshold, String supplier, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.id=id;
        this.sku=sku;
        this.name=name;
        this.description=description;
        this.price=price;
        this.stockQty=stockQty;
        this.reorderThreshold=reorderThreshold;
        this.supplier=supplier;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
    }

//    ---------- Getters and Setters below


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(int reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

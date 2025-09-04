package com.example.enterprise_resource_management.service;

import com.example.enterprise_resource_management.dto.ProductRequestDTO;
import com.example.enterprise_resource_management.dto.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO addProduct(ProductRequestDTO product);
}

package com.example.enterprise_resource_management.service;

import com.example.enterprise_resource_management.dto.ProductRequestDTO;
import com.example.enterprise_resource_management.dto.ProductResponseDTO;
import com.example.enterprise_resource_management.entity.Product;
import java.util.List;


public interface ProductService {
    ProductResponseDTO addProduct(ProductRequestDTO product);
    List<Product> getAllProducts();
    ProductResponseDTO getProductById(Long id);
}

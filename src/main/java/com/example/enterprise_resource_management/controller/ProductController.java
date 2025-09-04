package com.example.enterprise_resource_management.controller;

import com.example.enterprise_resource_management.dto.ProductRequestDTO;
import com.example.enterprise_resource_management.dto.ProductResponseDTO;
import com.example.enterprise_resource_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO product){
        productService.addProduct(product);
        return null;
    }
}

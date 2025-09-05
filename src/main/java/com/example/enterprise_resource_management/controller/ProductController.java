package com.example.enterprise_resource_management.controller;

import com.example.enterprise_resource_management.dto.ProductRequestDTO;
import com.example.enterprise_resource_management.dto.ProductResponseDTO;
import com.example.enterprise_resource_management.entity.Product;
import com.example.enterprise_resource_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO product){
         ProductResponseDTO productResponseDTO = productService.addProduct(product);
        return ResponseEntity.ok(productResponseDTO);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id){
        ProductResponseDTO productResponseDTO = productService.getProductById(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable  Long id){
        productService.deleteById(id);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<ProductResponseDTO> updateProductById(@RequestBody ProductRequestDTO productUpdateRequestDTO, @PathVariable Long id){
        ProductResponseDTO updatedProductResponseDTO = productService.updateProduct(productUpdateRequestDTO, id);
        return ResponseEntity.ok(updatedProductResponseDTO);
    }

}

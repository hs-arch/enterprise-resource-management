package com.example.enterprise_resource_management.service;

import com.example.enterprise_resource_management.dto.ProductRequestDTO;
import com.example.enterprise_resource_management.dto.ProductResponseDTO;
import com.example.enterprise_resource_management.entity.Product;
import com.example.enterprise_resource_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO product) {
        Product newProduct = new Product();

        newProduct.setSku(product.getSku());
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setStockQty(product.getStockQty());
        newProduct.setReorderThreshold(product.getReorderThreshold());
        newProduct.setSupplier(product.getSupplier());

        Product saved = productRepository.save(newProduct);

        System.out.println("Saved Product : " + saved);

         return null;
//        return
    }
}

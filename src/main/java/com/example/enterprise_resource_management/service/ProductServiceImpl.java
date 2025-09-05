package com.example.enterprise_resource_management.service;

import com.example.enterprise_resource_management.dto.ProductRequestDTO;
import com.example.enterprise_resource_management.dto.ProductResponseDTO;
import com.example.enterprise_resource_management.entity.Product;
import com.example.enterprise_resource_management.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;


    private ProductResponseDTO mapToDTO(Product product){
        return new ProductResponseDTO(
                product.getId(),
                product.getSku(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStockQty(),
                product.getReorderThreshold(),
                product.getSupplier(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }


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
        ProductResponseDTO productResponseDTO = mapToDTO(newProduct);

        System.out.println("Saved Product : " + saved);

        return productResponseDTO;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {

        Optional<Product> productResponseDTO = productRepository.findById(id);

        if(productResponseDTO.isPresent()){
            return mapToDTO(productResponseDTO.get());
        }else{
            throw new EntityNotFoundException("This id: "+ id +", is not present.");
        }
    }
}

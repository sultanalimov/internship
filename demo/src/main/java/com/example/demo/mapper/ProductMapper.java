package com.example.demo.mapper;

import com.example.demo.model.Product;
import com.example.demo.model.dto.ProductRequest;
import com.example.demo.model.dto.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory()
        );
    }

    public Product toEntity(ProductRequest requestDTO) {
        return new Product(
                requestDTO.getName(),
                requestDTO.getPrice(),
                requestDTO.getQuantity(),
                requestDTO.getCategory()
        );
    }
}
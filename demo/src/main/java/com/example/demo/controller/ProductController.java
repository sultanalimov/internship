package com.example.demo.controller;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.model.dto.ProductRequest;
import com.example.demo.model.dto.ProductResponse;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequest request) {
        Product product = productMapper.toEntity(request);
        product = productService.save(product);
        ProductResponse responseDTO = productMapper.toResponse(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        ProductResponse responseDTO = productMapper.toResponse(product);
        return ResponseEntity.ok(responseDTO);
    }
}

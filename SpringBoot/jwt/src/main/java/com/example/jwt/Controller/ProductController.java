package com.example.jwt.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.DTO.CreateProductDto;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public String getProducts() {
        return "Secure product list";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String createProduct(
        @Valid @RequestBody CreateProductDto dto) {

        return "Product created";
    }
}
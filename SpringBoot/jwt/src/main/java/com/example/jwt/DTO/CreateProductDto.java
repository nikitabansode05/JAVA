package com.example.jwt.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateProductDto {

    @NotBlank
    @Size(max = 100)
    private String name;

    @Min(1)
    @Max(100000)
    private double price;

    // getters & setters
}
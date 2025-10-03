package com.tap.EndToEndTesting.Repository;

import java.util.List;

import com.tap.EndToEndTesting.Entity.Product;

public interface ProductRepository {
    public List<Product> getAllList();
    public Product getProductById(int id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public String deleteProduct(int id);
}

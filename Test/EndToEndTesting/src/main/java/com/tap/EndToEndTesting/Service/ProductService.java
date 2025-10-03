package com.tap.EndToEndTesting.Service;

import java.util.List;

import com.tap.EndToEndTesting.Entity.Product;

public interface ProductService {
     public List<Product> getAllList();
  public Product getProductById(int id);
  public Product createProduct(Product product);
  public Product updateProduct(Product product);
  public String deleteProduct(int id);
}


package com.tap.EndToEndTesting.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tap.EndToEndTesting.Entity.Product;
import com.tap.EndToEndTesting.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
     
    private ProductRepository _repo;

    public ProductServiceImpl(ProductRepository repo){
        _repo = repo;
    }

    @Override
    public List<Product> getAllList(){
        return _repo.getAllList();
    }

    @Override
    public Product getProductById(int id){
        return _repo.getProductById(id);
    }

    @Override
    public Product createProduct(Product product){
        return _repo.createProduct(product);
    }

    @Override
    public Product updateProduct(Product product){
        return _repo.updateProduct(product);
    }

    @Override
    public String deleteProduct(int id){
       return _repo.deleteProduct(id);
    }
}
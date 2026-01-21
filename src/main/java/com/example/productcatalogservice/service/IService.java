package com.example.productcatalogservice.service;

import java.util.List;

import com.example.productcatalogservice.model.Product;

public interface IService {
    public List<Product> getAllProducts();
    public Product getProductById(long id);   
    public Product createProduct(Product product);
    public Product replaceProduct(String id,Product product);
} 

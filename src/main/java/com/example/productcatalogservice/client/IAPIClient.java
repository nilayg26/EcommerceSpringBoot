package com.example.productcatalogservice.client;

import java.util.List;

import com.example.productcatalogservice.model.Product;

public interface IAPIClient {
     public List<Product> getAllProducts();
     public Product getProductById(long id);
     public Product createProduct(Product product);
    public Product replaceProduct(long id, Product product);
}

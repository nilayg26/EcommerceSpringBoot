package com.example.productcatalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.productcatalogservice.client.FakeStoreAPIClient;
import com.example.productcatalogservice.model.Product;



@Service
public class InternetService implements IService {
    @Autowired
    private FakeStoreAPIClient fakeStoreAPIClient;
    // implement restTemplate
    @Override
    public List<Product> getAllProducts() {
        return fakeStoreAPIClient.getAllProducts();
    }

    @Override
    public Product getProductById(long id) {
        return fakeStoreAPIClient.getProductById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return fakeStoreAPIClient.createProduct(product);
    }

    public Product replaceProduct(String id, Product product) {
        return fakeStoreAPIClient.replaceProduct(id, product);
    }

}

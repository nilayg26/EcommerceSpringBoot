package com.example.productcatalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productcatalogservice.model.Product;
import com.example.productcatalogservice.repository.ProductRepository;


@Service("product")
public class ProductService implements IService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        List<Product> productL = productRepository.findAll();
        return validate(productL);
    }
    @Override
    public Product getProductById(long id) {
        Product product = productRepository.findById(id).orElse(null);
        return validate(product); 
    }

    @Override
    public Product createProduct(Product product) {
        Product saved= productRepository.save(product);
        return validate(saved);
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        // TODO Auto-generated method stub
        if(id!=product.getId()){
            product.setId(id);
        }
        Product product2 = productRepository.save(product);
        return validate(product2);
    }
    private <T> T validate(T product){
        if(product==null){
            throw new NullPointerException("product cannot be found");
        }
        return product;
    }
}

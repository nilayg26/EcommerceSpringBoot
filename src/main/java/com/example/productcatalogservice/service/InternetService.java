package com.example.productcatalogservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.productcatalogservice.dto.InternetProductDto;
import com.example.productcatalogservice.model.Product;


@Service
public class InternetService implements IService {
    @Autowired
    private RestTemplate restTemplate;

    // implement restTemplate
    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<InternetProductDto[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/",
                InternetProductDto[].class);
        List<InternetProductDto> list = Arrays.asList(response.getBody());
        List<Product> arr = new ArrayList<>();
        for(InternetProductDto dto : list){
            arr.add(dto.convert());
        }
        return arr;
    }

    @Override
    public Product getProductById(long id) {
        ResponseEntity<InternetProductDto> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                InternetProductDto.class,
                id);
        InternetProductDto dto  =response.getBody();
        Product product = dto.convert();
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        InternetProductDto dto = product.convertToIDto();
        ResponseEntity<InternetProductDto> response =
        restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                dto,
                InternetProductDto.class
        );
        return response.getBody().convert();
    }

}

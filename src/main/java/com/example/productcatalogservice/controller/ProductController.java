package com.example.productcatalogservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.productcatalogservice.dto.ProductDto;
import com.example.productcatalogservice.model.Product;
import com.example.productcatalogservice.service.InternetService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ProductController {
    @Autowired
    private InternetService internetService;
    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        List<Product> listP = internetService.getAllProducts();
        List<ProductDto> listD = new ArrayList<>();
        for(Product product : listP){
            listD.add(product.convertToDto());
        }
        return listD;
    }
    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable("id") Long id) {
        Product product = internetService.getProductById(id);
        ProductDto productDto = product.convertToDto();
        return productDto;
    }
    @PostMapping("/products")
    public ProductDto postProduct(@RequestBody ProductDto productDto) {
        Product product = productDto.convert();
        internetService.createProduct(product);
        return productDto;
    }
    @PutMapping("/products/{id}")
    public ProductDto replaceProduct(@PathVariable String id, @RequestBody ProductDto entity) {
        Product product = entity.convert();
        Product newP = internetService.replaceProduct(id,product);
        return newP.convertToDto();
    }
    @GetMapping("/")
    public String getMethodName() {
        return "This is application is built by Nilay";
    }
    
}

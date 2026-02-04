package com.example.productcatalogservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.productcatalogservice.dto.BackProductDto;
import com.example.productcatalogservice.dto.ProductDto;
import com.example.productcatalogservice.model.Product;
import com.example.productcatalogservice.service.IService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ProductController {
    @Autowired
    @Qualifier("product")
    private IService internetService;
    @GetMapping("/products")
    public List<BackProductDto> getAllProducts() {
        List<Product> listP = internetService.getAllProducts();
        List<BackProductDto> listD = new ArrayList<>();
        for(Product product : listP){
            listD.add(product.convertToBackProductDto());
        }
        return listD;
    }
    @GetMapping("/products/{id}")
    public BackProductDto getProductById(@PathVariable("id") Long id) {
        Product product = internetService.getProductById(id);
        BackProductDto productDto = product.convertToBackProductDto();
        return productDto;
    }
    @PostMapping("/products")
    public BackProductDto postProduct(@RequestBody ProductDto productDto) {
        Product product = productDto.convert();
        Product product2 =  internetService.createProduct(product);
        return product2.convertToBackProductDto();
    }
    @PutMapping("/products/{id}")
    public BackProductDto replaceProduct(@PathVariable long id, @RequestBody ProductDto entity) {
        Product product = entity.convert();
        Product newP = internetService.replaceProduct(id,product);
        return newP.convertToBackProductDto();
    }
    @GetMapping("/")
    public String getMethodName() {
        return "This is application is built by Nilay";
    }    
}

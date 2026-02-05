package com.example.productcatalogservice.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.productcatalogservice.model.Category;
import com.example.productcatalogservice.model.Product;

@SpringBootTest
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    void testFindAll() {
        List<Category> cat = categoryRepository.findAll();
        System.out.println("***Hello***");
        for(Category c: cat){
            for(Product p: c.getProducts()){
                System.out.println(p.getName());
            }
        }
    }
    @Test
    void testFindById() {
        Optional<Category> cat = categoryRepository.findById(1L);
        System.out.println("***Hello***");
        if(cat.isPresent()){
            System.out.println("Name: "+cat.get().getName());
            Category c = cat.get();
            for(Product p : c.getProducts()){
                System.out.println(p.getName());
            }
        }
    }
}

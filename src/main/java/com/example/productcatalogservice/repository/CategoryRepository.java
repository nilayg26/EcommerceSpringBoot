package com.example.productcatalogservice.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productcatalogservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    @Override
    List<Category> findAll();
    @Override 
    Optional<Category> findById(Long id);
    @Override
    Category save(Category category);
}

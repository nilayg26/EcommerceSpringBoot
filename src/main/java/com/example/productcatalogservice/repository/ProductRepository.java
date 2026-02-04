package com.example.productcatalogservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.productcatalogservice.model.Category;
import com.example.productcatalogservice.model.Product;

import jakarta.websocket.server.PathParam;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    @Override
    Optional<Product> findById(Long id);
    @Override
    List<Product> findAll();
    @Override
    Product save(Product product);
    
    @Query("SELECT c FROM Category c WHERE c.id = :id")
    Category findCategoryById(@PathParam("id") long id);
}

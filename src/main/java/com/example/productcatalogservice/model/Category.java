package com.example.productcatalogservice.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category extends BaseModel {
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}

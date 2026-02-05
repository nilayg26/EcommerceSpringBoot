package com.example.productcatalogservice.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category extends BaseModel {
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> products;
}

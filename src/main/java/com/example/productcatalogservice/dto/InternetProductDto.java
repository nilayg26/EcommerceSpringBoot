package com.example.productcatalogservice.dto;

import com.example.productcatalogservice.model.Category;
import com.example.productcatalogservice.model.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternetProductDto extends InternetBaseDto {
    private String description;
    private String image;
    private Double price;
    private String category;

    public Product convert() {
        Product product = new Product();
        product.setId(this.getId());
        product.setName(this.getTitle());
        product.setPrice(this.getPrice());
        Category category = new Category();
        category.setName(this.getCategory());
        product.setCategory(category);
        product.setDescription(this.getDescription());
        return product;
    }
}

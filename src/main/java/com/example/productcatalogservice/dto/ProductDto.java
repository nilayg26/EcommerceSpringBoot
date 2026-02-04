package com.example.productcatalogservice.dto;

import com.example.productcatalogservice.model.Category;
import com.example.productcatalogservice.model.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto extends BaseDto{
    private Double price;
    private String imageUrl;
    private CategoryDto category;
    public Product convert() {
        Product product = new Product();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setPrice(this.getPrice());
        if(this.getCategory()!=null){
            Category category = new Category();
            category.setId(this.getCategory().getId());
            category.setName(this.getCategory().getName());
            product.setCategory(category);
        }
        product.setDescription(this.getDescription());
        product.setImageUrl(imageUrl);
        return product;
    }
}


package com.example.productcatalogservice.model;

import com.example.productcatalogservice.dto.CategoryDto;
import com.example.productcatalogservice.dto.InternetProductDto;
import com.example.productcatalogservice.dto.ProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private Double price;
    private String imageUrl;
    private Category category;
    public ProductDto convertToDto() {
        ProductDto productDto = new ProductDto();
        productDto.setName(this.getName());
        productDto.setDescription(this.getDescription());
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(this.getCategory().getName());//just for simulation 
        productDto.setCategory(categoryDto);
        productDto.setPrice(this.getPrice());
        productDto.setId(this.getId());
        return productDto;
    }
    public InternetProductDto convertToIDto() {
        InternetProductDto productDto = new InternetProductDto();
        productDto.setTitle(this.getName());
        productDto.setDescription(this.getDescription());
        productDto.setCategory(this.getCategory().getName());
        productDto.setId(this.getId());
        productDto.setPrice(this.getPrice());
        return productDto;
    }
}


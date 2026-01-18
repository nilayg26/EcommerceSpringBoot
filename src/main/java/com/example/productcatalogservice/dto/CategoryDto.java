package com.example.productcatalogservice.dto;

import java.util.List;

import com.example.productcatalogservice.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto extends BaseDto {
    private List<Product> products;
}

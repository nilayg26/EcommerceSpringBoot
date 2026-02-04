package com.example.productcatalogservice.dto;

import java.util.HashMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BackProductDto extends BaseDto{
    private double price;
    private BackCategoryDto category;
    private String imageUrl;
}

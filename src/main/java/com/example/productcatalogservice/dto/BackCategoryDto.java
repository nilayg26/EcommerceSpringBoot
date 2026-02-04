package com.example.productcatalogservice.dto;

import java.util.HashMap;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BackCategoryDto extends BaseDto{
    private HashMap<Long,String> products;
}

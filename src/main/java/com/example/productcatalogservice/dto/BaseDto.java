package com.example.productcatalogservice.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseDto {
    private Long id;
    private String name;
    private String description;
}

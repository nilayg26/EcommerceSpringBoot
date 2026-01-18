package com.example.productcatalogservice.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseModel {
    private Long id;
    private String name;
    private String description;
}
enum State{ACTIVE, INACTIVE}

package com.example.productcatalogservice.model;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {
    @Id
    private Long id;
    private String name;
    private String description;
}
enum State{ACTIVE, INACTIVE}

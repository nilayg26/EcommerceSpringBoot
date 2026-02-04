package com.example.productcatalogservice.model;
import java.util.HashMap;
import com.example.productcatalogservice.dto.BackCategoryDto;
import com.example.productcatalogservice.dto.BackProductDto;
import com.example.productcatalogservice.dto.CategoryDto;
import com.example.productcatalogservice.dto.InternetProductDto;
import com.example.productcatalogservice.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseModel {
    private Double price;
    private String imageUrl;
    @ManyToOne
    private Category category;
    public ProductDto convertToDto() {
        ProductDto productDto = new ProductDto();
        productDto.setName(this.getName());
        productDto.setDescription(this.getDescription());
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(this.getCategory().getName());//just for simulation 
        categoryDto.setDescription(this.getCategory().getDescription());
        categoryDto.setProducts(this.getCategory().getProducts());
        categoryDto.setId(this.getCategory().getId());
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
    public BackProductDto convertToBackProductDto(){
        BackProductDto bProductDto= new BackProductDto();
        bProductDto.setDescription(this.getDescription());
        bProductDto.setId(this.getId());
        bProductDto.setName(getName());
        bProductDto.setPrice(getPrice());
        HashMap<Long,String> map =new HashMap<>();
        for(Product p : this.getCategory().getProducts()){
            map.put(p.getId(),p.getName());
        }
        BackCategoryDto backCategoryDto = new BackCategoryDto();
        backCategoryDto.setProducts(map);
        backCategoryDto.setDescription(getCategory().getDescription());
        backCategoryDto.setName(getCategory().getName());
        backCategoryDto.setId(getCategory().getId());
        bProductDto.setCategory(backCategoryDto);
        bProductDto.setImageUrl(imageUrl);
        return bProductDto;
    }
}


package com.example.productcatalogservice.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.productcatalogservice.dto.InternetProductDto;
import com.example.productcatalogservice.model.Product;

import jakarta.annotation.Nullable;

@Component
public class FakeStoreAPIClient implements IAPIClient {
    @Autowired
    private RestTemplate restTemplate;

    // implement restTemplate
    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<InternetProductDto[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/",
                InternetProductDto[].class);
        if(!response.hasBody()){
            throw new NullPointerException("No Product Can be found");
        }
        List<InternetProductDto> list = Arrays.asList(response.getBody());
        List<Product> arr = new ArrayList<>();
        for(InternetProductDto dto : list){
            arr.add(dto.convert());
        }
        return arr;
    }
    @Override
    public Product getProductById(long id) {
        ResponseEntity<InternetProductDto> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                InternetProductDto.class,
                id);
        validate(response);
        InternetProductDto dto  =response.getBody();
        Product product = dto.convert();
        return product;
    }
    @Override
    public Product createProduct(Product product) {
        InternetProductDto dto = product.convertToIDto();
        ResponseEntity<InternetProductDto> response =
        restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                dto,
                InternetProductDto.class
        );
        validate(response);
        return response.getBody().convert();
    }
    @Override
    public Product replaceProduct(String id, Product product) {
        InternetProductDto dto = product.convertToIDto();
        ResponseEntity<InternetProductDto> response =
        putForEntity(
                "https://fakestoreapi.com/products/{id}",
                dto,
                InternetProductDto.class,
                id
        );
        validate(response);
        return response.getBody().convert();
    }
    private void validate(ResponseEntity<InternetProductDto> response){
        if(!response.hasBody()){
            throw new NullPointerException("Cannot find or create Product");
        }
    }
    private <T> T nonNull(@Nullable T result) {
      Assert.state(result != null, "No result");
      return result;
    }
    private <T> ResponseEntity<T> putForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
      RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
      ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
      return (ResponseEntity)nonNull((ResponseEntity)restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables));
    }
}

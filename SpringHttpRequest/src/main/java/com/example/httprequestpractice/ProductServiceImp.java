package com.example.httprequestpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class
ProductServiceImp {

    private final RestTemplate restTemplate;

    @Autowired
    public ProductServiceImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String findProduct(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("/https://dummyjson.com/products/"+id, HttpMethod.GET, entity, String.class).getBody();
    }

}

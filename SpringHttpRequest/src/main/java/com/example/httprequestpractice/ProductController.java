package com.example.httprequestpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/template/products")
public class ProductController {

    ProductServiceImp productService;

    @Autowired
    public ProductController(ProductServiceImp productService){
        this.productService=productService;
    }

    @GetMapping("/{id}")
    public String getProduct (@PathVariable Long id){
      return productService.findProduct(id);
    }

}

package com.shreyas.microservices.product.controller;

import com.shreyas.microservices.product.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

import com.shreyas.microservices.product.dto.ProductRequest;
import com.shreyas.microservices.product.dto.ProductResponse;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) 
    {
        System.out.println("in post controller*************************************************************************************");
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() 
    {
        return productService.getAllProducts();
    }
    
}

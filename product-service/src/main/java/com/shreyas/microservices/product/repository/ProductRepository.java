package com.shreyas.microservices.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shreyas.microservices.product.model.Product;

public interface ProductRepository extends MongoRepository<Product,String>{
    
}

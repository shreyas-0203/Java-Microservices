package com.shreyas.microservices.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shreyas.microservices.product.dto.ProductRequest;
import com.shreyas.microservices.product.dto.ProductResponse;
import com.shreyas.microservices.product.model.Product;
import com.shreyas.microservices.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService 
{
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) 
    {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .skuCode(productRequest.skuCode())
                .price(productRequest.price())
                .build();
 
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() 
    {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) 
    {
        return new ProductResponse(product.getId(), product.getName(),
                product.getDescription(), product.getPrice());
    }
    
}

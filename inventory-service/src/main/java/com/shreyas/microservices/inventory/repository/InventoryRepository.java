package com.shreyas.microservices.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.microservices.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> 
{
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}
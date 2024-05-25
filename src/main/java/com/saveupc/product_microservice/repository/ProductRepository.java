package com.saveupc.product_microservice.repository;

import com.saveupc.product_microservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByNameAndCompanyId(String name, int companyId);
    List<Product> findByCompanyId(int companyId);
}

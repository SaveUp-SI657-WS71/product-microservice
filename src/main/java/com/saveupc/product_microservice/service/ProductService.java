package com.saveupc.product_microservice.service;

import com.saveupc.product_microservice.dto.ProductDto;
import com.saveupc.product_microservice.model.Product;

import java.util.List;

public interface ProductService {
    public abstract ProductDto createProduct(ProductDto productDto);
    public abstract void updateProduct(ProductDto productDto);
    public abstract void deleteProduct(int id);
    public abstract Product getProduct(int id);
    public abstract List<Product> getAllProducts();
    public abstract List<Product> getProductsByCompany(int companyId);
    public abstract boolean isProductExist(int id);
}

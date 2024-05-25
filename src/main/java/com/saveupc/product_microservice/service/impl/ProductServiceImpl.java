package com.saveupc.product_microservice.service.impl;

import com.saveupc.product_microservice.dto.CompanyDto;
import com.saveupc.product_microservice.dto.ProductDto;
import com.saveupc.product_microservice.exception.ResourceNotFoundException;
import com.saveupc.product_microservice.model.Product;
import com.saveupc.product_microservice.repository.ProductRepository;
import com.saveupc.product_microservice.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CompanyServiceImpl companyService;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CompanyServiceImpl companyService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = DtoToEntity(productDto);
        CompanyDto company = companyService.getCompanyById(productDto.getCompanyId());
        if (company == null) {
            throw new ResourceNotFoundException("No se encontró la compañía con id: " + productDto.getCompanyId());
        }

        product.setCompanyId(company.getId());
        return EntityToDto(productRepository.save(product));
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        Product product = DtoToEntity(productDto);
        CompanyDto company = companyService.getCompanyById(productDto.getCompanyId());
        if (company == null) {
            throw new ResourceNotFoundException("No se encontró la compañía con id: " + productDto.getCompanyId());
        }
        product.setCompanyId(company.getId());
        productRepository.save(product);
    }

    @Override
    public Product getProduct(int id) { return productRepository.findById(id).get(); }

    @Override
    public void deleteProduct(int id) { productRepository.deleteById(id); }

    @Override
    public List<Product> getAllProducts() { return (List<Product>) productRepository.findAll(); }

    @Override
    public List<Product> getProductsByCompany(int companyId) { return productRepository.findByCompanyId(companyId); }

    @Override
    public boolean isProductExist(int id) { return productRepository.existsById(id); }

    private ProductDto EntityToDto(Product product) { return modelMapper.map(product, ProductDto.class); }

    private Product DtoToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}

package com.example.spring.service.impl;


import com.example.spring.data.dao.ProductDAO;
import com.example.spring.data.dto.ProductDto;
import com.example.spring.data.dto.ProductResponseDto;
import com.example.spring.data.entity.Product;
import com.example.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceimpl implements ProductService {
    private final ProductDAO productDAO;   //productDAO 란 객체를 통해 DAO 의 CRUD 메소드에 접근가능

    @Autowired
    public ProductServiceimpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productDAO.insertProduct(product);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(savedProduct.getNumber());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setStock(savedProduct.getStock());

        return productResponseDto;
    }
    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changeProduct = productDAO.updateProductName(number, name);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(changeProduct.getNumber());
        productResponseDto.setName(changeProduct.getName());
        productResponseDto.setPrice(changeProduct.getPrice());
        productResponseDto.setStock(changeProduct.getStock());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}

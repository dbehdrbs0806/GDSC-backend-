package com.example.spring.service;

import com.example.spring.data.dto.ProductDto;            // Dto 파일을 사용
import com.example.spring.data.dto.ProductResponseDto;    // Dto 파일을 사용


public interface ProductService {
    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}

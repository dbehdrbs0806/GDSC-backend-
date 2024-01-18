package com.example.spring.data.dao;

import com.example.spring.data.entity.Product;

public interface ProductDAO {    // 추상클래스 즉 인터페이스로 구현해 놓음
    // entity 의 내용들을 CRUD 하는 부분
    Product insertProduct(Product product);
    Product selectProduct(Long number);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}

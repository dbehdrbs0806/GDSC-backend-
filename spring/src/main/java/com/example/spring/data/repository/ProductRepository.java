package com.example.spring.data.repository;

import com.example.spring.data.entity.Product;    // DB의 내용을 접근, 사용할 수 있는 엔티티 파일
import org.springframework.data.jpa.repository.JpaRepository;  // DB를 설정할 수 있는 메소드의 라이브러리
public class ProductRepository extends JpaRepository<Product, Long> {  // 이 처럼 상속해서 사용

}

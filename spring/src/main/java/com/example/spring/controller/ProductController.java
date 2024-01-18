package com.example.spring.controller;

import com.example.spring.data.dto.ChangeProductNameDto;
import com.example.spring.data.dto.ProductDto;
import com.example.spring.data.dto.ProductResponseDto;
import com.example.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;    // service 파일의 productService 클래스의 객체 생성

    @Autowired
    public ProductController(ProductService productService) {   // 생성자함수로 의존성 주입(DI)를 사용
        this.productService = productService;
    }
    // CRUD 중 R
    @GetMapping
    public ResponseEntity<ProductResponseDto> getProduct(Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);
        // ResponseEntity<객체> 형태의 객체를 반환값으로 쓴다
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productResponseDto);
    }
    // CRUD 중 C
    @PostMapping
    public ResponseEntity<ProductResponseDto> createProductName(@RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productResponseDto);
    }
    // CRUD 중 U
    @PutMapping
    public ResponseEntity<ProductResponseDto> changeProductName(
            @RequestBody ChangeProductNameDto changeProductNameDto
    ) throws Exception {
        ProductResponseDto productResponseDto = productService.changeProductName(
                changeProductNameDto.getNumber(),
                changeProductNameDto.getName()
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productResponseDto);
    }
    // CRUD 중 D
    @DeleteMapping
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.deleteProduct(number);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("정상적으로 삭제되었습니다.");
    }
}

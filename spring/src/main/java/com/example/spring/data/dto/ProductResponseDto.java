package com.example.spring.data.dto;

import lombok.*;    /* java 에서 유용하게 사용하는 getter, setter toString 과 같은 메소드들을 어노테이션
                     으로 대체해 쓸 수 있게 가지고 있는 라이브러리
                     DTO 파일으로서 getter, setter 로 존재 */
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {


    private Long number;
    private String name;
    private int price;
    private int stock;


}

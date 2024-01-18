package com.example.spring.data.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity      // 엔티티(DB의 테이블 내용을 객체로 사용)로 사용하는 클래스라고 명시하는 어노테이션
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "name")
@Table(name = "product")   // 원래 클래스의 이름과 테이블의 이름이 디폴트로 같지만 변경하고 싶을 때 사용
public class Product {

    @Id                // 무조건 써야하는 열을 명시하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id 어노테이션과 같이 쓰이며 열, 필드를 어떤 방식으로 쓸지 정하는 어노테이션
    private Long number;

    @Column(nullable = false)      // 열을 명시하는 어노테이션
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
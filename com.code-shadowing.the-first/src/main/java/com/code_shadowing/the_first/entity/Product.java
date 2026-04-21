package com.code_shadowing.the_first.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Integer price;

    public Product(String name, Integer price) {
        validatePrice(price);
        validateName(name);
        this.name = name;
        this.price = price;
    }

    public void update(String name, Integer price) {
        validatePrice(price);
        validateName(name);
        this.name = name;
        this.price = price;
    }

    private void validateName(String name) {
        if (name.length() > 100) {
            throw new IllegalArgumentException("상품 이름은 100자를 넘을 수 없습니다.");
        }
    }

    private void validatePrice(Integer price) {
        if (price < 0) {
            throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");
        }
    }
}

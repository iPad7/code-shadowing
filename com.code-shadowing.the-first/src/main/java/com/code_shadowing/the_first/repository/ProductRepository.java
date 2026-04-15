package com.code_shadowing.the_first.repository;

import com.code_shadowing.the_first.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

package com.code_shadowing.the_first.service;

import com.code_shadowing.the_first.dto.ProductRequest;
import com.code_shadowing.the_first.dto.ProductResponse;
import com.code_shadowing.the_first.entity.Product;
import com.code_shadowing.the_first.exception.ProductNotFoundException;
import com.code_shadowing.the_first.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        Product product = new Product(request.getName(), request.getPrice());
        Product saved = productRepository.save(product);
        return new ProductResponse(saved);
    }

    public ProductResponse getProduct(Long id) {
        Product product = findProductById(id);
        return new ProductResponse(product);
    }

    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponse::new)
                .toList();
    }

    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = findProductById(id);
        product.update(request.getName(), request.getPrice());
        return new ProductResponse(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(
                ProductNotFoundException::new
        );
    }
}

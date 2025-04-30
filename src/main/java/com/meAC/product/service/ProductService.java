package com.meAC.product.service;

import com.meAC.product.dto.ProductRequest;
import com.meAC.product.dto.ProductResponse;
import com.meAC.product.model.Product;
import com.meAC.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product saved successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(),product.getPrice());
    }

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(),product.getPrice()))
                .toList();
    }
}

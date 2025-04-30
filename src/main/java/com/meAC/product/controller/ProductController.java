package com.meAC.product.controller;

import com.meAC.product.dto.ProductRequest;
import com.meAC.product.dto.ProductResponse;
import com.meAC.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ProductResponse> getProduct() {
        return productService.getAllProduct();
    }
}

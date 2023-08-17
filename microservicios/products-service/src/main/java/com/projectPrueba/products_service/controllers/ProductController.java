package com.projectPrueba.products_service.controllers;


import com.projectPrueba.products_service.model.dto.ProductRequest;
import com.projectPrueba.products_service.model.dto.ProductResponse;
import com.projectPrueba.products_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController  {

    private final ProductService productService;

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest) {
        this.productService.addProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return this.productService.getAllProducts();
    }
}

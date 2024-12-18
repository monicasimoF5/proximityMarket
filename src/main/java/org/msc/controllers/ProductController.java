package org.msc.controllers;

import jakarta.validation.Valid;
import org.msc.dtos.ProductRequest;
import org.msc.dtos.ProductResponse;
import org.msc.exceptions.MarketAlreadyExistsException;
import org.msc.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductRequest productRequest) throws MarketAlreadyExistsException {
        ProductResponse product = (ProductResponse) productService.createProduct(productRequest);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> allProducts = productService.listAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
}

package com.example.pao_lab4_e1.controller;

import com.example.pao_lab4_e1.model.Product;
import com.example.pao_lab4_e1.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductControler {
  private final ProductService productService;

  public ProductControler(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/product")
  public void addProduct(@RequestBody Product product) {
    productService.addProduct(product);
  }

  @GetMapping("/products")
  public List<Product> getProducts() {
    return productService.getProducts();
  }
}

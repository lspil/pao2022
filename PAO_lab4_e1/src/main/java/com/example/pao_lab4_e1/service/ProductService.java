package com.example.pao_lab4_e1.service;

import com.example.pao_lab4_e1.model.Product;
import com.example.pao_lab4_e1.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ProductService(ProductRepository productRepository) {
  public void addProduct(Product product) {
    productRepository.addProduct(product);
  }

  public List<Product> getProducts() {
    return productRepository.getProducts();
  }
}

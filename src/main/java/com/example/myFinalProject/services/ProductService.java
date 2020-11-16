package com.example.myFinalProject.services;

import com.example.myFinalProject.model.Product;
import com.example.myFinalProject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> findById(long productId) {
        return productRepository.findById(productId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Product existingProduct) {
        productRepository.delete(existingProduct);
    }
}

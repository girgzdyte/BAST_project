package com.example.myFinalProject.controllers;

import com.example.myFinalProject.exception.ResourceNotFoundException;
import com.example.myFinalProject.model.Product;
import com.example.myFinalProject.repositories.ProductRepository;
import com.example.myFinalProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    //get all products
    @GetMapping("/getproducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //get products by id
    @GetMapping("/getproduct/{id}")
    public Product getProductById(@PathVariable(value = "id") long productId) {
        return  productService.findById(productId).orElseThrow
                (() -> new ResourceNotFoundException("Product not found with ID: " + productId));
    }

    // create product
    @PostMapping("/addproduct")
    public Optional<Product> createProduct(@RequestBody Product product) {
         productService.save(product);
         return productRepository.findById(product.getProductId());
    }

    @PutMapping("/updateproduct/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable ("id") long productId) {
        Product existingProduct = productService.findById(productId).orElseThrow
                (() -> new ResourceNotFoundException("Product not found with ID: " + productId));
        existingProduct.setTitle(product.getTitle());
        existingProduct.setColor(product.getColor());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setImage(product.getImage());
        existingProduct.setInStock(product.getInStock());
        return this.productRepository.save(existingProduct);
    }

    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable ("id") long productId) {
        Product existingProduct = productService.findById(productId).orElseThrow
                (() -> new ResourceNotFoundException("Product not found with ID: " + productId));
        productService.delete(existingProduct);
        return ResponseEntity.ok().build();
    }

}
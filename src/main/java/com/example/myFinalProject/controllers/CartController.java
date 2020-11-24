package com.example.myFinalProject.controllers;

import com.example.myFinalProject.exception.ResourceNotFoundException;
import com.example.myFinalProject.model.Cart;
import com.example.myFinalProject.repositories.CartRepository;
import com.example.myFinalProject.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

// cia yra Spring frameworko anotacija - nurodo, kad sita klase bus kontroliuojancioji, visa logika appso

@RestController
@RequestMapping("/orders")
public class CartController {

    // controller >      service     > repository
    //    Agne    > cileko padavejas > picu kepejas

    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/getorders")
    public List<Cart> getAllOrders() {
        return cartService.getAllOrders();
    }

    @GetMapping("/getorder/{id}")
    public Cart getOrderById(@PathVariable(value = "id") long cart_id) {
        return cartService.findById(cart_id).orElseThrow
                (() -> new ResourceNotFoundException("Order not found with ID: " + cart_id));
    }

    @PostMapping("/addorder")
    public Optional<Cart> createOrder(@RequestBody Cart cart) {
        cartService.save(cart);
        return cartRepository.findById(cart.getCart_id());
    }

    @PutMapping("/updateorder/{id}")
    public Cart updateOrder(@RequestBody Cart cart, @PathVariable("id") long cart_id) {
        Cart existingOrder = cartService.findById(cart_id).orElseThrow
                (() -> new ResourceNotFoundException("Order not found with ID: " + cart_id));
        existingOrder.setFullName(cart.getFullName());
        existingOrder.setShippingAddress(cart.getShippingAddress());
        existingOrder.setCountry(cart.getCountry());
        existingOrder.setPhoneNumber(cart.getPhoneNumber());
        existingOrder.setEmailAddress(cart.getEmailAddress());
        return cartService.save(existingOrder);
    }

    @DeleteMapping("/deleteorder/{id}")
    public ResponseEntity<Cart> deleteOrder(@PathVariable("id") long cart_id) {
        Cart existingOrder = cartService.findById(cart_id).orElseThrow
                (() -> new ResourceNotFoundException("Order not found with ID: " + cart_id));
        cartService.delete(existingOrder);
        return ResponseEntity.ok().build();
    }

}

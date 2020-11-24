package com.example.myFinalProject.services;

import com.example.myFinalProject.model.Cart;
import com.example.myFinalProject.repositories.OrderDetailsRepository;
import com.example.myFinalProject.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

     @Autowired
     private CartRepository cartRepository;
     @Autowired
     private OrderDetailsRepository orderDetailsRepository;

     public List<Cart>getAllOrders() {
         return (List<Cart>) cartRepository.findAll();
     }

     public Optional<Cart> findById(long cart_id) {
         return cartRepository.findById(cart_id);
    }

     public Cart save(Cart cart) {
         cartRepository.save(cart);
         return cart;
     }

    public void delete(Cart existingOrder) {
         orderDetailsRepository.deleteById(existingOrder.getCart_id());
         cartRepository.delete(existingOrder);
    }
}

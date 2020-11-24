package com.example.myFinalProject.services;

import com.example.myFinalProject.model.OrderDetails;
import com.example.myFinalProject.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public List<OrderDetails> getAllOrderDetails() {
        return (List<OrderDetails>) orderDetailsRepository.findAll();
    }

    public Optional<OrderDetails> findById(long orderDetailId) {
        return orderDetailsRepository.findById(orderDetailId);
    }

    public OrderDetails save(OrderDetails orderDetails) {
        orderDetailsRepository.save(orderDetails);
        return orderDetails;
    }
}

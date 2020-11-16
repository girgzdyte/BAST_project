package com.example.myFinalProject.controllers;

import com.example.myFinalProject.exception.ResourceNotFoundException;
import com.example.myFinalProject.model.OrderDetails;
import com.example.myFinalProject.repositories.OrderDetailsRepository;
import com.example.myFinalProject.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/getorderdetails")
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsService.getAllOrderDetails();
    }

    @GetMapping("/getorderdetails/{id}")
    public OrderDetails getOrderDetailsById(@PathVariable(value = "id") long orderDetailId) {
        return orderDetailsService.findById(orderDetailId).orElseThrow
                (() -> new ResourceNotFoundException("Order not found with ID: " + orderDetailId));
    }

    @PutMapping("/updateorderdetails/{id}")
    public OrderDetails updateOrderDetails(@RequestBody OrderDetails orderDetails, @PathVariable("id") long orderDetailsId) {
        OrderDetails existingOrderDetails = orderDetailsService.findById(orderDetailsId).orElseThrow
                (() -> new ResourceNotFoundException("Order details not found with ID: " + orderDetailsId));
        existingOrderDetails.setQuantity(orderDetails.getQuantity());
        return orderDetailsService.save(existingOrderDetails);
    }
}

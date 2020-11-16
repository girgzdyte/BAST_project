package com.example.myFinalProject.controllers;

import com.example.myFinalProject.exception.ResourceNotFoundException;
import com.example.myFinalProject.model.Orders;
import com.example.myFinalProject.repositories.OrdersRepository;
import com.example.myFinalProject.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

// cia yra Spring frameworko anotacija - nurodo, kad sita klase bus kontroliuojancioji, visa logika appso

@RestController
@RequestMapping("/orders")
public class OrdersController {

    // controller >      service     > repository
    //    Agne    > cileko padavejas > picu kepejas

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/getorders")
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/getorder/{id}")
    public Orders getOrderById(@PathVariable(value = "id") long order_id) {
        return ordersService.findById(order_id).orElseThrow
                (() -> new ResourceNotFoundException("Order not found with ID: " + order_id));
    }

    @PostMapping("/addorder")
    public Optional<Orders> createOrder(@RequestBody Orders orders) {
        ordersService.save(orders);
        return ordersRepository.findById(orders.getOrder_id());
    }

    @PutMapping("/updateorder/{id}")
    public Orders updateOrder(@RequestBody Orders orders, @PathVariable("id") long order_id) {
        Orders existingOrder = ordersService.findById(order_id).orElseThrow
                (() -> new ResourceNotFoundException("Order not found with ID: " + order_id));
        existingOrder.setFullName(orders.getFullName());
        existingOrder.setShippingAddress(orders.getShippingAddress());
        existingOrder.setCountry(orders.getCountry());
        existingOrder.setPhoneNumber(orders.getPhoneNumber());
        existingOrder.setEmailAddress(orders.getEmailAddress());
        return ordersService.save(existingOrder);
    }

    @DeleteMapping("/deleteorder/{id}")
    public ResponseEntity<Orders> deleteOrder(@PathVariable("id") long order_id) {
        Orders existingOrder = ordersService.findById(order_id).orElseThrow
                (() -> new ResourceNotFoundException("Order not found with ID: " + order_id));
        ordersService.delete(existingOrder);
        return ResponseEntity.ok().build();
    }
}

package com.example.myFinalProject.services;

import com.example.myFinalProject.model.Orders;
import com.example.myFinalProject.repositories.OrderDetailsRepository;
import com.example.myFinalProject.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

     @Autowired
     private OrdersRepository ordersRepository;
     @Autowired
     private OrderDetailsRepository orderDetailsRepository;

     public List<Orders>getAllOrders() {
         return (List<Orders>) ordersRepository.findAll();
     }

     public Optional<Orders> findById(long orderId) {
         return ordersRepository.findById(orderId);
    }

     public Orders save(Orders orders) {
         ordersRepository.save(orders);
         return orders;
     }

    public void delete(Orders existingOrder) {
         orderDetailsRepository.deleteById(existingOrder.getOrder_id());
         ordersRepository.delete(existingOrder);
    }
}

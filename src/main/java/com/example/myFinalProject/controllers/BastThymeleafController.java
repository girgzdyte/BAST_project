package com.example.myFinalProject.controllers;

import com.example.myFinalProject.model.Orders;
import com.example.myFinalProject.model.Product;
import com.example.myFinalProject.repositories.OrdersRepository;
import com.example.myFinalProject.services.OrdersService;
import com.example.myFinalProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // for returning views, for thymeleaf approach
@RequestMapping("/")
public class BastThymeleafController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersRepository ordersRepository;


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/neworder")
    public String showNewOrderPage(Model model) {
        Orders order = new Orders();
        model.addAttribute("orders", order);
        return "orders";
    }

    // issaugos ZMOGAUS orderi i duonbaze
    @RequestMapping (value = "/createorder", method = RequestMethod.POST)
    public String createOrder(@ModelAttribute("orders") Orders orders) {
        ordersService.save(orders);
        return "redirect:/";
    }


    @GetMapping("/backpacks")
    public String getAllProducts(Model model){
        List<Product> products = productService.getAllProducts();

        //kad i template paduoti duomenis
        model.addAttribute("products", products);
        return "products";
    }


}

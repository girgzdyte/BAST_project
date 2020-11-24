package com.example.myFinalProject.controllers;

import com.example.myFinalProject.model.Backpack;
import com.example.myFinalProject.model.Cart;
import com.example.myFinalProject.repositories.CartRepository;
import com.example.myFinalProject.repositories.BackpackRepository;
import com.example.myFinalProject.services.CartService;
import com.example.myFinalProject.services.BackpackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // for returning views, for thymeleaf approach
@RequestMapping("/")
public class BastThymeleafController {

    @Autowired
    private BackpackService backpackService;
    @Autowired
    private BackpackRepository backpackRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;



    @RequestMapping("/")
    public String index() {
        return "index";
    }

    
    @RequestMapping("/cart")
    public String showCart(Model model) {
        Cart order = new Cart();
        model.addAttribute("cart", order);
        return "cart";
    }


    // issaugos ZMOGAUS orderi i duonbaze
    @RequestMapping (value = "/createcart", method = RequestMethod.POST)
    public String createCart(@ModelAttribute("cart") Cart cart) {
        cartService.save(cart);
        return "redirect:/";
    }

    @GetMapping ("/contact-us")
    public String showContactUsPage() {
        return "contact-us";
    }


    // kad zmogus matytu backpacks puslapi
    @GetMapping("/backpacks")
    public String getAllBackpacks(Model model){
        List<Backpack> backpacks = backpackService.getAllBackpacks();

        //kad i template paduoti duomenis
        model.addAttribute("backpacks", backpacks);
        return "backpacks";
    }

    // kad AS ikelciau per template kuprine i duonbaze
    @GetMapping("/addbackpack")
    public String addBackpack() {
        return "addbackpack";
    }


}

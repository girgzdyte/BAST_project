package com.example.myFinalProject.controllers;

import com.example.myFinalProject.model.ContactUs;
import com.example.myFinalProject.services.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @PostMapping("/contactus")
    @RequestMapping (value = "/contactus", method = RequestMethod.POST)
    public String sendEmail (@ModelAttribute("cart") ContactUs contactUsRequest) {
        contactUsService.sendEmail(contactUsRequest);
        return "index";
    }
}

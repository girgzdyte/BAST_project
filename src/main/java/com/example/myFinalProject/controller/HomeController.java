package com.example.myFinalProject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


// cia yra Spring frameworko anotacija - nurodo, kad sita klase bus kontroliuojancioji, visa logika appso
@Controller
@ResponseBody
public class HomeController {
    @RequestMapping("/map")  // sita anotacija priskiria puslapio kelia, step by step
    public String index() {
        return "index";
    }
}

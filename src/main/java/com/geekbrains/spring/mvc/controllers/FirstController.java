package com.geekbrains.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/first")
    public String showFirstPage(Model model){
        model.addAttribute("username", "Bob");
        return "first_page";
    }
}

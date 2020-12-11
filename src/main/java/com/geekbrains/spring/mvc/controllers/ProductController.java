package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Box;
import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.BoxService;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "all_products";
    }



//    @GetMapping("/one/{id}")
//    public String getProductById(@PathVariable Long id) {
//        productService.getProductById(id);
//        return "one";
//    }

    @GetMapping("/one/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        model.addAttribute("frontProduct", productService.getProductById(id));
        productService.getProductById(id);
        return "one";
    }



    @GetMapping("/remove/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products/all";
    }

    @PostMapping("/add")
//    public String addNewBox(@RequestParam Long id, @RequestParam String color, @RequestParam int size) {
    public String addNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/all";
    }

    @PostMapping("/json/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewJsonBox(@RequestBody Product product) {
        productService.save(product);
    }

}

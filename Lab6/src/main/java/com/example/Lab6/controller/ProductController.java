package com.example.Lab6.controller;

import com.example.Lab6.enity.Product;
import com.example.Lab6.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RequestMapping("/products")
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listproduct",productService.GetAll());
        return "products/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "products/create";
    }
    @PostMapping("create")
    public String create(@Valid Product newProduct, @RequestParam MultipartFile imageProduct, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("product", newProduct);
            return "product/create";
        }
        productService.add(newProduct);
        return "redirect:/products";
    }

}

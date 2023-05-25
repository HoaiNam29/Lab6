package com.example.Lab6.service;

import com.example.Lab6.enity.Product;
import com.example.Lab6.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;
    public List<Product> GetAll() {return (List<Product>) repo.findAll();}
    public void add(Product newProduct){repo.save(newProduct);}
}

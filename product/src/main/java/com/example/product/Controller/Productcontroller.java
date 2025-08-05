package com.example.product.Controller;


import com.example.product.Entity.Product;
import com.example.product.Service.Productservice;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data")

public class Productcontroller {


    public final Productservice productservice;

    public Productcontroller(Productservice productservice) {
        this.productservice = productservice;
    }

    @GetMapping("/allproducts")
    public List<Product> allproud(){
        return productservice.allproducts();
    }

    @PostMapping("/addproduct")
    public String addproud(@RequestBody Product product){
        productservice.addproduct(product);
        return "Product added Succesufully";
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Product> getbyid_1(@PathVariable Long id){
        return productservice.findbyid_1(id);
    }




}

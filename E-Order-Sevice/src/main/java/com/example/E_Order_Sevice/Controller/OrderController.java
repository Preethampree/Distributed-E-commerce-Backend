package com.example.E_Order_Sevice.Controller;

import com.example.E_Order_Sevice.Entity.Orders;
import com.example.E_Order_Sevice.Entity.ProductDTO;
import com.example.E_Order_Sevice.Service.Client.ProductClient;
import com.example.E_Order_Sevice.Service.OrderService;
import com.netflix.discovery.converters.Auto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @Autowired
    public final ProductClient productClient;

    @PostMapping("/save-order")
    public String ordersave(@Valid @RequestBody Orders orders) {
        log.info("📦 Saving new order: {}", orders);
        orderService.addorder(orders);
        return "Order Saved";
    }

    @GetMapping("/all-orders")
    public List<Orders> getallorders() {
        log.info("📋 Fetching all orders");
        return orderService.allorders();
    }

    @GetMapping("/test/product/{id}")
    public ProductDTO getbyid(@PathVariable Long id){
        return orderService.getbyid(id);
    }


}

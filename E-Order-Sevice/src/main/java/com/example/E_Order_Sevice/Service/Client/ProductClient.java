package com.example.E_Order_Sevice.Service.Client;


import com.example.E_Order_Sevice.Entity.ProductDTO;
import jakarta.ws.rs.Path;
import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient {

        @GetMapping("/api/data/getbyid/{id}")
        ProductDTO getbyid_1(@PathVariable("id") Long id);



}

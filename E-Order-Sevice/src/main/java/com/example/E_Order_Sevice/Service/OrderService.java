package com.example.E_Order_Sevice.Service;

import com.example.E_Order_Sevice.Entity.Orders;

import com.example.E_Order_Sevice.Entity.ProductDTO;
import com.example.E_Order_Sevice.Repository.Orderrepository;
import com.example.E_Order_Sevice.Service.Client.ProductClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {

    @Autowired
    private final Orderrepository orderrepository;

    @Autowired
    public final ProductClient productClient;

    public Orders addorder(Orders orders) {
        log.info("📝 Saving order to DB: {}", orders);
        return orderrepository.save(orders);
    }

    public List<Orders> allorders() {
        log.info("📥 Retrieving all orders from database");
        return orderrepository.findAll();
    }
    public ProductDTO getbyid(Long id){
        return productClient.getbyid_1(id);
    }


}

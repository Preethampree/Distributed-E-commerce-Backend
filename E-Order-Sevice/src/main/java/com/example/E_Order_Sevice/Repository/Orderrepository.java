package com.example.E_Order_Sevice.Repository;

import com.example.E_Order_Sevice.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Orderrepository extends JpaRepository<Orders,Long> {


}

package com.example.product.Repository;

import com.example.product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryProduct extends JpaRepository<Product,Long> {



}

package com.example.product.Service;

import com.example.product.Entity.Product;
import com.example.product.Repository.RepositoryProduct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class Productservice {


    public final RepositoryProduct repositoryProduct;

    public Productservice(RepositoryProduct repositoryProduct) {
        this.repositoryProduct = repositoryProduct;
    }

    @Transactional
    public Product addproduct(Product product){
        return repositoryProduct.save(product);

    }

    public List<Product> allproducts(){
        return repositoryProduct.findAll();
    }

    public Optional<Product> findbyid_1(Long id){
        return repositoryProduct.findById(id);
    }
}

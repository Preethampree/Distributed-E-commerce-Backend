package com.example.E_Order_Sevice.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class ProductDTO {

    @Id
    private Long id;
    private String name;
    private String description;
    private Long price;



}

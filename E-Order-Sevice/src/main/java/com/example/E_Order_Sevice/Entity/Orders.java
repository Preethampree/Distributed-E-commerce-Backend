package com.example.E_Order_Sevice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_3;

    @NotBlank(message = "PRODUCT SHOULD NOT BLANK")
    private String productId;
    @NotBlank(message = "QUANTITY SHOULD ME NUMBER")
    private int quantity;


    private double price;





}

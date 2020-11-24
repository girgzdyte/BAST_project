package com.example.myFinalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_id;

    private String fullName;

    private String shippingAddress;

    private String country;

    private String phoneNumber;

    private String emailAddress;

}

package com.example.myFinalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;

    private String fullName;

    private String shippingAddress;

    private String country;

    private String phoneNumber;

    private String emailAddress;

}

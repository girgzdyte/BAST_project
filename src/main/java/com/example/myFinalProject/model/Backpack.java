package com.example.myFinalProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Backpack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long backpackId;
    private String image;
    private String title;
    private String color;
    private int price;
    private String description;
    private int inStock;
}

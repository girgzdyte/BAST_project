package com.example.myFinalProject.controllers;

import com.example.myFinalProject.exception.ResourceNotFoundException;
import com.example.myFinalProject.model.Backpack;
import com.example.myFinalProject.repositories.BackpackRepository;
import com.example.myFinalProject.services.BackpackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/backpacks")
public class BackpackController {

    @Autowired
    private BackpackRepository backpackRepository;
    @Autowired
    private BackpackService backpackService;

    //get all products
    @GetMapping("/getbackpacks")
    public List<Backpack> getAllBackpacks() {
        return backpackService.getAllBackpacks();
    }

    //get products by id
    @GetMapping("/getbackpack/{id}")
    public Backpack getBackpackById(@PathVariable(value = "id") long backpackId) {
        return  backpackService.findById(backpackId).orElseThrow
                (() -> new ResourceNotFoundException("Backpack not found with ID: " + backpackId));
    }

    // create product
    @PostMapping("/addbackpack")
    public Optional<Backpack> addBackpack(@RequestBody Backpack backpack) {
         backpackService.save(backpack);
         return backpackRepository.findById(backpack.getBackpackId());
    }

    @PutMapping("/updatebackpack/{id}")
    public Backpack updateBackpack(@RequestBody Backpack backpack, @PathVariable ("id") long backpackId) {
        Backpack existingBackpack = backpackService.findById(backpackId).orElseThrow
                (() -> new ResourceNotFoundException("Backpack not found with ID: " + backpackId));
        existingBackpack.setTitle(backpack.getTitle());
        existingBackpack.setColor(backpack.getColor());
        existingBackpack.setPrice(backpack.getPrice());
        existingBackpack.setDescription(backpack.getDescription());
        existingBackpack.setImage(backpack.getImage());
        existingBackpack.setInStock(backpack.getInStock());
        return this.backpackRepository.save(existingBackpack);
    }

    @DeleteMapping("/deletebackpack/{id}")
    public ResponseEntity<Backpack> deleteBackpack(@PathVariable ("id") long backpackId) {
        Backpack existingBackpack = backpackService.findById(backpackId).orElseThrow
                (() -> new ResourceNotFoundException("Backpack not found with ID: " + backpackId));
        backpackService.delete(existingBackpack);
        return ResponseEntity.ok().build();
    }

}
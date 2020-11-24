package com.example.myFinalProject.services;

import com.example.myFinalProject.model.Backpack;
import com.example.myFinalProject.repositories.BackpackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BackpackService {

    @Autowired
    private BackpackRepository backpackRepository;

    public List<Backpack> getAllBackpacks() {
        return (List<Backpack>) backpackRepository.findAll();
    }

    public Optional<Backpack> findById(long productId) {
        return backpackRepository.findById(productId);
    }

    public Backpack save(Backpack backpack) {
        return backpackRepository.save(backpack);
    }

    public void delete(Backpack existingBackpack) {
        backpackRepository.delete(existingBackpack);
    }
}

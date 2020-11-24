package com.example.myFinalProject.repositories;

import com.example.myFinalProject.model.Backpack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackpackRepository extends CrudRepository<Backpack, Long> {
}

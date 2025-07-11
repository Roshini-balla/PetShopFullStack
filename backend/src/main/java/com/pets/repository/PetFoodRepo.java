package com.pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets.entity.PetFood;

@Repository
public interface PetFoodRepo extends JpaRepository<PetFood, Integer> {


}

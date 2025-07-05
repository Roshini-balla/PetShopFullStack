package com.pets.service;

import java.util.List;

import com.pets.entity.PetFood;

public interface PetFoodService {

	public List<PetFood> retrieveAllPetFood();
	public PetFood getFoodById(int foodId);
	public PetFood addFood(PetFood petfood);
	public PetFood updateFood(int food_id, PetFood updatedPetFoods);
	public PetFood deleteByFoodId(int food_id);
}

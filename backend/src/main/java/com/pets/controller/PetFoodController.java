package com.pets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pets.entity.PetFood;
import com.pets.serviceImpl.PetFoodServiceImpl;

@RestController
@CrossOrigin(allowedHeaders="*",origins="*")
@RequestMapping("/api/v1/pet_foods")
public class PetFoodController {
	
	@Autowired
	PetFoodServiceImpl petfood_ser;
	
	@GetMapping
	public List<PetFood> retreiveAl(){
		return petfood_ser.retrieveAllPetFood();
	}
	
	@GetMapping("/{food_id}")
	public PetFood retreiveFoodByfoodId(@PathVariable("food_id") int foodId)
	{
		return petfood_ser.getFoodById(foodId);
	}
	
	@PostMapping("/add")
	public PetFood addFood(@RequestBody PetFood petfood)
	{
		return petfood_ser.addFood(petfood);
		
	}
	
	@PutMapping("/update/{food_id}")
	public PetFood updateFood(@PathVariable("food_id") Integer foodId,@RequestBody PetFood petfood) throws Throwable 

	{
		return petfood_ser.updateFood(foodId,petfood);
	}
	
	@DeleteMapping("/delete/{food_id}")
	public PetFood deleteFood(@PathVariable("food_id") Integer food_id)
	{
	   return petfood_ser.deleteByFoodId(food_id);
	}

}

package com.pets.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets.entity.PetFood;
import com.pets.exceptions.DuplicateIdFoundException;
import com.pets.exceptions.NoSuchDataFoundException;
import com.pets.exceptions.NoSuchIdFoundException;
import com.pets.repository.PetFoodRepo;
import com.pets.service.PetFoodService;

@Service
public class PetFoodServiceImpl implements PetFoodService {

	@Autowired
	PetFoodRepo petFoodRepo;
	
	@Override
	public List<PetFood> retrieveAllPetFood() throws NoSuchDataFoundException
	{	
		List<PetFood> petFood = petFoodRepo.findAll();
		if(petFood.isEmpty())
		{
			throw new NoSuchDataFoundException("No food data found with this Id");
		}
		return petFood;
	}

	@Override
	public PetFood getFoodById(int food_id) throws NoSuchIdFoundException
	{
		try
		{
			PetFood petFood = petFoodRepo.findById(food_id).get();
			return petFood;
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No food found with this Id");
		}
	}

	@Override
	public PetFood addFood(PetFood petFood) throws DuplicateIdFoundException 
	{
		if(petFoodRepo.existsById(petFood.getFoodId()))
		{
			throw new DuplicateIdFoundException("Food with Id already exists");
		}
		//System.out.println("Data added successfully");
		return petFoodRepo.save(petFood);
	}

	@Override
	public PetFood updateFood(int food_id, PetFood petFood)  throws NoSuchIdFoundException
	{
		try
		{
			PetFood existingPetFood = petFoodRepo.findById(food_id).get();
			existingPetFood.setName(petFood.getName());
			existingPetFood.setBrand(petFood.getBrand());
			existingPetFood.setType(petFood.getType());
			existingPetFood.setQuantity(petFood.getQuantity());
			existingPetFood.setPrice(petFood.getPrice());
			//System.out.println("Data updated successfully");
			return petFoodRepo.save(existingPetFood);
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No food found with this Id so food cannot be updated");
		}
			
	}

	@Override
	public PetFood deleteByFoodId(int food_id) throws NoSuchIdFoundException
	{
		try
		{
			PetFood food=petFoodRepo.findById(food_id).get();
		    petFoodRepo.deleteById(food_id);
		    //System.out.println("Data deleted successfully");
		    return food;
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No food found with this Id so food cannot be deleted");
		}
	    
	}
	
}

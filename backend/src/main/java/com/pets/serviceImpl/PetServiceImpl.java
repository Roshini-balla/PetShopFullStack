package com.pets.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets.entity.Pets;
import com.pets.exceptions.DuplicateIdFoundException;
import com.pets.exceptions.NoSuchDataFoundException;
import com.pets.exceptions.NoSuchIdFoundException;
import com.pets.repository.PetsRepo;
import com.pets.service.PetService;

@Service
public class PetServiceImpl implements PetService {
	
	@Autowired
	private PetsRepo pet_repo;
	
	@Override
	public List<Pets> retreiveAllPets() throws NoSuchDataFoundException
	{
		List<Pets> p = pet_repo.findAll();
		if(p.isEmpty())
		{
			throw new NoSuchDataFoundException("No pets data found with this Id");
		}
		return p;
	}
	
	@Override
	public Pets retreiveById(int id) throws NoSuchIdFoundException
	{
		try
		{
			Pets p =pet_repo.findById(id).get();
			return p;
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No pet found with this Id");
		}
	}

	
	@Override
	public Pets addPets(Pets pet) throws DuplicateIdFoundException
	{
		if(pet_repo.existsById(pet.getPetId()))
		{
			throw new DuplicateIdFoundException("Pet with Id already exists");
		}
		Pets p = pet_repo.save(pet);
		//System.out.println("Data added successfully");
		return p;
        
    }
	
	@Override
	public Pets updatePets(Pets pet,int id) throws NoSuchIdFoundException
	{
		try
		{
			Pets p = pet_repo.findById(id).get();
			p.setAge(pet.getAge());
			p.setBreed(pet.getBreed());
			p.setDescription(pet.getDescription());
			p.setName(pet.getName());
			p.setPrice(pet.getPrice());
			//System.out.println("Data updated successfully");
			return pet_repo.save(p);
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No pet found with this Id so pet cannot be updated");
		}
		
	}
	
	@Override
	public Pets deleteByPetId(int pet_id) throws NoSuchIdFoundException
	{
		try
		{
			Pets pet=pet_repo.findById(pet_id).get();
		    pet_repo.deleteById(pet_id);
		    //System.out.println("Data deleted successfully");
		    return pet;
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No pet found with this Id so pet cannot be deleted");
		}
	    
	}

}

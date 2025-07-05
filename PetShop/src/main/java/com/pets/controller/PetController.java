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

import com.pets.entity.Pets;
import com.pets.serviceImpl.PetServiceImpl;

@RestController
@CrossOrigin(allowedHeaders="*",origins="*")
@RequestMapping("api/v1/pets")
public class PetController {

	@Autowired
	PetServiceImpl pet_service;
	
	@GetMapping
	public List<Pets> retreiveAll()
	{
		return pet_service.retreiveAllPets();
	}
	
	@GetMapping("/pet/{pet_id}")
	public Pets retreiveByPetId(@PathVariable("pet_id") int pet_id)
	{
		return pet_service.retreiveById(pet_id);
	}
	
	@PostMapping("/add")
	public Pets addPet(@RequestBody Pets pet)
	{	
		return pet_service.addPets(pet);
	}
	
	@PutMapping("/update/{pet_id}")
	public Pets updatePet(@RequestBody Pets pet,@PathVariable("pet_id") int pet_id)
	{
		return pet_service.updatePets(pet,pet_id);
	}
	
	@DeleteMapping("/delete/{pet_id}")
	public Pets deletePet(@PathVariable("pet_id") Integer pet_id)
	{
	   return pet_service.deleteByPetId(pet_id);
	}
	
}

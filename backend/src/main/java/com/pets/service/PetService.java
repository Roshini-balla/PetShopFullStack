package com.pets.service;

import java.util.List;

import com.pets.entity.Pets;

public interface PetService {

	List<Pets> retreiveAllPets(); 
	
	Pets retreiveById(int id);

	Pets addPets(Pets pet);
	
	Pets updatePets(Pets pet,int id);
	
	Pets deleteByPetId(int pet_id);
	
}

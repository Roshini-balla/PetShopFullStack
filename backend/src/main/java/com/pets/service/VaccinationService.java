package com.pets.service;

import java.util.List;

import com.pets.entity.Vaccinations;

public interface VaccinationService {

	List<Vaccinations>getAllVaccinations(); 
	Vaccinations getVaccinationsByServiceId(int vaccinationId); 
	List<Vaccinations> getAllVaccinationsAvailable();
	List<Vaccinations> getAllVaccinationsUnavailable();
	Vaccinations addVaccinationService(Vaccinations vaccinations); 
	Vaccinations updateVaccinationService(int vaccinationId,Vaccinations updatedVaccinationService); 
	Vaccinations deleteByVaccinationId(int vaccination_id);

}

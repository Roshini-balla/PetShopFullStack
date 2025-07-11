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

import com.pets.entity.Vaccinations;
import com.pets.serviceImpl.VaccinationServiceImpl;

@RestController
@CrossOrigin(allowedHeaders="*",origins="*")
@RequestMapping("/api/v1/vaccinations")
public class VaccinationController {
	
	@Autowired
	private VaccinationServiceImpl vac_service;
	
	 @GetMapping
	 public List<Vaccinations> retrieveAll()
	 {
		 return vac_service.getAllVaccinations();	
	 }
	
	 
	 @GetMapping("/{vaccinationId}")
	 public Vaccinations retrieveByVaccinationId(@PathVariable("vaccinationId") int vaccinationId)
	 {
		 return vac_service.getVaccinationsByServiceId(vaccinationId);
	    	
	 }
	 
	@GetMapping("/available")
	public List<Vaccinations> getAllVacAvailable(){
		return vac_service.getAllVaccinationsAvailable();
	}
	
	@GetMapping("/unavailable")
	public List<Vaccinations> getAllVacUnavailable(){
		return vac_service.getAllVaccinationsUnavailable();
	}
	
	 @PostMapping("/add")
	 public Vaccinations addVaccinationService(@RequestBody Vaccinations vaccinations) 
	 {
		 return vac_service.addVaccinationService(vaccinations);	
	 }
	 
	 @PutMapping("/update/{vaccinationId}")
	 public Vaccinations updateVaccinationService(@PathVariable("vaccinationId") Integer vaccinationId,@RequestBody Vaccinations vaccinationservice)
	 {
		 return vac_service.updateVaccinationService(vaccinationId,vaccinationservice);
	 }
	 
	 @DeleteMapping("/delete/{vaccination_id}")
	 public Vaccinations deleteVaccinationService(@PathVariable("vaccination_id") Integer vaccination_id)
	 {
		 return vac_service.deleteByVaccinationId(vaccination_id);
	 }

}

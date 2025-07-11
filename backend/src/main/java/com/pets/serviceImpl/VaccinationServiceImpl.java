package com.pets.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pets.entity.Vaccinations;
import com.pets.exceptions.DuplicateIdFoundException;
import com.pets.exceptions.NoSuchDataFoundException;
import com.pets.exceptions.NoSuchIdFoundException;
import com.pets.exceptions.NoAvailableServicesFoundException;
import com.pets.exceptions.NoUnavailableServicesFoundException;
import com.pets.repository.VaccinationRepo;
import com.pets.service.VaccinationService;

@Service
public class VaccinationServiceImpl implements VaccinationService {

	@Autowired
	private VaccinationRepo vaccinationrepos;
	
	@Override
	public List<Vaccinations>getAllVaccinations() throws NoSuchDataFoundException
    {
		List<Vaccinations> vsl=vaccinationrepos.findAll();
		if(vsl.isEmpty())
		{
			throw new NoSuchDataFoundException("No vaccination data found with this Id");
		}
		return vsl;	
    }
	
	@Override
	public  Vaccinations getVaccinationsByServiceId(int vaccinationId) throws NoSuchIdFoundException 
	{
		try
		{
			Vaccinations  vs = vaccinationrepos.findById(vaccinationId).get();	
    		return vs;
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No vaccination found with this Id");
		}
	}

	@Override
	public List<Vaccinations> getAllVaccinationsAvailable() throws NoAvailableServicesFoundException 
	{
		List<Vaccinations> vaccinations = vaccinationrepos.findByAvailable();
		if(vaccinations.isEmpty())
		{
			throw new NoAvailableServicesFoundException("No vaccinations available");
		}
		return vaccinationrepos.findByAvailable();
	}
	
	@Override
	public List<Vaccinations> getAllVaccinationsUnavailable() throws NoUnavailableServicesFoundException
	{
		List<Vaccinations> vaccinations = vaccinationrepos.findByUnavailable();
		if(vaccinations.isEmpty())
		{
			throw new NoUnavailableServicesFoundException("No vaccinations unavailable");
		}
		return vaccinationrepos.findByUnavailable();
	}

	@Override
	public Vaccinations addVaccinationService(Vaccinations vaccinations) throws DuplicateIdFoundException
	{
		if(vaccinationrepos.existsById(vaccinations.getVaccinationId()))
		{
			throw new DuplicateIdFoundException("Vaccination with Id already exists");
		}
		Vaccinations v=vaccinationrepos.save(vaccinations);
		//System.out.println("Data added successfully");
    	return v;
	}
	  
	@Override
	public Vaccinations updateVaccinationService(int vaccinationId,Vaccinations updatedVaccinationService) throws NoSuchIdFoundException
	{
		try
		{
			Vaccinations vaccinationservice=vaccinationrepos.findById(vaccinationId).get();
			vaccinationservice.setName( updatedVaccinationService.getName());
			vaccinationservice.setDescription(updatedVaccinationService.getDescription());
			vaccinationservice.setPrice(updatedVaccinationService.getPrice());
			vaccinationservice.setAvailable(updatedVaccinationService.getAvailable());
			//System.out.println("Data updated successfully");
			return vaccinationrepos.save(vaccinationservice);
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No vaccination found with this Id so vaccination cannot be updated");
		}
		
		
	}
	
	@Override
	public Vaccinations deleteByVaccinationId(int vaccination_id) throws NoSuchIdFoundException
	{
		try
		{
			Vaccinations vaccination=vaccinationrepos.findById(vaccination_id).get();
		    vaccinationrepos.deleteById(vaccination_id);
		    //System.out.println("Data deleted successfully");
		    return vaccination; 
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No vaccination found with this Id so vaccination cannot be deleted");
		}
	   
	}
	
	
}

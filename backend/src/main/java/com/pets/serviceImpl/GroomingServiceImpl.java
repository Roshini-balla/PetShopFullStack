package com.pets.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets.entity.GroomingServices;
import com.pets.exceptions.DuplicateIdFoundException;
import com.pets.exceptions.NoSuchDataFoundException;
import com.pets.exceptions.NoSuchIdFoundException;
import com.pets.exceptions.NoAvailableServicesFoundException;
import com.pets.exceptions.NoUnavailableServicesFoundException;
import com.pets.repository.GroomingServicesRepo;
import com.pets.service.GroomingService;

@Service
public class GroomingServiceImpl implements GroomingService {

	@Autowired
	GroomingServicesRepo groomingServiceRepo;
	
	@Override
	public List<GroomingServices> getAllGroomingServices() throws NoSuchDataFoundException
	{
		
		List<GroomingServices> gr_services = groomingServiceRepo.findAll();
		if(gr_services.isEmpty())
		{
			throw new NoSuchDataFoundException("No grooming services data found with this Id");
		}
		return gr_services;
	}

	@Override
	public GroomingServices getGroomingServicesByServiceId(int service_id) throws NoSuchIdFoundException
	{
		try
		{
			GroomingServices gr_service = groomingServiceRepo.findById(service_id).get();
			return gr_service;
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No service found with this Id");
		}
			
	}

	@Override
	public List<GroomingServices> getAvailableGroomingServices() throws NoAvailableServicesFoundException
	{
		List<GroomingServices> gr_services = groomingServiceRepo.findAllAvailable();
		if(gr_services.isEmpty())
		{
			throw new NoAvailableServicesFoundException("No grooming services available");
		}
		return gr_services;
	}

	@Override
	public List<GroomingServices> getUnavailableGroomingServices() throws NoUnavailableServicesFoundException
	{
		
		List<GroomingServices> gr_services = groomingServiceRepo.findAllUnavailable();
		if(gr_services.isEmpty())
		{
			throw new NoUnavailableServicesFoundException("No grooming services unavailable");
		}
		return gr_services;
	}

	@Override
	public GroomingServices addGroomingService(GroomingServices service) throws DuplicateIdFoundException
	{
		if(groomingServiceRepo.existsById(service.getServiceId()))
		{
			throw new DuplicateIdFoundException("Service with Id already exists");
		}
		GroomingServices gr_service = groomingServiceRepo.save(service);
		//System.out.println("Data added successfully");
		return gr_service;
	}

	@Override
	public GroomingServices updateGroomingService(int service_id, GroomingServices service) throws NoSuchIdFoundException
	{
		try
		{
			GroomingServices gr_service = groomingServiceRepo.findById(service_id).get();
			gr_service.setName(service.getName());
			gr_service.setDescription(service.getDescription());
			gr_service.setPrice(service.getPrice());
			gr_service.setAvailable(service.getAvailable());
			//System.out.println("Data updated successfully");
			return groomingServiceRepo.save(gr_service);
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No service found with this Id so service cannot be updated");
		}
		
	}
	
	@Override
	public GroomingServices deleteByServiceId(int service_id) throws NoSuchIdFoundException 
	{
		try
		{
			GroomingServices service=groomingServiceRepo.findById(service_id).get();
		    groomingServiceRepo.deleteById(service_id);
		    //System.out.println("Data deleted successfully");
		    return service;
		}
		catch(NoSuchElementException ex)
		{
			throw new NoSuchIdFoundException("No service found with this Id so service cannot be deleted");
		}
	    
	}
	
}

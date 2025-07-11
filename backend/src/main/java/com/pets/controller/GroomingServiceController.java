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

import com.pets.entity.GroomingServices;
import com.pets.serviceImpl.GroomingServiceImpl;

@RestController
@CrossOrigin(allowedHeaders="*",origins="*")
@RequestMapping("/api/v1/services")
public class GroomingServiceController {
	
	@Autowired
    GroomingServiceImpl grooming_service;
	
	@GetMapping
    public List<GroomingServices> retrieveAll()
	{
		return grooming_service.getAllGroomingServices();
    }
    
    @GetMapping("/{service_id}")
    public GroomingServices retrieveByGroomingServiceId(@PathVariable("service_id") int serviceId)
    {
		return grooming_service.getGroomingServicesByServiceId( serviceId);
    }
    
    @GetMapping("/available")
    public List<GroomingServices> getAvailableServices()
    {
        return grooming_service.getAvailableGroomingServices();
    }
    
    @GetMapping("/unavailable")
    public List<GroomingServices> getUnAvailableServices()
    {
        return grooming_service.getUnavailableGroomingServices();
    }
    
    @PostMapping("/add")
	public GroomingServices addGroomingService(@RequestBody GroomingServices groomingservices)
	{
		return grooming_service.addGroomingService(groomingservices);
	}
    
    @PutMapping("/update/{service_id}")
	public GroomingServices updateGroomingService(@PathVariable("service_id") Integer service_id,@RequestBody GroomingServices groomingservice) 
    {
		return grooming_service.updateGroomingService(service_id,groomingservice);
	}
    
    @DeleteMapping("/delete/{service_id}")
	public GroomingServices deleteGroomingService(@PathVariable("service_id") Integer service_id)
	{
	   return grooming_service.deleteByServiceId(service_id);
	}

}

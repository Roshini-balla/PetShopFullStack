package com.pets.service;

import java.util.List;

import com.pets.entity.GroomingServices;

public interface GroomingService {

	List<GroomingServices> getAllGroomingServices(); 
	GroomingServices getGroomingServicesByServiceId(int serviceId); 
	List<GroomingServices> getAvailableGroomingServices(); 
	List<GroomingServices> getUnavailableGroomingServices(); 
	GroomingServices addGroomingService(GroomingServices groomingservices); 
	GroomingServices updateGroomingService(int serviceId,GroomingServices updatedgroomingService); 
	GroomingServices deleteByServiceId(int service_id);

}

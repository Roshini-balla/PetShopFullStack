package com.pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pets.entity.GroomingServices;

@Repository
public interface GroomingServicesRepo extends JpaRepository<GroomingServices, Integer>{
		@Query("select g from GroomingServices as g where g.available=1")
		List<GroomingServices> findAllAvailable();
		@Query("select g from GroomingServices as g where g.available=0")
		List<GroomingServices> findAllUnavailable();
		
}

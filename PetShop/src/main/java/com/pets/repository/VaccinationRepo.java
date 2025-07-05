package com.pets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pets.entity.Vaccinations;

@Repository
public interface VaccinationRepo extends JpaRepository<Vaccinations, Integer> {

	@Query("select v from Vaccinations as v where v.available=1")
	List<Vaccinations> findByAvailable();
	@Query("select v from Vaccinations as v where v.available=0")
	List<Vaccinations> findByUnavailable();
}

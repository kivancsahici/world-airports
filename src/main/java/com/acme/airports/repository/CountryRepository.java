package com.acme.airports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.airports.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>, CountryRepositoryCustom{

	Country findByCode(String code);
	Country findByName(String name);
}

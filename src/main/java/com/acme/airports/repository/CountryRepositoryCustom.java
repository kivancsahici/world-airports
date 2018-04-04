package com.acme.airports.repository;

import java.util.List;
import com.acme.airports.model.DTO;

public interface CountryRepositoryCustom {
	List<DTO> airportCount();
	List<String> getSurfacesByCountry(String countryCode);
	List<String> getTopRunwayIdentifications(String countryName);
}



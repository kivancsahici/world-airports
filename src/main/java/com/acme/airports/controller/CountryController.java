package com.acme.airports.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.acme.airports.model.Country;
import com.acme.airports.model.Report;
import com.acme.airports.service.AirportService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/")
public class CountryController {
	@Autowired
	private AirportService airportService;

	@JsonView(Views.Lazy.class)
	@RequestMapping("/countries")
	public List<Country> countries() {
		return airportService.findAll();		
	}
	
	@JsonView(Views.Eager.class)
	@RequestMapping("/countries/{countryName}")
	public Country countriesDetailed(@PathVariable("countryName") String name) {
		return airportService.findByName(name);
	}
	
	@RequestMapping("/report")
	public Report report() {
		return airportService.getReport();
	}
}

package com.acme.airports.service;

import java.util.List;

import com.acme.airports.model.Country;
import com.acme.airports.model.Report;

public interface AirportService {
	public Report getReport();
	public List<Country> findAll();
	public Country findByName(String name);
}

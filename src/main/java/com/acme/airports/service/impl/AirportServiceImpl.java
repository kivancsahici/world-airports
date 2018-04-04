package com.acme.airports.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.airports.model.Country;
import com.acme.airports.model.DTO;
import com.acme.airports.model.Report;
import com.acme.airports.repository.CountryRepository;
import com.acme.airports.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	private CountryRepository countryRepository;		

	@Override
	public Report getReport() {
		
		List<DTO> list = countryRepository.airportCount();
		List<DTO> max = null;
		List<DTO> min = null;
		if(list.size() >= 20) {
			max = list.subList(0, 10);
			min = list.subList(list.size() - 10, list.size());
		}
				
		for(DTO dto : max)  {
			List<String> surfaceList = countryRepository.getSurfacesByCountry(dto.getName());
			StringBuffer buf = new StringBuffer();
			for(String surface : surfaceList)
				buf.append(surface).append(", ");
			// remove trailing comma characters
			String runways = buf.toString().replaceAll(", $", "");
			dto.setRunwayTypes(runways);
			
			List<String> runwayIdentifications = countryRepository.getTopRunwayIdentifications(dto.getName());
			//reset buffer
			buf.setLength(0);
			//aggregate results into a single String
			for(int i = 0; i < runwayIdentifications.size() && i < 10; i++) {
				buf.append(runwayIdentifications.get(i)).append(", ");
			}							
			dto.setRunwayIdentifications(buf.toString().replaceAll(", $", ""));
		}
				
		for(DTO dto : min)  {			
			List<String> surfaceList = countryRepository.getSurfacesByCountry(dto.getName());
			StringBuffer buf = new StringBuffer();
			for(String surface : surfaceList)
				buf.append(surface).append(", ");
			// remove trailing comma characters
			String runways = buf.toString().replaceAll(", $", "");
			dto.setRunwayTypes(runways);
			
			List<String> runwayIdentifications = countryRepository.getTopRunwayIdentifications(dto.getName());
			
			//reset buffer
			buf.setLength(0);
			//aggregate results into a single String
			for(int i = 0; i < runwayIdentifications.size() && i < 10; i++) {
				buf.append(runwayIdentifications.get(i)).append(", ");
			}							
			dto.setRunwayIdentifications(buf.toString().replaceAll(", $", ""));
		}
		Report report = new Report(max, min);
				
		return report;
	}

	@Override
	public List<Country> findAll() {
		List<Country> list = countryRepository.findAll();				
		return list;		
	}

	@Override
	public Country findByName(String name) {
		return countryRepository.findByName(name);		
	}

}

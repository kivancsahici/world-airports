package com.acme.airports.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import com.acme.airports.model.DTO;

public class CountryRepositoryImpl implements CountryRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public List<DTO> airportCount() {
		List<DTO> list = em.createQuery("SELECT NEW com.acme.airports.model.DTO( COUNT(b.id), a.name) FROM Airport b, Country a  where a.code = b.iso_country GROUP BY a.name order by count(b.id) desc").getResultList();		
		return list;
	}
	
	
	
	@Override
	@Transactional
	public List<String> getSurfacesByCountry(String countryCode) {				
		Query query = em.createNamedQuery("Country.getSurfacePerCountry");
		query.setParameter("code", countryCode);				
		List<String> list = query.getResultList();		
		return list;
		
	}

	@Override
	@Transactional
	public List<String> getTopRunwayIdentifications(String countryName) {
		Query query = em.createNamedQuery("Country.getRunwayIdentificationsPerCountry");
		query.setParameter("name", countryName);
		List<String> runwayIdentifications = query.getResultList();
		return runwayIdentifications;
	}
}

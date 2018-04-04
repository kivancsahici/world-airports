package com.acme.airports.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.acme.airports.controller.Views;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@EntityScan
@NamedQueries({
@NamedQuery(name="Country.getSurfacePerCountry", query="SELECT DISTINCT upper(c.surface) FROM Country a, Airport b, Runway c where a.name = :code and a.code = b.iso_country and b.id = c.airport_ref"),
@NamedQuery(name="Country.getRunwayIdentificationsPerCountry", query="select c.le_ident from Country a, Airport b, Runway c where a.code = b.iso_country and b.id = c.airport_ref and a.name = :name group by a.code, c.le_ident order by a.code, count(c.le_ident) desc")
})
public class Country implements Serializable{
	private static final long serialVersionUID = 2976102889581906993L;

	private int id;
	
	@JsonView(Views.Lazy.class)
	private String code;
	
	@JsonView(Views.Lazy.class)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "iso_country", cascade = CascadeType.ALL)
	@JsonView(Views.Eager.class)
	private Set<Airport> airports;

	public Country() {
		super();
	}

	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	public Country(String code, String name, Set<Airport> airports) {
		super();
		this.code = code;
		this.name = name;
		this.airports = airports;
	}

	@Id
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "iso_country", cascade = CascadeType.ALL)
	public Set<Airport> getAirports() {
		return airports;
	}
	
	
	public void setAirports(Set<Airport> airports) {
		this.airports = airports;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

package com.acme.airports.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.acme.airports.controller.Views;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@EntityScan
public class Airport implements Serializable {
	private static final long serialVersionUID = 8370594168813136094L;

	@Column(name = "ID")
	@JsonView(Views.Eager.class)
	private int id;

	@Column(name = "NAME")
	@JsonView(Views.Eager.class)
	private String name;

	private String iso_country;
	
	@JsonView(Views.Eager.class)
	private Set<Runway> runways;

	public Airport() {

	}

	public Airport(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIso_country() {
		return iso_country;
	}

	public void setIso_country(String iso_country) {
		this.iso_country = iso_country;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "airport_ref", cascade = CascadeType.ALL)
	public Set<Runway> getRunways() {
		return runways;
	}

	public void setRunways(Set<Runway> runways) {
		this.runways = runways;
	}
}

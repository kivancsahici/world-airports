package com.acme.airports.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.acme.airports.controller.Views;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Runway {
	@JsonView(Views.Eager.class)
	private int id;
	@JsonView(Views.Eager.class)
	private int airport_ref;
	@JsonView(Views.Eager.class)
	private String airport_ident;
	@JsonView(Views.Eager.class)
	private String surface;
	@JsonView(Views.Eager.class)
	private String le_ident;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAirport_ref() {
		return airport_ref;
	}
	public void setAirport_ref(int airport_ref) {
		this.airport_ref = airport_ref;
	}
	public String getAirport_ident() {
		return airport_ident;
	}
	public void setAirport_ident(String airport_ident) {
		this.airport_ident = airport_ident;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public String getLe_ident() {
		return le_ident;
	}
	public void setLe_ident(String le_ident) {
		this.le_ident = le_ident;
	}

}

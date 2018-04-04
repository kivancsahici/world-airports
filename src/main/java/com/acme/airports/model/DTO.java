package com.acme.airports.model;

public class DTO {
	public DTO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private long id;
	private String name;
	private String runwayTypes;
	private String runwayIdentifications;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "DTO [id=" + id + ", name=" + name + "]";
	}
	public String getRunwayTypes() {
		return runwayTypes;
	}
	public void setRunwayTypes(String runwayTypes) {
		this.runwayTypes = runwayTypes;
	}
	public String getRunwayIdentifications() {
		return runwayIdentifications;
	}
	public void setRunwayIdentifications(String runwayIdentifications) {
		this.runwayIdentifications = runwayIdentifications;
	}
}

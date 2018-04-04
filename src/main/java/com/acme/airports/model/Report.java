package com.acme.airports.model;

import java.util.List;

public class Report {	
	public Report(List<DTO> max, List<DTO> min) {
		super();
		this.max = max;
		this.min = min;
	}
	private List<DTO> max;
	private List<DTO> min;
	public List<DTO> getMax() {
		return max;
	}
	public void setMax(List<DTO> max) {
		this.max = max;
	}
	public List<DTO> getMin() {
		return min;
	}
	public void setMin(List<DTO> min) {
		this.min = min;
	}
}

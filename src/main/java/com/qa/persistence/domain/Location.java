package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Location {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long locationID;
	private String countryName;
	private String locationName;
	private String image;
	private String description;
	
	public Location() {
		
	}
	
	public Location(String locationName, String description) {
		this.locationName = locationName;
		this.description = description;
	}

	public Long getLocationID() {
		return locationID;
	}

	public void setLocationID(Long locationID) {
		this.locationID = locationID;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	@Override
	public String toString() {
		return "Country Name: " + countryName + ", Location Name: " + locationName + ",Image:" + image + ", Description: " + description ;
	}
}

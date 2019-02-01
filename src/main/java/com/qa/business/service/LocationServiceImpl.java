package com.qa.business.service;

import com.qa.persistence.repository.LocationRepository;
import javax.inject.Inject;

public class LocationServiceImpl implements LocationService{

	@Inject
	private LocationRepository repo;
	
	public String getAllLocations() {
		return repo.getAllLocations();
	}

	public String createLocation(String location) {
		return repo.createLocation(location);
	}

	public String updateLocation(Long locationID, String location) {
		return repo.updateLocation(locationID, location);
	}

	public String deleteLocation(Long locationID) {
		return repo.deleteLocation(locationID);
	}
	
	public void setRepo(LocationRepository repo) {
		this.repo = repo;
	}
}


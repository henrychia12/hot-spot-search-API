package com.qa.business.service;

public interface LocationService {
	
	String getAllLocations();

	String createLocation(String location);
	
	String updateLocation(Long locationID, String location);

	String deleteLocation(Long locationID);

}

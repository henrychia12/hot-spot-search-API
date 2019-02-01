package com.qa.persistence.repository;

public interface LocationRepository {
	
	String getAllLocations();

	String createLocation(String location);
	
	String updateLocation(Long locationID, String location);

	String deleteLocation(Long locationID);

}

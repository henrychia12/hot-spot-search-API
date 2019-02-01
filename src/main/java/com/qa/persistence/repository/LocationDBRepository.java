package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Location;
import com.qa.util.JSONUtil;

@Default
public class LocationDBRepository implements LocationRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	public String getAllLocations() {
		Query query = manager.createQuery("Select a FROM Location a");
		Collection<Location> locations = (Collection<Location>) query.getResultList();
		return util.getJSONForObject(locations);
	}
	
	@Transactional(REQUIRED)
	public String createLocation(String location) {
		Location newLocation = util.getObjectForJSON(location, Location.class);
		manager.persist(newLocation);
		return  "{\"message\": \"Location has been sucessfully created\"}";
	}

	public String updateLocation(Long locationID, String location) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteLocation(Long locationID) {
		// TODO Auto-generated method stub
		return null;
	}

}

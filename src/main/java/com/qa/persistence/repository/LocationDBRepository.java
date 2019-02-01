package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

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

	@Transactional(REQUIRED)
	public String updateLocation(Long locationID, String location) {
		Location locationInDB = findLocation(locationID);
		Location newLocation = util.getObjectForJSON(location, Location.class);
		if(locationInDB != null) {
			manager.remove(locationInDB);
			manager.persist(newLocation);
			return "{\"message\": \"has been sucessfully updated\"}";
		}
		return "{\"message\": \"details entered are invalid\"}";
	}

	@Transactional(REQUIRED)
	public String deleteLocation(Long locationID) {
		Location locationInDB = findLocation(locationID);
		if(locationInDB != null) {
			manager.remove(locationInDB);
			return "{\"message\": \"location sucessfully deleted\"}";
		}
		return "{\"message\": \"deletion unsuccessful\"}";
	}
	
	private Location findLocation(Long locationID) {
		return manager.find(Location.class, locationID);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}

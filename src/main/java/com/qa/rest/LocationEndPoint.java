package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.business.service.LocationService;

@Path("/location")
public class LocationEndPoint {

	@Inject
	private LocationService service;
	
	@Path("/getAllLocations")
	@GET
	@Produces({"application/json"})
	public String getAllLocations() {
		return service.getAllLocations();
	}
	
	@Path("/createLocation")
	@POST
	@Produces({"application/json"})
	public String createLOCATION(String location) {
		return service.createLocation(location);
	}
	
	@Path("/deleteLocation/{locationID}")
	@DELETE
	@Produces({ "application/json"})
	public String deleteLocation(@PathParam("locationID") Long locationID) {
		return service.deleteLocation(locationID);
	}
	
	@Path("/updateLocation/{locationID")
	@POST
	@Produces({ "application/json"})
	public String updateLocation(@PathParam("locationID") Long locationID, String location) {
		return service.updateLocation(locationID, location);
	}
	
	public void setService(LocationService service) {
		this.service = service;
	}
}

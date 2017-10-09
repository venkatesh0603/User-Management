/**
 * 
 */
package com.happiestMinds.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.happiestMinds.dao.GioDao;
import com.happiestMinds.utils.ApiResponse;

/**
 * @author Mahesh Chouhan
 *
 */
@Path("/gio")
public class GioService {

	@Autowired
	GioDao gioDao;
	
	private static Logger log = Logger.getLogger(GioService.class);

	@GET
	@Path("/countries")
	@Produces(MediaType.APPLICATION_JSON)
	public ApiResponse getCountries() {
		log.info("Inside getCountries of GioService");
		
		return gioDao.getCountries();
	}

	@GET
	@Path("/states/{country}")
	@Produces(MediaType.APPLICATION_JSON)
	public ApiResponse getStates(@PathParam("country") long country) {
		log.info("Inside getStates of GioService with country id -" + country);
		return gioDao.getStates(country);
	}

	@GET
	@Path("/cities/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	public ApiResponse getCities(@PathParam("state") long state) {
		log.info("Inside getCities of GioService with country id -" + state);
		return gioDao.getCities(state);
	}

}

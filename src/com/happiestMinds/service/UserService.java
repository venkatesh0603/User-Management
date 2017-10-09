package com.happiestMinds.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.happiestMinds.dao.UserDao;
import com.happiestMinds.utils.ApiResponse;
import com.happiestMinds.vo.UserVo;

/**
 * @author Mahesh Chouhan
 *
 */
@Path("/user")
public class UserService {

	private static Logger logger=Logger.getLogger(UserService.class);
	
	@Autowired
	UserDao userDao;
	

	@PUT
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ApiResponse addUser(UserVo user) {
		logger.info("Inside addUser method of UserService with user vo -- "+user);
		return userDao.addUser(user);
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public ApiResponse getUser(){
		logger.info("Inside getUser method of UserService");
		return userDao.getAllUser();
	}
	
	@POST
	@Path("/edit")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ApiResponse editUser(UserVo userVo){
		logger.info("Inside editUser method of UserService");
		return userDao.editUser(userVo);
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ApiResponse deleteUser(@PathParam("id")Long id){
		logger.info("Inside deleteUser method of UserService");
		return userDao.deleteUser(id);
	}
}

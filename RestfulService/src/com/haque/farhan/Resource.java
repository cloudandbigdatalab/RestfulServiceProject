package com.haque.farhan;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.haque.farhan.model.UserProfile;

/**
 * Root resource (exposed at "myresource" path)
@Path("myresource")
 */
@Path("/database")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {
	@GET
	@Path("/users")
	public List<UserProfile>getUserList(){
		Database dataBase=new Database();
		return dataBase.UserList();
	}
	
	@GET
	@Path("/helpers")
	public List<UserProfile>getHelperList(){
		HelperDatabase helperdataBase=new HelperDatabase();
		return helperdataBase.helperList();
	}
  
    
}

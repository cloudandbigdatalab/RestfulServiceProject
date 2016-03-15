package com.haque.farhan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.haque.farhan.model.UserProfile;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {
	Database dataBase=new Database();
	@GET
	public List<UserProfile>getUserList(){
		return dataBase.UserList();
	}
  
    
}

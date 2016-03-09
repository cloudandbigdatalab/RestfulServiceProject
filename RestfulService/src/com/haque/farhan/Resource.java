package com.haque.farhan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class Resource {

	/* public String hello(){
	return "Hello REST OCI!!!";
}*/ 
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String readDatabase() {
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String finalData = null;
		try {
			//new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
			String connectionUrl = "jdbc:mysql://mysql9.000webhost.com";
			String connectionUser = "a7747432_user";
			String connectionPassword = "bhaq2010";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM prediction");
			while (rs.next()) {
				String lat = rs.getString("goalNum");
				String lng = rs.getString("cardnum");
				String event = rs.getString("posDiff");
				//System.out.println("ID: " + id + ", First Name: " + firstName
					//	+ ", Last Name: " + lastName);
				finalData= lat+"\n"+lng+"\n"+event+"\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
    	
        return "Test REST";//finalData;
    }
}

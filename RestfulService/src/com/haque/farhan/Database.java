package com.haque.farhan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.haque.farhan.model.UserProfile;

public class Database {
	
	//private List<String>values= new ArrayList<>();
	private List<UserProfile>userData=new ArrayList<>();
	
	public Database() {
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//new com.mysql.jdbc.Driver();
			Class.forName("com.mysql.jdbc.GoogleDriver").newInstance();
// conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
			String connectionUrl = "jdbc:google:mysql://utsasecurity-1219:utsasecuritysqlinstance/userinformation";
			String connectionUser = "root";
			String connectionPassword = "";
			conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				String phone = rs.getString("Phone");
				String name = rs.getString("Name");
				String latitude = rs.getString("Latitude");
				String longitude= rs.getString("Longitude");
				String event=rs.getString("Event");
				//System.out.println("ID: " + id + ", First Name: " + firstName
					//	+ ", Last Name: " + lastName);
				//finalData= lat+"\n"+lng+"\n"+event+"\n";
				userData.add(new UserProfile(phone,name,latitude,longitude,event));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
    	
    }
	
	public List<UserProfile> UserList(){
		return userData;
	}

}

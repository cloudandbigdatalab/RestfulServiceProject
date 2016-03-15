package com.haque.farhan.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserProfile {
	private String name,event,latitude,longitude,phone;
	
	
	public UserProfile(){}
	public UserProfile(String phone,String name,String latitude,String longitude,String event){
		this.setPhone(phone);
		this.setName(name);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setEvent(event);
	}
	public void setEvent(String event) {
		this.event=event;
		
	}
	public void setLongitude(String longitude) {
		this.longitude=longitude;
		
	}
	public void setLatitude(String latitude) {
		this.latitude=latitude;
		
	}
	public void setName(String name) {
		this.name=name;
		
	}
	public void setPhone(String phone) {
		this.phone=phone;
		
	}
	public String getEvent() {
		return event;
	}
	public String getLatitude() {
		return latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
}

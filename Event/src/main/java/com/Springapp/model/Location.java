package com.Springapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table
public class Location {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
private int locationid;
private String location;
public int getLocationid() {
	return locationid;
}
public void setLocationid(int locationid) {
	this.locationid = locationid;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}


public Location(int locationid, String location ) {
	super();
	this.locationid = locationid;
	this.location = location;
	
}


@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="event_id")
private Event event;
}

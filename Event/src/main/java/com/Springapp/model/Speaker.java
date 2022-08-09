package com.Springapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Speaker {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int speakerid;
private String speakername;
public int getSpeakerid() {
	return speakerid;
}
public void setSpeakerid(int speakerid) {
	this.speakerid = speakerid;
}
public String getSpeakername() {
	return speakername;
}
public void setSpeakername(String speakername) {
	this.speakername = speakername;
}


public Speaker(int speakerid, String speakername, List<Event> event) {
	super();
	this.speakerid = speakerid;
	this.speakername = speakername;
	this.event = event;
}


@ManyToMany(mappedBy="speaker")
private List<Event> event;
}

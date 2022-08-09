package com.Springapp.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Event {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="event_id")
	private int eventid;
	private String eventname;
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}


	public Event(int eventid, String eventname, Location location, List<Attendee> attendee, List<Speaker> speaker) {
		super();
		this.eventid = eventid;
		this.eventname = eventname;
		this.location = location;
		this.attendee = attendee;
		this.speaker = speaker;
	}


	@OneToOne (cascade=CascadeType.ALL,mappedBy="event")

	private Location location;

	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="event_id")
	private List<Attendee> attendee;
	
	
	
	public List<Attendee> getAttendee() {
		return attendee;
	}
	public void setAttendee(List<Attendee> attendee) {
		this.attendee = attendee;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="event_speakers",
	joinColumns= {@JoinColumn(name="event_id")}, inverseJoinColumns= {@JoinColumn(name="speaker_id")})
	private List<Speaker> speaker;
	public List<Speaker> getSpeaker() {
		return speaker;
	}
	public void setSpeaker(List<Speaker> speaker) {
		this.speaker = speaker;
	}
	
	
	
	
//	@JoinTable(
//			name="Location_event",
//			joinColumns= @Join(name="event_id"),
//			inverseJoinColumns =@JoinColumn(name= "Location_id")
//			)

	
//	@OneToMany(mappedBy="event")
	
//	@OneToMany(mappedBy= "eventModel")
//private Attendee attendee;
	
}

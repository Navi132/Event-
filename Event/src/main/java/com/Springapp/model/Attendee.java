package com.Springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table
public class Attendee {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="attendee_id")
	private int attendeeid;
	private String attendeename;
	public int getAttendeeid() {
		return attendeeid;
	}
	public void setAttendeeid(int attendeeid) {
		this.attendeeid = attendeeid;
	}
	public String getAttendeename() {
		return attendeename;
	}
	public void setAttendeename(String attendeename) {
		this.attendeename = attendeename;
	}
	
public Attendee(int attendeeid, String attendeename, Event event) {
		super();
		this.attendeeid = attendeeid;
		this.attendeename = attendeename;
		this.event = event;
	}

//
@ManyToOne
@JoinColumn(name= "event_id")
private Event event;
}

package com.Springapp.Sevice;

import java.util.List;

import com.Springapp.model.Attendee;

public interface AttendeeService {


	
	List<Attendee> getattendeeList();

	Attendee getattendeebyid(int id);
	
	Attendee updateattendee(Attendee attendee, int id);
	
	void deleteAttendee(int id);

	Attendee saveattendee(Attendee attendee);
}

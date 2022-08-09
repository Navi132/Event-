package com.Springapp.Sevice;

import java.util.List;


import com.Springapp.model.Event;

public interface EventService {


	List<Event> geteventList();

	Event geteventbyid(int id);
	
	Event updateevent(Event event, int id);
	
	void deleteEvent(int id);

	Event saveevent(Event event);
}

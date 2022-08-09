package com.Springapp.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Springapp.Exception.ResourceNotFoundException;

import com.Springapp.Repository.EventRepository;
import com.Springapp.Sevice.EventService;
import com.Springapp.model.Event;



@Service
public class EventServiceImplementation implements EventService {
private EventRepository eventRepository;

	public EventServiceImplementation(EventRepository eventRepository) {
	super();
	this.eventRepository = eventRepository;
}
@Override
	public Event saveevent(Event event) {
		// TODO Auto-generated method stub
		return eventRepository.save(event);
	}

	@Override
	public List<Event> geteventList() {
		// TODO Auto-generated method stub
		return eventRepository.findAll();
	}

	@Override
	public Event geteventbyid(int id) {
		// TODO Auto-generated method stub
		Optional<Event> event=eventRepository.findById(id);
		if (event.isPresent())
		{
			return event.get();
		}
		else {
			throw new ResourceNotFoundException("event", "Id", id);
		}
	}

	@Override
	public Event updateevent(Event event, int id) {
		// TODO Auto-generated method stub
		Event existingevent=eventRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("event","Id",id));
		
	existingevent.setEventid(event.getEventid());
	existingevent.setEventname(event.getEventname());

	//saving to db
eventRepository.save(existingevent);

	return existingevent;
	}

	@Override
	public void deleteEvent(int id) {
		// TODO Auto-generated method stub
		eventRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("event","Id",id));
		
		
		eventRepository.deleteById(id);
	}

}
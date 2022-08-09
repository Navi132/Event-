package com.Springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springapp.Sevice.EventService;

import com.Springapp.model.Event;


@RestController 
@RequestMapping("/event/service")
public class EventControllerLayer {
private EventService eventService;

public EventControllerLayer(com.Springapp.Sevice.EventService EventService) {
	super();
	this.eventService = EventService;
}



@PostMapping()
public ResponseEntity<Event> saveevent(@RequestBody Event event){
	return new ResponseEntity<Event>(eventService.saveevent(event), HttpStatus.CREATED);
	}


@GetMapping
public ResponseEntity<List<Event>> getEventList(){
	List<Event> list= eventService.geteventList();
	if(list.size()<=0) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
return ResponseEntity.of(Optional.of(list));
}


@GetMapping("{id}")
public ResponseEntity<Event> getEventbyid(@PathVariable("id") int Eventid){
	
	return new ResponseEntity<Event>(eventService.geteventbyid(Eventid), HttpStatus.OK);
}




@PutMapping("{id}")
public ResponseEntity<Event> updateEvent(@PathVariable("id") int Eventid,@RequestBody Event Event ){
	return new ResponseEntity<Event>(eventService.updateevent(Event, Eventid),HttpStatus.OK);
	
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){

	eventService.deleteEvent(id);
	return new ResponseEntity<String>("Event deleted", HttpStatus.OK);
}
}

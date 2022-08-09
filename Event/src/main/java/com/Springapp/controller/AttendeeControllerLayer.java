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

import com.Springapp.Sevice.AttendeeService;

import com.Springapp.model.Attendee;


@RestController 
@RequestMapping("/attendee/service")
public class AttendeeControllerLayer {
private AttendeeService attendeeService;

public AttendeeControllerLayer(com.Springapp.Sevice.AttendeeService attendeeService) {
	super();
	this.attendeeService = attendeeService;
}




@PostMapping()
public ResponseEntity<Attendee> saveattendee(@RequestBody Attendee attendee){
	return new ResponseEntity<Attendee>(attendeeService.saveattendee(attendee), HttpStatus.CREATED);
	}

@GetMapping
public ResponseEntity<List<Attendee>> getEmployeeList(){
	List<Attendee> list= attendeeService.getattendeeList();
	if(list.size()<=0) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
return ResponseEntity.of(Optional.of(list));
}


@GetMapping("{id}")
public ResponseEntity<Attendee> getattendeebyid(@PathVariable("id") int attendeeid){
	
	return new ResponseEntity<Attendee>(attendeeService.getattendeebyid(attendeeid), HttpStatus.OK);
}



@PutMapping("{id}")
public ResponseEntity<Attendee> updateattendee(@PathVariable("id") int attendeeid,@RequestBody Attendee attendee ){
	return new ResponseEntity<Attendee>(attendeeService.updateattendee(attendee, attendeeid),HttpStatus.OK);
	
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){

	attendeeService.deleteAttendee(id);
	return new ResponseEntity<String>("Attendee deleted", HttpStatus.OK);
}
}

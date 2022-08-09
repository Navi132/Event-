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

import com.Springapp.Sevice.SpeakerService;

import com.Springapp.model.Speaker;


@RestController 
@RequestMapping("/speaker/service")
public class SpeakerControllerLayer {
private SpeakerService speakerService;

public SpeakerControllerLayer(com.Springapp.Sevice.SpeakerService speakerService) {
	super();
	this.speakerService = speakerService;
}




@PostMapping()
public ResponseEntity<Speaker> savespeaker(@RequestBody Speaker speaker){
	return new ResponseEntity<Speaker>(speakerService.savespeaker(speaker), HttpStatus.CREATED);
	}


@GetMapping
public ResponseEntity<List<Speaker>> getEmployeeList(){
	List<Speaker> list= speakerService.getspeakerList();
	if(list.size()<=0) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
return ResponseEntity.of(Optional.of(list));
}


@GetMapping("{id}")
public ResponseEntity<Speaker> getspeakerbyid(@PathVariable("id") int speakerid){
	
	return new ResponseEntity<Speaker>(speakerService.getspeakerbyid(speakerid), HttpStatus.OK);
}




@PutMapping("{id}")
public ResponseEntity<Speaker> updatespeaker(@PathVariable("id") int speakerid,@RequestBody Speaker speaker ){
	return new ResponseEntity<Speaker>(speakerService.updatespeaker(speaker, speakerid),HttpStatus.OK);
	
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){

	speakerService.deleteSpeaker(id);
	return new ResponseEntity<String>("Speaker deleted", HttpStatus.OK);
}
}

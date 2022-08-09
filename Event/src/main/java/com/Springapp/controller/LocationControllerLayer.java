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

import com.Springapp.Sevice.LocationService;

import com.Springapp.model.Location;


@RestController 
@RequestMapping("/location/service")
public class LocationControllerLayer {
private LocationService locationService;

public LocationControllerLayer(com.Springapp.Sevice.LocationService locationService) {
	super();
	this.locationService = locationService;
}




@PostMapping()
public ResponseEntity<Location> savelocation(@RequestBody Location location){
	return new ResponseEntity<Location>(locationService.savelocation(location), HttpStatus.CREATED);
	}


@GetMapping
public ResponseEntity<List<Location>> getEmployeeList(){
	List<Location> list= locationService.getlocationList();
	if(list.size()<=0) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
return ResponseEntity.of(Optional.of(list));
}


@GetMapping("{id}")
public ResponseEntity<Location> getlocationbyid(@PathVariable("id") int locationid){
	
	return new ResponseEntity<Location>(locationService.getlocationbyid(locationid), HttpStatus.OK);
}





@PutMapping("{id}")
public ResponseEntity<Location> updatelocation(@PathVariable("id") int locationid,@RequestBody Location location ){
	return new ResponseEntity<Location>(locationService.updatelocation(location, locationid),HttpStatus.OK);
	
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){

	locationService.deleteLocation(id);
	return new ResponseEntity<String>("Location deleted", HttpStatus.OK);
}
}

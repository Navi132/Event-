package com.Springapp.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Springapp.Exception.ResourceNotFoundException;

import com.Springapp.Repository.LocationRepository;
import com.Springapp.Sevice.LocationService;
import com.Springapp.model.Location;



@Service
public class LocationServiceImplementation implements LocationService {
private LocationRepository locationRepository;

	public LocationServiceImplementation(LocationRepository locationRepository) {
	super();
	this.locationRepository = locationRepository;
}
@Override
	public Location savelocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepository.save(location);
	}

	@Override
	public List<Location> getlocationList() {
		// TODO Auto-generated method stub
		return locationRepository.findAll();
	}

	@Override
	public Location getlocationbyid(int id) {
		// TODO Auto-generated method stub
		Optional<Location> location=locationRepository.findById(id);
		if (location.isPresent())
		{
			return location.get();
		}
		else {
			throw new ResourceNotFoundException("location", "Id", id);
		}
	}

	@Override
	public Location updatelocation(Location location, int id) {
		// TODO Auto-generated method stub
		Location existinglocation=locationRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("location","Id",id));
		
	existinglocation.setLocationid(location.getLocationid());
	existinglocation.setLocation(location.getLocation());

	//saving to db
locationRepository.save(existinglocation);

	return existinglocation;
	}

	@Override
	public void deleteLocation(int id) {
		// TODO Auto-generated method stub
		locationRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("location","Id",id));
		
		
		locationRepository.deleteById(id);
	}

}
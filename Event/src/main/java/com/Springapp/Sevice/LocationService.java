package com.Springapp.Sevice;

import java.util.List;

import com.Springapp.model.Location;

public interface LocationService {

	Location savelocation(Location location);

	List<Location> getlocationList();

	Location getlocationbyid(int locationid);

	Location updatelocation(Location location, int locationid);

	void deleteLocation(int id);

}

package com.Springapp.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Springapp.Exception.ResourceNotFoundException;
import com.Springapp.Repository.AttendeeRepository;
import com.Springapp.Sevice.AttendeeService;
import com.Springapp.model.Attendee;



@Service
public class AttendeeServiceImplementation implements AttendeeService {
private AttendeeRepository attendeeRepository;

	public AttendeeServiceImplementation(AttendeeRepository attendeeRepository) {
	super();
	this.attendeeRepository = attendeeRepository;
}
@Override
	public Attendee saveattendee(Attendee attendee) {
		// TODO Auto-generated method stub
		return attendeeRepository.save(attendee);
	}

	@Override
	public List<Attendee> getattendeeList() {
		// TODO Auto-generated method stub
		return attendeeRepository.findAll();
	}

	@Override
	public Attendee getattendeebyid(int id) {
		// TODO Auto-generated method stub
		Optional<Attendee> attendee=attendeeRepository.findById(id);
		if (attendee.isPresent())
		{
			return attendee.get();
		}
		else {
			throw new ResourceNotFoundException("attendee", "Id", id);
		}
	}

	@Override
	public Attendee updateattendee(Attendee attendee, int id) {
		// TODO Auto-generated method stub
		Attendee existingattendee=attendeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("attendee","Id",id));
		
	existingattendee.setAttendeeid(attendee.getAttendeeid());
	existingattendee.setAttendeename(attendee.getAttendeename());

	//saving to db
attendeeRepository.save(existingattendee);

	return existingattendee;
	}

	@Override
	public void deleteAttendee(int id) {
		// TODO Auto-generated method stub
		attendeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("attendee","Id",id));
		
		
		attendeeRepository.deleteById(id);
	}

}

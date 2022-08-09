package com.Springapp.Serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Springapp.Exception.ResourceNotFoundException;

import com.Springapp.Repository.SpeakerRepository;
import com.Springapp.Sevice.SpeakerService;
import com.Springapp.model.Speaker;



@Service
public class SpeakerServiceImplementation implements SpeakerService {
private SpeakerRepository speakerRepository;

	public SpeakerServiceImplementation(SpeakerRepository speakerRepository) {
	super();
	this.speakerRepository = speakerRepository;
}
@Override
	public Speaker savespeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		return speakerRepository.save(speaker);
	}

	@Override
	public List<Speaker> getspeakerList() {
		// TODO Auto-generated method stub
		return speakerRepository.findAll();
	}

	@Override
	public Speaker getspeakerbyid(int id) {
		// TODO Auto-generated method stub
		Optional<Speaker> speaker=speakerRepository.findById(id);
		if (speaker.isPresent())
		{
			return speaker.get();
		}
		else {
			throw new ResourceNotFoundException("speaker", "Id", id);
		}
	}

	@Override
	public Speaker updatespeaker(Speaker speaker, int id) {
		// TODO Auto-generated method stub
		Speaker existingspeaker=speakerRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("speaker","Id",id));
		
	existingspeaker.setSpeakername(speaker.getSpeakername());
	existingspeaker.setSpeakerid(speaker.getSpeakerid());

	//saving to db
speakerRepository.save(existingspeaker);

	return existingspeaker;
	}

	@Override
	public void deleteSpeaker(int id) {
		// TODO Auto-generated method stub
		speakerRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("speaker","Id",id));
		
		
		speakerRepository.deleteById(id);
	}

}
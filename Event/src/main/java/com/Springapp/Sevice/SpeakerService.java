package com.Springapp.Sevice;

import java.util.List;

import com.Springapp.model.Speaker;

public interface SpeakerService {

	void deleteSpeaker(int id);

	Speaker updatespeaker(Speaker speaker, int speakerid);

	Speaker getspeakerbyid(int speakerid);

	List<Speaker> getspeakerList();

	Speaker savespeaker(Speaker speaker);

}

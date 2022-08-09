package com.Springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springapp.model.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Integer> {

}

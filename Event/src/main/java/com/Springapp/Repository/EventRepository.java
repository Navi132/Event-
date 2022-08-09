package com.Springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springapp.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
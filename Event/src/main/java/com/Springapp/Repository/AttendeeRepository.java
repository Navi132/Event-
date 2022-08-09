package com.Springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springapp.model.Attendee;

public interface AttendeeRepository extends JpaRepository<Attendee, Integer> {

}

package com.Springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springapp.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}

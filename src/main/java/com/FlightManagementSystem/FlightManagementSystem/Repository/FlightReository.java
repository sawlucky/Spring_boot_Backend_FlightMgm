package com.FlightManagementSystem.FlightManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightManagementSystem.FlightManagementSystem.Model.Flight;

public interface FlightReository extends JpaRepository<Flight, Integer> {

	   Optional<Flight> findBySourceAndDestination(String source, String destination);
	
}

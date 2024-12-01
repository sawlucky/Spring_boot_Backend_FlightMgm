package com.FlightManagementSystem.FlightManagementSystem.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.FlightManagementSystem.FlightManagementSystem.Model.ApiResponce;
import com.FlightManagementSystem.FlightManagementSystem.Model.Flight;

@Repository
public class FlightRepo {
	@Autowired
	private FlightReository frepo;

	public ResponseEntity<ApiResponce<Flight>> saveData(Flight flight) {
		Flight f = frepo.save(flight);
		ApiResponce<Flight> api = new ApiResponce<Flight>(HttpStatus.FOUND.value(), "Data Saved Succesfully", f);
		return new ResponseEntity<ApiResponce<Flight>>(api, HttpStatus.FOUND);
	}

	public Optional<Flight> getDataById(int id) {
		return frepo.findById(id);
	}

	public void deleteData(Flight flight) {

		frepo.delete(flight);

	}

	public Optional<Flight> findData(String source, String destination) {
		// TODO Auto-generated method stub
		
		return frepo.findBySourceAndDestination(source, destination);
	}

	public List<Flight> findAllData() {
		// TODO Auto-generated method stub
		
		return frepo.findAll();
		
	}

}

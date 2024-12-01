package com.FlightManagementSystem.FlightManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.FlightManagementSystem.FlightManagementSystem.Exception.IdNotFoundException;
import com.FlightManagementSystem.FlightManagementSystem.Exception.ResourceNotFoundException;
import com.FlightManagementSystem.FlightManagementSystem.Model.ApiResponce;
import com.FlightManagementSystem.FlightManagementSystem.Model.Flight;
//import com.FlightManagementSystem.FlightManagementSystem.Repository.FlightReository;
import com.FlightManagementSystem.FlightManagementSystem.Repository.FlightRepo;

@Service
public class FlightService {
	@Autowired
	private FlightRepo flightrepo;

	public ResponseEntity<ApiResponce<Flight>> saveData(Flight flight) {
		return flightrepo.saveData(flight);
	}

	public ResponseEntity<ApiResponce<Flight>> getDataById(int id) {

		Optional<Flight> o = flightrepo.getDataById(id);
		if (!o.isPresent()) {
			throw new IdNotFoundException(id + "Invalid Id");
		}

		ApiResponce<Flight> api = new ApiResponce<Flight>(HttpStatus.OK.value(), "data Found", o.get());
		return new ResponseEntity<ApiResponce<Flight>>(api, HttpStatus.OK);

	}

	public ResponseEntity<ApiResponce<String>> deleteData(int id) {
		// TODO Auto-generated method stub
		Optional<Flight> o = flightrepo.getDataById(id);
		if (!o.isPresent()) {
			throw new IdNotFoundException(id + "Invalid Id");
		}

		flightrepo.deleteData(o.get());
		ApiResponce<String> api = new ApiResponce<String>(HttpStatus.OK.value(), "data deleted",
				id + " data got delted");
		return new ResponseEntity<ApiResponce<String>>(api, HttpStatus.OK);
	}

	public ResponseEntity<ApiResponce<Flight>> findData(String source, String destination) {
		// TODO Auto-generated method stub

		Optional<Flight> o = flightrepo.findData(source, destination);
		if (!o.isPresent()) {
			throw new ResourceNotFoundException("not found");
		}

		ApiResponce<Flight> api = new ApiResponce<Flight>(HttpStatus.FOUND.value(), "Data Found", o.get());
		return new ResponseEntity<ApiResponce<Flight>>(api, HttpStatus.FOUND);

	}

	public ResponseEntity<ApiResponce<List<Flight>>> findAll() {
		// TODO Auto-generated method stub
		List<Flight> list = flightrepo.findAllData();
		ApiResponce<List<Flight>> api = new ApiResponce<List<Flight>>(HttpStatus.OK.value(), "Data Found", list);

		return new ResponseEntity<ApiResponce<List<Flight>>>(api, HttpStatus.OK);
	}

	public ResponseEntity<ApiResponce<Flight>> updateData(Flight flight, int id) {
		Optional<Flight> o = flightrepo.getDataById(id);
		if(!o.isPresent())
		{
			throw new IdNotFoundException("id Not found");
		}
		return flightrepo.saveData(flight);

	}

}

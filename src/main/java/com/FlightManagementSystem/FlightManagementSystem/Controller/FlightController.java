package com.FlightManagementSystem.FlightManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FlightManagementSystem.FlightManagementSystem.Model.ApiResponce;
import com.FlightManagementSystem.FlightManagementSystem.Model.Flight;
import com.FlightManagementSystem.FlightManagementSystem.Service.FlightService;

@RestController
@CrossOrigin("http://localhost:3000")
public class FlightController {
	@Autowired
	private FlightService flightservice;
	
	@PostMapping("/create")
	public void  SaveFlightData (@RequestBody Flight flight)
	{
		   flightservice.saveData(flight);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponce<Flight>> findById(@PathVariable int id)
	{
		return  flightservice.getDataById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponce<String>> DeleteById(@PathVariable int id)
	{
	   return	flightservice.deleteData(id);
	}
	
	@GetMapping("/find")
	public ResponseEntity<ApiResponce<Flight>> findData(@RequestParam String source,@RequestParam String destination)
	{   
//		System.out.println(source +" "+ destination);
		return   flightservice.findData(source, destination);
	}
    @GetMapping("/findall")
    public ResponseEntity<ApiResponce<List<Flight>>> findAll()
    {
      return  flightservice.findAll();	
    }
    @PostMapping("/update/{id}")
    public void updateData(@RequestBody Flight flight, @PathVariable int id)
    {
    	 flightservice.updateData(flight,id);
    }
}

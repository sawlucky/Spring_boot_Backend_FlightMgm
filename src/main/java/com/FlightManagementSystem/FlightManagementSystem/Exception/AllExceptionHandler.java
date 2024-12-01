package com.FlightManagementSystem.FlightManagementSystem.Exception;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.FlightManagementSystem.FlightManagementSystem.Model.ApiResponce;

@RestControllerAdvice
public class AllExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ApiResponce<String>> HandleIdNotFoundException(IdNotFoundException e) {
		ApiResponce<String> api = new ApiResponce<String>(HttpStatus.NOT_FOUND.value(), "No data Found", e.getMsg());
		return new ResponseEntity<ApiResponce<String>>(api, HttpStatus.NOT_FOUND);
	}
   @ExceptionHandler(ResourceNotFoundException.class)
   public  ResponseEntity<ApiResponce<String>> HandleException(ResourceNotFoundException r)
   {
	   ApiResponce<String> api = new ApiResponce<String>(HttpStatus.NOT_FOUND.value(), "No data Found", r.getMsg());
		return new ResponseEntity<ApiResponce<String>>(api, HttpStatus.NOT_FOUND);
   
   }
}

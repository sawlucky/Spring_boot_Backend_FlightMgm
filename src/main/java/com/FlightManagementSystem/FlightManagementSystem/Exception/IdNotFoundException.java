package com.FlightManagementSystem.FlightManagementSystem.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IdNotFoundException extends RuntimeException {
	private String msg;

}

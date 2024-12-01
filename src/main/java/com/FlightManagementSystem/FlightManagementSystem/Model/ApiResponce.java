package com.FlightManagementSystem.FlightManagementSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
public class ApiResponce<T> {
	private int StatusCode;
	private String msg;
	private T data;

}

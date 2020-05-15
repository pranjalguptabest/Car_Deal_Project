package com.cts.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCar {
	
	private Long userId;
	private String userName;
	private String email;
	private Long mobileNumber;
	private String city;
	private List<Car> carList;

}
package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feign.client.CarClient;
import com.cts.feign.client.UserClient;
import com.cts.model.Car;
import com.cts.model.User;
import com.cts.model.UserCar;



@RestController

public class FeignController {
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private CarClient carClient;
	
	
	
	//to get the detail of all review for a specific product 
	@GetMapping("/user/{userId}")
	public UserCar UserWithCar(@PathVariable("userId")int userId) {
		
		User user = userClient.getUserById(userId);
		List<Car> carList = carClient.allCarWithUserId(userId);
		UserCar userCar = new UserCar( 
				user.getUserId(),
				user.getUserName(),
				user.getEmail(),
				user.getMobileNumber(),
				user.getCity(),
				carList);

		
				return userCar;	
		}

}

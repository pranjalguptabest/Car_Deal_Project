package com.cts.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.model.User;

@FeignClient(url="http://localhost:8082", name="User-Service")
public interface UserClient {

	
	//to get the detail of Product using its id from Product-Service
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable("id") int userId);
	
	
	

}


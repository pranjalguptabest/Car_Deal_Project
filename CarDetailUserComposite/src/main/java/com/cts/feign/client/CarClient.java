package com.cts.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.model.Car;



@FeignClient(url="http://localhost:8081", name="Car-Service")
public interface CarClient {


	//to get the list of all review tag to product with particular productId
	@GetMapping("/allCarWithUserId/{id}")
		public List<Car> allCarWithUserId(@PathVariable("id") int userId);
}



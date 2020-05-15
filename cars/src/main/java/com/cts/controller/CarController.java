package com.cts.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.Exception.CarModelNotFoundException;
import com.cts.model.CarDetails;
import com.cts.model.CarDetailsDto;
import com.cts.service.ICarService;

@RestController

public class CarController {

	@Autowired
	ICarService carService;
	
	//Method to fetch the list of all entries in DB
	@GetMapping("/cars")
	public List<CarDetails> getCars() {
		return carService.getAllCars();
	}

	//Method to fetch the list of all entries in DB using User ID
	//This method is used for Composite Microservice
	@GetMapping(path="/allCarWithUserId/{userId}")
	public List<CarDetails> get(@PathVariable int userId) {
		return carService.findById(userId);
	}
	
	//Method for Sorting the data 
	@GetMapping("getAllSorted/{sortingParameter}")
	public List<CarDetails> getAllSortedCars(@PathVariable String sortingParameter)
	{
		return carService.findSortedCars(sortingParameter);
	}
	
	//Method to create a new entry in DB
	//This method implements DTO Layer
	//This method implements Validation
	@PostMapping("/car")
	public void addNewCar(@Valid @RequestBody CarDetailsDto car) {
		carService.createCar(car);
	}
	
	//Method to update an existing entry in DB 
	//This method implements Exception Handling
	//This method implements Validation
	//This method implements Optional
	@PutMapping("/update/{carId}")
	public ResponseEntity<Object> updatecar(@PathVariable("carId") Long carId,@Valid @RequestBody CarDetails car) {
	      
	     // carService.updatecar(carId, car);
	     // return new ResponseEntity<>(carService.updatecar(carId, car), HttpStatus.OK);
		Optional<CarDetails> optional=carService.get(carId);
		
	if(optional.isPresent())
		{
			carService.updateCar(carId, car);
			return new ResponseEntity<>(carService.updateCar(carId, car), HttpStatus.OK);
		}
		else 
		{
			throw new CarModelNotFoundException();
		}
	}
	
	//Method to delete an existing entry from DB
	@DeleteMapping("/delete/{carId}")
	public ResponseEntity<Object> deleteCar(@PathVariable("carId") Long carId) {
		return new ResponseEntity<>(carService.deleteCar(carId), HttpStatus.OK);
	}
	
	//Pagination
	@GetMapping("/getallcardetails/{pageNo}/{pageSize}")
	public List<CarDetails> getPaginated(@PathVariable int pageNo,@PathVariable int pageSize){
		return carService.findPaginated(pageNo,pageSize);
	}
}






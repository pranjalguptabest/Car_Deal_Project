package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.cts.model.CarDetails;
import com.cts.model.CarDetailsDto;

public interface ICarService {

	
	public List<CarDetails> getAllCars();
	
	public List<CarDetails> findSortedCars(String sortParam);
	
	public String updateCar(Long carId, CarDetails oldCar);
	
	public Optional<CarDetails> get(Long carId);

	public String deleteCar(Long carId);
	
	public CarDetailsDto createCar(CarDetailsDto car);

	public List<CarDetails> findById(int userId);
	
	public List<CarDetails> findPaginated(int pageNo, int pageSize);

}

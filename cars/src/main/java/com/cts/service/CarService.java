package com.cts.service;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.Exception.CarServiceException;
import com.cts.model.CarDetails;
import com.cts.model.CarDetailsDto;
import com.cts.repository.CarRepo;
import com.cts.repository.CarRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@Service
@Transactional
public class CarService implements ICarService {

	@Autowired
	CarRepository carRepository;

	@Autowired
	private CarRepo repo;

	//Implementation of Logger
	Logger log=LoggerFactory.getLogger(CarService.class);
	
	//Method to get all entries from DB
	//This method implements System Exception
	public List<CarDetails> getAllCars() 
	{
		//return (List<CarDetails>) carRepository.findAll();
		log.info("getAllCars() invoked");
		List<CarDetails> carList;
		try
		{
			carList = (List<CarDetails>) carRepository.findAll();
			log.info("try block executing");
		} 
		catch (CarServiceException ex) 
		{
			log.error("Car Service Exception encountered");
			throw new CarServiceException("Car Service is temporarily unavailable");
		}
		return carList;
	}
	
	//Method for Sorting 
	public List<CarDetails> findSortedCars(String sortParam)
	{
	return (List<CarDetails>) carRepository.findAll(Sort.by(sortParam));
	}
	
	//Method to create a new entry in DB
	//This method implements DTO Layer
	public CarDetailsDto createCar(CarDetailsDto car)
	{
		log.info("createCar(CarDetailsDto car) invoked");
		ModelMapper maper = new ModelMapper();
		maper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		CarDetails carr = maper.map(car, CarDetails.class);
		carRepository.save(carr);
		log.info("createCar(CarDetailsDto car) executed");
		return null;
	}

	//This method is used in Put mapping in controller
		public Optional<CarDetails> get(Long carId)
		{
			return carRepository.findById(carId);
		}
		
	//Method to update an existing entry in DB 
	//This method implements Optional
	@Override
	public String updateCar(Long carId, CarDetails car)
	{
		log.info("updateCar(Long carId, CarDetails car) invoked");
		CarDetails existingCar = carRepository.findById(carId).get();
		existingCar.setUserId(car.getUserId());
		existingCar.setSeaterType(car.getSeaterType());
		existingCar.setCarNumber(car.getCarNumber());
		existingCar.setYearOfPurchase(car.getYearOfPurchase());
		existingCar.setDistanceTravelled(car.getDistanceTravelled());
		existingCar.setAmount(car.getAmount());
		existingCar.setCarType(car.getCarType());
		existingCar.setBrand(car.getBrand());

		CarDetails updatedCar = carRepository.save(existingCar);
		return "Car Model with id "+carId+" is updated";
	}

	//Method to delete the detail using its id 
	@Override
	public String deleteCar(Long carId) 
	{
		log.info(" deleteCar(Long carId) invoked");
		carRepository.deleteById(carId);
		return "Car Model id with " + carId + " is deleted";
	}

	//Method to implement Normal Search Operation by using Id
	//This method is for Composite Microservice
	public List<CarDetails> findById(int userId) {
		log.info("findById(int userId) invoked");
		return repo.findById(userId);
	}
	
	//Pagination
	@Override
	public List<CarDetails> findPaginated(int pageNo, int pageSize)
	{
		// TODO Auto-generated method stub
		
		Pageable paging =PageRequest.of(pageNo, pageSize);
		Page<CarDetails> pagedResult =carRepository.findAll(paging);
		return pagedResult.toList();
	}
}
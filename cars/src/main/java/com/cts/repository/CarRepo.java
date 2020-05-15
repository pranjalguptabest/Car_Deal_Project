package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import com.cts.model.CarDetails;

@Repository
public interface CarRepo extends JpaRepository<CarDetails, Integer>{
	
	
	@Query(value="SELECT * from cardetails where user_id=?", nativeQuery = true)
	List<CarDetails> findById(int userId);
}
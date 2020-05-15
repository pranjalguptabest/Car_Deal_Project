package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import com.cts.model.CarDetails;

@Repository
public interface CarRepository extends JpaRepository<CarDetails, Long>{

	List<CarDetails> findByUserId(Long userId);

	
	
}
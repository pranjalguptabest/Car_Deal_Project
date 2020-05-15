package com.cts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
	
	private Long carId;
	private Long userId;
	private Long seaterType;
	private String carNumber;
	private Long yearOfPurchase;
	private Long distanceTravelled;
	private Long amount;
	private String carType;
	private String brand;
	

}

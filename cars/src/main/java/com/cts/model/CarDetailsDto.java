package com.cts.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CarDetailsDto implements Serializable
{
	
	private static final long serialVersionUID =5049730970690887263L;
	
	private Long carId;
	 
	@NotNull(message = "UserId must not be empty")
	@Min(value = 1, message = "UserId must be greater than or equal to 1") 
    @Max(value = 1000, message = "UserId must be lower than or equal to 1000") 
	private Long userId;
	
	@NotNull(message = "Seater Type must not be empty")
    private Long seaterType;
	
	@NotEmpty(message = "Car Number must not be empty")
	@Size(min=2,message="Name should be of 9 characters")
    private String carNumber;
	 
	@NotNull(message = "Year of Purchase must not be empty")
    private Long yearOfPurchase;
	
	@NotNull(message = "Distance Travelled must not be empty")
    private Long distanceTravelled;
	
	@NotNull(message = "Amount must not be empty")
    private Long amount;
	
	@NotEmpty(message = "Car type must not be empty")
    private String carType;
	
	@NotEmpty(message = "Brand must not be empty")
    private String brand;
	
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getSeaterType() {
		return seaterType;
	}
	public void setSeaterType(Long seaterType) {
		this.seaterType = seaterType;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public Long getYearOfPurchase() {
		return yearOfPurchase;
	}
	public void setYearOfPurchase(Long yearOfPurchase) {
		this.yearOfPurchase = yearOfPurchase;
	}
	public Long getDistanceTravelled() {
		return distanceTravelled;
	}
	public void setDistanceTravelled(Long distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
package com.model;

public class Vehicle {
	private String regNo;
	private String manufacturer;
	private double dailyRent;
	private double mileage;
	private String description;
	private VehicleType vehicleType;
	private FuelType fuelType;
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getDailyRent() {
		return dailyRent;
	}
	public void setDailyRent(double dailyRent) {
		this.dailyRent = dailyRent;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	public Vehicle(String regNo, String manufacturer, double dailyRent, double mileage, String description,
			VehicleType vehicleType, FuelType fuelType) {
		super();
		this.regNo = regNo;
		this.manufacturer = manufacturer;
		this.dailyRent = dailyRent;
		this.mileage = mileage;
		this.description = description;
		this.vehicleType = vehicleType;
		this.fuelType = fuelType;
	}
	

}

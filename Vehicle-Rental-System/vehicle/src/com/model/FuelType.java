package com.model;

public class FuelType {
	private int fuelId;
	private String fuelName;
	public int getFuelId() {
		return fuelId;
	}
	public void setFuelId(int fuelId) {
		this.fuelId = fuelId;
	}
	public String getFuelName() {
		return fuelName;
	}
	public void setFuelName(String fuelName) {
		this.fuelName = fuelName;
	}
	public FuelType(int fuelId, String fuelName) {
		super();
		this.fuelId = fuelId;
		this.fuelName = fuelName;
	}
	

}

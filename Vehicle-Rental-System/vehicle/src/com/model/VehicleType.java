package com.model;

public class VehicleType {
	private int vehicleTypeId;
	private String vehicleName;
	public int getVehicleTypeId() {
		return vehicleTypeId;
	}
	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public VehicleType(int vehicleTypeId, String vehicleName) {
		super();
		this.vehicleTypeId = vehicleTypeId;
		this.vehicleName = vehicleName;
	}
	
	

}

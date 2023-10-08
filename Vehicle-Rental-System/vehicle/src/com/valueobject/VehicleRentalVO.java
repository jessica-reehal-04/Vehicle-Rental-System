package com.valueobject;

public class VehicleRentalVO {
	private String vehicleType;
	private int totalVehicles;
	private int totalRentedVehicles;
	private double totalRentEarned;
	
	
	public int getTotalVehicles() {
		return totalVehicles;
	}
	public void setTotalVehicles(int totalVehicles) {
		this.totalVehicles = totalVehicles;
	}
	public int getTotalRentedVehicles() {
		return totalRentedVehicles;
	}
	public void setTotalRentedVehicles(int totalRentedVehicles) {
		this.totalRentedVehicles = totalRentedVehicles;
	}
	public double getTotalRentEarned() {
		return totalRentEarned;
	}
	public void setTotalRentEarned(double totalRentEarned) {
		this.totalRentEarned = totalRentEarned;
	}
	public VehicleRentalVO(String vehicleType, int totalVehicles, int totalRentedVehicles, double totalRentEarned) {
		super();
		this.vehicleType = vehicleType;
		this.totalVehicles = totalVehicles;
		this.totalRentedVehicles = totalRentedVehicles;
		this.totalRentEarned = totalRentEarned;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	

}

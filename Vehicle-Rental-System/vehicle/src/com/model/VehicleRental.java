package com.model;

import java.sql.Timestamp;

public class VehicleRental {
	private int vehicleRentalId;
	private String toDate;
	private String fromDate;
	private String regNo;
	private double totalRent;
	private String vehicleType;
	private String customerName;
	
	public int getVehicleRentalId() {
		return vehicleRentalId;
	}
	public void setVehicleRentalId(int vehicleRentalId) {
		this.vehicleRentalId = vehicleRentalId;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public double getTotalRent() {
		return totalRent;
	}
	public void setTotalRent(double totalRent) {
		this.totalRent = totalRent;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public VehicleRental(int vehicleRentalId, String toDate, String fromDate, String regNo, double totalRent,
			String vehicleType,String customerName) {
		super();
		this.vehicleRentalId = vehicleRentalId;
		this.toDate = toDate;
		this.fromDate = fromDate;
		this.regNo = regNo;
		this.totalRent = totalRent;
		this.vehicleType = vehicleType;
		this.customerName = customerName;
	}
	
	public VehicleRental(String toDate, String fromDate,
			String vehicleType,String regNo,String customerName) {
		super();
	
		this.toDate = toDate;
		this.fromDate = fromDate;
		this.regNo = regNo;
		this.vehicleType = vehicleType;
		this.customerName = customerName;
	}
	
	

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	

}

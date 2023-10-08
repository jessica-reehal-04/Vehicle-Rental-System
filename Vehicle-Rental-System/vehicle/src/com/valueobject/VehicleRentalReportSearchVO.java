package com.valueobject;

import java.sql.Timestamp;

public class VehicleRentalReportSearchVO {
	private Timestamp fromDate;
	private Timestamp toDate;
	private int vehicleTypeId;
	public Timestamp getFromDate() {
		return fromDate;
	}
	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}
	public Timestamp getToDate() {
		return toDate;
	}
	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}
	public int getVehicleTypeId() {
		return vehicleTypeId;
	}
	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}
	public VehicleRentalReportSearchVO(Timestamp fromDate, Timestamp toDate, int vehicleTypeId) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.vehicleTypeId = vehicleTypeId;
	}
	

}

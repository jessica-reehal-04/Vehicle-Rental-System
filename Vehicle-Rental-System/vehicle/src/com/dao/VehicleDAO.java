package com.dao;

import java.util.ArrayList;

import com.exception.DataAccessException;
import com.model.Vehicle;
import com.model.Vehicle1;
import com.model.VehicleRental;
import com.model.VehicleType;
import com.valueobject.VehicleRentalReportSearchVO;
import com.valueobject.VehicleRentalVO;

public interface VehicleDAO {
	ArrayList<VehicleType> getVehicleTypes() throws DataAccessException;
	int addVehicle(Vehicle1 vehicle) throws DataAccessException;
	int addVehicleRentalDetails(VehicleRental vehicleRental) throws DataAccessException;
	ArrayList<VehicleRentalVO> getVehicleRentalReport() throws DataAccessException;
	int getFuelId(String fuelName) throws DataAccessException;
	

}

package com.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

import com.dao.VehicleDAO;
import com.exception.DataAccessException;
import com.model.Vehicle;
import com.model.Vehicle1;
import com.model.VehicleRental;
import com.model.VehicleType;
import com.valueobject.VehicleRentalReportSearchVO;
import com.valueobject.VehicleRentalVO;

public class VehicleDAOImpl extends BaseDAO implements VehicleDAO {
	Connection con = null;
	PreparedStatement ps = null;
	private static final String GET_VEHICLE_TYPE = "select * from vehicletype";
	private static final String ADD_VEHICLE_DETAILS = "insert into vehicle values(?,?,?,?,?,?,?)";
	private static final String GET_VEHICLE_DETAILS = "select * from vehicle where regno=?";
	private static final String ADD_VEHICLE_RENTAL_DETAILS = "insert into vehiclerental(todate,fromdate,vehicletypeid,regno,customername)values(?,?,?,?,?)";
	private static final String GET_VEHICLES_COUNT = "select vt.vehiclename,count(v.regno) from vehicle v left join vehicletype vt on vt.vehicletypeid=v.vehicletypeid group by vt.vehiclename";
	private static final String GET_VEHICLES_RENTAL_COUNT=" select vt.vehiclename,count(vr.vehiclerentalid) from vehiclerental vr inner join vehicletype vt on vr.vehicletypeid=vt.vehicletypeid where vr.todate between ? and ? group by vr.vehicletypeid;";
	private static final String GET_VEHICLES_TOTAL_RENT = "select vt.vehiclename,sum(v.dailyrent*DATEDIFF(vr.todate,?)) as total_rent from vehicle v inner join vehiclerental vr on v.vehicletypeid=vr.vehicletypeid left join vehicletype vt on vt.vehicletypeid=v.vehicletypeid group by vr.vehicletypeid";
	private static final String GET_VEHICLE_TYPE_ID = "select vehicletypeid from vehicletype where vehiclename = ?";
	private static final String GET_FUEL_TYPE_ID = "select fueltypeid from fueltype where fuelname = ?";
	
	
	
	
	

	@SuppressWarnings("finally")
	@Override
	public ArrayList<VehicleType> getVehicleTypes() throws DataAccessException {
	    
	    ArrayList<VehicleType> vehicleTypes = new ArrayList<>();
	    try {
	    	con = getConnection();
	    	System.out.println(con);
			ps = con.prepareStatement(GET_VEHICLE_TYPE);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				vehicleTypes.add(new VehicleType(id,name));
			}
			
			System.out.println(vehicleTypes);
		} catch (Exception e) {
			
			throw new DataAccessException("cannot be loaded..");
		}
	    finally {
	    	releaseResources(con,ps);
	    	return vehicleTypes;
	    }
		
		
	}

	@SuppressWarnings("finally")
	@Override
	public int addVehicle(Vehicle1 vehicle) throws DataAccessException {
		
		int gvt=getVehicleTypeId(vehicle.getVehicleType());
		int gft=getFuelId(vehicle.getFuelType());
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(ADD_VEHICLE_DETAILS);
			ps.setString(1, vehicle.getRegNo());
			ps.setString(2, vehicle.getManufacturer());
			ps.setDouble(3, vehicle.getDailyRent());
			ps.setDouble(4, vehicle.getMileage());
			ps.setString(5, vehicle.getDescription());
			ps.setInt(6,gvt);
			ps.setInt(7,gft);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			releaseResources(con,ps);
			return result;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public ArrayList<VehicleRentalVO> getVehicleRentalReport()
			throws DataAccessException {
		
		ArrayList<VehicleRentalVO> listVehicleRentalVOs = new ArrayList<>();
		try {
			con = getConnection();
			ps = con.prepareStatement(GET_VEHICLES_COUNT);
			LocalDate currDate = LocalDate.now();
			int currMonth = currDate.getMonthValue();
			int currYear = currDate.getYear();
			String fromDate  = currYear+"-"+currMonth+"-"+"01";
			String toDate  = currYear+"-"+currMonth+"-"+"31";
			ResultSet vehiclesCountTypes = ps.executeQuery();
			ArrayList<String> listVehicleTypes = new ArrayList<>();//
			ArrayList<Integer> listVehicleCounts = new ArrayList<>();//
			while(vehiclesCountTypes.next()) {
				listVehicleTypes.add(vehiclesCountTypes.getString(1));
				listVehicleCounts.add(vehiclesCountTypes.getInt(2));
			}
			ArrayList<Integer> listVehicleRentalCounts = new ArrayList<>();//
			ps = con.prepareStatement(GET_VEHICLES_RENTAL_COUNT);
			ps.setString(1, fromDate);
			ps.setString(2, toDate);
			ResultSet vehicleRentalCounts = ps.executeQuery();
			while(vehicleRentalCounts.next()) {
				listVehicleRentalCounts.add(vehicleRentalCounts.getInt(2));
			}
			
			ArrayList<Integer> listVehicleRents = new ArrayList<>();//
			ps = con.prepareStatement(GET_VEHICLES_TOTAL_RENT);
			ps.setString(1, fromDate);
			ResultSet totalRents = ps.executeQuery();
			while(totalRents.next()) {
				listVehicleRents.add(totalRents.getInt(2));
			}
			
			
			
			for(int i=0;i<4;i++)
			{
				listVehicleRentalVOs.add(new VehicleRentalVO(listVehicleTypes.get(i),listVehicleCounts.get(i),listVehicleRentalCounts.get(i),listVehicleRents.get(i)));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			releaseResources(con,ps);
			return listVehicleRentalVOs;
		}
		
		
		
	}

	@SuppressWarnings("finally")
	@Override
	public int getFuelId(String fuelName) throws DataAccessException {
		
		int fuelTypeId =-1;
		try {
			con = getConnection();
			ps = con.prepareStatement(GET_FUEL_TYPE_ID);
			ps.setString(1, fuelName);
			ResultSet rs = ps.executeQuery();
			fuelTypeId= rs.next()==true?rs.getInt(1):-1;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			releaseResources(con,ps);
			return fuelTypeId;
		}
		
	}
	
	@SuppressWarnings("finally")
	public int getVehicleTypeId(String vehicleName) throws DataAccessException{
		int vehicleTypeId =-1;
		try {
			con = getConnection();
			ps = con.prepareStatement(GET_VEHICLE_TYPE_ID);
			ps.setString(1, vehicleName);
			ResultSet rs = ps.executeQuery();
			vehicleTypeId= rs.next()==true?rs.getInt(1):-1;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			releaseResources(con,ps);
			return vehicleTypeId;
		}
		
		
	}

	@SuppressWarnings("finally")
	@Override
	public int addVehicleRentalDetails(VehicleRental vehicleRental) throws DataAccessException {
	
		int result =0;
		int gvt=getVehicleTypeId(vehicleRental.getVehicleType());
		
		try {
			con=getConnection();
			ps=con.prepareStatement(ADD_VEHICLE_RENTAL_DETAILS);
			ps.setString(1, vehicleRental.getToDate());
			ps.setString(2, vehicleRental.getFromDate());
			ps.setInt(3,gvt);
			ps.setString(4, vehicleRental.getRegNo());
			ps.setString(5, vehicleRental.getCustomerName());
			result = ps.executeUpdate(); 
			System.out.println("The vehicle is booked successfully");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			releaseResources(con,ps);
			return result;
		}
	}

	
	
}

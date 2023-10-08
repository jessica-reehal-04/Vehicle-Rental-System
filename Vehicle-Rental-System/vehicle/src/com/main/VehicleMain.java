package com.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.VehicleDAO;
import com.dao.jdbc.VehicleDAOImpl;
import com.exception.DataAccessException;
import com.model.Vehicle;
import com.model.Vehicle1;
import com.model.VehicleRental;
import com.model.VehicleType;
import com.valueobject.VehicleRentalVO;

public class VehicleMain {

	public static void main(String[] args) throws DataAccessException 
	{
		while(true)
		{
			int choice;
			System.out.println("1. Add a new vehicle");
			System.out.println("2. Book a vehicle");
			System.out.println("3. generate report");
			System.out.println("4. Exit");
			
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			
			VehicleDAO vdao=new VehicleDAOImpl();
			switch(choice)
			{
			    case 1:
			        System.out.println("Enter registration number");
			    	String regno=sc.next();
			    	System.out.println("Enter vehicle category");
			    	ArrayList<VehicleType> vehicleType=vdao.getVehicleTypes();
			    	
		
			    	for(VehicleType vt:vehicleType)
			    	{
			    		System.out.print(vt.getVehicleName()+" ");
			    	}
			    	String vtype=sc.next();
			    	
			    	System.out.println("Enter manufacturer");
			    	String manufacturer=sc.next();
			    	
			    	System.out.println("Enter daily rent");
			    	double dailyRent=sc.nextDouble();
			    	
			    	System.out.println("Enter mileage");
			    	double mileage=sc.nextDouble();
			    	
			    	System.out.println("Enter fuel type");
			    	System.out.println("Petrol"+" "+"Diesel"+" "+"LPG");
			    	String fuelType=sc.next();
			    	
			    	System.out.println("Enter description");
			    	String desc=sc.next();
			    	
			    	Vehicle1 vadd=new Vehicle1(regno,manufacturer,dailyRent,mileage,desc,vtype,fuelType);
			    	vdao.addVehicle(vadd);
			    	break;
			    case 2:
			    	System.out.println("Enter customer name");
			    	String custName=sc.next();
			    	
			    	ArrayList<VehicleType> vehicleTypes=vdao.getVehicleTypes();
			    	
					
			    	for(VehicleType vt:vehicleTypes)
			    	{
			    		System.out.print(vt.getVehicleName()+" ");
			    	}
			    	String vtypes=sc.next();
			    	
			    	System.out.println("Enter registration number");
			    	String regno1=sc.next();
			    	
			    	System.out.println("Enter from date");
			    	String bookedFrom=sc.next();
			    	
			    	
			    	System.out.println("Enter to date");
			    	String bookedTo=sc.next();
			    	
			    	VehicleRental vr=new VehicleRental(bookedTo,bookedFrom,vtypes,regno1,custName);
			    	int res=vdao.addVehicleRentalDetails(vr);
			    	break;
			    case 3:
			    	ArrayList<VehicleRentalVO> vrentalvo=vdao.getVehicleRentalReport();
			    	
			    	for(VehicleRentalVO v:vrentalvo)
			    	{
			    		System.out.println(v.getVehicleType()+" "+v.getTotalVehicles()+" "+v.getTotalRentedVehicles()+" "+Math.abs(v.getTotalRentEarned()));
			    	}
			    	break;
			    case 4:
			    	System.out.println("Exited Successfully");
			    	System.exit(1);
				
			}
			
		}

	}

}

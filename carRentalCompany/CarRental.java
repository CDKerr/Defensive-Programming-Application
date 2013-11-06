/**
 * Car Rental class that uses the carRental Package
 */
package carRentalCompany;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import carRental.*;

/**
 * CarRental - class to allocate cars to drivers Licenses
 * 
 * @author b2038092 christopherkerr; c.kerr@ncl.ac.uk
 * @version 1.0
 */
public class CarRental {
	private static final ArrayList<Car> CARS = new ArrayList<Car>(30);
	private boolean carRented = false;private int fuelCapacity = 0; private int fuelInCar = 0; private RegistrationNumber registrationNumber = null;
	private static final Map<DrivingLicense, Car> RENTEDCARS = new HashMap<DrivingLicense, Car>();
	
	public int availableCars(String typeOfCar){
		int counter = 0;
		for(int i = 0; i < CARS.size(); i++){ 
			if (typeOfCar.equals(typeOfCar) && carRented == false){
		    	counter++;
		    } else {
		    	return 0;
		    }
		}
		return counter;
	}

	/**
	 * Return the cars that are currently rented out
	 * 
	 * @return rented cars
	 */
	public Car getRentedCars(){
		for (Car car:CARS){
			if(car.isCarRented() == true){
				return car;
			}
		  }
		return null;
		}
	
	/**
	 * Returns the car that is allocated to a specific drivers license
	 * 
	 * @param drivingLicense drivers license
	 * @return Car car that is rented
	 * @throws IllegalArgumentException
	 */
	public Car getCar(DrivingLicense drivingLicense){
		String typeOfCar = "";
		Car c = AbstractCar.getInstance(typeOfCar, RegistrationNumber.getInstance(extracted(registrationNumber).getLetterIdentifier(), extracted(registrationNumber).getNumberIdentifier()), fuelCapacity, fuelInCar, carRented);
		if (!RENTEDCARS.containsKey(drivingLicense)){
			throw new IllegalArgumentException("The driving license does not have a car");
		}
		return RENTEDCARS.get(c);
	}
	
	/**
	 * Issues a car to a driver
	 * 
	 * @param drivingLicense drivers license
	 * @param typeOfCar type of car desired
	 * @return Car new car rented
	 * @throws IllegalArgumentException
	 */
	public Car issueCar(DrivingLicense drivingLicense, String typeOfCar){
		Date now = new Date(); 
		Car c = AbstractCar.getInstance(typeOfCar, RegistrationNumber.getInstance(extracted(registrationNumber).getLetterIdentifier(), extracted(registrationNumber).getNumberIdentifier()), fuelCapacity, fuelInCar, carRented);
		long driverAge = now.getTime() - drivingLicense.getDateOfBirth().getTime();
		long licenseAge = now.getTime() - drivingLicense.getDateOfIssue().getTime();
		
		if (typeOfCar.equalsIgnoreCase("small car")){
			if(driverAge > 20*365*24*60*60*1000 && licenseAge > 1*365*24*60*60*1000 && drivingLicense.getIsFullLicense()==true){
			    c = AbstractCar.getInstance("small car", RegistrationNumber.getInstance(extracted(registrationNumber).getLetterIdentifier(), extracted(registrationNumber).getNumberIdentifier()), fuelCapacity, fuelInCar, carRented);
				fuelInCar = 49;
				carRented = true;
				CARS.remove(c);
			} else {
				throw new IllegalArgumentException("A car cannot be allocated");
			}
		} else if (typeOfCar.equalsIgnoreCase("large car")){ 
			if(driverAge > 25*365*24*60*60*1000 && licenseAge > 5*365*24*60*60*1000 && drivingLicense.getIsFullLicense()== true){
				c = AbstractCar.getInstance("small car", RegistrationNumber.getInstance(extracted(registrationNumber).getLetterIdentifier(), extracted(registrationNumber).getNumberIdentifier()), fuelCapacity, fuelInCar, carRented);
				fuelInCar = 60;
				carRented = true;
				CARS.remove(c);
			} else {
				throw new IllegalArgumentException("A car cannot be allocated");
			}
		} else{
			throw new IllegalArgumentException("That is not a suitable type of car");
		}
		RENTEDCARS.put(drivingLicense, c);
		return c;
	}
	
	/**
	 * Return a rented car
	 * 
	 * @param drivingLicense drivers license
	 * @return fuelToFillTank fuel to fill the car
	 * @throws IllegalArgumentException
	 */
	public int terminateRental(DrivingLicense drivingLicense){
		String typeOfCar = "";
		int fuelToFillTank = 0;
		int distanceTravelled = 0;
		Car c = AbstractCar.getInstance(typeOfCar, RegistrationNumber.getInstance(extracted(registrationNumber).getLetterIdentifier(), extracted(registrationNumber).getNumberIdentifier()), fuelCapacity, fuelInCar, carRented);
	    carRented = false;
		RENTEDCARS.remove(drivingLicense);
		CARS.add(c); 
		if (typeOfCar.equalsIgnoreCase("small car")){
			fuelToFillTank = c.driveTheCar(distanceTravelled);
		} else if (typeOfCar.equalsIgnoreCase("large Car")){
			fuelToFillTank = c.driveTheCar(distanceTravelled); 
		} else{
			throw new IllegalArgumentException("That is not a valid car");
		}
		return fuelToFillTank;
	}


	private RegistrationNumber extracted(RegistrationNumber registrationNumber) {
		return registrationNumber;
	}
}

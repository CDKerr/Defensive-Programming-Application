/**
 * Abstract Car class for the Car interface
 */
package carRental;

import java.util.HashMap;
import java.util.Map;

/**
 * @author b2038092 christopherkerr; c.kerr@ncl.ac.uk	
 * @version 1.0
 */
public abstract class AbstractCar implements Car {
	private final RegistrationNumber registrationNumber;
	private final int fuelCapacity;
	private int fuelInCar;
	private boolean carRented;
	private static final Map<String, Car>CARS = new HashMap<String, Car>(30); 

	
	AbstractCar(RegistrationNumber registrationNumber, int fuelCapacity, int fuelInCar, boolean carRented){	
		this.registrationNumber = RegistrationNumber.getInstance(registrationNumber.getLetterIdentifier(), registrationNumber.getNumberIdentifier());
		if (RegistrationNumber.getInstance(registrationNumber.getLetterIdentifier(), registrationNumber.getNumberIdentifier()).equals(null))
		    throw new IllegalArgumentException("That is not a valid Registration Number.");
		
		this.fuelCapacity = fuelCapacity;
		if(fuelCapacity <= 0)
			throw new IllegalArgumentException("The fuel capacity is inappropriate.");
		
		this.fuelInCar = fuelInCar;
		if (fuelInCar > fuelCapacity || fuelInCar < 0)
			throw new IllegalArgumentException("The fuel in car is a unacceptable amount.");
		
		this.carRented = carRented;
	}
	
	/**
	 * Static factory Method to create a new instance of a Car or return the car from the Map.
	 *  
	 * @param typeOfCar type of car created
	 * @param registrationNumber registration number of the car
	 * @param fuelCapacity fuel capacity of the car
	 * @param fuelInCar fuel in the car
	 * @param carRented car rented or not
	 * @return a new instance of a car
	 */
	public static Car getInstance(String typeOfCar, RegistrationNumber registrationNumber, int fuelCapacity, int fuelInCar, boolean carRented){
		String stringRepresentation = registrationNumber.toString() + fuelCapacity + fuelInCar + carRented;
		Car c = CARS.get(stringRepresentation);
		if (c != null) return c;
		
		if (typeOfCar.equalsIgnoreCase("small car")){
			c = new SmallCar(registrationNumber, fuelCapacity, fuelInCar, carRented);
		}else{
			c = new LargeCar(registrationNumber, fuelCapacity, fuelInCar, carRented);
		}
		CARS.put(stringRepresentation, c);
		return c;
	}
	
	public Map<String, Car> getCars(){
		return CARS;
	}
	
	/**
	 * toString representation of the car instance
	 * 
	 * @return string representation of the car
	 */
	public String toString(){
		return  registrationNumber.toString() + fuelCapacity + fuelInCar + carRented;
	}
	
	/**
	 * get method for the registration number of the car
	 * 
	 * @return registration number of the car
	 */
	public RegistrationNumber getRegistrationNumber(){
		return RegistrationNumber.getInstance(registrationNumber.getLetterIdentifier(), registrationNumber.getNumberIdentifier());
		}
	
	/**
	 * get method for the fuel capacity of the car
	 * 
	 * @return fuel capacity of the car
	 */
	public int getFuelCapacity(){
		return fuelCapacity;
		}
	
	/**
	 * get method for the fuel in the car
	 * 
	 * @return fuel in the car
	 */
	public int getFuelInCar(){
		return fuelInCar;
		}
	
	/**
	 * declares if the car fuel tank is full
	 * 
	 * @return if the fuel tank is full
	 */
	public boolean isCarFuelTankFull(){
		return fuelCapacity == fuelInCar;
		}
	
	/**
	 * declares if the car is rented
	 * 
	 * @return if the car is rented
	 */
	public boolean isCarRented(){
		return carRented;
		}
}

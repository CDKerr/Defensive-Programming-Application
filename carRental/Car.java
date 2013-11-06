/**
 * Public Interface for the Abstract Car
 */
package carRental;

/**
 * Car - interface to cars.
 * 
 * @author b2038092 christopherkerr; c.kerr@ncl.ac.uk
 * @version 1.0
 */
public interface Car {
	
	/**
	 * Returns the Registration Number of the car.
	 * All cars must have a registration number which uniquely
	 * identifies a car. 
	 * 
	 * @throws IllegalArgumentException if <code>letterIdentifier</code>
	 * is not viable
	 * @throws IllegalArgumentException if <code>numberIdentifier</code>
	 * is not viable
	 * @return the registration number
	 */
	RegistrationNumber getRegistrationNumber();
	
	/**
	 * Returns the fuel Capacity of the car.
	 * 
	 * @return the fuel capacity
	 */
	int getFuelCapacity();
	
	/**
	 * Returns the amount of fuel in the car.
	 * 
	 * @return the fuel in the car
	 */
	int getFuelInCar();
	
	/**
	 * Returns if the car tank is full. 
	 * 
	 * @return if the car tank is full
	 */
	boolean isCarFuelTankFull();
	
	/**
	 * Returns if the car is rented.
	 * 
	 * @return if the car is rented
	 */
	boolean isCarRented();
	
	/**
	 * Adds fuel to the car equivalent to the litres added
	 * or up to the fuel tank capacity. It is forbidden to add
	 * more fuel than the fuel capacity.
	 * 
	 * @param litresAdded litres to be added to the car
	 * @return the amount of litres actually added
	 */
	int addFuelToCar(int litresAdded);
	
	/**
	 * Uses the distance travelled to return the amount of fuel
	 * consumed. The distance travelled is allowed to consume more
	 * fuel than is available in the car.
	 * @param distanceTravelled the distance travelled
	 * @return the fuel consumed
	 */
	int driveTheCar(int distanceTravelled);
}

/**
 * Small Car concrete class that extends the AbstractCar class
 */
package carRental;

/**
 * @author b2038092 christopherkerr; c.kerr@ncl.ac.uk
 * @version 1.0
 */
final class SmallCar extends AbstractCar {
	private static final int fuelCapacity = 49;
	private int fuelInCar;

	SmallCar(RegistrationNumber registrationNumber, int fuelCapacity, int fuelInCar, boolean carRented) {
		super(registrationNumber, fuelCapacity, fuelInCar, carRented);
	}

	/**
	 * Adds fuel to the car
	 * 
	 * @return litresAdded the amount of litres added to the car or zero if the car is full or hasn't been driven
	 */
     public int addFuelToCar(int litresAdded) {
	        if(isCarRented() == false || getFuelInCar() == getFuelCapacity()){
				return 0;
			} else {
	        int fuelTotal = fuelInCar + litresAdded;
			int fuel = Math.min(fuelTotal, fuelCapacity);
			fuelInCar = fuel;
			if (litresAdded >= (fuelCapacity - fuelInCar)){
				return fuelCapacity - fuelInCar;
			} else {
			return litresAdded;
			}
		}
	  }

	/**
	 * drive the car and reduce the petrol amount according to how far the car was driven
	 * 
	 * @return amountOfFuelConsumed return the amount of fuel consumed or zero if the car was not driven
	 */
	public int driveTheCar(int distanceTravelled) {
			if (isCarRented() == true || fuelInCar > 0) {
			     int consumptionRate = distanceTravelled/20;
			     return consumptionRate;
			} else {
			 return 0;
			}
	}
}

/**
 * Large Car concrete class that extends the AbstractCar class
 */
package carRental;

/**
 * @author christopherkerr;
 * @version 1.0
 */
public class LargeCar extends AbstractCar {
	private static final int fuelCapacity = 60;
	private int fuelInCar;

	LargeCar(RegistrationNumber registrationNumber, int fuelCapacity, int fuelInCar, boolean carRented) {
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
		    if (isCarRented() == true || fuelInCar > 0){
			    int consumptionRate;
			    if (distanceTravelled <= 50){
			    	consumptionRate = distanceTravelled/10;
			    	return consumptionRate;
			    } else { 
			    	consumptionRate = ((distanceTravelled - 50)/15) + 5;
			    	return consumptionRate;
			    }
			} else {
				return 0;
			}

	}
}

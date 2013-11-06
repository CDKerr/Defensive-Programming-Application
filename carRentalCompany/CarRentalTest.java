/**
 * Test class for the CarRental class
 */
package carRentalCompany;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import carRental.*;

/**
 * @author b2038092 christopherkerr; c.kerr@ncl.ac.uk
 * @version 1.0
 */
public class CarRentalTest {
	Car c; DrivingLicense dl; PersonName pn; Calendar cal, cal2; Date dob; Date doi; LicenseNumber ln; 
	RegistrationNumber rn; int fuelCapacity; int fuelInCar; boolean carRented; boolean isFullLicense;
	private static final ArrayList<Car> CARS = new ArrayList<Car>(30);
	private static final Map<DrivingLicense, Car> RENTEDCARS = new HashMap<DrivingLicense, Car>();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		isFullLicense = true; 
		pn = new PersonName("Chris", "Kerr");
		cal = Calendar.getInstance(); cal.set(1984, 10, 11); dob = cal.getTime();
		cal2 = Calendar.getInstance(); cal2.set(2001, 9, 21); doi = cal2.getTime();
		ln = LicenseNumber.getInstance("CK", 2001, 9);
		dl = DrivingLicense.getInstance(pn, dob, ln, doi, isFullLicense);
		rn = RegistrationNumber.getInstance('a', 1234);
		carRented = false;
		fuelCapacity = 49; 
		fuelInCar = 10;
		c = AbstractCar.getInstance("small car", rn, fuelCapacity, fuelInCar, carRented);}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {c = null;}

	/**
	 * Test method for {@link carRentalCompany.CarRental#availableCars(java.lang.String)}.
	 */
	@Test
	public final void testAvailableCars() {
		CARS.add(c);
		assertNotNull(CARS);
		assertFalse(c.isCarRented() == true);
		assertTrue(CARS.get(0) == c);
	}

	/**
	 * Test method for {@link carRentalCompany.CarRental#getRentedCars()}.
	 */
	@Test
	public final void testGetRentedCars() {
		isFullLicense = true; 
		pn = new PersonName("Chris", "Kerr");
		cal = Calendar.getInstance(); cal.set(1984, 10, 11); dob = cal.getTime();
		cal2 = Calendar.getInstance(); cal2.set(2001, 9, 21); doi = cal2.getTime();
		ln = LicenseNumber.getInstance("CK", 2001, 9);
		dl = DrivingLicense.getInstance(pn, dob, ln, doi, isFullLicense);
		rn = RegistrationNumber.getInstance('a', 1234);
		carRented = true;
		fuelCapacity = 49; 
		fuelInCar = 10;
		c = AbstractCar.getInstance("small car", rn, fuelCapacity, fuelInCar, carRented);
		assertTrue(c.isCarRented() == true);
		assertFalse(c.isCarRented() == false);
		assertNotNull(c.isCarRented());
	}

	/**
	 * Test method for {@link carRentalCompany.CarRental#getCar(carRental.DrivingLicense)}.
	 */
	@Test
	public final void testGetCar() {
		RENTEDCARS.put(dl, c);
		System.out.println(RENTEDCARS.containsKey(dl));
		assertNotNull(RENTEDCARS);
		assertFalse(RENTEDCARS.isEmpty());
	}

	/**
	 * Test method for {@link carRentalCompany.CarRental#issueCar(carRental.DrivingLicense, java.lang.String)}.
	 */
	@Test
	public final void testIssueCar() {
		RENTEDCARS.put(dl, c);
		assertTrue(RENTEDCARS.containsKey(dl));
		assertNotNull(RENTEDCARS);
		assertFalse(RENTEDCARS.isEmpty());
	}
	
	/**
	 * Test method for {@link carRentalCompany.CarRental#terminateRental(carRental.DrivingLicense, java.lang.String)}.
	 */
	@Test
	public final void testTerminateRental(){
		assertTrue(c.isCarRented() == false);
		assertTrue(CARS.get(0)==c);
		assertNotNull(CARS);
	}

}

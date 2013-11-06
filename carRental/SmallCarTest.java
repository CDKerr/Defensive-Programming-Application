/**
 * Test class for the concrete SmallCar class
 */
package carRental;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author b2038092 christopherkerr; c.kerr@ncl.ac.uk
 * @version 1.0
 */
public class SmallCarTest {
	private Car tester;
	private RegistrationNumber registrationNumber = RegistrationNumber.getInstance('a', 1234);
	private int fuelCapacity = 49;
	private int fuelInCar = 10;
	private boolean carRented = true;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {tester = new SmallCar(registrationNumber, fuelCapacity, fuelInCar, carRented);}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {tester = null;}

	/**
	 * Test method for {@link carRental.SmallCar#SmallCar(carRental.RegistrationNumber, int, int, boolean)}.
	 */
	@Test
	public final void testSmallCar() {
		assertNotNull(tester);
		carRented = false;
		Car tester2 = new SmallCar(registrationNumber, fuelCapacity, fuelInCar, carRented);
		assertFalse(tester2 == tester);
		Car tester3 = tester;
		assertEquals(tester3, tester);
	}

	/**
	 * Test method for {@link carRental.SmallCar#addFuelToCar(int)}.
	 */
	@Test
	public final void testAddFuelToCar() {
		int litresAdded = 20;
		assertTrue(tester.addFuelToCar(litresAdded) == 20);
		assertNotNull(tester.addFuelToCar(litresAdded));
		assertFalse(tester.addFuelToCar(litresAdded) == 60);
	}

	/**
	 * Test method for {@link carRental.SmallCar#driveTheCar(int)}.
	 */
	@Test
	public final void testDriveTheCar() {
		int distanceTravelled = 100;
		assertTrue(tester.driveTheCar(distanceTravelled) == 5);
		assertNotNull(tester.driveTheCar(distanceTravelled));
		assertFalse(tester.driveTheCar(distanceTravelled) == 0);
	}

}

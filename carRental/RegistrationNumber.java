/**
 * Registration Number - immutable class for the Registration Number of the cars held
 * by the car rental company
 */
package carRental;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author christopherkerr; 
 * @version 1.0
 */
public final class RegistrationNumber {
	private static final Map<String, RegistrationNumber> REGISTRATIONNUMBERS = new HashMap<String, RegistrationNumber>();
	private final char letterIdentifier;
	private final int numberIdentifier;
	private final String stringRepresentation;

	private RegistrationNumber(char letterIdentifier, int numberIdentifier, String stringRepresentation){
		Random randomLetterIdentifier = new Random();
		this.letterIdentifier=(char)(randomLetterIdentifier.nextInt(26) + 'a');	
		if (Character.isDigit(letterIdentifier))
			throw new IllegalArgumentException("That is not a valid letter identifier.");

		Random randomNumberIdentifier = new Random();
		this.numberIdentifier=randomNumberIdentifier.nextInt(9999) + 1001;
		if (Integer.toString(numberIdentifier).length()!=4)
			throw new IllegalArgumentException("That is not a valid number identifier.");	
		
		this.stringRepresentation = stringRepresentation;
	}
	
	/**
	 * Static Factory method to create a new instance of a Registration Number or return if already stored in Map.
	 * 
	 * @param letterIdentifier letter Identifier of the registration number
	 * @param numberIdentifier number identifier of the registration number
	 * @return the new instance of the Registration Number
	 */
 	public static RegistrationNumber getInstance(char letterIdentifier, int numberIdentifier){
		String stringRepresentation = Character.toString(letterIdentifier) + numberIdentifier;
		RegistrationNumber rn = REGISTRATIONNUMBERS.get(stringRepresentation);
		if (rn == null){
			rn = new RegistrationNumber(letterIdentifier, numberIdentifier, stringRepresentation);
			REGISTRATIONNUMBERS.put(stringRepresentation, rn);
		}
		return rn;
	}
	
	/**
	 * get unique letterIdentifier method for the registration number.
	 * 
	 * @return unique letterIdentifier.
	 */
	public char getLetterIdentifier(){return letterIdentifier;}
	
	/**
	 * get unique numberIdentifier method for the registration number.
	 * 
	 * @return unique numberIdentifier.
	 */
	public int getNumberIdentifier(){return numberIdentifier;}

	/**
	 * toString method of letterIdentifier and numberIdentifier.
	 * 
	 * @see java.lang.Object#toString().
	 */
	@Override
	public String toString(){return stringRepresentation;}	
	

}

package fczachor.cipher;

/**
 * SecAlphception
 * This class extends Exception.
 * @author Florian Czachor
 * @version 27.11.2018
 */

public class Egseption extends Exception{

	// Constructor
	public Egseption() {
		super("The criteria for the secret alphabet was not fulfilled");
	}
	
	// Constructor with parameter
	public Egseption(String errmessage) {
		super(errmessage);
	}
}
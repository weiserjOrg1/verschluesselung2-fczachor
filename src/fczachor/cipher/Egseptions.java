package fczachor.cipher;
/**
 * This class contains all the exceptions.
 * @author FCzachor
 * @version 11.10.2018
 */
public class Egseptions extends Exception{
	public Egseptions() {
		super("Something is wrong");
		// standard message
	}
	
	public Egseptions(String m) {
		super(m);
		// custom message
	}
}
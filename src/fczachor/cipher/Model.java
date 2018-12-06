package fczachor.cipher;

/**
 * MODEL
 * This class
 * @author Florian Czachor
 * @version 27.11.2018
 */

// Imports
import javax.swing.*;

public class Model {
	
	// Attributes
	public MonoAlphabeticCipher mac;
	public SubstitutionCipher suc;
	public ShiftCipher shc;
	
	// Constructor
	public Model() {
		this.mac = new MonoAlphabeticCipher();	
		this.suc = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		this.shc = new ShiftCipher(0);
		this.mac = this.suc;
	}
}
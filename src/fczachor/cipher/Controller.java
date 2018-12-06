package fczachor.cipher;

/**
 * CONTROLLER
 * This class implements ActionListener.
 * It checks if a button or a circle is clicked
 * and performs an action.
 * @author Florian Czachor
 * @version 27.11.2018
 */

// Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller implements ActionListener {
	
	// Attributes
	private Model m;
	private View v;
	private int help;
	
	// Constructor
	public Controller() {
		this.m = new Model();
		this.v = new View(this, this.m);
		this.help = 0; 									// if help is 0 = SubstitutionC, 1 = ShiftC, 2 = "Other" (Infinity)
	}
	
	// Methods
	
	// ACTIONPERFORMED
	public void actionPerformed(ActionEvent e) {

		// Shift Cipher
		if (this.v.isShiftCipher(e)) { 
			this.v.activateShiftC();
			this.help = 1;
		}
	
		// Substitution Cipher
		if (this.v.isSubCipher(e)) {
			this.v.activateSubC();
			this.help = 0;
		}

		// Decrypt
		if (this.v.isDecrypt(e)) {
			this.v.setOutput(this.m.mac.decrypt(this.v.getText()));
		}

		// Encrypts
		if (this.v.isEncrypt(e)) {
			this.v.setOutput(this.m.mac.encrypt(this.v.getText()));
		}

		// Applying
		if (this.v.isApply(e)) {
			if (this.help == 0) {
				this.m.mac.setSecretAlphabet(this.v.getSubAlph());
			}
			if (this.help == 1 && this.v.getShiftAlph().equals("") == false) {
				this.m.shc.setShiftValue(Integer.parseInt(this.v.getShiftAlph()));
			}
		}
	}
}
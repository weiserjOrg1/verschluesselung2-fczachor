package fczachor.cipher;

/**
 * SHIFT CIPHER
 * This class extends MonoAlphabeticCipher.
 * @author Florian Czachor
 * @version 27.11.2018
 */

public class ShiftCipher extends MonoAlphabeticCipher{
	
	// Constructor
	public ShiftCipher(int wert) {
		this.setShiftValue(wert);
	}
	
	// Methods
	
	// SET SHIFT VALUE
	// This method sets the shift value.
	public void setShiftValue(int wert) {
		String sAlph = "abcdefghijklmnopqrstuvwxyzäöüß";
		String nAlph = "";
		wert %= 30;
		if (wert == 0) return;
		if (wert > 0) {
			nAlph = sAlph.substring(wert);
			nAlph = nAlph + sAlph.substring(0, wert);
			super.setSecretAlphabet(nAlph);
		} else {
			nAlph = sAlph.substring(29 + wert);
			nAlph = sAlph.substring(0, 29 + wert);
			super.setSecretAlphabet(nAlph);
		}
	}
}
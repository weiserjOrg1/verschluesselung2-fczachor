package fczachor.cipher;

/**
 * SUBSTITUTION CIPHER
 * This class extends MonoAlphabeticCipher.
 * @author Florian Czachor
 * @version 27.11.2018
 */

public class SubstitutionCipher extends MonoAlphabeticCipher{
	
	// Constructor
	public SubstitutionCipher(String secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet);
	}
	
	// Methods
	
	// SET SECRET ALPHABET
	// This method returns secretAlpahbet
	public boolean setSecretAlphabet(String secretAlphabet){
		return super.setSecretAlphabet(secretAlphabet);
	}
}
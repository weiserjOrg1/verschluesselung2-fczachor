package fczachor.cipher;

/**
 * MONO ALPHABETIC CIPHER
 * This class implements Cipher.
 * @author Florian Czachor
 * @version 27.11.2018
 */

public class MonoAlphabeticCipher implements Cipher {

	// Attributes
	private String secretAlphabet;
	
	// Constructor
	public MonoAlphabeticCipher() {
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}
	
	// Methods
	
	// GET SECRET ALPABET
	// This getter returns secretAlphabet.
	public String getSecretAlphabet() {
		return this.secretAlphabet;							
	}
	
	// SET SECRET ALPHABET
	// This setter returns secretAlphabet.
	protected boolean setSecretAlphabet(String secretAlphabet) {
		String help = exceptMaster(secretAlphabet);
		if (help == null) {
			return false;
		}
		this.secretAlphabet = exceptMaster(secretAlphabet);
		return true;													
	}

	// EXCEPT MASTER
	// This method checks if the criteria are fulfilled.
	public String exceptMaster(String secretAlphabet) {
		secretAlphabet = secretAlphabet.toLowerCase();
		
		// 30
		if (secretAlphabet.length() !=30) {
			 return null;
		}
		
		// 1x character
		for (int i = 0; i < secretAlphabet.length(); i++) {
			char c = secretAlphabet.charAt(i);
			if (secretAlphabet.indexOf(c) == secretAlphabet.lastIndexOf(c)) {
				
			} else {
				return null;
			}
		}
		
		// invalid characters
		for (int i = 0; i < secretAlphabet.length(); i++) {
            char c = secretAlphabet.charAt(i);
            if (c >= 97 && c <= 122 || c == 246 || c == 228 || c == 252 || c == 223) {
            } else {
            	return null;
            }
        }
		return secretAlphabet;
	}

	// ENCRYPT
	// This method encrypts the message.
	public String encrypt(String text) {
		String encryptedText = "";
		String defAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			int place = defAlphabet.indexOf(c);
			if (place == -1) {
				encryptedText = encryptedText + c;
			} else {
				encryptedText = encryptedText + this.secretAlphabet.charAt(place);
			}
		}
		return encryptedText;
	}
	
	// DECRYPT
	// This method decrypts the message.
	public String decrypt(String text) {
		String decryptedText = "";
		String defaultAlph = "abcdefghijklmnopqrstuvwxyzäöüß";
		text = text.toLowerCase();
		
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			int place = this.secretAlphabet.indexOf(c);
			if (place == -1) {
				decryptedText = decryptedText + c;
			} else {
				decryptedText = decryptedText + defaultAlph.charAt(place);
			}
		}
		return decryptedText;
	}
}
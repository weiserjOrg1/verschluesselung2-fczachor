package fczachor.cipher;

/**
 * CIPHER
 * @author Florian Czachor
 * @version 27.11.2018
 */

public interface Cipher {
	
	// Attributes
	public String encrypt(String text);
	public String decrypt(String text);
	
}
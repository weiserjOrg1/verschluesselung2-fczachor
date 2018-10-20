package fczachor.cipher;
/**
 * This class implements the 2 Strings encrypt and decrypt.
 * @author FCzachor
 * @version 11.10.2018
 */
public interface Cipher {
	
	// Methoden
	public String encrypt(String text);
	public String decrypt(String text);
}
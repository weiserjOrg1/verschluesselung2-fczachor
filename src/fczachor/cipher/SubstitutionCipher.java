package fczachor.cipher;
/**
 * This class is the child class of MonoAlphabeticCipher and it sets the secret Alphabet.
 * @author FCzachor
 * @version 11.10.2018
 */
public class SubstitutionCipher extends MonoAlphabeticCipher{
	public SubstitutionCipher(String secretAlphabet) throws Egseptions {
		super.setSecretAlphabet(secretAlphabet);
	}
	
	public void setSecretAlphabet(String secretAlphabet) throws Egseptions {
		super.setSecretAlphabet(secretAlphabet);
	}
}
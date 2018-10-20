package fczachor.cipher;

public class ShiftCipher extends MonoAlphabeticCipher{
	public ShiftCipher(int value) throws Egseptions{
		this.setShiftValue(value);
		
	}
	
	public void setShiftValue(int value) throws Egseptions{
		String normalAlpha = "abcdefghijklmnopqrstuvwxyzäöüß";
		String newAlpha = "";
		
		while(value >= normalAlpha.length()) {
			value = value - 30;
		}
		
		while(value < 0) {
			value = value + 30;
		}
		
		for(int i=0; i<normalAlpha.length(); i++) {
			newAlpha = newAlpha + normalAlpha.charAt(value);
			value++;
			
			if(value >= normalAlpha.length()) {
				value = value -30;
			}
		}
		
		this.setSecretAlphabet(newAlpha);
	}
}
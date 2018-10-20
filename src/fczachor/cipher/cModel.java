package fczachor.cipher;

public class cModel {
	private String output;
	private SubstitutionCipher su1;
	private ShiftCipher sh1;
	private int which;
	
	
	public cModel() {
		this.which = 1;
		this.output = "N.A.";
		
		try {
			this.su1 = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
			this.sh1 = new ShiftCipher(0);
		}catch(Egseptions e) {
			
		}
	}
	public void setSubCipher(String alpha) throws Egseptions {

			this.su1.setSecretAlphabet(alpha);
	}
	
	public void setShiftCipher(int value)  {
		try {
			this.sh1.setShiftValue(value);
		}catch(Egseptions e) {
			
		}
			
	}
	
	public void setEncryptText(String t) {
		switch(this.which) {
			case 1: this.output = this.su1.encrypt(t);
				break;
			case 2: this.output = this.sh1.encrypt(t);
				break;
			default: 
				break;
		}
	}
	
	public void setDecryptText(String t) {
		switch(this.which) {
		case 1: this.output = this.su1.decrypt(t);
			break;
		case 2: this.output = this.sh1.decrypt(t);
			break;
		default: 
			break;
		}
	}
	
	public String getOutput() {
		return this.output;
	}
	
	
	public void setWhich(int i) {
		this.which = i;
	}
	
	public int getWhich() {
		return this.which;
	}
}

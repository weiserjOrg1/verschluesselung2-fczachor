package fczachor.cipher;

/**
 * VIEW
 * This class extends JFrame.
 * @author Florian Czachor
 * @version 27.11.2018
 */

// Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class View extends JFrame {

	// Attributes
	private Model m;
	private Controller c;
	
	private JPanel select;
	private JPanel alphBox;
	private JPanel inOutputBox;
	
	private JTextField inputShift;
	private JTextField inputSub;
	private JLabel shiftLabel;
	private JLabel subLabel;
	private JPanel inputShiftPanel;
	private JPanel inputSubstPanel;
	private JButton apply;
	
	private JRadioButton subCipher;
	private JRadioButton shiftCipher;
	private ButtonGroup radioGroup;
	
	private JTextField eText;
	private JTextField output;
	private JButton encrypt;
	private JButton decrypt;
	
	// Constructor
	public View(Controller c1, Model m1) {
	
	this.setTitle("Verschluesselung");
	this.setSize(new Dimension(400, 500));
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	this.m = m1;
	this.c = c1;

	// Attribute
	
	this.select = new JPanel();
	this.alphBox = new JPanel();
	this.inputSubstPanel = new JPanel();
	this.inOutputBox = new JPanel();
	this.inputShiftPanel = new JPanel();
	
	this.radioGroup = new ButtonGroup();
	this.shiftCipher = new JRadioButton("Shift Cipher");
	this.subCipher = new JRadioButton("Substitution", true);
	
	this.subLabel = new JLabel("Substitution: ");
	this.shiftLabel = new JLabel("Shifting: ");
	
	this.inputShift = new JTextField();
	this.inputSub = new JTextField();
	this.eText = new JTextField();
	this.output = new JTextField();
	
	this.apply = new JButton("Apply");
	this.apply.setEnabled(false);
	this.encrypt = new JButton("Encrypt");
	this.decrypt = new JButton("Decrypt");
	
	// Radio Buttons
	this.shiftCipher.addActionListener(this.c);
	this.subCipher.addActionListener(this.c);
	this.radioGroup.add(this.shiftCipher);
	this.radioGroup.add(this.subCipher);

	// Panels
	this.select.setBorder(BorderFactory.createTitledBorder("Methode"));
	this.select.add(this.shiftCipher);
	this.select.add(this.subCipher);

	this.alphBox.setBorder(BorderFactory.createTitledBorder("Alphabet"));
	this.alphBox.setLayout(new GridLayout(3, 1));

	this.inputSubstPanel.setLayout(new GridLayout(1, 2));
	
	this.inputSub.setDocument(new PlainDocument() {
        private static final long serialVersionUID = 1L;

        @Override
        public void insertString(int offs, String str, AttributeSet a) 
                throws BadLocationException {
            super.insertString(offs, str, a);
            applyAllow(false);
        }
        @Override
        protected void removeUpdate(AbstractDocument.DefaultDocumentEvent chng) {
            applyAllow(true);
        }
    });
	this.inputSubstPanel.add(this.subLabel);
	this.inputSubstPanel.add(this.inputSub);

	// Textfield on false
	this.inputShift.setEditable(false);
	this.inputShift.setDocument(new PlainDocument() {
    private static final long serialVersionUID = 1L;

    @Override
    public void insertString(int offs, String str, AttributeSet a) 
    		throws BadLocationException {
        for (int i = str.length()-1; i >= 0; i--) {
        	String s = str.charAt(i) + "";
            if(s.matches("[0-9]") ) {
                super.insertString(offs, s, a);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }});

	this.inputShiftPanel.setLayout(new GridLayout(1, 2));
	this.inputShiftPanel.add(this.shiftLabel);
	this.inputShiftPanel.add(this.inputShift);
	
	this.apply.addActionListener(this.c);
	JPanel applyPanel = new JPanel();
	applyPanel.setLayout(new BorderLayout());
	applyPanel.add(this.apply);

	this.alphBox.add(this.inputSubstPanel);
	this.alphBox.add(this.inputShiftPanel);
	this.alphBox.add(applyPanel);

	this.inOutputBox.setBorder(BorderFactory.createTitledBorder("Input & Output"));
	this.inOutputBox.setLayout(new GridLayout(3, 1));

	JLabel textLabel = new JLabel("Input: ");
	JPanel textPanel = new JPanel();
	textPanel.setLayout(new GridLayout(1, 2));
	textPanel.add(textLabel);
	textPanel.add(this.eText);

	JLabel outLabel = new JLabel("Output: ");
	JPanel outPanel = new JPanel();
	outPanel.setLayout(new GridLayout(1, 2));
	outPanel.add(outLabel);
	outPanel.add(this.output);
	this.output.setEditable(false);

	this.encrypt.addActionListener(this.c);
	this.decrypt.addActionListener(this.c);

	this.inOutputBox.add(textPanel);
	this.inOutputBox.add(outPanel);
	
	JPanel inOut = new JPanel();
	inOut.setLayout(new GridLayout(1, 2));
	this.inOutputBox.add(inOut);
	inOut.add(this.encrypt);
	inOut.add(this.decrypt);

	this.add(this.select);
	this.add(this.alphBox);
	this.add(this.inOutputBox);
	this.setLocationRelativeTo(null);
	this.setVisible(true);
}
	public void activateSubC() {
		this.m.mac = this.m.suc;
		this.applyAllow(false);
		this.inputSub.setEditable(true);
		this.inputShift.setEditable(false);
	}
	
	public void activateShiftC() {
		this.m.mac = this.m.shc;
		this.apply.setEnabled(true);
		this.inputShift.setEditable(true);
		this.inputSub.setEditable(false);
	}
	
	public void refresh() {
		this.repaint();
	}
	
	// Setter and Getter
	public String getSubAlph() {
		return inputSub.getText();
	}
	public String getShiftAlph() {
		return inputShift.getText();
	}
	public String getText() {
		return this.eText.getText();
	}
	public void setOutput(String str) {
		this.output.setText(str);
	}
	
	public void applyAllow(boolean b) {
		String alph = "abcdefghijklmnopqrstuvwxyzäöüß";
        boolean button = true;
        String text = inputSub.getText();
        if (b && text.equals("") == false) text = text.substring(0, text.length()-1);
        text = text.toLowerCase();
        if(text.length() != 30) button = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.indexOf(alph.charAt(i)+"") != (text.lastIndexOf(alph.charAt(i)+""))) {
                button = false;
                break;
            }
            if((text.charAt(i)+"").matches("[a-zäöüß]") && alph.contains(text.charAt(i)+"")) {} else {
                button = false;
                break;
            }
        }

        apply.setEnabled(button);
	}
	
	// Is - Methods
	public boolean isSubCipher(ActionEvent e) {
		if (this.subCipher == e.getSource())
			return true;
		return false;
		}
	
	public boolean isShiftCipher(ActionEvent e) {
		if(this.shiftCipher == e.getSource())
			return true;
		return false;
	}
	
	public boolean isApply(ActionEvent e) {
		if (this.apply == e.getSource())
			return true;
		return false;
	}
	
	public boolean isEncrypt(ActionEvent e) {
		if (this.encrypt == e.getSource())
			return true;
		return false;
	}
	
	public boolean isDecrypt(ActionEvent e) {
		if (this.decrypt == e.getSource())
			return true;
		return false;
	}
}

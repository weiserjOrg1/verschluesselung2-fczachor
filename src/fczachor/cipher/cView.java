package fczachor.cipher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cView extends JFrame{
	private cModel m1;
	private cController c1;
	private cPanel p1;
	private JButton en, de;
	private JRadioButton sh, su;
	private JTextField text, sAlpha, value;
	private JPanel pa1, pa2, pa3;
	private JLabel te, sA, va;
	private Container co1, co2, co3;
	private ButtonGroup rgb;
	
	public cView(cController c, cModel m) {
		this.m1 = m;
		this.c1 = c;
		this.p1 = new cPanel(this.m1);
		
		this.setSize(500, 500);
		
		this.en = new JButton("encrypt");
		this.de = new JButton("decrypt");
		
		this.sh = new JRadioButton("Shift-Cipher");
		this.su = new JRadioButton("Substitution-Cipher", true);
		
		this.text = new JTextField();
		this.sAlpha = new JTextField();
		this.value = new JTextField();
		
		this.pa1 = new JPanel();
		this.pa2 = new JPanel();
		this.pa3 = new JPanel();
		
		this.te = new JLabel("Text: ");
		this.sA = new JLabel("Secret Alphabet: ");
		this.va = new JLabel("Shift-value: ");
		
		this.co1 = new Container();
		this.co2 = new Container();
		this.co3 = new Container();
		
		this.rgb = new ButtonGroup();
		
		this.rgb.add(this.su);
		this.rgb.add(this.sh);
		
		this.en.addActionListener(this.c1);
		this.de.addActionListener(this.c1);
		this.su.addActionListener(this.c1);
		this.sh.addActionListener(this.c1);
		
		this.setLayout(new BorderLayout());
		this.pa1.setLayout(new BorderLayout());
		this.pa2.setLayout(new BorderLayout());
		this.pa3.setLayout(new GridLayout());
		this.co1.setLayout(new GridLayout());
		this.co2.setLayout(new GridLayout());
		this.co3.setLayout(new GridLayout());
		
		this.co1.add(this.te);
		this.co1.add(this.text);
		this.co2.add(this.va);
		this.co2.add(this.value);
		this.co3.add(this.sA);
		this.co3.add(this.sAlpha);
		
		this.pa3.add(this.sh);
		this.pa3.add(this.su);
		
		this.pa2.add(this.pa3, BorderLayout.NORTH);
		this.pa2.add(this.co1, BorderLayout.SOUTH);
		
		this.pa1.add(this.co3, BorderLayout.NORTH);
		this.pa1.add(this.co2, BorderLayout.SOUTH);
		
		this.add(this.p1);
		this.add(this.pa2, BorderLayout.NORTH);
		this.add(this.pa1, BorderLayout.SOUTH);
		this.add(this.en, BorderLayout.WEST);
		this.add(this.de, BorderLayout.EAST);
		
		this.setVisible(true);
	}
	public void refresh() {
		this.p1.repaint();
	}
	public boolean isEnPressed(ActionEvent e) {
		if(e.getSource()==this.en) return true;
		return false;
	}
	public boolean isDePressed(ActionEvent e) {
		if(e.getSource()==this.de) return true;
		return false;
	}
	public boolean isShChecked() {
		if(this.sh.isSelected()) return true;
		return false;
	}
	public boolean isSuChecked() {
		if(this.su.isSelected()) return true;
		return false;
	}
	public String getValue() {
		return this.value.getText();
	}
	public String getSAlpha() {
		return this.sAlpha.getText();
	}
	public String getText() {
		return this.text.getText();
	}
}
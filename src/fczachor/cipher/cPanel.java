package fczachor.cipher;

import java.awt.*;
import javax.swing.*;

public class cPanel extends JPanel{
	private cModel m1;
	public cPanel(cModel m) {
		this.m1 = m;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(this.m1.getOutput(),10, 10);
	}
}
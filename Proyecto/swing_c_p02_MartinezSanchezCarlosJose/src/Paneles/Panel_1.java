/*
 * Created on 9 dic. 2020
 * @author Carlos
 * @version 1.0
 */
package Paneles;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class Panel_1.
 */
public class Panel_1 extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The titulo. */
	private JLabel titulo;
	
	/**
	 * Instantiates a new panel 1.
	 *
	 * @author Carlos
	 * Created on 9 dic. 2020
	 * @version 1.0
	 */
	public Panel_1() {
		setBackground(Color.PINK);
		setLayout(new FlowLayout());
		
		titulo= new JLabel("Hotel Printer-Boi");
		titulo.setFont(new Font("Arial",1,40));
		titulo.setForeground(Color.BLUE);
		
		
		add(titulo);
		
		setVisible(true);
	}

}

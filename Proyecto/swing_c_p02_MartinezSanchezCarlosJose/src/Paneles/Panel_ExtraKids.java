/*
 * Created on 08-dic-2020
 * @author Carlos
 * @version 1.0
 */
package Paneles;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

// TODO: Auto-generated Javadoc
/**
 * The Class Panel_ExtraKids.
 */
public class Panel_ExtraKids extends JPanel implements FocusListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The l extras. */
	private JLabel lEdad, lExtras;

	/** The edad. */
	private JSpinner edad;

	/** The extras. */
	private JTextField extras;

	/**
	 * Instantiates a new panel extra kids.
	 *
	 * @author Carlos
	 * Created on 08-dic-2020
	 * @version 1.0
	 */
	public Panel_ExtraKids() {
		setLayout(null);
		setBackground(Color.GRAY);
		
		//Inicializamos los JLabel
		lEdad = new JLabel("Edad:");
		lExtras = new JLabel("Extras:");

		// Incializamos el JSlider
		edad = new JSpinner(new SpinnerNumberModel(0, 0, 14, 1));

		//Inicializamos el JTextField
		extras = new JTextField();
		extras.setEditable(false);
		
		//Añadimos el foco
		extras.addFocusListener(this);
		
		
		lEdad.setBounds(25, 20, 50, 25);
		edad.setBounds(70, 20, 50, 25);
		lExtras.setBounds(25, 75, 50, 25);
		extras.setBounds(70, 75, 150, 25);

		//Añadimos al panel
		add(lEdad);
		add(edad);
		add(lExtras);
		add(extras);
		setVisible(false);
	}
	
	
	public String getEdad() {
		String laEdad= edad.getValue().toString();
		return laEdad;
	}

	/**
	 * Metodo que devuelve Focus gained.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void focusGained(FocusEvent arg0) {
		int edadValor=(Integer) edad.getValue();
		
		if(edadValor<=3)
			extras.setText("Cuna");
		
		if(edadValor>3 && edadValor<=10)
			extras.setText("Cama supletoria pequeña");
		
		if(edadValor>10 && edadValor<=14)
			extras.setText("Cama supletoria normal");

	}

	/**
	 * Metodo que devuelve Focus lost.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void focusLost(FocusEvent arg0) {
	}
	
	
	public void resetKids() {
		edad.setValue(((SpinnerNumberModel) edad.getModel()).getMinimum());
		lExtras.setText("");
	}

}

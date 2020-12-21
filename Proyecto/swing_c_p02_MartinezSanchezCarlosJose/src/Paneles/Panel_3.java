/*
 * Created on 9 dic. 2020
 * @author Carlos
 * @version 1.0
 */
package Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

// TODO: Auto-generated Javadoc
/**
 * The Class Panel_3.
 */
public class Panel_3 extends JPanel implements ActionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1519237183299406495L;

	/** Los JLabel. */
	private JLabel tfTipoHabitacion, numHabitaciones, importeHabitacion;

	/** The lista. */
	private static JComboBox<String> lista;

	/** The sp habitaciones. */
	private JSpinner spHabitaciones;

	/** The panel. */
	private JPanel panel;

	/** The ninios. */
	private static JCheckBox ninios;

	/** The panel kids. */
	private Panel_ExtraKids panelKids;

	/** The panel imagenes. */
	@SuppressWarnings("unused")
	private Panel_Imagenes panelImagenes;

	/** The tf importe habitacion. */
	private static JTextField tfImporteHabitacion;
	
	private JButton botonImg;

	/**
	 * Instantiates a new panel 3.
	 *
	 * @author Carlos
	 * Created on 9 dic. 2020
	 * @version 1.0
	 */
	// ponemos el layout y la resolucion
	public Panel_3() {
		setLayout(null);
		// setSize(640, 480);

		// Array que contiene las distintas opciones del JComboBox
		String[] tipoHabitacion = { "Simple", "Doble", "Suite" };
		// -----------------------------------------------------------------------------

		// Inicializamos el JComboBox
		lista = new JComboBox<String>(tipoHabitacion);

		// Incializamos los JLabel
		tfTipoHabitacion = new JLabel("Tipo de habitacion:");
		numHabitaciones = new JLabel("Numero de habitaciones:");
		importeHabitacion = new JLabel("Importe de la habitacion:");
		importeHabitacion.setForeground(Color.RED);

		// Inicializamos el JTextField
		tfImporteHabitacion = new JTextField();
		tfImporteHabitacion.setEditable(false);

		// Incializamos el JSlider
		spHabitaciones = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));

		// Lo añadimos a un panel para evitar que ocupe mucho espacio
		panel = new JPanel();
		panel.add(spHabitaciones);

		// Inicializamos el JCheckBox
		ninios = new JCheckBox("¿Niños?");

		// Inicializamos el panel que se abrirá en caso de pulsar el JCheckBox
		panelKids = new Panel_ExtraKids();
		
		botonImg=new JButton("Mostrar imagenes de las habitaciones");
		// -----------------------------------------------------------------------------

		// Añadimos los listeners
		lista.addActionListener(this);
		ninios.addActionListener(this);
		botonImg.addActionListener(this);
		// -----------------------------------------------------------------------------

		// Damos posiciones Falta calibrar la posicion de los paneles de kids e imagenes
		tfTipoHabitacion.setBounds(50, 350, 125, 50);
		lista.setBounds(200, 362, 100, 25);

		numHabitaciones.setBounds(50, 450, 150, 25);
		spHabitaciones.setBounds(200, 450, 75, 25);

		ninios.setBounds(50, 550, 75, 50);

		panelKids.setBounds(50, 600, 250, 150);

		importeHabitacion.setBounds(50, 800, 150, 25);
		tfImporteHabitacion.setBounds(200, 800, 100, 25);
		
		botonImg.setBounds(150, 100, 375, 50);
		// -----------------------------------------------------------------------------

		// Añadimos al panel
		add(tfTipoHabitacion);
		add(numHabitaciones);
		add(lista);
		add(spHabitaciones);
		add(ninios);
		add(panelKids);
		add(importeHabitacion);
		add(tfImporteHabitacion);
		add(botonImg, BorderLayout.NORTH);
		// -----------------------------------------------------------------------------

		// Mostramos el panel
		setVisible(true);
	}
	
	/**
	 * Metodo que calcula el importe de la habitacion.
	 * Realizando la llamada al setImporteTotal para mostrarlo en el JTextField
	 */
	public static void calcularImporte() {
		final int SIMPLE=50, DOBLE=75, SUITE=125;
		int kids = 0;
		int dias=Integer.parseInt(Panel_2.getNDias());
		
		if (ninios.isSelected()) {kids=20;}
			
		if(lista.getSelectedIndex()==0) {
			int resultado=SIMPLE*dias+kids;
			setImporteTotal(resultado);
		}
		
		if(lista.getSelectedIndex()==1) {
			int resultado=DOBLE*dias+kids;
			setImporteTotal(resultado);
		}
		
		if(lista.getSelectedIndex()==2) {
			int resultado=SUITE*dias+kids;
			setImporteTotal(resultado);
		}
	}

	/**
	 * Metodo que devuelve Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ninios) {
			if (ninios.isSelected())
				panelKids.setVisible(true);

			if (ninios.isSelected() == false)
				panelKids.setVisible(false);
		}
		
		if(e.getSource()==botonImg) {
			panelImagenes = new Panel_Imagenes();
		}
	}

	// Metodos get
	/**
	 * Metodo que devuele el tipo de la habitacion.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return el tipo de la habitacion
	 */
	public String getTipoHabitacion() {
		return lista.getSelectedItem().toString();
	}

	/**
	 * Metodo que devuelve el numero de habitaciones.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return el numero de habitaciones
	 */
	public String getNumHabitaciones() {
		return spHabitaciones.getValue().toString();
	}

	/**
	 * Metodo que devuelve la edad en caso de que la casilla de niños esté activada
	 * En caso contrario devuelve N, indicando que no está pulsada.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return la edad o N
	 */
	public String getEdadKids() {
		if (ninios.isSelected() == true) {
			return panelKids.getEdad();
		}
		return "N";
	}

	/**
	 * Sets the importe total.
	 * Created on 9 dic. 2020
	 *
	 * @author Carlos
	 * @version 1.0
	 * @param importe the new importe total
	 */
	// Metodo set para el JTextField del importe de la habitacion
	public static void setImporteTotal(int importe) {
		tfImporteHabitacion.setText(Integer.toString(importe) + " €");
	}
	
	/**
	 * Gets the importe total.
	 * Created on 9 dic. 2020
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return the importe total
	 */
	public String getImporteTotal() {
		return tfImporteHabitacion.getText();
	}
	
	/**
	 * Metodo que resetea todo el panel.
	 */
	public void resetHabitacion() {
		lista.setSelectedIndex(0);
		spHabitaciones.setValue(((SpinnerNumberModel) spHabitaciones.getModel()).getMinimum());
		panelKids.resetKids();
		tfImporteHabitacion.setText("");
	}

}

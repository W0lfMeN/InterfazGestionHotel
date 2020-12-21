/*
 * Created on 04-dic-2020
 * @author Carlos
 * @version 1.0
 */
package Paneles;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Exceptions.ClienteException;

// TODO: Auto-generated Javadoc
/**
 * The Class Panel_2.
 */
public class Panel_2 extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8622274147906685389L;

	/** Los JLabel. */
	private JLabel nombre, dni, apellidos, telefono, fechaEntrada, fechaSalida, nDias;

	/** The JTextField. */
	private static JTextField tfNombre, tfDni, tfApellidos, tfTelefono, tfFechaEntrada, tfFechaSalida, tfNDias;

	/**
	 * Instantiates el panel 2.
	 *
	 * @author Carlos Created on 04-dic-2020
	 * @version 1.0
	 */
	public Panel_2() {
		// ponemos el layout y la resolucion
		setLayout(null);
		

		// Incializamos los JLabel
		nombre = new JLabel("Nombre:");
		dni = new JLabel("DNI:");
		apellidos = new JLabel("Apellidos:");
		telefono = new JLabel("Telefono:");
		fechaEntrada = new JLabel("Fecha de Entrada:");
		fechaSalida = new JLabel("Fecha de Salida:");
		nDias = new JLabel("Numero de dias:");

		// Inicializamos los JTextField
		tfNombre = new JTextField();
		tfDni = new JTextField();
		tfApellidos = new JTextField();
		tfTelefono = new JTextField();
		tfFechaEntrada = new JTextField(getFechaActual());
		tfFechaSalida = new JTextField(getFechaPosterior());
		tfNDias = new JTextField();

		tfNDias.setEditable(false);

		// Damos medidas
		nombre.setBounds(50, 275, 50, 50);
		tfNombre.setBounds(160, 290, 100, 25);
		dni.setBounds(50, 350, 50, 25);
		tfDni.setBounds(160, 350, 75, 25);
		apellidos.setBounds(50, 390, 75, 50);
		tfApellidos.setBounds(160, 405, 150, 25);
		telefono.setBounds(50, 455, 75, 25);
		tfTelefono.setBounds(160, 455, 100, 25);
		fechaEntrada.setBounds(50, 500, 110, 25);
		tfFechaEntrada.setBounds(160, 500, 80, 25);
		fechaSalida.setBounds(50, 550, 110, 25);
		tfFechaSalida.setBounds(160, 550, 80, 25);
		nDias.setBounds(50, 600, 100, 25);
		tfNDias.setBounds(160, 600, 50, 25);

		// Añadimos
		add(nombre);
		add(tfNombre);
		add(dni);
		add(tfDni);
		add(apellidos);
		add(tfApellidos);
		add(telefono);
		add(tfTelefono);
		add(fechaEntrada);
		add(tfFechaEntrada);
		add(fechaSalida);
		add(tfFechaSalida);
		add(nDias);
		add(tfNDias);

		// Mostramos el panel
		setVisible(true);
	}
	
	/**
	 * String to local date.
	 * Convierte una cadena a LocalDate
	 *
	 * @param fecha the fecha
	 * @return the local date
	 */
	private static LocalDate stringToLocalDate(String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(fecha, formatter);
		return localDate;
	}
	
	/**
	 * Calcula los dias que hay entre la fecha de salida y la fecha de entrada
	 *
	 * @return the string
	 */
	private static String calcularDias() {
		LocalDate entrada= stringToLocalDate(tfFechaEntrada.getText().trim());
		LocalDate salida= stringToLocalDate(tfFechaSalida.getText().trim());
		
		Long entradaDias=entrada.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
		Long salidaDias=salida.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
		
		if(salidaDias<entradaDias) {
			JOptionPane.showMessageDialog(null, "ERROR: LA FECHA DE SALIDA NO PUEDE SER MENOR A LA DE ENTRADA");
			throw new ClienteException();
		}
		
		Long diferencia=salidaDias-entradaDias;
		
		Long millisecondsToDays=TimeUnit.MILLISECONDS.toDays(diferencia);
		
		String dias=millisecondsToDays.toString();
		
		return dias;
	}

	/**
	 * Gets the fecha actual.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return the fecha actual
	 */
	public static String getFechaActual() {
		LocalDate ahora = LocalDate.now();
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return ahora.format(formateador);
	}

	/**
	 * Gets the fecha posterior.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return the fecha posterior
	 */
	public static String getFechaPosterior() {
		LocalDate diaSiguiente = LocalDate.now().plusDays(1);
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return diaSiguiente.format(formateador);
	}

	/**
	 * Gets the nombre.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return the nombre
	 */
	public String getNombre() {
		return tfNombre.getText().trim();
	}

	/**
	 * Gets the dni.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return the dni
	 */
	public String getDni() {
		if (tfDni.getText().trim().length() != 9) {
			JOptionPane.showMessageDialog(null, "ERROR: EL DNI DEBE DE TENER 9 ALFANUMERICOS");
			throw new ClienteException();
		}
		return tfDni.getText().trim();
	}

	/**
	 * Gets the apellidos.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return the apellidos
	 */
	public String getApellidos() {
		return tfApellidos.getText().trim();
	}

	/**
	 * Gets the telefono.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return the telefono
	 */
	public String getTelefono() {
		final String PATRON = "[0-9]+";
		String telefono = tfTelefono.getText().trim();

		if (!telefono.matches(PATRON) || telefono.length() != 9) {
			JOptionPane.showMessageDialog(null, "ERROR: EL TELEFONO DEBE DE TENER 9 DIGITOS");
			throw new ClienteException();
		}

		return tfTelefono.getText().trim();
	}

	/**
	 * Gets the fecha entrada.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return the fecha entrada
	 */
	public String getFechaEntrada() {
		return tfFechaEntrada.getText().trim();
	}

	/**
	 * Gets the fecha salida.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return the fecha salida
	 */
	public String getFechaSalida() {
		return tfFechaSalida.getText().trim();
	}

	/**
	 * Gets dias de estancia.
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return the n dias
	 */
	public static String getNDias() {
		return tfNDias.getText().trim();
	}
	
	/**
	 * Metodo que modifica el campo de los dias de estancia
	 */
	public static void setNDias() {
		tfNDias.setText(calcularDias());
	}
	
	/**
	 * Metodo que realiza un reset de los campos de clientes.
	 */
	public void resetClientes() {
		tfNombre.setText("");
		tfDni.setText("");
		tfApellidos.setText("");
		tfTelefono.setText("");
		tfFechaEntrada.setText(getFechaActual());
		tfFechaSalida.setText(getFechaPosterior());
		tfNDias.setText("");
		
		tfNombre.requestFocus();
	}
	
	
	
	
	
	
	
	
	
}
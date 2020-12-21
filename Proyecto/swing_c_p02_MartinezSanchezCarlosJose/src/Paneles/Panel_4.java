/*
 * Created on 9 dic. 2020
 * @author Carlos
 * @version 1.0
 */
package Paneles;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import swing_c_p02_MartinezSanchezCarlosJose.Dialogo;

// TODO: Auto-generated Javadoc
/**
 * The Class Panel_4.
 */
public class Panel_4 extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1740828945108575741L;

	/** The pestañas. */
	private JTabbedPane pestañas;

	/** The datos. */
	private static ArrayList<String> datos = Dialogo.getDatos();
	
	/** The area clientes. */
	private static JTextArea areaClientes;
	
	/** The area habitacion. */
	private static JTextArea areaHabitacion;
	

	/**
	 * Instantiates a new tabbed panel.
	 *
	 * @author Carlos Created on 23-nov-2020
	 * @version 1.0
	 */
	public Panel_4() {
		setLayout(null);

		pestañas = new JTabbedPane();

		// Inicializamos el panel
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		// Componentes del panel1------------------------
		panel1.setLayout(new BorderLayout());

		areaClientes=new JTextArea("");
		areaClientes.setEditable(false);

		panel1.add(areaClientes);

		// Componentes del panel2------------------------
		
		panel2.setLayout(new BorderLayout());

		areaHabitacion=new JTextArea("");
		areaHabitacion.setEditable(false);
		
		panel2.add(areaHabitacion);

		// Añadimos los paneles al JTabbedPane
		pestañas.addTab("Datos Cliente", panel1);
		pestañas.addTab("Datos Habitacion", panel2);

		pestañas.setBounds(75, 100, 450, 500);

		// Añadimos el JTabbedPane
		add(pestañas);

		setVisible(true);
	}

	/**
	 * Metodo que rellena el textArea con los datos indicados de Clientes.
	 */
	public static void rellenarPanelClientes() {
		
		areaClientes.setText("Nombre: "+datos.get(0)+"\n"
				+ "Apellidos: "+datos.get(1)+"\n"
				+ "DNI: "+datos.get(2)+"\n"
				+ "Telefono: "+datos.get(3)+"\n"
				+ "Fecha de entrada: "+datos.get(4)+"\n"
				+ "Fecha de salida: "+datos.get(5)+"\n"
				+ "Numero de dias: "+datos.get(6));
	}

	/**
	 * Metodo que rellena el textArea con los datos indicados de Habitaciones.
	 * Si la cadena de los niños es igual a N quiere decir que no hay y por eso se muestra el mensaje indicado
	 */
	public static void rellenarPanelHabitacion() {
		String cadenaKids = "No hay";

		if (datos.get(9).trim() != "N") {
			cadenaKids = datos.get(9);
		}
		
		areaHabitacion.setText("Tipo de habitacion: "+datos.get(7)+"\n"
				+ "Cantidad de habitaciones: "+datos.get(8)+"\n"
				+ "Edad de los niños: "+cadenaKids+"\n"
				+ "Importe total: "+datos.get(10));

	}
	
	/**
	 * Metodo que vacía los dos textArea.
	 */
	public void resetVentanas() {
		areaClientes.setText("");
		areaHabitacion.setText("");
	}

}

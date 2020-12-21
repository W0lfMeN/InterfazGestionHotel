/*
 * Created on 9 dic. 2020
 * @author Carlos
 * @version 1.0
 */
package swing_c_p02_MartinezSanchezCarlosJose;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Exceptions.ClienteException;
import Exceptions.HabitacionException;
import Paneles.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Dialogo.
 */
public class Dialogo extends JDialog implements ActionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The horizontal. */
	int horizontal=Toolkit.getDefaultToolkit().getScreenSize().width;
	
	/** The vertical. */
	int vertical=Toolkit.getDefaultToolkit().getScreenSize().height;

	/** The panel 1. */
	private Panel_1 panel1;
	
	/** The panel 2. */
	private Panel_2 panel2;
	
	/** The panel 3. */
	private Panel_3 panel3;
	
	/** The panel 4. */
	private Panel_4 panel4;

	/** The bt guardar. */
	private JButton btImprimirDocumento, btNuevo, btGuardar;
	
	/** The datos. */
	private static ArrayList<String> datos=new ArrayList<String>();

	/**
	 * Instantiates a new dialogo.
	 *
	 * @author Carlos
	 * Created on 9 dic. 2020
	 * @version 1.0
	 */
	public Dialogo() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize()); // Se obtiene la resolucion usando Toolkit
		setIconImage(new ImageIcon(getClass().getResource("recursos/anagrama.png")).getImage()); // Se añade el icono al
																									// panel
		setResizable(false); // Hacemos que no se pueda redimensionar la ventana
		setTitle("Alta reservas"); // Se añade el titulo de la ventana
		setLayout(new BorderLayout(2,2));
		// --------------------------------------------------------------------------------------------

		// Imagenes
		Image imgPrintDocument = new ImageIcon(getClass().getResource("recursos/printDocument.png")).getImage();
		ImageIcon imgPrintDocumentUps = new ImageIcon(imgPrintDocument.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

		Image imgNew = new ImageIcon(getClass().getResource("recursos/new.png")).getImage();
		ImageIcon imgNewUps = new ImageIcon(imgNew.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

		Image imgSave = new ImageIcon(getClass().getResource("recursos/save.png")).getImage();
		ImageIcon imgSaveUps = new ImageIcon(imgSave.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		// --------------------------------------------------------------------------------------------

		panel1 = new Panel_1(); // El panel 1
		
		panel2 = new Panel_2(); // El panel 2
		panel2.setPreferredSize(new Dimension((int)(horizontal/3), vertical)); //Ajustamos su tamaño a un tercio del eje X
		panel2.setBackground(Color.GRAY);
		
		panel3 = new Panel_3(); // El panel 3
		
		panel4 = new Panel_4(); // El panel 4
		panel4.setPreferredSize(new Dimension((int)(horizontal/3), vertical)); //Ajustamos su tamaño a un tercio del eje X
		panel4.setBackground(Color.GRAY);
		
		JPanel botones=new JPanel(); //Panel donde meteremos los botones
	
		//Incializamos los botones
		btImprimirDocumento = new JButton(imgPrintDocumentUps);
		btNuevo = new JButton(imgNewUps);
		btGuardar = new JButton(imgSaveUps);
		//Los metemos en el panel de los botones
		botones.add(btImprimirDocumento);
		botones.add(btNuevo);
		botones.add(btGuardar);

		//Añadimos los listeners
		btImprimirDocumento.addActionListener(this);
		btNuevo.addActionListener(this);
		btGuardar.addActionListener(this);

		//Los añadimos al panel de Dialogo
		getContentPane().add(panel1, BorderLayout.NORTH);
		getContentPane().add(panel2, BorderLayout.WEST);
		getContentPane().add(panel3, BorderLayout.CENTER);
		getContentPane().add(panel4, BorderLayout.EAST);
		getContentPane().add(botones, BorderLayout.SOUTH);

		setVisible(true);
	}

	/**
	 * Metodo que Realiza acciones segun los datos introducidos.
	 * 
	 * El boton de Imprimir captura 2 excepciones personalizadas que heredan de IllegalArgumentException
	 * Se realiza asi para controlar que se introducen todos los campos necesarios.
	 * 
	 * El boton Nuevo llama a los metodos reset de los 3 paneles
	 * @param e the ActionEvent
	 */
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btImprimirDocumento) {
			
			datos.clear(); //Limpiamos el arrayList antes de añadir valores
			
			// Variables para el panel 2
			String nombre = "", dni = "", telefono = "", apellidos = "", fechaEntrada = "", fechaSalida = "", nDias = "";
			// Variables para el panel 3
			String tipoHabitacion = "", cantidadHabitacion = "", edadKids = "", importeTotal="";
			
			try {
				// Datos de cliente (Panel 2)
				panel2.setNDias(); //Se calculan los dias de la estancia

				//Obtenemos los datos de Clietnes
				nombre = panel2.getNombre();
				dni = panel2.getDni();
				apellidos = panel2.getApellidos();
				telefono = panel2.getTelefono();
				fechaEntrada = panel2.getFechaEntrada();
				fechaSalida = panel2.getFechaSalida();
				nDias = panel2.getNDias();
				// -------------------------------------------
				// Datos de la habitacion (Panel 3)
				panel3.calcularImporte();
				
				//Obtenemos los datos de las Habitaciones
				tipoHabitacion = panel3.getTipoHabitacion();
				cantidadHabitacion = panel3.getNumHabitaciones();
				edadKids = panel3.getEdadKids();
				importeTotal=panel3.getImporteTotal();
				
				
				// -------------------------------------------
				
				//Metemos todo en un arrayList para pasarlo al panel Toggle
				datos.add(nombre);
				datos.add(apellidos);
				datos.add(dni);
				datos.add(telefono);
				datos.add(fechaEntrada);
				datos.add(fechaSalida);
				datos.add(nDias);
				
				datos.add(tipoHabitacion);
				datos.add(cantidadHabitacion);
				datos.add(edadKids);
				datos.add(importeTotal);
				
				
				//Llamamos al rellenar clientes del panel 4
				Panel_4.rellenarPanelClientes();
				
				//Llamamos al rellenar habitaciones del panel 4
				Panel_4.rellenarPanelHabitacion();

			} catch (ClienteException ex) {
				return;
			} catch (HabitacionException ex) {
				return;
			}
		}
		
		if(e.getSource()==btNuevo) {
			panel2.resetClientes();
			panel3.resetHabitacion();
			panel4.resetVentanas();
		}
		
		if(e.getSource()==btGuardar) {
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		}
	}
	
	/**
	 * Gets the datos.
	 * Created on 9 dic. 2020
	 *
	 * @author Carlos
	 * @version 1.0
	 * @return the datos
	 */
	public static ArrayList<String> getDatos(){
		return datos;
	}
	
}

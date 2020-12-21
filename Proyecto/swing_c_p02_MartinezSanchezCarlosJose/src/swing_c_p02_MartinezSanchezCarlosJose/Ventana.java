/*
 * Created on 9 dic. 2020
 * @author Carlos
 * @version 1.0
 */
package swing_c_p02_MartinezSanchezCarlosJose;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


// TODO: Auto-generated Javadoc
/**
 * The Class Ventana.
 */
public class Ventana extends JFrame implements ActionListener, KeyListener{

	/** Declaracion de atributos. */
	private static final long serialVersionUID = 1L;
	
	/** The barra menu. */
	private JMenuBar barraMenu;
	
	/** The ayuda. */
	private JMenu archivo, registro, ayuda;;
	
	/** The acerca de. */
	private JMenuItem salir, altaReservas, bajaReservas, acercaDe;
	
	/** The bt baja reservas. */
	private JButton btAltaReservas, btBajaReservas;

	/**
	 * Instantiates a new ventana.
	 *
	 * @author Carlos
	 * Created on 9 dic. 2020
	 * @version 1.0
	 */
	public Ventana() {
		
		/**
		 * Declaracion del titulo de la ventana y de las medidas de la misma
		 */
		super("Gestion Hotel Printer-Boi");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(400, 200);
	    setLocationRelativeTo(null);
	    setResizable(false);
		this.setLayout(null);
		
		Image logo= new ImageIcon(getClass().getResource("recursos/anagrama.png")).getImage();
		setIconImage(logo);
		//--------------------------------------------------------------------------------------------
		
		//Imagenes
		Image imgBtAlta = new ImageIcon(getClass().getResource("recursos/add.png")).getImage();
		ImageIcon imgAltaUps = new ImageIcon(imgBtAlta.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		
		Image imgBtBaja = new ImageIcon(getClass().getResource("recursos/delete.png")).getImage();
		ImageIcon imgBajaUps = new ImageIcon(imgBtBaja.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		//--------------------------------------------------------------------------------------------
		
		//Inicializamos
		barraMenu= new JMenuBar();
		
		archivo= new JMenu("Archivo");
		registro= new JMenu("Registro");
		ayuda= new JMenu("Ayuda");
		
		salir= new JMenuItem("Salir");
		altaReservas= new JMenuItem("Alta Reservas");
		bajaReservas= new JMenuItem("Baja Reservas");
		acercaDe= new JMenuItem("Acerca De...");
		
		btAltaReservas= new JButton(imgAltaUps);
		btBajaReservas= new JButton(imgBajaUps);
		//--------------------------------------------------------------------------------------------
		
		//Damos medidas a los elementos
		barraMenu.setSize(400,25);
		btAltaReservas.setBounds(0, 25, 200, 150);
		btBajaReservas.setBounds(200, 25, 200, 150);
		//--------------------------------------------------------------------------------------------
		
		//Añadios los listeners correspondientes
		salir.addActionListener(this);
		altaReservas.addActionListener(this);
		bajaReservas.addActionListener(this);
		acercaDe.addActionListener(this);
		
		btAltaReservas.addActionListener(this);
		btBajaReservas.addActionListener(this);
		
		registro.setMnemonic(KeyEvent.VK_R);
		btAltaReservas.setMnemonic(KeyEvent.VK_A);
		btBajaReservas.setMnemonic(KeyEvent.VK_B);
		//--------------------------------------------------------------------------------------------
		
		//Añadimos los componentes a los elementos del menu
		archivo.add(salir);
		registro.add(altaReservas);
		registro.add(bajaReservas);
		ayuda.add(acercaDe);
		
		//Añadimos los elementos del menu al menu
		barraMenu.add(archivo);
		barraMenu.add(registro);
		barraMenu.add(ayuda);

		add(barraMenu);
		add(btAltaReservas);
		add(btBajaReservas);
		//--------------------------------------------------------------------------------------------
		
		//Mostramos el panel
		this.setVisible(true);
	}

	/**
	 * Metodo que devuelve Key pressed.
	 *
	 * @param e the e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
			
	}

	/**
	 * Metodo que devuelve Key released.
	 *
	 * @param e the e
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	/**
	 * Metodo que devuelve Key typed.
	 *
	 * @param e the e
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	/**
	 * Metodo que devuelve Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==salir)
			System.exit(0);
		
		if(e.getSource()==btBajaReservas || e.getSource()==bajaReservas)
			JOptionPane.showMessageDialog(null, "Esta opcion aun no está desarrollada");
		
		if(e.getSource()==acercaDe)
			JOptionPane.showMessageDialog(null, "Progrmama encargado de gestionar las reservas del hotel Printer-Boi");
		
		if(e.getSource()==btAltaReservas || e.getSource()==altaReservas) {
			@SuppressWarnings("unused")
			Dialogo d= new Dialogo();
		}
		
	}
	
}

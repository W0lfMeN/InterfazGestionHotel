/*
 * Created on 9 dic. 2020
 * @author Carlos
 * @version 1.0
 */
package Paneles;

import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class Panel_Imagenes.
 */
public class Panel_Imagenes extends JDialog {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The l img suite. */
	private JLabel lImgSimple, lImgDoble, lImgSuite;

	/** The suite. */
	private JLabel simple, doble, suite;

	/**
	 * Instantiates a new panel imagenes.
	 *
	 * @author Carlos 
	 * Created on 9 dic. 2020
	 * @version 1.0
	 */
	public Panel_Imagenes() {
		setSize(640, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new GridLayout(3, 2));
		
		//Imagenes
		Image imgSimple = new ImageIcon(getClass().getResource("resources/hotel1.jpg")).getImage();
		ImageIcon imgSimpleUps = new ImageIcon(imgSimple.getScaledInstance(200, 100, Image.SCALE_SMOOTH));

		Image imgDoble = new ImageIcon(getClass().getResource("resources/hotel2.jpg")).getImage();
		ImageIcon imgDobleUps = new ImageIcon(imgDoble.getScaledInstance(200, 100, Image.SCALE_SMOOTH));

		Image imgSuite = new ImageIcon(getClass().getResource("resources/hotel3.jpg")).getImage();
		ImageIcon imgSuiteUps = new ImageIcon(imgSuite.getScaledInstance(200, 100, Image.SCALE_SMOOTH));
		
		//------------------------------------------------------------------------------------------------------

		//Incializamos los Jlabel con sus imagenes
		lImgSimple = new JLabel(imgSimpleUps);
		lImgDoble = new JLabel(imgDobleUps);
		lImgSuite = new JLabel(imgSuiteUps);

		//Incializamos los Jlabel con su texto
		simple = new JLabel("Habitacion Simple");
		doble = new JLabel("Habitacion Doble");
		suite = new JLabel("Habitacion Suite");

		//Añadimos todo al panel
		add(lImgSimple);
		add(simple);
		add(lImgDoble);
		add(doble);
		add(lImgSuite);
		add(suite);
		
		//Lo mostramos
		setVisible(true);
	}
}

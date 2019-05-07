package Clases;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Clase principal de excepción.
 * Maneja TODAS las excepciones. Si no le gusta, pos perdidas...
 */
public class JajaUyPapiQuePutasException extends Exception
{
	
	/**
	 * Constante de serialización.
	 */
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------
		//Bob el constructor
	//-----------------------------------------------------
	
	/*
	 * Metodo constructor de la clase JajaUyPapiQuePutasException.
	 */
	
	public JajaUyPapiQuePutasException(String e)
	{
		JFrame x  = new JFrame();
		x.setVisible(true);
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setSize(1000, 450);
		x.setResizable(false);
		ImageIcon y = new ImageIcon("./data/images/excuse.jpg");
		JPanel z = new JPanel();
		x.add(z);
		JLabel w = new JLabel(e);
		w.setIcon(y);
		z.add(w);
	}
}
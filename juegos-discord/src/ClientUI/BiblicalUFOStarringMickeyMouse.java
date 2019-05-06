package ClientUI;

//Java clases
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Clase principal del juego
 * Maldita sea Daniel, comente su puto codigo...
 * Ups :v att: Daniel.
 */
public class BiblicalUFOStarringMickeyMouse implements ActionListener
{
	//-------------------------------------------------------------
		//Constantes
	//-------------------------------------------------------------
	public static final String LAUNCH = "Launch Game";

	//-------------------------------------------------------------
		//Atributos
	//-------------------------------------------------------------
	public JFrame frame;

	public JPanel panel;

	public JButton bLaunch;

	//-------------------------------------------------------------
		//Bob el constructor
	//-------------------------------------------------------------
	
	/*
	 * Metodo constructor de el launcher.
	 */
	public BiblicalUFOStarringMickeyMouse()
	{
		frame = new JFrame("Biblical UFO starring Mickey Mouse");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 500));

		panel = new JPanel();

		//Creacion y agregacion del boton
		bLaunch = new JButton(LAUNCH);
		bLaunch.setActionCommand(LAUNCH);
		bLaunch.addActionListener(this);
		panel.add(bLaunch);

		frame.getContentPane().add(panel);

		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	//-------------------------------------------------------------
		//Metodos
	//-------------------------------------------------------------

	/*
	 * Metodo principal de inicio.
	 */
	public static void main(String[] args)
	{
		new BiblicalUFOStarringMickeyMouse();
	}

	/*
	 *Metodo ejecutado al oprimir cualquier boton.
	 */
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		String cmd = evt.getActionCommand();
		if(cmd.equals(LAUNCH))
		{
			//TODO: launch method
		}
	}
	
}


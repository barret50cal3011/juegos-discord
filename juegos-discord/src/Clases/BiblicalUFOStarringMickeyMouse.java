package Clases;

import javax.swing.JFrame;
/*
 * Clase principal del juego
 * Maldita sea Daniel, comente su puto codigo...
 * Ups :v att: Daniel.
 */
public class BiblicalUFOStarringMickeyMouse
{
	//-------------------------------------------------------------
		//Atributos
	//-------------------------------------------------------------
	public JFrame frame;

	public Board board;
	
	//-------------------------------------------------------------
		//Bob el constructor
	//-------------------------------------------------------------
	
	/*
	 * Metodo constructor del juego.
	 */
	public BiblicalUFOStarringMickeyMouse()
	{
		frame = new JFrame("Biblical UFO starring Mickey Mouse");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		board = new Board();
	}

	/*
	 * Metodo principal de inicio.
	 */
	public static void main(String[] args)
	{
		new BiblicalUFOStarringMickeyMouse();
	}
	
}


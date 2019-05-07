package ClientUI;



import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import Clases.JajaUyPapiQuePutasException;

/*
 * @author Lele
 * Clase donde de diagrama el tablero de juego.
 */
public class GameScreen extends JFrame
{
	
	
	private Board board;
	

	/**
	 * Variable de serializacion
	 */
	private static final long serialVersionUID = 1L;

	//--------------------------------------------
		//Bob el constructor
	//--------------------------------------------
	public GameScreen() throws JajaUyPapiQuePutasException
	{
		//---------------------------------------------------------
			//Window Setup
		//---------------------------------------------------------
		setTitle("Biblical UFO Starring Mickey Mouse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(500, 500));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		//---------------------------------------------------------
			//Layout
		//---------------------------------------------------------
		setLayout(new BorderLayout());
		
		//---------------------------------------------------------
			//Panel Startup
		//---------------------------------------------------------
		board = new Board();
		board.setVisible(true);
		//---------------------------------------------------------
			//Board
		//---------------------------------------------------------
		
		add(board, BorderLayout.CENTER);
		
		
		
	}
	
	
}

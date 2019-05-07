package ClientUI;



import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Clases.JajaUyPapiQuePutasException;
import Client.Hex;
import Client.Layout;
import Client.Point;

/*
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

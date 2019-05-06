package ClientUI;



import java.awt.BasicStroke;
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
public class Board extends JFrame
{
	
	
	private JPanel panel;
	
	private Graphics2D canvas;

	/**
	 * Variable de serializacion
	 */
	private static final long serialVersionUID = 1L;

	//--------------------------------------------
		//Bob el constructor
	//--------------------------------------------
	public Board() throws JajaUyPapiQuePutasException
	{
		setTitle("Biblical UFO Starring Mickey Mouse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(500, 500));

		panel = new JPanel();
		getContentPane().add(panel);

		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		canvas = (Graphics2D) panel.getGraphics();
		paintTest(canvas);
		
		
	}
	
	public void paintTest(Graphics2D canvas) throws JajaUyPapiQuePutasException
	{
		
		canvas.setColor(Color.BLACK);
		canvas.setStroke(new BasicStroke(5));
//		Polygon testHex = new Polygon();
//		Hex actualHex = new Hex(1, 0, -1);
		canvas.drawLine(0, 0, 500, 500);
//		Layout layout = new Layout(Layout.flat, new Point(10,10), new Point(100, 100));
//		ArrayList<Point> points = layout.polygonCorners(actualHex);
//		for(int i = 0; i < 6; i++)
//		{
//			testHex.addPoint((int)points.get(i).x, (int)points.get(i).y);
//		}
//		canvas.drawPolygon(testHex);
//		canvas.drawString("Memes", 100, 100);
	}
}

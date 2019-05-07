package ClientUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Clases.JajaUyPapiQuePutasException;
import Client.Hex;
import Client.Layout;
import Client.Point;

public class Board extends JPanel 
{


	/**
	 * Constante de serializacion.
	 */
	private static final long serialVersionUID = 1L;
	


	
		
	

	
	public ArrayList<Point> buildHexN(int i)
	{

		try
		{
		Hex actualHex = new Hex(i, 0, -i);
		Layout layout = new Layout(Layout.pointy, new Point(15,15), new Point(250,250));
		ArrayList<Point> points = layout.polygonCorners(actualHex);
		return points;
		}
		catch (JajaUyPapiQuePutasException e)
		{
			JOptionPane.showMessageDialog(this, e, "Jaja uy papi, qué putas?", JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}

	public void paintTest(Graphics2D canvas, ArrayList<Point> points)
	{
		canvas.setColor(Color.BLACK);
		canvas.setStroke(new BasicStroke(1));
		Polygon testHex = new Polygon();


		for(int i = 0; i < 6; i++)
		{
			testHex.addPoint((int)points.get(i).x, (int)points.get(i).y);
		}
		canvas.drawPolygon(testHex);

	}

	public void paintComponent( Graphics canvas )
	{
		super.paintComponent( canvas );

		
		for(int i = 0; i < 16 ; i++)
		{

			paintTest((Graphics2D) canvas, buildHexN(i));

		}
	}
}

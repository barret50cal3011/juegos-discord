package ClientUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Clases.JajaUyPapiQuePutasException;
import Client.Hex;
import Client.Layout;
import Client.Point;
import Client.Orientation;
/*
 * @author Lele
 * Clase que grafica el tablero de juego.
 */
public class Board extends JPanel implements MouseListener
{

	/*
	 * Archivo de propiedades
	 */
	private Properties properties;
	/*
	 * Arreglo de arrglo de puntos de hexagonos
	 */
	private ArrayList<ArrayList<Point>> mapa;

	private String nombre;

	private int size;

	private int origin;

	private int hexes;
	
	private Layout layout;
	
	private ArrayList<Hex> hexArray;

	/**
	 * Constante de serializacion.
	 */
	private static final long serialVersionUID = 1L;

	

	/*
	 * Metodo constructor del tablero.
	 */
	public Board() throws JajaUyPapiQuePutasException
	{
		addMouseListener(this);
		
		properties = new Properties();
		try
		{
			properties.load(new FileInputStream("./data/maps/testMap.properties"));
		}
		catch (Exception e)
		{
			throw new JajaUyPapiQuePutasException(e.getMessage());
		}
		mapa = new ArrayList<>();
		hexArray = new ArrayList<>();
		
		buildMap(properties);
		
		setBorder(new TitledBorder(nombre));
	}

	/*
	 * Metodo que agrega hexagonos al arreglo de puntos para dibujarlos.
	 */
	public ArrayList<Point> buildHexN(int q, int r, int s, int size, int origin)
	{

		try
		{
			Hex actualHex = new Hex(q, r, s, randomColor());
			hexArray.add(actualHex);
			ArrayList<Point> points = layout.polygonCorners(actualHex);
			return points;
		}
		catch (JajaUyPapiQuePutasException e)
		{
			return null;
		}

	}
	
	public Color randomColor()
	{
		int x = (int) (Math.random() * 80);
		if(x < 11)
			return Color.RED;
		else if(x >= 11 && x <= 20)
			return Color.BLUE;
		else if(x >= 21 && x <= 30)
			return Color.YELLOW;
		else if(x >= 31 && x <= 40)
			return Color.GREEN;
		else if(x >= 41 && x <= 50)
			return Color.GRAY;
		else if(x >= 51 && x <= 60)
			return Color.PINK;
		else if(x >= 61 && x <=70)
			return Color.MAGENTA;
		else
			return Color.WHITE;
		
		
	}

	/*
	 * Metodo que construye el mapa a partir del archivo de propiedades.
	 */
	public void buildMap(Properties properties) throws JajaUyPapiQuePutasException
	{
		nombre = properties.getProperty("nombre");
		String x = properties.getProperty("size");
		String y = properties.getProperty("origin");

		size = Integer.parseInt(x);
		origin = Integer.parseInt(y);
		
		String strOri = properties.getProperty("orientation");
		Orientation ori = Layout.pointy;
		if(strOri == "flat")
		{
			ori = Layout.flat;
		}
		else if(strOri == "pointy")
		{
			ori = Layout.pointy;
		}
		layout = new Layout(ori, new Point(size, size), new Point(origin, origin));
		

		
		hexes = Integer.parseInt(properties.getProperty("hexes")); 
		


		for(int i = 1; i <= hexes; i++)
		{
			String[] temp = properties.getProperty("hex"+i).split(",");
			int q = Integer.parseInt(temp[0]); 
			int r = Integer.parseInt(temp[1]); 
			int s = Integer.parseInt(temp[2]); 
			mapa.add(buildHexN(q, r, s, size, origin));
		}


	}

	/*
	 * Metodo que pinta un hexagono.
	 */
	public void drawHex(Graphics2D canvas, ArrayList<Point> points)
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
	public void paintHex(Graphics2D canvas, Hex hex, ArrayList<Point> points)
	{
		Polygon testHex = new Polygon();


		for(int i = 0; i < 6; i++)
		{
			testHex.addPoint((int)points.get(i).x, (int)points.get(i).y);
			canvas.setColor(hex.getColor());
		}
		canvas.fillPolygon(testHex);
	}
	

	/*
	 * Metodo que pinta los hexagonos. El rango del ciclo es la cantidad de hexagonos pintados.
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent( Graphics canvas )
	{
		super.paintComponent( canvas );


		for(int i = 0; i < mapa.size(); i++)
		{

			paintHex((Graphics2D) canvas, hexArray.get(i), mapa.get(i));
			drawHex((Graphics2D) canvas, mapa.get(i));

		}
		
		
	}
	
	public void validHex(Hex clicked)
	{
		for(int i = 0; i < hexArray.size(); i++)
		{
			if(!(clicked.isEqual(hexArray.get(i))));
			{
				System.out.println("Invalid");
			}
		}
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		int x = arg0.getX();
		int y = arg0.getY();
		Point z = new Point(x, y);
		try 
		{
			Hex clicked = layout.pixelToHex(z).hexRound();
			System.out.println(clicked.toString());
			for(int i = 0; i < hexArray.size(); i++)
			{
				if(clicked.isEqual(hexArray.get(i)));
				{
					clicked.setColor(hexArray.get(i).getColor());
				}
			}
			System.out.println(clicked.toString());

		} 
		catch (JajaUyPapiQuePutasException e) 
		{
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		// No se necesita		
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		// No se necesita		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		// No se necesita		
	}
}

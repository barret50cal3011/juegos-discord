/**
 * 
 */
package Client;

import java.awt.Color;
import java.util.ArrayList;

import Clases.JajaUyPapiQuePutasException;

/**
 * @author Lele
 *
 */
public class Hex 
{
	//---------------------------------
	//Atributos
	//---------------------------------

	private int q;
	private int r;
	private int s;
	private Color color;

	static public ArrayList<Hex> directions;

	//---------------------------------
	//Bob el constructor
	//---------------------------------

	/**
	 * Constructor del hexagono.
	 * 
	 */
	public Hex(int q, int s, int r, Color color) throws JajaUyPapiQuePutasException
	{
		this.q = q;
		this.r = r;
		this.s = s;
		this.color = color;
		if (q + r + s != 0) 
			throw new JajaUyPapiQuePutasException("q + r + s must be 0");
		
		
	}

	static public Hex direction(int direction)
	{
		return Hex.directions.get(direction);
	}


	public Hex neighbor(int direction) throws JajaUyPapiQuePutasException
	{
		return add(Hex.direction(direction));
	}


	/*
	 * Metodo que compara un hexagono con el hexagono actual.
	 */
	public boolean isEqual(Hex a)
	{
		boolean r = false;
		boolean x = a.q == this.q;
		boolean y = a.r == this.r;
		boolean z = a.s == this.s;
		if(x == y && y == z)
			r = true;
		return r;
		
	}

	/*
	 * Metodo que da la distancia desde el centro al hexagono actual
	 */
	public int length()
	{
		return (int)((Math.abs(q) + Math.abs(r) + Math.abs(s)) / 2);
	}


	/*
	 * Metodo que retorna la distancia entre este hexagono y el hexagono que entra por parametro.
	 */
	public int distance(Hex b) throws JajaUyPapiQuePutasException
	{
		return subtract(b).length();
	}


	/*
	 * Retorna el hexagono con coordenadas del hexagono actual mas las coordenadas del hexagono que entra por parametro.
	 */
	public Hex add(Hex b) throws JajaUyPapiQuePutasException
	{
		return new Hex(q + b.q, r + b.r, s + b.s, color);
	}

	/*
	 * Retorna el hexagono con coordenadas del hexagono actual menos las coordenadas del hexagono que entra por parametro.
	 */
	public Hex subtract(Hex b) throws JajaUyPapiQuePutasException
	{
		return new Hex(q - b.q, r - b.r, s - b.s, color);
	}
	
	/*
	 * Retorna q
	 */
	public int getQ()
	{
		return q;
	}
	
	/*
	 * Retorna r
	 */
	public int getR()
	{
		return r;
	}
	
	/*
	 * Retorna s
	 */
	public int getS()
	{
		return s;
	}
	
	/*
	 * Retorna color
	 */
	public Color getColor()
	{
		return color;
	}
	
	/*
	 * (non-Javadoc) Retorna coordenadas y color
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return q + "," + r + "," + s + ", " + color;
	}
	
	/*
	 * Cambia el color
	 */
	public void setColor(Color c)
	{
		color = c;
	}

}

/**
 * 
 */
package Client;

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

	public final int q;
	public final int r;
	public final int s;

	static public ArrayList<Hex> directions;

	//---------------------------------
	//Bob el constructor
	//---------------------------------

	/**
	 * Constructor del hexagono.
	 * 
	 */
	public Hex(int q, int s, int r) throws JajaUyPapiQuePutasException
	{
		this.q = q;
		this.r = r;
		this.s = s;
		if (q + r + s != 0) 
			throw new JajaUyPapiQuePutasException("q + r + s must be 0");
		directions = new ArrayList<Hex>();

		directions.add(new Hex(1, 0, -1));
		directions.add(new Hex(1, -1, 0));
		directions.add(new Hex(0, -1, 1));
		directions.add(new Hex(-1, 0, 1));
		directions.add(new Hex(-1, 1, 0));
		directions.add(new Hex(0, 1, -1));
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
		return a.q == this.q && a.r == this.r && a.s == this.s;
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
		return new Hex(q + b.q, r + b.r, s + b.s);
	}

	/*
	 * Retorna el hexagono con coordenadas del hexagono actual menos las coordenadas del hexagono que entra por parametro.
	 */
	public Hex subtract(Hex b) throws JajaUyPapiQuePutasException
	{
		return new Hex(q - b.q, r - b.r, s - b.s);
	}



}

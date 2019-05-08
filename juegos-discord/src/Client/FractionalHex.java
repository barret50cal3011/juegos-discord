package Client;

import java.awt.Color;

import Clases.JajaUyPapiQuePutasException;
/*
 * @author Lele
 * Clase que representa hexagonos temporales fraccionarios.
 */
public class FractionalHex
{
	public final double q;
	public final double r;
	public final double s;
	public final Color color;

	/*
	 * Constructor del hexagono
	 */
	public FractionalHex(double q, double r, double s, Color color) throws JajaUyPapiQuePutasException
	{
		this.color = color;
		this.q = q;
		this.r = r;
		this.s = s;
		if (Math.round(q + r + s) != 0) throw new JajaUyPapiQuePutasException("q + r + s must be 0");
	}

	/*
	 * Retorna el hexagono entero mas cergano a este hexagono fraccionario.
	 */

	public Hex hexRound() throws JajaUyPapiQuePutasException
	{
		int qi = (int)(Math.round(q));
		int ri = (int)(Math.round(r));
		int si = (int)(Math.round(s));
		double q_diff = Math.abs(qi - q);
		double r_diff = Math.abs(ri - r);
		double s_diff = Math.abs(si - s);
		if (q_diff > r_diff && q_diff > s_diff)
		{
			qi = -ri - si;
		}
		else
			if (r_diff > s_diff)
			{
				ri = -qi - si;
			}
			else
			{
				si = -qi - ri;
			}
		return new Hex(qi, ri, si, null);
	}

}


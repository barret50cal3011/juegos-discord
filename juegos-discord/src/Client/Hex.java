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
	private ArrayList<Hex> vecinos;
	
	public final int q;
    public final int r;
    public final int s;

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
    }
    


}

package Clases;

/*
 * Clase principal de excepci�n.
 * Maneja TODAS las excepciones. Si no le gusta, pos perdidas...
 */
public class JajaUyPapiQuePutasException extends Exception
{
	
	/**
	 * Constante de serializaci�n.
	 */
	private static final long serialVersionUID = 1L;

	//-----------------------------------------------------
		//Bob el constructor
	//-----------------------------------------------------
	
	/*
	 * Metodo constructor de la clase JajaUyPapiQuePutasException.
	 */
	
	public JajaUyPapiQuePutasException(String e)
	{
		super(e);
	}
}
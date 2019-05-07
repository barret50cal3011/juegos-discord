package Client;

import java.util.ArrayList;

/*
 *Clase del juego.
 */

public class Game
{

	public final static String rutaMapas = "./data/maps";
	//-------------------------------------------------------------
		//Atributos
	//-------------------------------------------------------------
	private ArrayList<Player> players;
	
	private ArrayList<String> mapas;
	
	
	
	
	//-------------------------------------------------------------
		//Bob el constructor
	//-------------------------------------------------------------
	
	/*
	 * Metodo constructor del juego.
	 */
	public Game()
	{

		players = new ArrayList<>();
		mapas = new ArrayList<>();
	}
}
package negocio;

import java.sql.SQLException;

import data.CatalogoJugadores;
import entidades.Jugador;

public class ControladorLogin {

	//Busca un jugador por su dni
	public Jugador buscarJugador(int dni) throws ClassNotFoundException, SQLException {
		CatalogoJugadores cj = new CatalogoJugadores();
		Jugador j = cj.getJugador(dni);
		return j;
	}
	
	// guarda un nuevo jugador
	public void guardarJugador(Jugador j) throws ClassNotFoundException, SQLException{
		CatalogoJugadores cj = new CatalogoJugadores();
		cj.guardarJugador(j);
	}

}

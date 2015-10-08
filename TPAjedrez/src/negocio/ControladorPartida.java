package negocio;

import java.sql.SQLException;

import data.CatalogoPartidas;
import entidades.Jugador;
import entidades.Partida;

public class ControladorPartida {

	// inicia nueva partida
	public Partida iniciarPartida(Jugador j1, Jugador j2) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Partida p = new Partida();
		CatalogoPartidas cp = new CatalogoPartidas();
		p = cp.nuevaPartida(j1, j2);
		return p;
	}

	// devuelve partidas anteriores de dos jugadores
	public Partida partidaAnterior(Jugador j1, Jugador j2) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		CatalogoPartidas cp = new CatalogoPartidas();
		return cp.getPartidaAnterior(j1,j2);
	}
	
	// sobreescribe una partida que ya existe
	public Partida sobreescribirPartida(Partida p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		CatalogoPartidas cp = new CatalogoPartidas();
		cp.borrarPartida(p);
		cp.borrarFichas(p);
		p = cp.nuevaPartida(p.getJ1(),p.getJ2());
		return p;
	}



}

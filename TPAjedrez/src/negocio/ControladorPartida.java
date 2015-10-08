package negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import data.CatalogoPartidas;
import entidades.Alfil;
import entidades.Caballo;
import entidades.Ficha;
import entidades.Jugador;
import entidades.Partida;
import entidades.Peon;
import entidades.Reina;
import entidades.Rey;
import entidades.Torre;

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

	// inicializa el tablero de una partida
	public ArrayList<Ficha> inicializarTablero(Partida p) throws ClassNotFoundException, SQLException{
		ArrayList<Ficha> tablero = new ArrayList<Ficha>();
	
	// fichas jugador uno
	// torres
	Torre t1 = new Torre();
	t1.setDni(p.getJ1().getDni());
	t1.setNombre("Torre 1");
	t1.setEstado(true);
	t1.setPosX(1);
	t1.setPosY(1);
	tablero.add(t1);
	Torre t2 = new Torre();
	t2.setDni(p.getJ1().getDni());
	t2.setNombre("Torre 2");
	t2.setEstado(true);
	t2.setPosX(8);
	t2.setPosY(1);
	tablero.add(t2);
	// alfiles
	Alfil a1 = new Alfil();
	a1.setDni(p.getJ1().getDni());
	a1.setNombre("Alfil 1");
	a1.setEstado(true);
	a1.setPosX(3);
	a1.setPosY(1);
	tablero.add(a1);
	Alfil a2 = new Alfil();
	a2.setDni(p.getJ1().getDni());
	a2.setNombre("Alfil 2");
	a2.setEstado(true);
	a2.setPosX(6);
	a2.setPosY(1);
	tablero.add(a2);
	// caballos
	Caballo c1 = new Caballo();
	c1.setDni(p.getJ1().getDni());
	c1.setNombre("Caballo 1");
	c1.setEstado(true);
	c1.setPosX(2);
	c1.setPosY(1);
	tablero.add(c1);
	Caballo c2 = new Caballo();
	c2.setDni(p.getJ1().getDni());
	c2.setNombre("Caballo 2");
	c2.setEstado(true);
	c2.setPosY(1);
	c2.setPosX(7);
	tablero.add(c2);
	// rey
	Rey r = new Rey();
	r.setDni(p.getJ1().getDni());
	r.setNombre("Rey");
	r.setEstado(true);
	r.setPosX(5);
	r.setPosY(1);
	tablero.add(r);
	// reina
	Reina q = new Reina();
	q.setDni(p.getJ1().getDni());
	q.setNombre("Reina");
	q.setEstado(true);
	q.setPosY(1);
	q.setPosX(4);
	tablero.add(q);
	// peones 
	for (int i = 1; i<=8;i++){
		Peon pe = new Peon();
		pe.setDni(p.getJ1().getDni());
		pe.setEstado(true);
		pe.setNombre("Peon " + Integer.toString(i) );
		pe.setPosY(2);
		pe.setPosX(i);
		tablero.add(pe);
	}
	
	// fichas jugador dos
	// torres
	Torre t3 = new Torre();
	t1.setDni(p.getJ2().getDni());
	t1.setNombre("Torre 1");
	t1.setEstado(true);
	t1.setPosX(1);
	t1.setPosY(8);
	tablero.add(t1);
	Torre t4 = new Torre();
	t2.setDni(p.getJ2().getDni());
	t2.setNombre("Torre 2");
	t2.setEstado(true);
	t2.setPosX(8);
	t2.setPosY(8);
	tablero.add(t2);
	// alfiles
	Alfil a3 = new Alfil();
	a1.setDni(p.getJ2().getDni());
	a1.setNombre("Alfil 1");
	a1.setEstado(true);
	a1.setPosX(3);
	a1.setPosY(8);
	tablero.add(a1);
	Alfil a4 = new Alfil();
	a2.setDni(p.getJ2().getDni());
	a2.setNombre("Alfil 2");
	a2.setEstado(true);
	a2.setPosX(6);
	a2.setPosY(8);
	tablero.add(a2);
	// caballos
	Caballo c3 = new Caballo();
	c1.setDni(p.getJ2().getDni());
	c1.setNombre("Caballo 1");
	c1.setEstado(true);
	c1.setPosX(2);
	c1.setPosY(8);
	tablero.add(c1);
	Caballo c4 = new Caballo();
	c2.setDni(p.getJ2().getDni());
	c2.setNombre("Caballo 2");
	c2.setEstado(true);
	c2.setPosY(8);
	c2.setPosX(7);
	tablero.add(c2);
	// rey
	Rey r2 = new Rey();
	r.setDni(p.getJ2().getDni());
	r.setNombre("Rey");
	r.setEstado(true);
	r.setPosX(5);
	r.setPosY(8);
	tablero.add(r);
	// reina
	Reina q2 = new Reina();
	q.setDni(p.getJ2().getDni());
	q.setNombre("Reina");
	q.setEstado(true);
	q.setPosY(8);
	q.setPosX(4);
	tablero.add(q);
	// peones 
	for (int i = 1; i<=8;i++){
		Peon pe = new Peon();
		pe.setDni(p.getJ2().getDni());
		pe.setEstado(true);
		pe.setNombre("Peon " + Integer.toString(i) );
		pe.setPosY(7);
		pe.setPosX(i);
		tablero.add(pe);
	}

	CatalogoPartidas cp = new CatalogoPartidas();
	cp.guardarTablero(tablero, p);
	return tablero;
	}



}

package entidades;

import java.util.ArrayList;

public class Partida {
	
	// atributos
	private int nroPartida;
	private Jugador j2;
	private Jugador j1;
	private int turno;
	private ArrayList<Ficha> tablero;

	// getters & setters
	public int getNroPartida() {
		return nroPartida;
	}
	public void setNroPartida(int nroPartida) {
		this.nroPartida = nroPartida;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	public Jugador getJ2() {
		return j2;
	}
	public void setJ2(Jugador j2) {
		this.j2 = j2;
	}
	public Jugador getJ1() {
		return j1;
	}
	public void setJ1(Jugador j1) {
		this.j1 = j1;
	}
	public ArrayList<Ficha> getTablero() {
		return tablero;
	}
	public void setTablero(ArrayList<Ficha> tablero) {
		this.tablero = tablero;
	}
	
}

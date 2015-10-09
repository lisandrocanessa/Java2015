package negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import data.CatalogoFichas;
import data.CatalogoPartidas;
import entidades.*;

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
		CatalogoFichas cf = new CatalogoFichas();
		cp.borrarPartida(p);
		cf.borrarFichas(p);
		p = cp.nuevaPartida(p.getJ1(),p.getJ2());
		return p;
	}
	
	// inicializa el tablero de una partida
	public ArrayList<Ficha> inicializarTablero(Partida p) throws ClassNotFoundException, SQLException{
		ArrayList<Ficha> tablero = new ArrayList<Ficha>();
		CatalogoFichas cf = new CatalogoFichas();
		
		for (int i = 0; i < 2; i++) {
			if (i==0){
				for (int y = 1; y < 3; y++) {
					if (y==1){
						for (int x = 1; x < 9; x++) {
							//aca van las fichas de abajo del jugador 1
							if(x==1 || x==8){
								Torre t = new Torre();
								t.posicionInicial(x, y);
								if(x==1) t.setNombre("t1");
								else t.setNombre("t2");
								t.setDni(p.getJ1().getDni());
								t.setEstado(true);
								tablero.add(t);
							}
							if(x==2 || x==7){
								Caballo c = new Caballo();
								c.posicionInicial(x, y);
								if(x==2) c.setNombre("c1");
								else c.setNombre("c2");
								c.setDni(p.getJ1().getDni());
								c.setEstado(true);
								tablero.add(c);
							}
							if(x==3 || x==6){
								Alfil a = new Alfil();
								a.posicionInicial(x, y);
								if(x==3) a.setNombre("a1");
								else a.setNombre("a2");
								a.setDni(p.getJ1().getDni());
								a.setEstado(true);
								tablero.add(a);
							}
							if(x==4){
								Reina q=new Reina();
								q.posicionInicial(x, y);
								q.setNombre("q");
								q.setDni(p.getJ1().getDni());
								q.setEstado(true);
								tablero.add(q);
							}
							if(x==5){
								Rey r=new Rey();
								r.posicionInicial(x, y);
								r.setNombre("r");
								r.setNombre("r");
								r.setDni(p.getJ1().getDni());
								r.setEstado(true);
								tablero.add(r);
							}
						}
					}
					else{
						for (int x = 1; x < 9; x++) {
							Peon pe = new Peon();
							pe.posicionInicial(x, y);
							pe.setNombre("p"+Integer.toString(x));
							pe.setDni(p.getJ1().getDni());
							pe.setEstado(true);
							tablero.add(pe);
						}
					}							
				}					
			}else if(i==1){
				for (int y = 1; y < 3; y++) {
					if (y==1){
						for (int x = 1; x < 9; x++) {
							//aca van las fichas de abajo del jugador 2
							if(x==1 || x==8){
								Torre t = new Torre();
								t.posicionInicial(x, 8);
								if(x==1) t.setNombre("t1");
								else t.setNombre("t2");
								t.setDni(p.getJ2().getDni());
								t.setEstado(true);
								tablero.add(t);
							}
							if(x==2 || x==7){
								Caballo c = new Caballo();
								c.posicionInicial(x, 8);
								if(x==2) c.setNombre("c1");
								else c.setNombre("c2");
								c.setDni(p.getJ2().getDni());
								c.setEstado(true);
								tablero.add(c);
							}
							if(x==3 || x==6){
								Alfil a = new Alfil();
								a.posicionInicial(x, 8);
								if(x==3) a.setNombre("a1");
								else a.setNombre("a2");
								a.setDni(p.getJ2().getDni());
								a.setEstado(true);
								tablero.add(a);
							}
							if(x==4){
								Rey r=new Rey();
								r.posicionInicial(x, 8);
								r.setNombre("r");
								r.setNombre("r");
								r.setDni(p.getJ2().getDni());
								r.setEstado(true);
								tablero.add(r);
							}
							if(x==5){
								Reina q=new Reina();
								q.posicionInicial(x, 8);
								q.setNombre("q");
								q.setDni(p.getJ2().getDni());
								q.setEstado(true);
								tablero.add(q);
							}
						}
					}
					else{
						for (int x = 1; x < 9; x++) {
							Peon pe = new Peon();
							pe.posicionInicial(x, 7);
							pe.setNombre("p"+Integer.toString(x));
							pe.setDni(p.getJ2().getDni());
							pe.setEstado(true);
							tablero.add(pe);
						}
					}
				}
			}
			
		}	
		
		cf.guardarTablero(tablero, p);
		return tablero;
	}

	// carga tablero de la base de datos
	public ArrayList<Ficha> cargarTablero(Partida p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		CatalogoFichas cf = new CatalogoFichas();
		return cf.cargarTablero(p);
	}

	public void realizarMovimiento(String f, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<String> dameFichasNoComidas(int dni, int nroPartida) throws ClassNotFoundException, SQLException {
		CatalogoFichas cf=new CatalogoFichas();
		return cf.getFichasNoComidas(dni,nroPartida);
		
	}



}

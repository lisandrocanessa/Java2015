package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.*;

public class CatalogoFichas {
		
	// borra todo el tablero de una partida anterior de dos jugadores
		public void borrarFichas(Partida p) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			PreparedStatement ps = FactoriaConexiones.getInstancia().getConn().prepareStatement("delete from fichas where nropartida=?");
			ps.setInt(1, p.getNroPartida());
			ps.execute();
			ps.close();
			FactoriaConexiones.getInstancia().releaseConn();
		}

		// guarda el tablero en la bd
		public void guardarTablero(ArrayList<Ficha> tablero, Partida p) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			for (int i = 0; i < tablero.size(); i++) {
				Ficha f=tablero.get(i);
				PreparedStatement ps = FactoriaConexiones.getInstancia().getConn().prepareStatement(
						"insert into fichas(nropartida,dni,nombre,posx,posy,estado) values (?,?,?,?,?,?)");
				ps.setInt(1, p.getNroPartida());
				ps.setInt(2, f.getDni());
				ps.setString(3, f.getNombre());
				ps.setInt(4, f.getPosX());
				ps.setInt(5, f.getPosY());
				if (f.isEstado()){
					ps.setInt(6, 1);
				}
				else {
					ps.setInt(6, 0);
				}
				ps.execute();
				ps.close();
				FactoriaConexiones.getInstancia().releaseConn();
			}
			
			
		}

		// carga tablero de la bd
		public ArrayList<Ficha> cargarTablero(Partida p) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			ArrayList<Ficha> tablero=new ArrayList<>();
			PreparedStatement ps = FactoriaConexiones.getInstancia().getConn().prepareStatement("select * from fichas where nropartida=? ");
			ps.setInt(1, p.getNroPartida());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Ficha f;
				if (rs.getString("nombre").contains("r")){
					f = new Rey();
					f.setDni(rs.getInt("dni"));
					if (rs.getShort("estado")==1){
						f.setEstado(true);
					}
					else {
						f.setEstado(false);
					}
					f.setNombre(rs.getString("nombre"));
					f.setPosX(rs.getInt("posx"));
					f.setPosY(rs.getInt("posy"));
					tablero.add(f);
				}
				else if (rs.getString("nombre").contains("q")){
					f = new Reina();
					f.setDni(rs.getInt("dni"));
					if (rs.getShort("estado")==1){
						f.setEstado(true);
					}
					else {
						f.setEstado(false);
					}
					f.setNombre(rs.getString("nombre"));
					f.setPosX(rs.getInt("posx"));
					f.setPosY(rs.getInt("posy"));
					tablero.add(f);
				}
				else if (rs.getString("nombre").contains("a")){
					f = new Alfil();
					f.setDni(rs.getInt("dni"));
					if (rs.getShort("estado")==1){
						f.setEstado(true);
					}
					else {
						f.setEstado(false);
					}
					f.setNombre(rs.getString("nombre"));
					f.setPosX(rs.getInt("posx"));
					f.setPosY(rs.getInt("posy"));
					tablero.add(f);
				}
				else if (rs.getString("nombre").contains("c")){
					f = new Caballo();
					f.setDni(rs.getInt("dni"));
					if (rs.getShort("estado")==1){
						f.setEstado(true);
					}
					else {
						f.setEstado(false);
					}
					f.setNombre(rs.getString("nombre"));
					f.setPosX(rs.getInt("posx"));
					f.setPosY(rs.getInt("posy"));
					tablero.add(f);
				}
				else if (rs.getString("nombre").contains("t")){
					f = new Torre();
					f.setDni(rs.getInt("dni"));
					if (rs.getShort("estado")==1){
						f.setEstado(true);
					}
					else {
						f.setEstado(false);
					}
					f.setNombre(rs.getString("nombre"));
					f.setPosX(rs.getInt("posx"));
					f.setPosY(rs.getInt("posy"));
					tablero.add(f);
				}
				else if (rs.getString("nombre").contains("p")){
					f = new Peon();
					f.setDni(rs.getInt("dni"));
					if (rs.getShort("estado")==1){
						f.setEstado(true);
					}
					else {
						f.setEstado(false);
					}
					f.setNombre(rs.getString("nombre"));
					f.setPosX(rs.getInt("posx"));
					f.setPosY(rs.getInt("posy"));
					tablero.add(f);
				}				
			}
			rs.close();
			ps.close();
			FactoriaConexiones.getInstancia().releaseConn();
			return tablero;
		}

		public void guardarFicha(Ficha f) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			PreparedStatement ps = FactoriaConexiones.getInstancia().getConn().prepareStatement(
					"insert into fichas(nropartida,dni,nombre,posx,posy,estado) values (?,?,?,?,?,?)");
			ps.setInt(1, f.getNroPartida());
			ps.setInt(2, f.getDni());
			ps.setString(3, f.getNombre());
			ps.setInt(4, f.getPosX());
			ps.setInt(5, f.getPosY());
			if (f.isEstado()){
				ps.setInt(6, 1);
			}
			else {
				ps.setInt(6, 0);
			}
			ps.execute();
			ps.close();
			FactoriaConexiones.getInstancia().releaseConn();
		}

		//select que busca las fichas no comida de una partida para un jugador
		public ArrayList<String> getFichasNoComidas(int dni, int nroPartida) throws SQLException, ClassNotFoundException {
			// TODO Auto-generated method stub
			ArrayList<String> fichasNoComidas=new ArrayList<>();
			PreparedStatement ps = FactoriaConexiones.getInstancia().getConn().prepareStatement("select * from fichas where nropartida=? and dni=? and estado=true ");
			ps.setInt(1, nroPartida);
			ps.setInt(2, dni);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				fichasNoComidas.add(rs.getString("nombre"));
			}
			ps.close();
			return fichasNoComidas;
		}
		
		//devuelve una sola ficha
		public Ficha getFicha(String nombre, int nroPartida, int dni) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			Ficha f=null;
			PreparedStatement ps = FactoriaConexiones.getInstancia().getConn().prepareStatement("select * from fichas where nropartida=? and dni=? and nombre=?");
			ps.setInt(1, nroPartida);
			ps.setInt(2, dni);
			ps.setString(3, nombre.toString());
			ResultSet rs = ps.executeQuery();
				
			while (rs.next()){
				if(rs.getString("nombre").contains("t"))
					f=new Torre();
				else if(rs.getString("nombre").contains("c"))
					f=new Caballo();
				else if(rs.getString("nombre").contains("a"))
					f=new Alfil();
				else if(rs.getString("nombre").contains("q"))
					f=new Reina();
				else if(rs.getString("nombre").contains("r"))
					f=new Rey();
				else if(rs.getString("nombre").contains("p"))
					f=new Peon();
				f.setDni(rs.getInt("dni"));
				f.setEstado(true);
				f.setNombre(rs.getString("nombre"));
				f.setNroPartida(rs.getInt("nropartida"));
				f.setPosX(rs.getInt("posx"));
				f.setPosY(rs.getInt("posy"));
			}
			rs.close();
			ps.close();
			FactoriaConexiones.getInstancia().releaseConn();
			return f;
		}

		//update que actualiza las posiciones de todas las fichas del tablero (No actualiza---ver---llegan bien los parametros)
		public void updateFichas(ArrayList<Ficha> fichas) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			for (int i = 0; i < fichas.size(); i++) {
				PreparedStatement ps = FactoriaConexiones.getInstancia().getConn().prepareStatement("update fichas set posx=?, posy=?, estado=? where nropartida=? and dni=? and nombre=?");
				ps.setInt(1, fichas.get(i).getPosX());
				ps.setInt(2, fichas.get(i).getPosY());
				if (fichas.get(i).isEstado()) ps.setInt(3, 1);
				else ps.setInt(3, 0);
				ps.setInt(4, fichas.get(i).getNroPartida());
				ps.setInt(5, fichas.get(i).getDni());
				ps.setString(6, (String)fichas.get(i).getNombre());
				ps.executeUpdate();
				ps.close();
				FactoriaConexiones.getInstancia().releaseConn();
			}
		}

}

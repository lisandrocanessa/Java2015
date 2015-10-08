package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}

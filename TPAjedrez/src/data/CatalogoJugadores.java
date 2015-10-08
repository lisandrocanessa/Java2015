package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Jugador;

public class CatalogoJugadores {

	//Devuelve un jugador segun su dni
	public Jugador getJugador(int dni) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = FactoriaConexiones.getInstancia().getConn().prepareStatement("select * from jugadores where dni = ?");
		ps.setInt(1, dni);
		ResultSet rs = ps.executeQuery();
		
		Jugador j = new Jugador();
		boolean empty = true;
		
		while(rs.next()){
			j.setDni(rs.getInt("dni"));
			j.setNombre(rs.getString("nombre"));
			j.setApellido(rs.getString("apellido"));
			empty = false;
		}
		
		rs.close();
		ps.close();
		FactoriaConexiones.getInstancia().releaseConn();
		
		if (empty){
			return null;
		}
		else {
			return j;
		}
		
	}

	// registra un nuevo jugador
	public void guardarJugador(Jugador j) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = FactoriaConexiones.getInstancia().getConn().prepareStatement("insert into jugadores(dni,nombre,apellido) values (?, ?, ?)");
		ps.setInt(1, j.getDni());
		ps.setString(2, j.getNombre());
		ps.setString(3, j.getApellido());
		ps.execute();
		ps.close();
		FactoriaConexiones.getInstancia().releaseConn();
	}

}

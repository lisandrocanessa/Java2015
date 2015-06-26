package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Persona;

public class DataBase {
	
	String dbDriver = "com.mysql.jdbc.Driver";
	String host="localhost";
	String port="3306";
	String user="user";
	String pass="user";
	String db="java";
	
	public void add(Persona p) throws ClassNotFoundException, SQLException{
		Class.forName(dbDriver);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://" + host+":"+port+"/"+db+"?user="+user+"&password="+pass);
		
		PreparedStatement stmt = conn.prepareStatement(
				"insert into personas (dni,nombre,apellido,email)values(?,?,?,?)"); //cuando hay parametros se usa el preparedStatement
		stmt.setInt(1,p.getDni());
		stmt.setString(2,p.getNombre());
		stmt.setString(3,p.getApellido());
		stmt.setString(4,p.getEmail());
		
		stmt.execute();
		
		stmt.close();
		conn.close();
	}
	
	public ArrayList<Persona> getAll() throws ClassNotFoundException, SQLException{
		Class.forName(dbDriver);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://" + host+":"+port+"/"+db+"?user="+user+"&password="+pass);
		
		Statement stmt = conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from personas");
		
		ArrayList<Persona> listPersona= new ArrayList<>();
		
		while(rs.next()){
			Persona p = new Persona();
			p.setId(rs.getInt("id"));
			p.setDni(rs.getInt("dni"));
			p.setNombre(rs.getString("nombre"));
			p.setApellido(rs.getString("apellido"));
			p.setEmail(rs.getString("email"));
			listPersona.add(p);
		}
		
		stmt.close();
		rs.close();
		conn.close();
		return listPersona;
	}
	
	
	public Persona getByDni(int dni) throws ClassNotFoundException, SQLException{
		Class.forName(dbDriver);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://" + host+":"+port+"/"+db+"?user="+user+"&password="+pass);
		
		Persona p=new Persona();
		
		PreparedStatement stmt=conn.prepareStatement("select * from personas where dni=?");
		stmt.setInt(1,dni);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()==true){
			p.setId(rs.getInt("id"));
			p.setDni(rs.getInt("dni"));
			p.setApellido(rs.getString("apellido"));
			p.setEmail(rs.getString("email"));
			p.setNombre(rs.getString("nombre"));
			
		}
		else{
			p=null;
		}
		rs.close();
		stmt.close();
		conn.close();	
		return p;
	} 

	public void delete(int dni) throws ClassNotFoundException, SQLException{
		Class.forName(dbDriver);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://" + host+":"+port+"/"+db+"?user="+user+"&password="+pass);
		
		PreparedStatement stmt=conn.prepareStatement("delete from personas where dni=?");
		stmt.setInt(1, dni);
		
		stmt.execute();
		stmt.close();
		conn.close();
		
		
	}
}

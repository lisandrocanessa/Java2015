package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConexionDB {
	
	String dbDriver = "com.mysql.jdbc.Driver";
	String host="localhost";
	String port="3306";
	String user="root";
	String pass="";
	String db="java";
	
	public void add() throws ClassNotFoundException, SQLException{
		Class.forName(dbDriver);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://" + host+":"+port+"/"+db+"?user="+user+"&password="+pass);
		
		PreparedStatement stmt = conn.prepareStatement(
				"insert into personas (dni,nombre,apellido,email)values(?,?,?,?)"); //cuando hay parametros se usa el preparedStatement
		stmt.setInt(1,111111);
		stmt.setString(2,"Juan");
		stmt.setString(3,"Perez");
		stmt.setString(4,"jp@gmail.com");
		
		stmt.setInt(1,35243854);
		stmt.setString(2,"Lisandro");
		stmt.setString(3,"Canessa");
		stmt.setString(4,"lisandrocaness@hotmail.com");
		
		stmt.execute();
		
		stmt.close();
		conn.close();
	}
}

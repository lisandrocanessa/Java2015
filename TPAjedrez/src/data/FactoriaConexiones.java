package data;

import java.sql.*;

public class FactoriaConexiones {
	
	//Variables para uso de DB
	String dbDriver = "com.mysql.jdbc.Driver";
	String host = "localhost";
	String port = "3306";
	String user = "root";
	String pass = "root";
	String db = "tpajedrez";
	
	private Connection conn;
	private int cantConn;
	
	// Constructor de la factoria de conexiones
	private FactoriaConexiones() throws ClassNotFoundException {
			Class.forName(dbDriver);
			conn = null;
			cantConn = 0;
	}
	
	private static FactoriaConexiones instancia;
	
	// Instancia la factoria de conexiones
	public static FactoriaConexiones getInstancia() throws ClassNotFoundException {
		if (instancia == null) {
			instancia = new FactoriaConexiones();
		}
		return instancia;
	}
	
	// Retorna una conexion
	public Connection getConn() throws SQLException{
		if (conn==null || conn.isClosed()){
			conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+pass);
			cantConn++;
		}
		return conn;
	}
	
	// Cierra todas las conexiones
	public void releaseConn() throws SQLException{
		cantConn--;
		if (cantConn == 0){
			conn.close();
		}
	}
}

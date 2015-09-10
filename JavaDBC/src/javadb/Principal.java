package javadb;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{

		ConexionDB cdb=new ConexionDB();
		Persona[] p = new Persona[2];
		Scanner sc=new Scanner(System.in);
		try{
			for (int i = 0; i < p.length; i++) {
				System.out.println("Ingrese apellido:");
				p[i].setApellido(sc.nextLine());
				System.out.println("Ingrese Dni:");
				p[i].setDni(Integer.parseInt(sc.nextLine()));
				System.out.println("Ingrese Nombre:");
				p[i].setNombre(sc.nextLine());
				System.out.println("Ingrese Email:");
				p[i].setEmail(sc.nextLine());
			}
		}
		catch(NumberFormatException nfe){
			System.out.println("error "+ nfe.getMessage());
		}
		catch(NullPointerException npe){
			System.out.println("Vacio");
		}
		finally{
			sc.close();
		}
		
		cdb.add();
	}

}

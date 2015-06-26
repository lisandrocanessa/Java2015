package data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DataBase;
import entidades.Persona;

public class CatalogoPersonas {
	
	private static ArrayList<Persona> personas=new ArrayList<Persona>();
	DataBase dbc=new DataBase();
	public CatalogoPersonas(){
		Persona p=new Persona();
	}
	
	public List<Persona> getPeronas(){
		return null; //Desarrollar
	}
	
	public Persona getByDni(int dni) throws ClassNotFoundException, SQLException{		
		return dbc.getByDni(dni);
	}
	
	public void addPersona(Persona p) throws ClassNotFoundException, SQLException{
		personas.add(p);
		dbc.add(p);
	}
	public void modifyPersona(Persona p){
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getDni()==p.getDni()){
				personas.set(i, p);
			}
		}
	}
	public void deletePersona(Persona p) throws ClassNotFoundException, SQLException{
		dbc.delete(p.getDni());
	}

}

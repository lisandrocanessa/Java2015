package data;

import java.util.ArrayList;
import java.util.List;

import entidades.Persona;

public class CatalogoPersonas {
	
	private static ArrayList<Persona> personas=new ArrayList<Persona>();
	
	public CatalogoPersonas(){
		Persona p=new Persona();
	}
	
	public List<Persona> getPeronas(){
		return null; //Desarrollar
	}
	public Persona getByDni(int dni){
		for (Persona p : personas) {
			if(p.getDni()==dni){
				return p;
			}
		}
		return null;
	}
	public void addPersona(Persona p){
		personas.add(p);
	}
	public void modifyPersona(Persona p){
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getDni()==p.getDni()){
				personas.set(i, p);
			}
		}
	}
	public void deletePersona(Persona p){
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getDni()==p.getDni()){
				personas.remove(i);
			}
		}
	}

}

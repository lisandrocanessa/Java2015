package negocio;

import data.CatalogoPersonas;
import entidades.Persona;

public class ControladorPersona {
	CatalogoPersonas cp=new CatalogoPersonas();
	public ControladorPersona(){
		
	}
	
	public Persona buscarPersona(int dni){
		Persona p;
		p=cp.getByDni(dni);
		return p;
	}
	public void guardarPersona(Persona p){
		cp.addPersona(p);
	}
	public void modificarPersona(Persona p){
		cp.modifyPersona(p);
	}
	public void borrarPersona(Persona p){
		cp.deletePersona(p);
	}
}



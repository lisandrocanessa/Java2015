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
	public boolean borrarPersona(int dni){
		Persona p;
		if (validarExistencia(dni)) {
			p = cp.getByDni(dni);
			cp.deletePersona(p);
			return true;
		}
		else
			return false;
	}
	
	public boolean validarExistencia(int dni) {
		if(buscarPersona(dni)!=null)
				return true;
		else
			return false;		
	}
}



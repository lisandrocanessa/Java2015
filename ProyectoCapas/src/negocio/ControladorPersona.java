package negocio;


import java.sql.SQLException;

import data.CatalogoPersonas;
import entidades.Persona;

public class ControladorPersona {
	CatalogoPersonas cp=new CatalogoPersonas();
	public ControladorPersona(){
		
	}
	
	public Persona buscarPersona(int dni) throws ClassNotFoundException, SQLException{
		Persona p;
		p=cp.getByDni(dni);
		return p;
	}
	public void guardarPersona(Persona p) throws ClassNotFoundException, SQLException{
		cp.addPersona(p);
	}
	public void modificarPersona(Persona p){
		cp.modifyPersona(p);
	}
	public boolean borrarPersona(int dni) throws ClassNotFoundException, SQLException{
		Persona p;
		if (validarExistencia(dni)) {
			p = cp.getByDni(dni);
			cp.deletePersona(p);
			return true;
		}
		else
			return false;
	}
	
	public boolean validarExistencia(int dni) throws ClassNotFoundException, SQLException {
		if(buscarPersona(dni)!=null)
				return true;
		else
			return false;		
	}
}



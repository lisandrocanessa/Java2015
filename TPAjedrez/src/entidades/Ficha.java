package entidades;

public abstract class Ficha {
	private String nombre;
	// estado = true >> la ficha esta en juego == 1
	// estado = false >> la ficha fue comida == 0
	private boolean estado;
	private int dni;
	private int posX;
	private int posY;
	private int nroPartida;
	
	// getters & setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	public abstract void posicionInicial(int posX, int posY);
	
	public abstract boolean hayFichaEnemiga(int posXMov, int posYMov);
	
	public abstract boolean validarMovimiento(int posXMov,int posYMov);
	
	public int getNroPartida() {
		return nroPartida;
	}
	public void setNroPartida(int nroPartida) {
		this.nroPartida = nroPartida;
	}

	
}

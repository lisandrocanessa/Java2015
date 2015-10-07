package entidades;

public class Peon extends Ficha {

	@Override
	public boolean validarMovimiento() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void posicionInicial(int posX) {
		this.setPosX(posX);
		this.setPosY(2);
		
	}

}

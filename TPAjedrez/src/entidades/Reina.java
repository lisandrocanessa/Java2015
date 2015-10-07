package entidades;

public class Reina extends Ficha {

	@Override
	public boolean validarMovimiento() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void posicionInicial(int posX) {
		this.setPosX(posX);
		this.setPosY(1);
		
	}

}

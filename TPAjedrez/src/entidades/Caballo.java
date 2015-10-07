package entidades;

public class Caballo extends Ficha {

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

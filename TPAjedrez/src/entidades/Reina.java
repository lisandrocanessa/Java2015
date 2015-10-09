package entidades;

public class Reina extends Ficha {


	@Override
	public void posicionInicial(int posX, int posY) {
		this.setPosX(posX);
		this.setPosY(posY);
	}

	@Override
	public boolean validarMovimiento(int posXMov, int posYMov) {
		for (int i = 1; i < 8; i++) {
			if((this.getPosX()+i==posXMov && this.getPosY()==posYMov) || (this.getPosX()+i==posXMov && this.getPosY()+i==posYMov) || 
					(this.getPosX()==posXMov && this.getPosY()+i==posYMov) || (this.getPosX()-i==posXMov && this.getPosY()+i==posYMov) || 
					(this.getPosX()-i==posXMov && this.getPosY()==posYMov) || (this.getPosX()-i==posXMov && this.getPosY()-i==posYMov) ||
					(this.getPosX()==posXMov && this.getPosY()-i==posYMov) || (this.getPosX()+i==posXMov && this.getPosY()-i==posYMov))
				return true;
		}
		return false;
	}

	@Override
	public boolean hayFichaEnemiga(int posXMov, int posYMov) {
		// TODO Auto-generated method stub
		return false;
	}

}

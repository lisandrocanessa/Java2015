package entidades;

public class Rey extends Ficha {

	@Override
	public void posicionInicial(int posX, int posY) {
		this.setPosX(posX);
		this.setPosY(posY);
		
	}

	@Override
	public boolean validarMovimiento(int posXMov, int posYMov) {
		if((this.getPosX()+1==posXMov && this.getPosY()==posYMov) || (this.getPosX()+1==posXMov && this.getPosY()+1==posYMov) || 
				(this.getPosX()==posXMov && this.getPosY()+1==posYMov) || (this.getPosX()-1==posXMov && this.getPosY()+1==posYMov) || 
				(this.getPosX()-1==posXMov && this.getPosY()==posYMov) || (this.getPosX()-1==posXMov && this.getPosY()-1==posYMov) ||
				(this.getPosX()==posXMov && this.getPosY()-1==posYMov) || (this.getPosX()+1==posXMov && this.getPosY()-1==posYMov))
			return true;
		else
			return false;
	}

	@Override
	public boolean hayFichaEnemiga(int posXMov, int posYMov) {
		// TODO Auto-generated method stub
		return false;
	}

}

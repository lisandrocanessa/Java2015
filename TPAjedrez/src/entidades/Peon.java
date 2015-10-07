package entidades;

public class Peon extends Ficha {

	@Override
	public void posicionInicial(int posX) {
		this.setPosX(posX);
		this.setPosY(2);
	}

	@Override
	public boolean validarMovimiento(int posXMov, int posYMov) {
		if(this.getPosX()==posXMov && this.getPosY()+1==posYMov){
			return true;
		}
		else if((this.getPosX()+1==posXMov || this.getPosX()-1==posXMov) && this.getPosY()+1==posYMov && hayFichaEnemiga(posYMov,posXMov))
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

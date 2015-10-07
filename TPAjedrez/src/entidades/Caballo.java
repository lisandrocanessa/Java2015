package entidades;

public class Caballo extends Ficha {

	@Override
	public void posicionInicial(int posX) {
		this.setPosX(posX);
		this.setPosY(1);
		
	}
	
	@Override
	public boolean validarMovimiento(int posXMov, int posYMov) {
		if(((this.getPosX()+2==posXMov || this.getPosX()-2==posXMov) && (this.getPosY()+1==posYMov || this.getPosY()-1==posYMov)) ||
				((this.getPosX()+1==posXMov || this.getPosX()-1==posXMov) && (this.getPosY()+2==posYMov || this.getPosY()-2==posYMov))){
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean hayFichaEnemiga(int posXMov, int posYMov) {
		// TODO Auto-generated method stub
		return false;
	}

}

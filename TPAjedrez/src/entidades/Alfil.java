package entidades;

public class Alfil extends Ficha {

	// setea posicion inicial
	@Override
	public void posicionInicial(int posX, int posY) {
		this.setPosX(posX);
		this.setPosY(posY);
	}

	@Override
	public boolean validarMovimiento(int posXMov, int posYMov) {
		int i=1;
		do{			
			if(this.getPosX()+i==posXMov && this.getPosY()+i==posYMov){
				return true;				
			}else if(this.getPosX()-i==posXMov && this.getPosY()-i==posYMov){
				return true;
			}else if(this.getPosX()+i==posXMov && this.getPosY()-i==posYMov){
				return true;
			}else if(this.getPosX()-i==posXMov && this.getPosY()-i==posYMov){
				return true;
			}
			i++;
		}while(i<8);
		if(i==8){
			return false;
		}else return true;
	}

	@Override
	public boolean hayFichaEnemiga(int posXMov, int posYMov) {
		// TODO Auto-generated method stub
		return false;
	}

}

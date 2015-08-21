package domain;

public class Cochera {
	private char piso;
	private int numeroCochera;
	
	public char getPiso() {
		return piso;
	}
	
	public void setPiso(char piso) {
		this.piso = piso;
	}
	
	public int getNumeroCochera() {
		return numeroCochera;
	}
	
	public void setNumeroCochera(int numeroCochera) {
		this.numeroCochera = numeroCochera;
	}
	
	public Cochera(char piso, int numeroCochera){
		this.setPiso(piso);
		this.setNumeroCochera(numeroCochera);
	}
	
	@Override
	public int hashCode(){
		return Character.hashCode(getPiso())*Integer.hashCode(getNumeroCochera());
	}
	
	@Override
	public boolean equals(Object pos){
		return(pos instanceof Cochera
				&& this.getPiso()==((Cochera)pos).getPiso()
				&& this.getNumeroCochera()==((Cochera)pos).getNumeroCochera()
				);
	}
	

}

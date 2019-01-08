package GranCombat.modelo;

public class LuchadorFolletTortuga extends Luchador{

	public LuchadorFolletTortuga(String nombre, int forz, int cons, int mid, int des, int per) {
		super(nombre, forz, cons, mid, des, per);
		
	}
	
	@Override
	public int puntsDany(int forza,int mida){
		return puntsDanyTortuga(forza,mida,super.per);
	}
	
	public int puntsDanyTortuga(int forza,int mida,int personalitat){
		return (forza+mida+personalitat)/4;
	}

}

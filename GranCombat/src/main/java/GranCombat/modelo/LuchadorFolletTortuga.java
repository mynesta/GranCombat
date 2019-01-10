package GranCombat.modelo;

public class LuchadorFolletTortuga extends Luchador{

	public LuchadorFolletTortuga(String nombre,String escuela, int forz, int cons, int mid, int des, int per) {
		super(nombre,escuela, forz, cons, mid, des, per);
		
	}
	
	@Override
	public int puntsDany(){
		return puntsDanyTortuga(super.forz,super.mid,super.per);
	}
	
	public int puntsDanyTortuga(int forza,int mida,int personalitat){
		return (forza+mida+personalitat)/4;
	}

}

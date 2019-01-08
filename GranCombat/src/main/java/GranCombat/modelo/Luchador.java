package GranCombat.modelo;

public class Luchador {
	String nomArtistic;
	int forz;
	int cons;
	int mid;
	int des;
	int per;
	
	public Luchador(String nombre, int forz,int cons,int mid,int des, int per) {
		nomArtistic = nombre;
		this.forz = forz;
		this.cons = cons;
		this.mid = mid;
		this.des = des;
		this.per = per;
	}
	
	public int puntsResistencia(int constitucio ,int mida){
		return constitucio+mida;
	}
	
	public int puntsDany(int forza ,int mida){
		return forza+mida;
	}
	
	public int ProbabilitatAtacar(int destre�a ,int forza,int constitucio){
		return destre�a+forza+constitucio;
	}
}

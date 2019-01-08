package GranCombat.modelo;

public class LuchadorCorbGenial extends Luchador {

	public LuchadorCorbGenial(String nombre, int forz, int cons, int mid, int des, int per) {
		super(nombre, forz, cons, mid, des, per);
	}
	
	@Override
	public int ProbabilitatAtacar(int destre�a ,int forza,int constitucio){
		return ProbabilitatAtacarCorb(destre�a,forza,constitucio,super.per);
	}
	
	public int ProbabilitatAtacarCorb(int destre�a ,int forza,int constitucio,int personalitat){
		return destre�a+forza+constitucio+personalitat;
	}

}

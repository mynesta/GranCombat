package GranCombat.modelo;

public class LuchadorCorbGenial extends Luchador {

	public LuchadorCorbGenial(String nombre, int forz, int cons, int mid, int des, int per) {
		super(nombre, forz, cons, mid, des, per);
	}
	
	@Override
	public int ProbabilitatAtacar(int destreça ,int forza,int constitucio){
		return ProbabilitatAtacarCorb(destreça,forza,constitucio,super.per);
	}
	
	public int ProbabilitatAtacarCorb(int destreça ,int forza,int constitucio,int personalitat){
		return destreça+forza+constitucio+personalitat;
	}

}

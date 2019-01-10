package GranCombat.modelo;

public class LuchadorCorbGenial extends Luchador {

	public LuchadorCorbGenial(String nombre,String escuela, int forz, int cons, int mid, int des, int per) {
		super(nombre,escuela, forz, cons, mid, des, per);
	}
	
	@Override
	public int ProbabilitatAtacar(){
		return ProbabilitatAtacarCorb(super.des,super.forz,super.cons,super.per);
	}
	
	public int ProbabilitatAtacarCorb(int destreça ,int forza,int constitucio,int personalitat){
		return destreça+forza+constitucio+personalitat;
	}

}

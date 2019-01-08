package GranCombat.modelo;

public class LuchadorHoiPoi extends Luchador{

	public LuchadorHoiPoi(String nombre, int forz, int cons, int mid, int des, int per) {
		super(nombre, forz, cons, mid, des, per);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int ProbabilitatEsquivar(int destreça){
		return ProbabilitatEsquivarHoiPoi (destreça, super.per);
	}
	
	public int ProbabilitatEsquivarHoiPoi(int destreça ,int personalitat){
		return (destreça*3)+personalitat;
	}
}

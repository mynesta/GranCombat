package GranCombat.modelo;

public class LuchadorHoiPoi extends Luchador{

	public LuchadorHoiPoi(String nombre, int forz, int cons, int mid, int des, int per) {
		super(nombre, forz, cons, mid, des, per);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int ProbabilitatEsquivar(int destre�a){
		return ProbabilitatEsquivarHoiPoi (destre�a, super.per);
	}
	
	public int ProbabilitatEsquivarHoiPoi(int destre�a ,int personalitat){
		return (destre�a*3)+personalitat;
	}
}

package GranCombat.modelo;

public class LuchadorHoiPoi extends Luchador{

	public LuchadorHoiPoi(String nombre,String escuela, int forz, int cons, int mid, int des, int per) {
		super(nombre,escuela, forz, cons, mid, des, per);

	}
	@Override
	public int ProbabilitatEsquivar(){
		return ProbabilitatEsquivarHoiPoi (super.des, super.per);
	}
	
	public int ProbabilitatEsquivarHoiPoi(int destre�a ,int personalitat){
		return (destre�a*3)+personalitat;
	}
}

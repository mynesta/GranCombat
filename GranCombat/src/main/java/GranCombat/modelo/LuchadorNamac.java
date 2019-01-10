package GranCombat.modelo;

public class LuchadorNamac extends Luchador{

	public LuchadorNamac(String nombre,String escuela, int forz, int cons, int mid, int des, int per) {
		super(nombre,escuela, forz, cons, mid, des, per);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int puntsResistencia(){
		return puntsResistenciaNamac(super.cons, super.mid, super.per);
	}
	
	public int puntsResistenciaNamac(int constitucio ,int mida, int personalitat){
		return constitucio+mida+personalitat;
	}
}

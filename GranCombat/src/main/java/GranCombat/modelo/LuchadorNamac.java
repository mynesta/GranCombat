package GranCombat.modelo;

public class LuchadorNamac extends Luchador{

	public LuchadorNamac(String nombre, int forz, int cons, int mid, int des, int per) {
		super(nombre, forz, cons, mid, des, per);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int puntsResistencia(int constitucio ,int mida){
		return puntsResistenciaNamac(constitucio, mida, super.per);
	}
	
	public int puntsResistenciaNamac(int constitucio ,int mida, int personalitat){
		return constitucio+mida+personalitat;
	}
}

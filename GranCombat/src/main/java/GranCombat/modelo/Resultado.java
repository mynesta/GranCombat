package GranCombat.modelo;

public class Resultado {
	
	static public int aleatorio() {
		return (int) (Math.random() * 100) + 1;
	}
	
	static boolean exitoAccion (int Probabilidad,int numero) {
		
		if (numero<=Probabilidad) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	static public int ataque(int atacar, int danyo,int numero) {
		if (exitoAccion(atacar,numero)){
			return danyo;
		}
		else {
			return 0;
		}
	}
	
	static public int esquiva(int esquivaDefensor, int vidaDefensor, int danyoAtacante,int numero) {
		if (exitoAccion(esquivaDefensor,numero)){
			return vidaDefensor;
		}
		else if (vidaDefensor <= danyoAtacante) {
			return 0;
		}
		else {
			return (vidaDefensor - danyoAtacante);
		}
	}
	

}

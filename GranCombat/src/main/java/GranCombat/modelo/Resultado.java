package GranCombat.modelo;

public class Resultado {
	
	
	static boolean exitoAtacar (int Probabilidad) {
		int numero;
		numero = (int) (Math.random() * 100) + 1;
		if (numero<=Probabilidad) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//public int combat() {
		
	//}

}

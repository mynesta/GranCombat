package GranCombat.controlador;


import GranCombat.modelo.Luchador;
import GranCombat.modelo.LuchadorCorbGenial;

public class GranCombat {
	public static void main(String args[]) {
		Luchador luchador = new Luchador("jose", 5, 5, 5, 5, 5);
		LuchadorCorbGenial luchadorCorbGenial = new LuchadorCorbGenial("juan", 5, 5, 5, 5, 5);
		System.out.println(luchador.ProbabilitatAtacar(5, 5, 5));
		System.out.println(luchadorCorbGenial.ProbabilitatAtacar(5, 5, 5));
	}

}
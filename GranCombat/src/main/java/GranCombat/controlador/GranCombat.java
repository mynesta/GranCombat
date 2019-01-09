package GranCombat.controlador;


import GranCombat.modelo.Luchador;
import GranCombat.vista.Consola;
import GranCombat.modelo.LuchadorCorbGenial;
import GranCombat.modelo.LuchadorFolletTortuga;
import GranCombat.modelo.LuchadorHoiPoi;
import GranCombat.modelo.LuchadorNamac;

public class GranCombat {
	public static void main(String args[]) {
		Consola consola=Consola.getSingletonInstance();
    	consola.escribirSL("BIENVENIDOS AL GRAN COMBATE DE LAS ARTES MARCIALES!!!");
		consola.escribirSL("-----------------------------------------------------");
		consola.escribirSL("\n Define a tus luchadores:");
		
		Luchador[] luchadores;
		
		luchadores = new Luchador[2];
		int contLuchador = 0;
		generarLuchador (luchadores, contLuchador,consola);
		System.out.println(luchadores[0]);
		
	}

	private static void generarLuchador(Luchador[] luchadores, int contLuchador,Consola consola) {
		String nombre = consola.leerString("Nombre del luchador:");
		String fue = consola.leerString("FUE:");
		String con = consola.leerString("CON:");
		String tam = consola.leerString("TAM:");
		String des = consola.leerString("DES:");
		String per = consola.leerString("PER:");
		consola.escribirSL("\nEscuela: ");
		consola.escribirSL("\t0) Follet Tortuga");
		consola.escribirSL("\t1) Corb Genial");
		consola.escribirSL("\t2) Hoi-Poi");
		consola.escribirSL("\t3) Namac");
		consola.escribirSL("\t4) Ninguna");
		String escuela = consola.leerString("");
		switch(Integer.parseInt(escuela)) {
			case 0:
				LuchadorFolletTortuga luchadorTortuga = new LuchadorFolletTortuga(nombre,
						Integer.parseInt(fue), Integer.parseInt(con), Integer.parseInt(tam),
						Integer.parseInt(des), Integer.parseInt(per));
				luchadores[contLuchador] = luchadorTortuga;
				break;
			case 1:
				LuchadorCorbGenial luchadorCorb = new LuchadorCorbGenial(nombre,
						Integer.parseInt(fue), Integer.parseInt(con), Integer.parseInt(tam),
						Integer.parseInt(des), Integer.parseInt(per));
				luchadores[contLuchador] = luchadorCorb;
				break;
			case 2:
				LuchadorHoiPoi luchadorHoiPoi = new LuchadorHoiPoi(nombre,
						Integer.parseInt(fue), Integer.parseInt(con), Integer.parseInt(tam),
						Integer.parseInt(des), Integer.parseInt(per));
				luchadores[contLuchador] = luchadorHoiPoi;
				break;
			case 3:
				LuchadorNamac luchadorNamac = new LuchadorNamac(nombre,
						Integer.parseInt(fue), Integer.parseInt(con), Integer.parseInt(tam),
						Integer.parseInt(des), Integer.parseInt(per));
				luchadores[contLuchador] = luchadorNamac;
				break;
			case 4:
				Luchador luchador = new Luchador(nombre,
						Integer.parseInt(fue), Integer.parseInt(con), Integer.parseInt(tam),
						Integer.parseInt(des), Integer.parseInt(per));
				luchadores[contLuchador] = luchador;
				break;
			
		}
		contLuchador +=1;
		if(contLuchador >1) {
			contLuchador = 0;
		}
	}

}
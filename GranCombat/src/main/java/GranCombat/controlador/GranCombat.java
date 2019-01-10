package GranCombat.controlador;


import GranCombat.modelo.Luchador;
import GranCombat.vista.Consola;
import GranCombat.modelo.LuchadorCorbGenial;
import GranCombat.modelo.LuchadorFolletTortuga;
import GranCombat.modelo.LuchadorHoiPoi;
import GranCombat.modelo.LuchadorNamac;
import GranCombat.modelo.Resultado;

public class GranCombat {
	public static void main(String args[]) {
		Consola consola=Consola.getSingletonInstance();
    	consola.escribirSL("BIENVENIDOS AL GRAN COMBATE DE LAS ARTES MARCIALES!!!");
		consola.escribirSL("-----------------------------------------------------");
		consola.escribirSL("\nDefine a tus luchadores:");
		
		Luchador[] luchadores;
		
		luchadores = new Luchador[2];
		generarLuchador (luchadores, 0,consola);
		generarLuchador (luchadores, 1,consola);
		Luchador luchador1 = luchadores[0];
		Luchador luchador2 = luchadores[1];
		consola.escribirSL(luchadores[0].toString()+"\n");
		consola.escribirSL(luchadores[1].toString());
		
		consola.escribirSL("Que empiece el combate!!!\n");
		int vidaLuchador1 = luchador1.puntsResistencia();
		int vidaLuchador2 = luchador2.puntsResistencia();
		int aleatorioAtaque = Resultado.aleatorio();
		int aleatiorioEsquiva = Resultado.aleatorio();
		int dany = (Resultado.ataque(luchador1.ProbabilitatAtacar(), luchador1.puntsDany(),aleatorioAtaque ));
		int esquiva = (Resultado.esquiva(luchador2.ProbabilitatEsquivar(),vidaLuchador2, dany, aleatiorioEsquiva));
		if(dany!=0) {
			consola.escribirSL(luchador1.nomArtistic+" ataca con un"+aleatorioAtaque+"% y acierta el golpe");
			if((Resultado.esquiva(luchador2.ProbabilitatEsquivar(), vidaLuchador2, dany, aleatiorioEsquiva)!=vidaLuchador2)) {
				consola.escribirSL(luchador2.nomArtistic+" esquiva con un"+aleatiorioEsquiva+"% y falla la esquiva");
				vidaLuchador2 = esquiva;
				if(vidaLuchador2 !=0) {
					consola.escribirSL(luchador2.nomArtistic+" recibe un golpe que le baja la resistencia a "+vidaLuchador2);
				}
				else {
					consola.escribirSL(luchador2.nomArtistic+" recibe su ultimo golpe y cae vencido");
					//break;
				}
				}
				
		}
		else {
			consola.escribirSL(luchador1.nomArtistic+" ataca con un"+aleatorioAtaque+"% y falla el golpe");
			
		}
		
		
	}

	private static void generarLuchador(Luchador[] luchadores, int contLuchador,Consola consola) {
		String nombre = consola.leerString("Nombre del luchador: ");
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
				LuchadorFolletTortuga luchadorTortuga = new LuchadorFolletTortuga(nombre,", escola del Follet Tortuga",
						Integer.parseInt(fue), Integer.parseInt(con), Integer.parseInt(tam),
						Integer.parseInt(des), Integer.parseInt(per));
				luchadores[contLuchador] = luchadorTortuga;
				break;
			case 1:
				LuchadorCorbGenial luchadorCorb = new LuchadorCorbGenial(nombre,", escola del Corb Genial",
						Integer.parseInt(fue), Integer.parseInt(con), Integer.parseInt(tam),
						Integer.parseInt(des), Integer.parseInt(per));
				luchadores[contLuchador] = luchadorCorb;
				break;
			case 2:
				LuchadorHoiPoi luchadorHoiPoi = new LuchadorHoiPoi(nombre,", escola HoiPoi",
						Integer.parseInt(fue), Integer.parseInt(con), Integer.parseInt(tam),
						Integer.parseInt(des), Integer.parseInt(per));
				luchadores[contLuchador] = luchadorHoiPoi;
				break;
			case 3:
				LuchadorNamac luchadorNamac = new LuchadorNamac(nombre,", escola Namac",
						Integer.parseInt(fue), Integer.parseInt(con), Integer.parseInt(tam),
						Integer.parseInt(des), Integer.parseInt(per));
				luchadores[contLuchador] = luchadorNamac;
				break;
			case 4:
				Luchador luchador = new Luchador(nombre,"",
						Integer.parseInt(fue), Integer.parseInt(con), Integer.parseInt(tam),
						Integer.parseInt(des), Integer.parseInt(per));
				luchadores[contLuchador] = luchador;
				break;
			
		}
	}
	
	

}
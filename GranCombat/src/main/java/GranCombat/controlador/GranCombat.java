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
		
		
		Boolean respuesta = true;

		do {
			consola.escribirSL("Que empiece el combate!!!\n");
			int vidaLuchador1 = luchador1.puntsResistencia();
			int vidaLuchador2 = luchador2.puntsResistencia();
			consola.escribirSL(luchadores[0].toString()+"\n");
			consola.escribirSL(luchadores[1].toString());
			
		do {
			
			if (vidaLuchador1 > 0) {
				vidaLuchador2 = turno(consola, luchador1, luchador2, vidaLuchador2);
			}
			if (vidaLuchador2 > 0) {
				vidaLuchador1 = turno(consola, luchador2, luchador1, vidaLuchador1);
			}
		}while (vidaLuchador1 > 0 && vidaLuchador2 > 0);
		
		String continuar = consola.leerString("\nQuieres desafiar al ganador con otro contrincante? Y/N");
		if (continuar.equals("Y") || continuar.equals("y")) {
			if (vidaLuchador1 == 0) {
				generarLuchador (luchadores, 0,consola);
				luchador1 = luchadores[0];
			}else {
				generarLuchador (luchadores, 1,consola);
				luchador2 = luchadores[1];
			}
		}else {
			respuesta = false;
			System.exit(0);
		}
		
		}while (respuesta == true);		
	}

	private static int turno(Consola consola, Luchador atacante, Luchador defensor, int vidaDefensor) {
		int aleatorioAtaque = Resultado.aleatorio();
		int aleatiorioEsquiva = Resultado.aleatorio();
		int dany = (Resultado.ataque(atacante.ProbabilitatAtacar(), atacante.puntsDany(),aleatorioAtaque ));
		int esquiva = (Resultado.esquiva(defensor.ProbabilitatEsquivar(),vidaDefensor, dany, aleatiorioEsquiva));
		if(dany!=0) {
			consola.escribirSL(atacante.nomArtistic+" ataca con un "+aleatorioAtaque+"% y acierta el golpe");
			if((Resultado.esquiva(defensor.ProbabilitatEsquivar(), vidaDefensor, dany, aleatiorioEsquiva)!=vidaDefensor)) {
				consola.escribirSL(defensor.nomArtistic+" esquiva con un "+aleatiorioEsquiva+"% y falla la esquiva");
				vidaDefensor = esquiva;
				if(vidaDefensor !=0) {
					consola.escribirSL(defensor.nomArtistic+" recibe un golpe que le baja la resistencia a "+vidaDefensor);
				}
				else {
					consola.escribirSL(defensor.nomArtistic+" recibe su ultimo golpe y cae vencido");
					consola.escribirSL("\n EL LUCHADOR "+atacante.nomArtistic+" GANA EL COMBATE!!");
				}
				}
				
		}
		else {
			consola.escribirSL(atacante.nomArtistic+" ataca con un "+aleatorioAtaque+"% y falla el golpe");
			
		}
		return vidaDefensor;
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
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
		Consola consola = Consola.getSingletonInstance();
		consola.escribirSL("BIENVENIDOS AL GRAN COMBATE DE LAS ARTES MARCIALES!!!");
		consola.escribirSL("-----------------------------------------------------");
		consola.escribirSL("\nDefine a tus luchadores:");

		Luchador[] luchadores;

		luchadores = new Luchador[2];
		generarLuchador(luchadores, 0, consola);
		generarLuchador(luchadores, 1, consola);
		Luchador luchador1 = luchadores[0];
		Luchador luchador2 = luchadores[1];

		Boolean respuesta = true;

		do {
			consola.escribirSL("Que empiece el combate!!!\n");
			int vidaLuchador1 = luchador1.puntsResistencia();
			int vidaLuchador2 = luchador2.puntsResistencia();
			consola.escribirSL(luchadores[0].toString() + "\n");
			consola.escribirSL(luchadores[1].toString());
			consola.escribirSL("");

			do {

				if (vidaLuchador1 > 0) {
					vidaLuchador2 = turno(consola, luchador1, luchador2, vidaLuchador2);
				}
				if (vidaLuchador2 > 0) {
					vidaLuchador1 = turno(consola, luchador2, luchador1, vidaLuchador1);
				}
			} while (vidaLuchador1 > 0 && vidaLuchador2 > 0);

			String continuar = consola.leerString("\nQuieres desafiar al ganador con otro contrincante? Y/N");
			if (continuar.equals("Y") || continuar.equals("y")) {
				if (vidaLuchador1 == 0) {
					generarLuchador(luchadores, 0, consola);
					luchador1 = luchadores[0];
					luchador2.subirNivel();
				} else {
					generarLuchador(luchadores, 1, consola);
					luchador2 = luchadores[1];
					luchador1.subirNivel();
				}
			} else {
				respuesta = false;
				System.exit(0);
			}

		} while (respuesta == true);
	}

	private static int turno(Consola consola, Luchador atacante, Luchador defensor, int vidaDefensor) {
		int aleatorioAtaque = Resultado.aleatorio();
		int aleatiorioEsquiva = Resultado.aleatorio();
		int dany = (Resultado.ataque(atacante.ProbabilitatAtacar(), atacante.puntsDany(), aleatorioAtaque));
		int esquiva = (Resultado.esquiva(defensor.ProbabilitatEsquivar(), vidaDefensor, dany, aleatiorioEsquiva));
		if (dany != 0) {
			consola.escribirSL(atacante.nomArtistic + " ataca con un " + aleatorioAtaque + "% y acierta el golpe");
			if ((Resultado.esquiva(defensor.ProbabilitatEsquivar(), vidaDefensor, dany,
					aleatiorioEsquiva) != vidaDefensor)) {
				consola.escribirSL(
						defensor.nomArtistic + " esquiva con un " + aleatiorioEsquiva + "% y falla la esquiva");
				vidaDefensor = esquiva;
				if (vidaDefensor != 0) {
					consola.escribirSL(
							defensor.nomArtistic + " recibe un golpe que le baja la resistencia a " + vidaDefensor);
				} else {
					consola.escribirSL(defensor.nomArtistic + " recibe su ultimo golpe y cae vencido");
					consola.escribirSL("\nEL LUCHADOR " + atacante.nomArtistic + " GANA EL COMBATE!!");
				}
			}

		} else {
			consola.escribirSL(atacante.nomArtistic + " ataca con un " + aleatorioAtaque + "% y falla el golpe");

		}
		return vidaDefensor;
	}

	private static void generarLuchador(Luchador[] luchadores, int contLuchador, Consola consola) {
		String nombre = consola.leerString("Nombre del luchador: ");

		int fue = 0;
		int con = 0;
		int tam = 0;
		int des = 0;
		int per = 0;
		int sumastats = 61;
		Boolean stats = true;

		while (sumastats > 60 || stats == true) {
			try {
				fue = Integer.parseInt(consola.leerString("FUE:"));
				con = Integer.parseInt(consola.leerString("CON:"));
				tam = Integer.parseInt(consola.leerString("TAM:"));
				des = Integer.parseInt(consola.leerString("DES:"));
				per = Integer.parseInt(consola.leerString("PER:"));

				sumastats = fue + con + tam + des + per;

				stats = comprobarStats(fue, con, tam, des, per, consola);
				if (sumastats > 60) {
					consola.escribirSL("La suma total de los Stats no debe ser superior a 60!");
				}

			} catch (NumberFormatException e) {
				consola.escribirSL("No se pueden introducir letras en los atributos!");
			}
		}

		Boolean comprobacion = false;

		while (comprobacion == false) {
			try {
				consola.escribirSL("\nEscuela: ");
				consola.escribirSL("\t0) Follet Tortuga");
				consola.escribirSL("\t1) Corb Genial");
				consola.escribirSL("\t2) Hoi-Poi");
				consola.escribirSL("\t3) Namac");
				consola.escribirSL("\t4) Ninguna");
				int escuela = Integer.parseInt(consola.leerString(""));
				switch (escuela) {
				case 0:
					LuchadorFolletTortuga luchadorTortuga = new LuchadorFolletTortuga(nombre,
							", escola del Follet Tortuga", fue, con, tam, des, per);
					luchadores[contLuchador] = luchadorTortuga;
					break;
				case 1:
					LuchadorCorbGenial luchadorCorb = new LuchadorCorbGenial(nombre, ", escola del Corb Genial", fue,
							con, tam, des, per);
					luchadores[contLuchador] = luchadorCorb;
					break;
				case 2:
					LuchadorHoiPoi luchadorHoiPoi = new LuchadorHoiPoi(nombre, ", escola HoiPoi", fue, con, tam, des,
							per);
					luchadores[contLuchador] = luchadorHoiPoi;
					break;
				case 3:
					LuchadorNamac luchadorNamac = new LuchadorNamac(nombre, ", escola Namac", fue, con, tam, des, per);
					luchadores[contLuchador] = luchadorNamac;
					break;
				case 4:
					Luchador luchador = new Luchador(nombre, "", fue, con, tam, des, per);
					luchadores[contLuchador] = luchador;
					break;
				}
				
				if (escuela <= 4 && escuela >= 0) {
					comprobacion = true;
				}else {
					comprobacion = false;
					consola.escribirSL("Debes seleccionar una escuela entre el 0 y el 4!");
				}
				

			} catch (NumberFormatException e) {
				consola.escribirSL("No se pueden introducir letras escogiendo las escuelas!");
				comprobacion = false;
			}

		}

	}

	static public Boolean comprobarStats(int fue, int con, int tam, int des, int per, Consola consola) {
		int[] atributos = { fue, con, tam, des, per };

		for (int i = 0; i < atributos.length; i++) {
			if (atributos[i] < 3 || atributos[i] > 18) {
				consola.escribirSL("Los atributos deben estar entre 3 y 18!");
				return true;
			}
		}
		return false;
	}

}
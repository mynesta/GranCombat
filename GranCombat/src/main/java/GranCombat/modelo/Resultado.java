package GranCombat.modelo;

public class Resultado {
	
	
	static boolean exitoAccion (int Probabilidad) {
		int numero;
		numero = (int) (Math.random() * 100) + 1;
		if (numero<=Probabilidad) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public int ataque(int atacar, int danyo) {
		if (exitoAccion(atacar)){
			return danyo;
		}
		else {
			return 0;
		}
	}
	
	public int esquiva(int esquivaDefensor, int vidaDefensor, int danyoAtacante) {
		if (exitoAccion(esquivaDefensor)){
			return vidaDefensor;
		}
		else if (vidaDefensor <= danyoAtacante) {
			return 0;
		}
		else {
			return (vidaDefensor - danyoAtacante);
		}
	}
	
	/*member function atacar return int is
			aleatorio int;
			begin
				aleatorio := dbms_random.value(1,100);
				if aleatorio <= SELF.probabilitatatacar() then
					return SELF.puntsdany();
				else
					return 0;
				end if;
			end;
		member function esquivar(vida int,dany int) return int is
			aleatorio int;
			resta int;
			begin
				aleatorio := dbms_random.value(1,100);
				if aleatorio <= SELF.probabilitatesquivar() then
					return vida;
				else
					if vida-dany <= 0 then
						return 0;
					else
						resta := vida-dany;
						return resta;
					end if;
				end if;
			end;
		end;*/

}

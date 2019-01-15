package GranCombat.modelo;

public class Luchador {
	public String nomArtistic;
	int forz;
	int cons;
	int mid;
	int des;
	int per;
	String escuela;
	
	public Luchador(String nombre,String escuela, int forz,int cons,int mid,int des, int per) {
		nomArtistic = nombre;
		this.forz = forz;
		this.cons = cons;
		this.mid = mid;
		this.des = des;
		this.per = per;
		this.escuela = escuela;
	}
	
	public int puntsResistencia(){
		return cons+mid;
	}
	
	public int puntsDany(){
		return forz+mid;
	}
	
	public int ProbabilitatAtacar(){
		return des+forz+cons;
	}
	
	public int ProbabilitatEsquivar(){
		return des*3;
	}
	
	public void subirNivel() {
		per+=1;
	}
	
	public String toString() {
		return "Luchador "+nomArtistic+escuela+"\nFUE: "+forz+" CON: "+cons+" TAM: "+mid+" DES: "+des+" PER: "+per+
				"\nPR: "+puntsResistencia()+" PD: "+puntsDany()+" PA(%): "+ProbabilitatAtacar()+
				" PE(%): "+ProbabilitatEsquivar();
	}

	
}

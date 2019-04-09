package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti ;

	public Libretto() {
		
		this.voti = new ArrayList<Voto>(); //qua è vuota ma non nulla
	}
	
	/*public void add(int voto,String corso, LocalDate data) {
		
	}
	*/
	/**
	 * Aggiunge nuovo voto al libretto
	 * @param v il (@link Voto) da aggiungere
	 */
	public void add(Voto v) {
		//metodo che delega la funzione
		//se si dovesse modifica la classe voto con questo metodo non devo modificare la classe libretto
		voti.add(v);
	}
}

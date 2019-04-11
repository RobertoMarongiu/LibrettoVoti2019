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
	
	/* ****************** PUNTO 1 ****************** */
	
	/**
	 * Aggiunge nuovo voto al libretto
	 * @param v il (@link Voto) da aggiungere
	 */
	/*
	public void add(Voto v) {
		//metodo che delega la funzione
		//se si dovesse modifica la classe voto con questo metodo non devo modificare la classe libretto
		voti.add(v);
	}
	*/
	/* ****************** PUNTO 2 ****************** */
	//tre casi che mi cercano i voti
	
	//La classe libretto lo stampa direttamente
	//public void StampaVoti(int voto) {}
	
	//costruisce una stringa che conterrà gli esami da stampare ma non la stama ancora
	//public String StampaVoti2(int voto) {}
	
	//seleziona una lista che contiene solo i voti che sottostanno al criterio di ricerca
	//Scelgo questa perchè separa la ricerca dalla grafica
	/**
	 * Seleziona il sottinsieme di voti che hanno il punteggio specificato
	 * @param punti puntegio di ricerca
	 * @return lista di {@link Voto} aventi quel punteggio(eventualmente vuota)
	 */
	public List<Voto> cercaVoti(int punti){
		List<Voto>result = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getPunti()==punti) {
				result.add(v);
			}
		}
		return result;
	}
	
	/* ****************** PUNTO 3 ****************** */
	/**
	 * ricerca un {@link Voto} relativo al corso di cui è specificato il nome
	 * @param nomeEsame nome del corso
	 * @return il {@link Voto}corrispondente,oppure {@code null} se non esistente
	 */
	public Voto cercaEsame(String nomeEsame) {
		/*for(Voto v : this.voti) {
			if(v.getCorso().equals(nomeEsame)) {
				return v;
			}
		}*/
		Voto voto = new Voto(0,nomeEsame,null);
		int pos = this.voti.indexOf(voto);
		//controlla solo il nome del corso,quindi non ci serve il voto e la data
		
		if(pos==-1)
			return null;
		else
			return this.voti.get(pos);
	}
	
	/* ****************** PUNTO 4 ****************** */
	
	/**
	 * Dato un {@link Voto}, determina se esiste già un voto con uguale
	 * corso ed uguale punteggio
	 * @param v
	 * @return {@code true},se ha trovato un corso e punteggio uguali, 
	 * {@code false} se non ha trovato il corso oppure con voto diverso
	 */
	public boolean esisteGiaVoto(Voto v) {
		
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else 
			return(v.getPunti()==this.voti.get(pos).getPunti());
				
		
		/*Voto trovato = this.cercaEsame(v.getCorso());
		if(trovato == null)
			return false;
		if(trovato.getPunti()==v.getPunti()) {
			return true;
		}
		else {
			return false;}*/
		
		}
	
	/* ****************** PUNTO 5 ****************** */
	
	/**
	 * Mi dice se il {@link Voto} {@code v}è in conflitto con uno dei voti esistenti
	 * Se il voto non esiste ,nonc'è conflitto.
	 * Se il voto esiste ed ha un puntegio diverso,c'è conflitto.
	 * @param v
	 * @return {@code true}se il voto esiste ed ha un puntegio diverso,
	 * 			{@code false}se il voto non esiste,oppure esiste ma ha lo stesso punteggio
	 */
	public boolean votoConflitto(Voto v) {
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else 
			return(v.getPunti() != this.voti.get(pos).getPunti());
	}
	
	
	/* ****************** PUNTO 6 ****************** */
	/**
	 * Aggiunge nuovo voto al libretto
	 * @param v il (@link Voto) da aggiungere
	 * @return {@code true}nel caso normale,
	 * 			{@code false} se non è riuscito ad aggiugere il voto
	 */
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoConflitto(v)) {
			voti.add(v);
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return this.voti.toString();
		}
}

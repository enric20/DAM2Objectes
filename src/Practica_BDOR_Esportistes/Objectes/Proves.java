package Practica_BDOR_Esportistes.Objectes;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class Proves {

	private String nom;
	private int any;
	private ArrayList<Participants> participants = new ArrayList<Participants>();
	private int codiProva; //AAAAPPPP | A= any, P = Prova //codiProva = (any.toString()+numeroSequencial.toString()).toInteger()
	
	public Proves(String nom, int any, ArrayList<Participants> participants, int codiProva) {
		
		this.setNom(nom);
		this.setAny(any);
		this.setParticipants(participants);
		this.setCodiProva(codiProva);
		
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAny() {
		return any;
	}

	public void setAny(int any) {
		this.any = any;
	}

	public ArrayList<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(ArrayList<Participants> participants) {
		this.participants = participants;
	}

	public int getCodiProva() {
		return codiProva;
	}

	public void setCodiProva(int codiProva) {
		this.codiProva = codiProva;
	}
	
	/**
	 * Afegeix un participant a la llista privada participants de cada prova
	 * @param nom
	 * @param cognom1
	 * @param cognom2
	 * @param sexe
	 * @param dataNaixement
	 * @param dni
	 * @param club
	 * @param codiFederat
	 * @param categoria
	 * @param dorsal
	 * @param tempsProva
	 */
	public void afegirParticipant(String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat, String categoria, int dorsal, Duration tempsProva) {
		
		//String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat, String categoria, int dorsal, Duration tempsProva
		
		participants.add(new Participants(nom, cognom1, cognom2, sexe, dataNaixement, dni, club, codiFederat, categoria, dorsal, tempsProva));

	}
	
	public void esborrarParticipant(int posicio) {
		
		participants.remove(posicio);
		
	}
}

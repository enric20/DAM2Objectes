package Practica_BDOR_Esportistes.Objectes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MarxaPopular extends Proves {
	
	private String ubicacio;
	private LocalDate data;
	private LocalDateTime dataSortida;
	private ArrayList<Participants> participantsMarxaPopular = new ArrayList<Participants>();

	
	public MarxaPopular(String nom, int any, ArrayList<Participants> participants, int codiProva,  String ubicacio, LocalDate data, LocalDateTime dataSortida) {
		
		super(nom, any, participants, codiProva);
		this.setUbicacio(ubicacio);
		this.setData(data);
		this.setDataSortida(dataSortida);
		
	}
	
	public String getUbicacio() {
		return ubicacio;
	}

	public void setUbicacio(String ubicacio) {
		this.ubicacio = ubicacio;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDateTime getDataSortida() {
		return dataSortida;
	}

	public void setDataSortida(LocalDateTime dataSortida) {
		this.dataSortida = dataSortida;
	}

	public ArrayList<Participants> getParticipantsMarxaPopular() {
		return participantsMarxaPopular;
	}

	public void setParticipantsMarxaPopular(ArrayList<Participants> participantsMarxaPopular) {
		this.participantsMarxaPopular = participantsMarxaPopular;
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
	public void afegirParticipantMarxaPopular(String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat, String categoria, int dorsal, Duration tempsProva) {
		
		//String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat, String categoria, int dorsal, Duration tempsProva
		
		participantsMarxaPopular.add(new Participants(nom, cognom1, cognom2, sexe, dataNaixement, dni, club, codiFederat, categoria, dorsal, tempsProva));

	}
	
	public void esborrarParticipantMarxaPopular(int posicio) {
		
		participantsMarxaPopular.remove(posicio);
		
	}

}

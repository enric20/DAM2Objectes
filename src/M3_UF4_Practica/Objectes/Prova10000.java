package M3_UF4_Practica.Objectes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Prova10000 extends Proves {

	private String clubAnfitrio;
	private String ubicacio;
	private LocalDate data;
	private LocalDateTime dataSortida;
	private ArrayList<Participants> participantsProva10000 = new ArrayList<Participants>();
	
	public Prova10000(String nom, int any, ArrayList<Participants> participants, int codiProva, String clubAnfitrio, String ubicacio, LocalDate data, LocalDateTime dataSortida) {
	
		super(nom, any, participants, codiProva);
		
		this.setClubAnfitrio(clubAnfitrio);
		this.setUbicacio(ubicacio);
		this.setData(data);
		this.setDataSortida(dataSortida);
		
	}

	public String getClubAnfitrio() {
		return clubAnfitrio;
	}

	public void setClubAnfitrio(String clubAnfitrio) {
		this.clubAnfitrio = clubAnfitrio;
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

	public ArrayList<Participants> getParticipantsProva10000() {
		return participantsProva10000;
	}

	public void setParticipantsProva10000(ArrayList<Participants> participantsProva10000) {
		this.participantsProva10000 = participantsProva10000;
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
	public void afegirParticipantProva10000(String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat, String categoria, int dorsal, Duration tempsProva) {
		
		//String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat, String categoria, int dorsal, Duration tempsProva
		
		participantsProva10000.add(new Participants(nom, cognom1, cognom2, sexe, dataNaixement, dni, club, codiFederat, categoria, dorsal, tempsProva));

	}
	
	public void esborrarParticipantProva10000(int posicio) {
		
		participantsProva10000.remove(posicio);
		
	}
}

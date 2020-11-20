package M3_UF4_Practica.Objectes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Marato extends Proves {


	private LocalDate data;
	private LocalDateTime horaSortida;
	private ArrayList<Participants> participantsMarato = new ArrayList<Participants>();
	
	public Marato(String nom, int any, ArrayList<Participants> participants, int codiProva, LocalDate data, LocalDateTime horaSortida) {
		
		super(nom, any, participants, codiProva);
		this.setData(data);
		this.setHoraSortida(horaSortida);
			
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDateTime getHoraSortida() {
		return horaSortida;
	}

	public void setHoraSortida(LocalDateTime horaSortida) {
		this.horaSortida = horaSortida;
	}

	public ArrayList<Participants> getParticipantsMarato() {
		return participantsMarato;
	}

	public void setParticipantsMarato(ArrayList<Participants> participantsMarato) {
		this.participantsMarato = participantsMarato;
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
	public void afegirParticipantMarato(String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat, String categoria, int dorsal, Duration tempsProva) {
		
		//String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat, String categoria, int dorsal, Duration tempsProva
		
		participantsMarato.add(new Participants(nom, cognom1, cognom2, sexe, dataNaixement, dni, club, codiFederat, categoria, dorsal, tempsProva));

	}
	
	public void esborrarParticipantMarato(int posicio) {
		
		participantsMarato.remove(posicio);
		
	}
	
}

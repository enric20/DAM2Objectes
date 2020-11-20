package M3_UF4_Practica.Objectes;

import java.time.Duration;
import java.time.LocalDate;

public class Participants extends Esportistes {


	private String categoria; //"Absolut" nascut abans 31/12/1969 "Vetera" nascuts després 21/12/1969
	private int dorsal; //Dorsal unic per cada prova
	private Duration tempsProva; //Temps en realitzar prova
	
	public Participants(String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat, String categoria, int dorsal, Duration tempsProva) {
		super(nom, cognom1, cognom2, sexe, dataNaixement, dni, club, codiFederat); //String categoria, int dorsal, Duration tempsProva - no heredat
		this.setCategoria(categoria);
		this.setDorsal(dorsal);
		this.setTempsProva(tempsProva);
		
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public Duration getTempsProva() {
		return tempsProva;
	}

	public void setTempsProva(Duration tempsProva) {
		this.tempsProva = tempsProva;
	}
	
}

package M3_UF4_Practica.Objectes;

import java.time.LocalDate;

public class Clubs {

	private String nom;
	private String poblacio;
	private int codiPostal;
	private LocalDate anyFundacio;
	private int codiClub;
	
	public Clubs(String nom, String poblacio, int codiPostal, LocalDate anyFundacio, int codiClub) {
		
		this.setNom(nom);
		this.setPoblacio(poblacio);
		this.setCodiPostal(codiPostal);
		this.setAnyFundacio(anyFundacio);
		this.setCodiClub(codiClub);
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	public int getCodiPostal() {
		return codiPostal;
	}

	public void setCodiPostal(int codiPostal) {
		this.codiPostal = codiPostal;
	}

	public LocalDate getAnyFundacio() {
		return anyFundacio;
	}

	public void setAnyFundacio(LocalDate anyFundacio) {
		this.anyFundacio = anyFundacio;
	}

	public int getCodiClub() {
		return codiClub;
	}

	public void setCodiClub(int codiClub) {
		this.codiClub = codiClub;
	}
	
}

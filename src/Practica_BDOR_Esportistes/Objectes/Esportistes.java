package Practica_BDOR_Esportistes.Objectes;

import java.time.LocalDate;

public class Esportistes {
	
	private String nom;
	private String cognom1;
	private String cognom2;
	private char sexe; //'H' || 'D'
	private LocalDate dataNaixement; // DD/MM/YYYY
	private String dni; //9 caracters
	private String club;
	private String codiFederat;
	
	public static M3_UF4_Practica.Objectes.Esportistes esportistes;
	// ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList object
	
	public Esportistes (String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat) {
		this.setNom(nom);
		this.setCognom1(cognom1);
		this.setCognom2(cognom2);
		this.setSexe(sexe);
		this.setDataNaixement(dataNaixement);
		this.setDni(dni);
		this.setClub(club);
		this.setCodiFederat(codiFederat);
		
	}
	
	public Esportistes (String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni) {
		this.setNom(nom);
		this.setCognom1(cognom1);
		this.setCognom2(cognom2);
		this.setSexe(sexe);
		this.setDataNaixement(dataNaixement);
		this.setDni(dni);
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom1() {
		return cognom1;
	}

	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}

	public String getCognom2() {
		return cognom2;
	}

	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public LocalDate getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(LocalDate dataNaixement) {
		this.dataNaixement = dataNaixement;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getCodiFederat() {
		return codiFederat;
	}

	public void setCodiFederat(String codiFederat) {
		this.codiFederat = codiFederat;
	}

}

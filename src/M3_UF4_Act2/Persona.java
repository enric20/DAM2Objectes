package M3_UF4_Act2;

public class Persona {
	
	private String nom;
	private String cognom;
	private int edad;
	private char sexe;
	private static int numPersones;
	
	public Persona (String nom, String cognom, int edad, char sexe) {
		
		this.setNom(nom);
		this.setCognom(cognom);
		this.setEdat(edad);
		this.setSexe(sexe);
		
	}
	
	public static int afegirPersona() {
		return numPersones++;
	}
	
	public static int getNumPersones() {
		return numPersones;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCognom() {
		return cognom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	
	public int getEdat() {
		return edad;
	}
	public void setEdat(int edad) {
		this.edad = edad;
	}
	
	public String getSexe() {
		
		if (this.sexe == 'H') return "Home"; 
		else if (this.sexe == 'D') return "Dona";
		else return "Helicoptero Apache de Combate";
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	
}

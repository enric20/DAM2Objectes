package M3_UF4_Act2;

import java.util.Scanner;

public class Main {
	
	static Scanner lector = new Scanner(System.in);
	static int numPersones = 0;
	static Persona[] persones = new Persona[5];
	
	public static void main(String[] args) {
		
		System.out.println("Introdueix 5 persones");
		while (numPersones < persones.length) {
			crearPersona();
		}
		
		for (int i = 0; i < numPersones ; i++) {
			
			System.out.println("-----");
			System.out.println(persones[i].getNom());
			System.out.println(persones[i].getCognom());
			System.out.println(persones[i].getEdat());
			System.out.println(persones[i].getSexe());
			
			
		}
		System.out.println("-------");
		System.out.println("Numero de persones: "+numPersones);
		
	}
	
	public static void crearPersona() {
		
		int edat = 0;
		char sexe = 'A';
		
		System.out.print("Posa el teu nom: ");
		String nom = lector.nextLine();
		System.out.print("Posa el teu cognom: ");
		String cognom = lector.nextLine();
		
		
		boolean integerComprovat = false; //Afegir i Comprovar edad
		while (!integerComprovat) {
			System.out.print("Posa la teva edat (int): ");
			
			if (lector.hasNextInt()) {
				edat = lector.nextInt();
				lector.nextLine();
				if (edat >= 0) { //No admet una edat inferior a 0
					integerComprovat = true;
				}
				else {
					System.out.println("La edat no pot ser negativa");
				}
			}
			
			else {
				System.out.println("Incorrecte, posa un numero enter");
				lector.nextLine();
			}
		}
		
		boolean charComprovat = false;
		
		System.out.println("Posa el teu sexe: 'H' - Home | 'D' - Dona: ");
		String sexeStr = lector.nextLine();
		sexe = sexeStr.charAt(0);
			
		persones[numPersones] = new Persona(nom, cognom, edat, sexe);
		Persona.afegirPersona();
		numPersones = Persona.getNumPersones();
	}

}

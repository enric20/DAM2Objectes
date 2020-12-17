package Practica_BDOR_Esportistes.MenusSecundaris;
import Practica_BDOR_Esportistes.*;
import Practica_BDOR_Esportistes.Database.DatabaseScript;
import Practica_BDOR_Esportistes.MenusSecundaris.*;

import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/**
 * Inscriure esportistes en proves, anular participants i llistar-los.
 * @author enric
 * Version 1.0
 */
public class Inscripcio {

	static Scanner lector = new Scanner(System.in);	
	
	public static void MenuInscripcio() {
			
		boolean sortir = false;
		
		while (!sortir) {
			
			System.out.println("---------------- Menu Inscripció: ---------------");
			System.out.println("Selecciona una opció: ");
			System.out.println("1 - Inscripció prova de un esportista "); //Introduir esportista
			System.out.println("2 - Anul·lació inscripció de un participant "); //Introduir el dorsal
			System.out.println("3 - Llistar Inscripción  (Llistar participants de una prova) ");
			System.out.println("4 - Retorna al menu anterior ");
			
			if (lector.hasNextInt()) {
				int opcio = lector.nextInt();
				lector.nextLine();
				switch (opcio) {
				
					case 1:
						InscripcioEsportista();
						break;
						
					case 2:
						AnularInscripcio();
						break;
						
					case 3:
						LlistarInscripcions();
						break;
						
					case 4:
						sortir = true;
						break;
						
					default:
						System.out.println("Numero fora de rang");
						break;
				
				
				}
			}
			
			else {
				lector.nextLine();
				System.out.println("Has de posar un numero");
			}
			
		}
	}
	
	/**
	 * Insriure esportistes, utilitza els l'objecjte Esportistes.java
	 */
	public static void InscripcioEsportista() { //Tipus de prova?
			
		System.out.print("Dni del esportista que vols inscriure: ");
		String dniEsportista = lector.nextLine();
		
		boolean dniExistent = DatabaseScript.ComprovarClausPrimariesExistents("esportista", dniEsportista, 0, 0); //DNI EXISTENT?
		if (!dniExistent) {
			System.out.println("El dni no existeix, tornant al menú");
			return;
		}
		
		System.out.print("Codi de la prova a la qual vols inscriure l'esportista: ");
		while (!lector.hasNextInt()) {
			System.out.print("Codi Prova ha de ser un numero: ");
			lector.nextLine();
		}
		int codiProva = lector.nextInt();
		lector.nextLine();
		
		boolean provaExistent = DatabaseScript.ComprovarClausPrimariesExistents("proves", null, 0, codiProva); //PROVA EXISTENT?
		if (!provaExistent) {
			System.out.println("El codi prova no existeix, tornant al menú");
			return;
		}
				
		Date dataNaixementEsportista = DatabaseScript.RetornarDataNaixementEsportista(dniEsportista); //Retornar la data naixement del esportista desde la BD
		String categoriaEsportista = Support.RetornarAbsolutVetera(dataNaixementEsportista); //Establir la categoria: "Absolut" o "Vetera"
		
		
		int dorsalParticipant = DatabaseScript.AssignarDorsal(codiProva);
		if (dorsalParticipant == -1) {
			System.out.println("L'assignació del dorsal ha fallat, tornant al menú");
			return;
		}
		
		boolean inscripcio = DatabaseScript.InscripcioProva(dniEsportista, codiProva, categoriaEsportista, dorsalParticipant);
		
		if (inscripcio) {
			System.out.println("Inscripció del esportista amb Dni: "+dniEsportista+" a la prova (codi prova): "+codiProva+" completada");
		}
		else {
			System.out.println("No s'ha pogut inscriuré l'esportista amb Dni: "+dniEsportista+" a la prova (codi prova): "+codiProva);
		}
		
	
	}
	
	/**
	 * Eliminar un esportiste de una prova
	 */
	public static void AnularInscripcio() {
		
		System.out.print("Dni del esportista que vols anular la inscripcio: ");
		String dniEsportista = lector.nextLine();
		
		boolean dniExistent = DatabaseScript.ComprovarClausPrimariesExistents("esportista", dniEsportista, 0, 0); //DNI EXISTENT?
		if (!dniExistent) {
			System.out.println("El dni no existeix, tornant al menú");
			return;
		}
		
		System.out.print("Codi de la prova a la qual vols anular l'inscripcio de l'esportista: ");
		while (!lector.hasNextInt()) {
			System.out.print("Codi Prova ha de ser un numero: ");
			lector.nextLine();
		}
		int codiProva = lector.nextInt();
		lector.nextLine();
		
		boolean provaExistent = DatabaseScript.ComprovarClausPrimariesExistents("proves", null, 0, codiProva); //PROVA EXISTENT?
		if (!provaExistent) {
			System.out.println("El codi prova no existeix, tornant al menú");
			return;
		}
		
		boolean participantExistent = DatabaseScript.ComprovarClausPrimariesExistents("proves_participants", dniEsportista, 0, codiProva);
		
		if (!participantExistent) {
			System.out.println("El participant no està en la prova solicitada, tornant al menú");
			return;
		}
		
		boolean anulat = DatabaseScript.AnularInscripcioProva(dniEsportista, codiProva);
		
		if (anulat) {
			System.out.println("S'ha anulat l'inscripció");
		}
		else {
			System.out.println("No s'ha pogut anul·lar l'inscripció");
		}
	}
	
	public static void LlistarInscripcions() {
		
		System.out.print("Codi de la prova a la qual vols llistar les inscripcions: ");
		while (!lector.hasNextInt()) {
			System.out.print("Codi Prova ha de ser un numero: ");
			lector.nextLine();
		}
		int codiProva = lector.nextInt();
		lector.nextLine();

		DatabaseScript.LlistarInscripcionsProva(codiProva);
		System.out.println("");
	}
	
}
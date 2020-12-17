package Practica_BDOR_Esportistes.MenusSecundaris;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import Practica_BDOR_Esportistes.*;
import Practica_BDOR_Esportistes.Database.DatabaseScript;
import Practica_BDOR_Esportistes.Objectes.*;

/**
 * Tercer menu secundari per a introuir dates i llistar les proves
 * @author enric
 * @version 1.0
 */
public class ProvesM {
	
	static Scanner lector = new Scanner(System.in);	

	public static void MenuProves() {
		
		boolean sortir = false;
		
		while (!sortir) {
			
			System.out.println("---------------- Menu Proves: ---------------");
			System.out.println("Selecciona una opció: ");
			System.out.println("1 - Entrada Temps Prova (Assignar hora de la prova): "); //Introduir codi prova i entrar la hora d'inici d'aquesta
			System.out.println("2 - Entrada Temps arribada Participants (Assignar temps dels participants en la prova) "); //Introduir temps del participant
			System.out.println("3 - Classificació Total"); //Mostrar tots els participants de la prova a partir del codi d'aquesta
			System.out.println("4 - Classificació Sexe (Mostrar classificació per sexe) ");  //Mostrar en 2 columnes/files
			System.out.println("5 - Classificació Categoria (Mostrar classificació per categoria) "); //Mostrar 4 guanyadors de cada categoria ordenats per temps
			System.out.println("6 - Retorna al menu anterior");
			
			if (lector.hasNextInt()) {
				int opcio = lector.nextInt();
				lector.nextLine();
				switch (opcio) {
				
					case 1: //Entrada Temps Prova
						EntradaTempsProva();
						break; 
						
					case 2: //Entrada Temps arribada Participants
						EntradaTempsArribadaParticipants();
						break;
						
					case 3: //Classificació Total
						ClassificacioTotal();
						break;
					
					case 4: //Classificació Sexe
						ClassificacioSexe();
						break;
					
					case 5: //Classificació Categoria
						ClassificacioCategoria();
						break;
						
					case 6: //Sortir
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
	 * Estableix la data i hora i minut de sortida de una prova especificada
	 */
	public static void EntradaTempsProva() {
				
		System.out.print("Codi de la prova a la qual vols llistar les inscripcions: ");
		while (!lector.hasNextInt()) {
			System.out.print("Codi Prova ha de ser un numero: ");
			lector.nextLine();
		}
		int codiProva = lector.nextInt();
		lector.nextLine();

		DatabaseScript.ComprovarClausPrimariesExistents("proves", null, 0, codiProva);
		System.out.println("");
		
		int provaHora = Support.EstablirHoraTipusProva();
		LocalTime horaSortida = LocalTime.of(provaHora, 0, 0);
		
		boolean updateProves = DatabaseScript.UpdateProves(0, null, horaSortida, null, codiProva, 2);
		if (updateProves) {
			System.out.println("Hora de la prova cambiada");
		}
		else {
			System.out.println("No s'ha pogut canviar l'hora de la prova");
		}
		
	}
	
	/**
	 * Estableix el temps del participant
	 */
	public static void EntradaTempsArribadaParticipants() {
		
		System.out.print("Dni del esportista que vols entrar el temps: ");
		String dniEsportista = lector.nextLine();
		
		boolean dniExistent = DatabaseScript.ComprovarClausPrimariesExistents("esportista", dniEsportista, 0, 0); //DNI EXISTENT?
		if (!dniExistent) {
			System.out.println("El dni no existeix, tornant al menú");
			return;
		}
		
		System.out.print("Codi de la prova en la qual està l'esportista: ");
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
		
		int hores = Support.EstablirHoraTipusProva();
		int minuts = 0;
		boolean minutsComprovats = false;
		while (!minutsComprovats) {
			
			System.out.println("Posa els minuts totals: ");
			while (!lector.hasNextInt()) {
				System.out.println("Minuts ha de ser un numero absolut: ");
				lector.nextLine();
			}
		
			minuts = lector.nextInt();
			lector.nextLine();
			
			if (minuts >= 0 && minuts <= 59) {
				minutsComprovats = true;
			}
			else {
				System.out.println("Minuts fora de rang");
			}
		}
		
		int segons = 0;
		boolean segonsComprovats = false;
		while (!segonsComprovats) {
			
			System.out.println("Posa els segons totals: ");
			while (!lector.hasNextInt()) {
				System.out.println("Segons ha de ser un numero absolut: ");
				lector.nextLine();
			}
		
			segons = lector.nextInt();
			lector.nextLine();
			
			if (segons >= 0 && segons <= 59) {
				segonsComprovats = true;
			}
			else {
				System.out.println("Segons fora de rang");
			}
		}
		
		LocalTime tempsProvaLT = LocalTime.of(hores, minuts, segons);
		
		boolean tempsIntroduit = DatabaseScript.UpdateProvesParticipantsTemps(dniEsportista, codiProva, tempsProvaLT);
		
		if (tempsIntroduit) {
			System.out.println("Temps del participant introduit ");
		}
		else {
			System.out.println("No s'ha pogut introduir el temps del participant");
		}
		
	}
	
	/**
	 * Classificar els participant de una prova seleccionada ordenats per el temps total
	 */
	public static void ClassificacioTotal() {
		
		System.out.print("Posa el codi de la prova que vols llistar la classificació total: ");
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
		
		DatabaseScript.MostrarClassificacioTotal(codiProva, "temps");
	}
	
	/**
	 * Classificar els participant de una prova seleccionada ordenats per el sexe
	 */
	public static void ClassificacioSexe() {
		
		System.out.print("Posa el codi de la prova que vols llistar la classificació per sexe: ");
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
		
		DatabaseScript.MostrarClassificacioTotal(codiProva, "sexe");
		
	}
	
	/**
	 * Classificar els participant de una prova seleccionada ordenats per la categoria
	 */
	public static void ClassificacioCategoria() {
	
		System.out.print("Posa el codi de la prova que vols llistar la classificació per categoria: ");
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
		
		DatabaseScript.MostrarClassificacioTotal(codiProva, "categoria");
		
	}

}

package Practica_BDOR_Esportistes.MenusSecundaris;

import Practica_BDOR_Esportistes.*;
import Practica_BDOR_Esportistes.Database.DatabaseScript;
import Practica_BDOR_Esportistes.Objectes.Clubs;
import Practica_BDOR_Esportistes.Objectes.Esportistes;
import Practica_BDOR_Esportistes.Objectes.Marato;
import Practica_BDOR_Esportistes.Objectes.MarxaPopular;
import Practica_BDOR_Esportistes.Objectes.Participants;
import Practica_BDOR_Esportistes.Objectes.Prova10000;
import Practica_BDOR_Esportistes.Objectes.Proves;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Primer menu secundari per a introduir, modificar y llistar dades
 * @author enric
 * Version 1.0
 */
public class Dades {

	static Scanner lector = new Scanner(System.in);	
	/**
	 * Mètode del Menu de Dades
	 */
	public static void MenuDades() {
		
		boolean sortir = false;
		
		while (!sortir) {
			System.out.println("---------------- Menu Dades: ---------------");
			System.out.println("Selecciona una opció: ");
			System.out.println("1 - Alta Esportista "); //Registrar un esportista
			System.out.println("2 - Alta Club "); //Registrar un Club
			System.out.println("3 - Alta Prova "); //Registrar una Prova
			System.out.println("4 - Consulta Club  (llistar clubs) "); //Consultar clubs
			System.out.println("5 - Consulta Prova (llistar proves) "); //Consultar proves
			System.out.println("6 - Consulta Esportista  (llistar esportistes) "); //Consultar esportistes
			System.out.println("7 - Modificació Esportista "); //Introduir nom esportista i dni
			System.out.println("8 - Modificació Club "); //Introduir nom club i codi club
			System.out.println("9 - Modificació Prova "); //Introduir usuari i codi prova
			System.out.println("10 - Retorna al menu anterior "); //Sortir
			
			if (lector.hasNextInt()) {
				int opcio = lector.nextInt();
				lector.nextLine();
				
				switch (opcio) {
				
					case 1:
						AltaEsportista();
						break;
						
					case 2:
						AltaClub();
						break;
						
					case 3:
						AltaProva();
						break;
						
					case 4:
						ConsultaClub();
						break;
						
					case 5:
						ConsultaProva();
						break;
						
					case 6:
						ConsultaEsportista();
						break;
						
					case 7:
						ModificacioEsportista();
						break;
						
					case 8:
						ModificacioClub();
						break;
						
					case 9:
						ModificacioProva();
						break;
						
					case 10:
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
	 * Registrar un esportista, utilitza les funcions EstablirSexeEsportista, EstablirDataNaixementEsportista, EstablirDniEsportista, 
	 * EstablirClubEsportista, EstablirCodiFederatEsportista
	 */
	public static void AltaEsportista() {
		
		System.out.println("*********ALTA ESPORTISTA*********");
		String[] nomICognoms = new String[3];
		
		nomICognoms = Support.EstablirNomICognomsEsportista();
		String nomEsportista = nomICognoms[0];
		String primerCognomEsportista = nomICognoms[1];
		String segonCognomEsportista = nomICognoms[2];
		
		char sexeEsportista = Support.EstablirSexeEsportista(); //Establir sexe a travvés de la funcio amb un return del sexe
		LocalDate dataNaixementLDEsportista = Support.EstablirDataNaixementEsportista(); //Establir data naixement a travvés de la funcio amb un return de la data naixement LD
		System.out.print("Dni esportista: ");
		String dniEsportista = lector.nextLine(); //Establir dni esportista a través de la funcio amb un return del dni del esportista
		
		
		System.out.print("Vols federar l'esportista? (yes) (no) ");
		String opcio = lector.nextLine();
		
		String clubEsportista = "";
		String codiFederatEsportista = "";
		
		switch (opcio) {
			case "yes":
				
				System.out.println("Posa el codi del club (integer:) ");
				clubEsportista = lector.nextLine();
				int clubEsportistaInt = 0;
				try {
					clubEsportistaInt = Integer.parseInt(clubEsportista);
				}
				catch (Exception e) {
					System.out.println("Club esportista ha de ser un numero");
					return;
				}
				System.out.println("Codi federat del esportista: ");
				codiFederatEsportista = lector.nextLine();
				
				boolean insertat1 = DatabaseScript.InsertEsportista(nomEsportista, primerCognomEsportista, segonCognomEsportista, sexeEsportista, dataNaixementLDEsportista, dniEsportista, 
						clubEsportistaInt, codiFederatEsportista);
				if (insertat1) {
					System.out.println("S'ha afegit l'esportista com a federat");
				}
				else {
					System.out.println("No s'ha pogut afegir l'esportista com a federat");
				}
				
				//INSERT TO DATABASE
				//Afegir nou objecte a la llista esportistes (Com a federat)
				break;
				
			default:
				//INSERT TO DATABASE WITH NULL VALUES
				//String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, int codiClub, String codiFederat
				boolean insertat2 = DatabaseScript.InsertEsportista(nomEsportista, primerCognomEsportista, segonCognomEsportista, sexeEsportista, dataNaixementLDEsportista, dniEsportista, 0, null);
				
				if (insertat2) {
					System.out.println("S'ha afegit l'esportista com a NO federat");
				}
				
				else {
					System.out.println("No s'ha pogut afegir l'esportista");
				}
				
				//Afegir nou objecte a la llista esportistes (Com a NO federat)
				break;
		}
		
		System.out.println("************************************");
	}
	
	/**
	 * Registrar un club, utilitza les funcions EstablirCodiPostalClub i EstablirCodiClub per establir els atributs
	 */
	public static void AltaClub() {
		
		//String nom, String poblacio, int codiPostal, LocalDate anyFundacio, int codiClub
		
		System.out.println("*********ALTA CLUB*********");
		System.out.print("Nom del club: ");
		String nomClub = lector.nextLine();
		System.out.print("Poblacio: ");
		String poblacioClub = lector.nextLine();
		
		try {
			int codiPostalClub = Support.EstablirCodiPostalClub();
			LocalDate anyFundacioLDClub = Support.EstablirAnyFundacioClub();
			int codiClub = 0;
			
			System.out.print("Codi Club: ");
			while (!lector.hasNextInt()) {
				System.out.print("Codi Club ha de ser un numero: ");
				lector.nextLine();
			}
			codiClub = lector.nextInt();
			lector.nextLine();
			int anyFundacioClub = anyFundacioLDClub.getYear();
			boolean inserted = DatabaseScript.InsertClub(nomClub, poblacioClub, codiPostalClub, anyFundacioClub, codiClub);
			
			if (inserted) {
				System.out.println("Club afegit");
			}
			
			else {
				System.out.println("No s'ha pogut afegir el club");
			}
		}
		
		catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
		//InsertClub(String nomClub, String poblacioClub, int codiPostalClub, LocalDate anyFundacioClub, int codiClub)
		
		
	}
	
	/**
	 * Registrar una prova, utilitza les funcions EstablirAnyProva i EstablirCodiProva per establir els atributs de la prova
	 */
	public static void AltaProva() {
		
		//String nom, int any, ArrayList<Participants> participants, int codiProv				   (PROVA)
		
		System.out.print("Nom de la prova: ");
		String nomProva = lector.nextLine();
		
		int codiProva = 0;
				
		System.out.print("Codi Prova: ");
		while (!lector.hasNextInt()) {
			System.out.print("Codi Prova ha de ser un numero: ");
			lector.nextLine();
		}
		codiProva = lector.nextInt();
		
		System.out.println("Posa la data de la prova");
		LocalDate provaData = Support.EstablirAnyFundacioClub(); //Reutilitzable per a prova
		
		int provaHora = Support.EstablirHoraTipusProva();
		
		LocalTime timeSortida = LocalTime.of(provaHora, 0, 0);
		System.out.println(timeSortida);
		
		boolean sortirMenuTipusProva = false;
		lector.nextLine();
		
		while (!sortirMenuTipusProva) {

			System.out.println("Quin tipus de prova es? ");
			System.out.println("A - Marato");
			System.out.println("B - Prova 10000");
			System.out.println("C - Marxa Popular");
			System.out.println("D - Prova");
			
			String opcio = lector.nextLine();
			
			switch (opcio) {
				
				case "A": // MARATO
					boolean insertat = DatabaseScript.InsertProves(codiProva, nomProva, timeSortida, provaData, null, 0, 1);
					
					if (insertat) {
						System.out.println("S'ha afegit la prova com a marato");
					}
					
					else {
						System.out.println("No s'ha pogut afegir la prova com a marato");
					}
					sortirMenuTipusProva = true;
					break;
					
				case "B": // PROVA 10000 (ubicacio, club anfitrio)
					
					int codiClub = 0;
					
					System.out.print("Codi Club: ");
					while (!lector.hasNextInt()) {
						System.out.print("Codi Club ha de ser un numero: ");
						lector.nextLine();
					}
					codiClub = lector.nextInt();
					lector.nextLine();
					
					System.out.print("Ubicació de la Prova 10000: ");
					String ubicacioProva10000 = lector.nextLine();
					
					boolean insertat1 = DatabaseScript.InsertProves(codiProva, nomProva, timeSortida, provaData, ubicacioProva10000, codiClub, 2);
					
					if (insertat1) {
						System.out.println("S'ha afegit la prova com a Prova 10000");
					}
					
					else {
						System.out.println("No s'ha pogut afegir la prova com a Prova 10000");
					}	
					sortirMenuTipusProva = true;
					break;
					 
				case "C": //MARXA POPULAR (ubicacio)
					
					System.out.print("Ubicació de la Marxa Popular: ");
					String ubicacioMarxaPopular = lector.nextLine();
					boolean insertat2 = DatabaseScript.InsertProves(codiProva, nomProva, timeSortida, provaData, ubicacioMarxaPopular, 0, 3);
					
					if (insertat2) {
						System.out.println("S'ha afegit la prova com a marxa popular");
					}
					
					else {
						System.out.println("No s'ha pogut afegir la prova com a marxa popular");
					}
					sortirMenuTipusProva = true;
					break;
					
				case "D": //PROVA

					boolean insertat3 = DatabaseScript.InsertProves(codiProva, nomProva, timeSortida, provaData, null, 0, 4);
					
					if (insertat3) {
						System.out.println("S'ha afegit la prova");
					}
					
					else {
						System.out.println("No s'ha pogut afegir la prova");
					}
					sortirMenuTipusProva = true;
					break;
				
				default:
					System.out.println("Opcio incorrecta");
					break;
			
			}
			
		}
		
	}
	
	/**
	 * Llistar els clubs existents 
	 */
	public static void ConsultaClub() {
		
		DatabaseScript.ShowDataBaseValues("club");
	}
	
	/**
	 * Llistar les proves existents i els seus respectius participants
	 */
	public static void ConsultaProva() {
		
		DatabaseScript.ShowDataBaseValues("proves");
		
	}
	
	/**
	 * Llistar tots els esportistes, federats i no federats
	 */
	public static void ConsultaEsportista() {
		
		DatabaseScript.ShowDataBaseValues("esportista");
	}
	
	/**
	 * Modificar un esportista a través del seu DNI
	 */
	public static void ModificacioEsportista() {
		
		String dniEsportista = "";
		
		System.out.print("Posa el dni del esportista que vols modificar: ");
		dniEsportista = lector.nextLine();
		boolean existentDni = DatabaseScript.ComprovarClausPrimariesExistents("esportista", dniEsportista, 0, 0);
		
		if (!existentDni) {
			System.out.println("El dni no existeix");
			return;
		}
				
		System.out.println("Quines dades vols modificar? ");
		
		boolean sortirModificarEsportistes = false;
		
		while (!sortirModificarEsportistes) {
			
			System.out.println("Modificant Dni: "+dniEsportista);
			System.out.println("A - Modificar nom i cognoms");
			System.out.println("B - Modificar sexe i data naixement");
			System.out.println("C - Modificar club i codi federat");
			System.out.println("D - Modificar dni");
			System.out.println("S - Sortir");
			
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
			case "A":
				
				String[] nomICognoms = new String[3];
				
				nomICognoms = Support.EstablirNomICognomsEsportista();
				String nomEsportista = nomICognoms[0];
				String primerCognomEsportista = nomICognoms[1];
				String segonCognomEsportista = nomICognoms[2];
				
				boolean updated1 = DatabaseScript.UpdateEsportistes(null, nomEsportista, primerCognomEsportista, segonCognomEsportista, 'X', null, dniEsportista, 0, null, 1);
				
				if (updated1) {
					System.out.println("S'ha actualitzat el nom i cognoms");
				}
				else {
					System.out.println("No s'han pogut actualitzar el nom i cognoms");
				}
				
				break;
			
			case "B":
				
				char sexeEsportista = Support.EstablirSexeEsportista();
				LocalDate dataNaixementLDEsportista = Support.EstablirDataNaixementEsportista();
				
				boolean updated2 = DatabaseScript.UpdateEsportistes(null, null, null, null, sexeEsportista, dataNaixementLDEsportista, dniEsportista, 0, null, 2);
				
				if (updated2) {
					System.out.println("Sexe i data naixement esportista canviat");
				}
				else {
					System.out.println("No s'han pogut actualitzar la data naixement / sexe");
				}
				
				break;
				
			case "C":
				
				int codiClub = 0;
				System.out.print("Codi Club: ");
				while (!lector.hasNextInt()) {
					System.out.print("Codi Club ha de ser un numero: ");
					lector.nextLine();
				}
				codiClub = lector.nextInt();
				lector.nextLine();
				
				System.out.println("Posa el nou codi federat del esportista");
				String codiFederatEsportista = lector.nextLine();
				
				boolean updated3 = DatabaseScript.UpdateEsportistes(null, null, null, null, 'X', null, dniEsportista, codiClub, codiFederatEsportista, 3);
				
				if (updated3) {
					System.out.println("Club del esportista i codi federat canviats");
				}
				else {
					System.out.println("No s'ha pogut canviar el club del esportista ni el codi federat");
				}
								
				break;
				
			case "D":
				System.out.println("Posa el nou dni del esportista (No es modificarà si el dni està relacionat)");
				String dniEsportistaNew = lector.nextLine();
				
				boolean updated4 = DatabaseScript.UpdateEsportistes(dniEsportistaNew, null, null, null, 'X', null, dniEsportista, 0, null, 4);
				
				if (updated4) {
					System.out.println("Dni modificat, tornant al menu");
					return;
				}
				else {
					System.out.println("No s'ha pogut modificar el dni");
				}
				
				
				break;
			
			case "S":
				
				sortirModificarEsportistes = true;
				break;
				
			default: 
				System.out.println("Opcio incorrecta");
				break;
			
			}
			
		}
		
	}
	
	/**
	 * Modificar un club a través del seu codi
	 */
	public static void ModificacioClub() {
		
		int codiClub = 0;
		
		System.out.print("Posa el codi del club que vols modificar: ");
		while (!lector.hasNextInt()) {
			System.out.println("El codi del club ha de ser un numero");
			lector.nextLine();
		}
		codiClub = lector.nextInt();
		lector.nextLine();
		
		boolean codiClubExistent = DatabaseScript.ComprovarClausPrimariesExistents("club", null, codiClub, 0);
		if (!codiClubExistent) {
			System.out.println("Codi club no existeix");
			return;
		}
	
		System.out.println("Quines dades vols modificar? ");
		
		boolean sortirModificarEsportistes = false;
		
		while (!sortirModificarEsportistes) {
			
			System.out.println("Modificant Codi Club: "+codiClub);
			System.out.println("A - Modificar nom club");
			System.out.println("B - Modificar poblacio club");
			System.out.println("C - Modificar codi postal poblacio");
			System.out.println("D - Modificar Any Fundacio Club");
			System.out.println("S - Sortir");
			
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
				case "A": //Nom club
								 
					System.out.print("Posa el nom del club: ");
					String nomClub = lector.nextLine();
					
					boolean updated1 = DatabaseScript.UpdateClub(0, nomClub, 0, 0, null, codiClub, 1);
					if (updated1) {
						System.out.println("S'ha actualitzat el nom del club");
					}
					else {
						System.out.println("No s'ha pogut actualitzar el nom del club");
					}

					break;
				
				case "B": //Poblacio club
					 
					System.out.print("Posa la poblacio del club: ");
					String poblacio = lector.nextLine();
					
					boolean updated2 = DatabaseScript.UpdateClub(0, null, 0, 0, poblacio, codiClub, 2);
					if (updated2) {
						System.out.println("S'ha actualitzat la poblacio del club");
					}
					else {
						System.out.println("No s'ha pogut actualitzar la poblacio del club");
					}
					break;
					
				case "C": //Codi postal
					
					int codiPostal = 0;
					System.out.print("Posa el codi postal del club: ");
					while (!lector.hasNextInt()) {
						System.out.print("Codi postal ha de ser un numero: ");
						lector.nextLine();
					}
					codiPostal = lector.nextInt();
					lector.nextLine();
					
					boolean updated3 = DatabaseScript.UpdateClub(0, null, 0, codiPostal, null, codiClub, 3);
					if (updated3) {
						System.out.println("S'ha actualitzat la poblacio del club");
					}
					else {
						System.out.println("No s'ha pogut actualitzar la poblacio del club");
					}
					break;
					
				case "D": //Any fundacio
					int anyFundacioClub = 0;
					System.out.print("Posa l'any de fundacio del club: ");
					while (!lector.hasNextInt()) {
						System.out.print("Any fundacio club ha de ser un numero: ");
						lector.nextLine();
					}
					anyFundacioClub = lector.nextInt();
					lector.nextLine();
					
					boolean updated4 = DatabaseScript.UpdateClub(0, null, anyFundacioClub, 0, null, codiClub, 4);
					if (updated4) {
						System.out.println("S'ha actualitzat l'any fundacio del club");
					}
					else {
						System.out.println("No s'ha pogut actualitzar l'any fundaciod el club");
					}
					break;
				
				case "S":
					
					sortirModificarEsportistes = true;
					break;
					
				default: 
					System.out.println("Opcio incorrecta");
					break;
			
			}
			
		}
		
	}
	
	/*
	 * Modificar una prova a través del seu codi
	 */
	public static void ModificacioProva() {
		
		int codiProva = 0;
		
		System.out.print("Posa el codi de la prova a modificar: ");
		while (!lector.hasNextInt()) {
			System.out.println("El codi de la prova ha de ser un numero absolut");
			lector.nextLine();
		}
		codiProva = lector.nextInt();
		lector.nextLine();
		
		boolean codiProvaExistent = DatabaseScript.ComprovarClausPrimariesExistents("proves", null, 0, codiProva);
		
		if (!codiProvaExistent) {
			System.out.println("El codi de la prova no existeix");
			return;
		}
		
		System.out.println("Quines dades vols modificar? ");
		
		boolean sortirModificarEsportistes = false;
		
		while (!sortirModificarEsportistes) {
			
			System.out.println("Modificant Codi Prova: "+codiProva);
			System.out.println("A - Modificar nom prova");
			System.out.println("B - Modificar hora prova");
			System.out.println("C - Modificar data prova");
			System.out.println("S - Sortir");
			
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
				case "A": //Nom Prova	 
					System.out.print("Posa el nom de la prova ");
					String nomProva = lector.nextLine();
					
					boolean update1 = DatabaseScript.UpdateProves(0, nomProva, null, null, codiProva, 1);
					if (update1) {
						System.out.println("Nom de la prova cambiat");
					}
					else {
						System.out.println("No s'ha pogut canviar el nom de la prova");
					}
					
					break;
					
				case "B": //Hora Prova
										
					int provaHora = Support.EstablirHoraTipusProva();
					LocalTime horaSortida = LocalTime.of(provaHora, 0, 0);
					
					boolean update2 = DatabaseScript.UpdateProves(0, null, horaSortida, null, codiProva, 2);
					if (update2) {
						System.out.println("Hora de la prova cambiada");
					}
					else {
						System.out.println("No s'ha pogut canviar l'hora de la prova");
					}

					break;
				
				case "C": //Data Prova
					
					LocalDate data = Support.EstablirAnyFundacioClub(); //Reutilitzable per a prova
					
					boolean update3 = DatabaseScript.UpdateProves(0, null, null, data, codiProva, 3);
					if (update3) {
						System.out.println("Data de la prova cambiada");
					}
					else {
						System.out.println("No s'ha pogut canviar la data de la prova");
					}
					
					break;
				
				case "S":
					sortirModificarEsportistes = true;
					break;
					
				default: 
					System.out.println("Opcio incorrecta");
					break;
			
			}
			
		}
		
	}
		
	

}
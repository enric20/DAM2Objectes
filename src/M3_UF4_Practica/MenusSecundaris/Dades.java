package M3_UF4_Practica.MenusSecundaris;

import M3_UF4_Practica.*;
import M3_UF4_Practica.Objectes.Clubs;
import M3_UF4_Practica.Objectes.Esportistes;
import M3_UF4_Practica.Objectes.Marato;
import M3_UF4_Practica.Objectes.MarxaPopular;
import M3_UF4_Practica.Objectes.Participants;
import M3_UF4_Practica.Objectes.Prova10000;
import M3_UF4_Practica.Objectes.Proves;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
			System.out.println("4 - Consulta Club  (llistar clubs) ");
			System.out.println("5 - Consulta Prova (llistar proves) ");
			System.out.println("6 - Consulta Esportista  (llistar esportistes) ");
			System.out.println("7 - Modificació Esportista "); //Introduir nom esportista i dni
			System.out.println("8 - Modificació Club "); //Introduir nom club i codi club
			System.out.println("9 - Modificació Prova "); //Introduir usuari i codi prova
			System.out.println("10 - Retorna al menu anterior "); //Sortir
			
			if (lector.hasNextInt()) {
				int opcio = lector.nextInt();
				lector.nextLine();
				
				switch (opcio) {
				
					case 1:
						
						if (DadesObjectes.esportistes.size() >= 1000) { //Establir un numero màxim d'esportistes registrats (1000)
							System.out.println("S'ha sobrepassat la llista maxima d'esportistes (1000 esportistes) ");
						}
						else {
							AltaEsportista();
						}
						
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
		String dniEsportista = Support.EstablirDniEsportista(); //Establir dni esportista a través de la funcio amb un return del dni del esportista
		
		
		System.out.print("Vols federar l'esportista? (yes) (no) ");
		String opcio = lector.nextLine();
		
		String clubEsportista = "";
		String codiFederatEsportista = "";
		
		switch (opcio) {
			case "yes":
				
				clubEsportista = Support.EstablirClubEsportista();
				codiFederatEsportista = Support.EstablirCodiFederatEsportista();
				
				DadesObjectes.esportistes.add(new Esportistes(nomEsportista, primerCognomEsportista, segonCognomEsportista, 
						sexeEsportista, dataNaixementLDEsportista, dniEsportista, clubEsportista, codiFederatEsportista));
				//Afegir nou objecte a la llista esportistes (Com a federat)
				break;
				
			default:
				DadesObjectes.esportistes.add(new Esportistes(nomEsportista, primerCognomEsportista, segonCognomEsportista, 
						sexeEsportista, dataNaixementLDEsportista, dniEsportista));
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
		
		int codiPostalClub = Support.EstablirCodiPostalClub();
		LocalDate anyFundacioLDClub = Support.EstablirAnyFundacioClub();
		int codiClub = Support.EstablirCodiClub();
		
		
		DadesObjectes.clubs.add(new Clubs(nomClub, poblacioClub, codiPostalClub, anyFundacioLDClub, codiClub));
	}
	
	/**
	 * Registrar una prova, utilitza les funcions EstablirAnyProva i EstablirCodiProva per establir els atributs de la prova
	 */
	public static void AltaProva() {
		
		//String nom, int any, ArrayList<Participants> participants, int codiProv				   (PROVA)
		
		System.out.print("Nom de la prova: ");
		String nomProva = lector.nextLine();
		
		int anyProva = Support.EstablirAnyProva();
		ArrayList<Participants> participantsProva = new ArrayList<Participants>();
		int codiProva = Support.EstablirCodiProva(anyProva);
		
		DadesObjectes.proves.add(new Proves(nomProva, anyProva, participantsProva, codiProva)); //La prova es guarda en l'ArrayList prova, per a tenir constancia del seu codi prova
		
		System.out.println("Posa la data de la prova");
		LocalDate provaData = Support.EstablirAnyFundacioClub(); //Reutilitzable per a prova
		
		int provaHora = Support.EstablirHoraTipusProva();
		
		LocalDateTime maratoHoraSortida = LocalDateTime.of(provaData.getDayOfYear(), provaData.getMonthValue(), 
				provaData.getDayOfMonth(), provaHora, 0);
		
		boolean sortirMenuTipusProva = false;
		
		while (!sortirMenuTipusProva) {

			System.out.println("Quin tipus de prova es? ");
			System.out.println("A - Marato");
			System.out.println("B - Prova 10000");
			System.out.println("C - Marxa Popular");
			
			String opcio = lector.nextLine();
			
			switch (opcio) {
				
				case "A": // " " " " LocalDate data, LocalDateTime horaSortida 										(MARATO)
					
					System.out.println("S'ha afegit la prova com a marato");
					DadesObjectes.marato.add(new Marato(nomProva, anyProva, participantsProva, codiProva, provaData, maratoHoraSortida));
					sortirMenuTipusProva = true;
					break;
					
				case "B": // " " " " String clubAnfitrio, String ubicacio, LocalDate data, LocalDateTime dataSortida (PROVA 10000)
					
					boolean clubExistent = false;
					String clubAnfitrio = "";
					while (!clubExistent) {
						System.out.println("Posa el nom del club anfitrio: ");
						clubAnfitrio = lector.nextLine();
						clubExistent = Support.ComprovarExistenciaClubs(clubAnfitrio, DadesObjectes.clubs); // Support.ComprovarExistenciaClubs(clubAnfitrio, DadesObjectes.clubs); 
						if (!clubExistent) {
							System.out.println("Nom del club no trobat");
						}
					}
					
					System.out.print("Ubicació de la Prova 10000: ");
					String ubicacioProva = lector.nextLine();
					DadesObjectes.prova10000.add(new Prova10000(nomProva, anyProva, participantsProva, codiProva, clubAnfitrio, 
							ubicacioProva, provaData, maratoHoraSortida));
					System.out.println("S'ha afegit la prova com a Prova 10000");
					sortirMenuTipusProva = true;
					break;
					 
				case "C": // " " " " String ubicacio, LocalDate data, LocalDateTime dataSortida 					   (MARXA POPULAR)
					
					System.out.print("Ubicació de la Marxa Popular: ");
					String ubicacioMarxaPopular = lector.nextLine();
					DadesObjectes.marxaPopular.add(new MarxaPopular(nomProva, anyProva, participantsProva, codiProva, 
							ubicacioMarxaPopular, provaData, maratoHoraSortida));
					System.out.println("S'ha afegit la prova com a Marxa Popular");
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
		
		System.out.println("********************************CONSULTA CLUB********************************");
		System.out.println("Nom Club	Poblacio	C.Postal	AnyFundacio	CodiClub");
		for (int i = 0; i < DadesObjectes.clubs.size(); i++) {
			System.out.println("");
			System.out.print(DadesObjectes.clubs.get(i).getNom()+"	"+DadesObjectes.clubs.get(i).getPoblacio()+"	"+DadesObjectes.clubs.get(i).getCodiPostal());
			System.out.print("		"+DadesObjectes.clubs.get(i).getAnyFundacio()+"	"+DadesObjectes.clubs.get(i).getCodiClub());
			
		}
		System.out.println();
		System.out.println("*****************************************************************************");
	}
	
	/**
	 * Llistar les proves existents i els seus respectius participants
	 */
	public static void ConsultaProva() {
		//String nom, int any, String[] participants, int codiProva
		System.out.println("*******************************************************************************");
		System.out.println("********************************CONSULTA PROVES********************************");
		System.out.println("*******************************************************************************");
		
		for (int i = 0; i < DadesObjectes.proves.size(); i++) { //Llistar proves
			System.out.println();
			System.out.println("Nom: "+DadesObjectes.proves.get(i).getNom());
			System.out.println("Any: "+DadesObjectes.proves.get(i).getAny());
			System.out.println("Codi Prova: "+DadesObjectes.proves.get(i).getCodiProva());
		}
		System.out.println();
		System.out.println("*****************************************************************************");
		
	}
	
	/**
	 * Llistar tots els esportistes, federats i no federats
	 */
	public static void ConsultaEsportista() {
		//String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat
		System.out.println("********************************CONSULTA ESPORTISTES********************************");
		System.out.println("Nom	Cognom1		Cognom2	Sexe	dataNaixement	dni		club	CodiFederat");
		for (int i = 0; i < DadesObjectes.esportistes.size(); i++) {
			System.out.println("");
			System.out.print(DadesObjectes.esportistes.get(i).getNom()+"	"+DadesObjectes.esportistes.get(i).getCognom1()+"  "+DadesObjectes.esportistes.get(i).getCognom2());
			System.out.print("	"+DadesObjectes.esportistes.get(i).getSexe()+"	"+DadesObjectes.esportistes.get(i).getDataNaixement()+"	"+DadesObjectes.esportistes.get(i).getDni());
			System.out.print("	"+DadesObjectes.esportistes.get(i).getClub()+"	"+DadesObjectes.esportistes.get(i).getCodiFederat());
			
		}
		System.out.println();
		System.out.println("*****************************************************************************");
		
	}
	
	/**
	 * Modificar un esportista a través del seu DNI
	 */
	public static void ModificacioEsportista() {
		
		int numeroEsportista = -1;
		String dniEsportista = "";
		
		System.out.print("Posa el dni del esportista que vols modificar: ");
		dniEsportista = lector.nextLine();
		numeroEsportista = Support.MostrarDadesEsportistaIRetornarPosicio(dniEsportista, DadesObjectes.esportistes); //Retorna la posicio
		//Mostrar les dades del esportista
		if (numeroEsportista == -1) {
			System.out.println("Dni del esportista no trobat, tornant al menu: ");
		}
		
		else {
			System.out.println("Quines dades vols modificar? ");
			
			boolean sortirModificarEsportistes = false;
			
			while (!sortirModificarEsportistes) {
				
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
					
					DadesObjectes.esportistes.get(numeroEsportista).setNom(nomEsportista); //Canviar el nom de l'esportista
					DadesObjectes.esportistes.get(numeroEsportista).setCognom1(primerCognomEsportista); //Canviar el cognom de l'esportista
					DadesObjectes.esportistes.get(numeroEsportista).setCognom2(segonCognomEsportista); //Canviar el segon cognom de l'esportista
					System.out.println("Nom i cognoms de l'esportista canviats");
					break;
				
				case "B":
					
					char sexeEsportista = Support.EstablirSexeEsportista();
					LocalDate dataNaixementLDEsportista = Support.EstablirDataNaixementEsportista();
					
					DadesObjectes.esportistes.get(numeroEsportista).setDataNaixement(dataNaixementLDEsportista); //Canviar data naixement esportista
					DadesObjectes.esportistes.get(numeroEsportista).setSexe(sexeEsportista);//Canviar sexe esportista
					break;
					
				case "C":
					
					String clubEsportista = Support.EstablirClubEsportista();
					String codiFederatEsportista = Support.EstablirCodiFederatEsportista();
					
					DadesObjectes.esportistes.get(numeroEsportista).setClub(clubEsportista); //Canviar club esportista
					DadesObjectes.esportistes.get(numeroEsportista).setCodiFederat(codiFederatEsportista); //Canviar codi federat esportista
					break;
					
				case "D":
					
					String dniEsportistaD = Support.EstablirDniEsportista();
					boolean dniRepetit = Support.ComprovarDniRepetit(dniEsportistaD, DadesObjectes.esportistes);
					if (dniRepetit) {
						System.out.println("El dni esta repetit, tornant al menú");
						return;
					}
					DadesObjectes.esportistes.get(numeroEsportista).setDni(dniEsportistaD);
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
	
	/**
	 * Modificar un club a través del seu codi
	 */
	public static void ModificacioClub() {
		
		int numeroClub = -1;
		int codiClub = 0;
		
		System.out.print("Posa el codi del club que vols modificar: ");
		while (!lector.hasNextInt()) {
			System.out.println("El codi del club ha de ser un numero");
			lector.nextLine();
		}
		codiClub = lector.nextInt();
		lector.nextLine();
		
		numeroClub = Support.MostrarDadesClubIRetornarPosicio(codiClub, DadesObjectes.clubs); //Retorna la posicio
		//Mostrar les dades dels clubs
		if (numeroClub == -1) {
			System.out.println("Codi del club no trobat, tornant al menu: ");
		}
		
		else {
			
			System.out.println("Quines dades vols modificar? ");
			
			boolean sortirModificarEsportistes = false;
			
			while (!sortirModificarEsportistes) {
				
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
						DadesObjectes.clubs.get(numeroClub).setNom(nomClub); //Canviar el nom del club
	
						System.out.println("Nom del club cambiat");
						break;
					
					case "B": //Poblacio club
						 
						System.out.print("Posa la poblacio del club: ");
						String poblacioClub = lector.nextLine();
						DadesObjectes.clubs.get(numeroClub).setNom(poblacioClub); //Canviar el nom del club
	
						System.out.println("Poblacio del club cambiat");
						break;
						
					case "C": //Codi postal
						
						System.out.println("Posa el codi postal de la poblacio");
						int codiPostal = Support.EstablirCodiPostalClub();
						DadesObjectes.clubs.get(numeroClub).setCodiPostal(codiPostal);
						System.out.println("Codi postal del club cambiat");
						break;
						
					case "D": //Any fundacio
						LocalDate anyFundacioLD = Support.EstablirAnyFundacioClub();
						DadesObjectes.clubs.get(numeroClub).setAnyFundacio(anyFundacioLD);
						System.out.println("Fundacio del club cambiat");
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
	
	/*
	 * Modificar una prova a través del seu codi
	 */
	public static void ModificacioProva() {
		
		//String nom, int any, ArrayList<Participants> participants, int codiProva
		int numeroProva = -1;
		int codiProva = 0;
		
		System.out.print("Posa el codi de la prova a modificar: ");
		while (!lector.hasNextInt()) {
			System.out.println("El codi de la prova ha de ser un numero absolut");
			lector.nextLine();
		}
		codiProva = lector.nextInt();
		lector.nextLine();
		
		numeroProva = Support.ComprovarCodiProvaExistent(codiProva, DadesObjectes.proves); //Retorna la posicio //HABIA POSAT Support.ComprovarCodiProvaExistent(codiProva, DadesObjectes.proves);
		//Mostrar les dades dels clubs
		if (numeroProva == -1) {
			System.out.println("Codi de la prova no trobada");
		}
		
		else {
			
			System.out.println("Quines dades vols modificar? ");
			
			boolean sortirModificarEsportistes = false;
			
			while (!sortirModificarEsportistes) {
				
				System.out.println("A - Modificar nom prova");
				System.out.println("B - Modificar any prova");
				System.out.println("S - Sortir");
				
				String opcio = lector.nextLine();
				
				switch (opcio) {
				
					case "A": //Nom Prova	 
						System.out.print("Posa el nom de la prova ");
						String nomProva = lector.nextLine();
						DadesObjectes.proves.get(numeroProva).setNom(nomProva); //Canviar el nom de la prova
	
						System.out.println("Nom de la prova cambiat");
						break;
					
					case "B": //Any Prova
						System.out.print("Posa l'any de la prova: ");
						int anyProva = Support.EstablirAnyProva();
						DadesObjectes.proves.get(numeroProva).setAny(anyProva);; //Canviar el nom del club
	
						System.out.println("Any de la prova cambiada");
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

}
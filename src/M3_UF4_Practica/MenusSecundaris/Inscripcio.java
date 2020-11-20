package M3_UF4_Practica.MenusSecundaris;
import M3_UF4_Practica.*;
import M3_UF4_Practica.MenusSecundaris.*;

import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import M3_UF4_Practica.Objectes.Esportistes;
import M3_UF4_Practica.Objectes.Participants;
import M3_UF4_Practica.Objectes.Proves;

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
			
		String dniEsportista = "";
		int dniEsportistaPosicio = -1;
		while (dniEsportistaPosicio == -1) { //Comprova que el dni existeixi
			System.out.println("Posa el dni del esportista: ");
			dniEsportista = lector.nextLine();
			dniEsportistaPosicio = Support.ComprovarDniExistent(dniEsportista, DadesObjectes.esportistes);
			if (dniEsportistaPosicio == -1) {
				System.out.println("Dni no existent");
			}
		}
		//Esportistes esportista = DadesObjectes.esportistes.get(dniEsportistaPosicio);
		
		//Establir les dades del participant a través de la posicio del dni de l'esportista (index en l'array)
		String nomParticipant = DadesObjectes.esportistes.get(dniEsportistaPosicio).getNom();
		String cognom1Participant = DadesObjectes.esportistes.get(dniEsportistaPosicio).getCognom1();
		String cognom2Participant = DadesObjectes.esportistes.get(dniEsportistaPosicio).getCognom2();
		char sexeParticipant = DadesObjectes.esportistes.get(dniEsportistaPosicio).getSexe();
		LocalDate dataNaixementLDEsportista = DadesObjectes.esportistes.get(dniEsportistaPosicio).getDataNaixement();
		String dniParticipant = DadesObjectes.esportistes.get(dniEsportistaPosicio).getDni();
		String nomClubParticipant = DadesObjectes.esportistes.get(dniEsportistaPosicio).getClub();
		String codiFederatParticipant = DadesObjectes.esportistes.get(dniEsportistaPosicio).getCodiFederat();
		String categoriaEsportista = Support.RetornarAbsolutVetera(dataNaixementLDEsportista); //Establir la categoria: "Absolut" o "Vetera"
		Duration tempsProvaParticipant = Duration.ofHours(0).plus(Duration.ofMinutes(0).plus(Duration.ofSeconds(0)));
		
		
		int  dorsalParticipant = 0;
		boolean tipusProvaSeleccionada = false;
		
		while (!tipusProvaSeleccionada) {
			
			System.out.println("Selecciona el tipus de prova en el que vols afegir el participant");
			System.out.println("A - Marato");
			System.out.println("B - Marxa Popular");
			System.out.println("C - Prova10000");
			
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
				case "A": //Afegeix el participant en marato						
					int posicioMarato = Support2.RetornarPosicioMarato(); //Busca el codi de la prova en marato
					boolean dniRepetitMarato = Support2.ComprovarDniRepetitParticipants(dniEsportista, DadesObjectes.marato.get(posicioMarato).getParticipantsMarato());
					if (dniRepetitMarato) {
						System.out.println("El participant ja existeix en la marato, tornant al menu");
						return;
					}
					dorsalParticipant = Support.RetornarDorsalParticipants(DadesObjectes.marato.get(posicioMarato).getParticipantsMarato()); //Agafar els participants de la prova codiProvaExistent
					//Revisa el seu dorsal i assigna un de nou
					
					if (DadesObjectes.marato.get(posicioMarato).getParticipantsMarato().size() >= 150) { //Maxim 150 participants per Marato
						System.out.println("Maxim de participants assolits, tornant al menu");
						return;
					}
					DadesObjectes.marato.get(posicioMarato).afegirParticipantMarato(nomParticipant, cognom1Participant, cognom2Participant, sexeParticipant, 
							dataNaixementLDEsportista, dniParticipant, nomClubParticipant, codiFederatParticipant, categoriaEsportista, dorsalParticipant, tempsProvaParticipant);
					tipusProvaSeleccionada = true;
					System.out.println("Participant afegit");
					break;
					
				case "B": //Afegeix el participant en marxa popular
					if (DadesObjectes.esportistes.get(dniEsportistaPosicio).getCodiFederat() != null) {
						System.out.println("L'esportista està federat, no pot inscriure's a la marxa popular si esta federat");
						System.out.println("Tornant al menu");
						return;						
					}
					
					int posicioMarxaPopular = Support2.RetornarPosicioMarxaPopular();
					boolean dniRepetitMarxaPopular = Support2.ComprovarDniRepetitParticipants(dniEsportista, DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular());
					if (dniRepetitMarxaPopular) {
						System.out.println("El participant ja existeix en la marxa popular, tornant al menu");
						return;
					}
					dorsalParticipant = Support.RetornarDorsalParticipants(DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular()); //Agafar els participants de la prova codiProvaExistent
					//Revisa el seu dorsal i assigna un de nou
					
					DadesObjectes.marxaPopular.get(posicioMarxaPopular).afegirParticipantMarxaPopular(nomParticipant, cognom1Participant, cognom2Participant, sexeParticipant, 
							dataNaixementLDEsportista, dniParticipant, nomClubParticipant, codiFederatParticipant, categoriaEsportista, dorsalParticipant, tempsProvaParticipant);
					tipusProvaSeleccionada = true;
					System.out.println("Participant afegit");
					break;
					
				case "C": //Afegir participant prova 10000
					int posicioProva10000 = Support2.RetornarPosicioProva10000();
					boolean dniRepetitProva10000 = Support2.ComprovarDniRepetitParticipants(dniEsportista, DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000());
					if (dniRepetitProva10000) {
						System.out.println("El participant ja existeix en la prova 10000, tornant al menu");
						return;
					}
					dorsalParticipant = Support.RetornarDorsalParticipants(DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000()); //Agafar els participants de la prova codiProvaExistent
					//Revisa el seu dorsal i assigna un de nou
					
					if (DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000().size() >= 50) { //Maxim 50 participants per Prova 10000
						System.out.println("Maxim de participants assolits, tornant al menu");
						return;
					}
					
					DadesObjectes.prova10000.get(posicioProva10000).afegirParticipantProva10000(nomParticipant, cognom1Participant, cognom2Participant, sexeParticipant, 
							dataNaixementLDEsportista, dniParticipant, nomClubParticipant, codiFederatParticipant, categoriaEsportista, dorsalParticipant, tempsProvaParticipant);
					tipusProvaSeleccionada = true;
					System.out.println("Participant afegit");
					break;
					
				default:
					System.out.println("Opcio incorrecta");
					break;

			}
			
		}
	
	}
	
	/**
	 * Eliminar un esportiste de una prova
	 */
	public static void AnularInscripcio() {
		
		int dniEsportistaExistent = -1;
		String dniEsportista = "";
		
		boolean tipusProvaSeleccionada = false;
		
		while (!tipusProvaSeleccionada) {
			
			System.out.println("Selecciona el tipus de prova que vols esborrar");
			System.out.println("A - Marato");
			System.out.println("B - Marxa Popular");
			System.out.println("C - Prova10000");
			System.out.println("S - Sortir");
			
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
				case "A": //Elimina el participant de la marato
					
					int posicioMarato = Support2.RetornarPosicioMarato(); //Busca el codi de la prova en marato
					
					int posicioParticipantMarato = -1;
					
					while (posicioParticipantMarato == -1) { //Comprovar l'existencia del dni
						System.out.println("Posa el dni del esportista del que vols anular la inscripcio: ");
						dniEsportista = lector.nextLine();
						posicioParticipantMarato = Support2.ComprovarDniParticipantExistent(dniEsportista, DadesObjectes.marato.get(posicioMarato).getParticipantsMarato()); //Revisar si el dni existeix en la llista especificada
						if (posicioParticipantMarato == -1) {
							System.out.println("DNI no trobat");
						}
					}
					
					DadesObjectes.marato.get(posicioMarato).esborrarParticipantMarato(posicioParticipantMarato);
					tipusProvaSeleccionada = true;
					System.out.println("Participant esborrat");
					break;
					
				case "B": //Elimina el participant de la marxa popular
					int posicioMarxaPopular = Support2.RetornarPosicioMarxaPopular();
					
					int posicioParticipantMarxaPopular = -1;
					
					while (posicioParticipantMarxaPopular == -1) { //Comprovar l'existencia del dni
						System.out.println("Posa el dni del esportista del que vols anular la inscripcio: ");
						dniEsportista = lector.nextLine();
						posicioParticipantMarxaPopular = Support2.ComprovarDniParticipantExistent(dniEsportista, DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular()); //Revisar si el dni existeix en la llista especificada
						if (posicioParticipantMarxaPopular == -1) {
							System.out.println("DNI no trobat");
						}
					}
					DadesObjectes.marxaPopular.get(posicioMarxaPopular).esborrarParticipantMarxaPopular(posicioParticipantMarxaPopular);
					tipusProvaSeleccionada = true;
					System.out.println("Participant esborrat");
					break;
					
				case "C":
					int posicioProva10000 = Support2.RetornarPosicioProva10000();
					
					int posicioParticipantProva10000 = -1;
					
					while (posicioParticipantProva10000 == -1) { //Comprovar l'existencia del dni
						System.out.println("Posa el dni del esportista del que vols anular la inscripcio: ");
						dniEsportista = lector.nextLine();
						posicioParticipantProva10000 = Support2.ComprovarDniParticipantExistent(dniEsportista, DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000()); //Revisar si el dni existeix en la llista especificada
						if (posicioParticipantProva10000 == -1) {
							System.out.println("DNI no trobat");
						}
					}
					DadesObjectes.prova10000.get(posicioProva10000).esborrarParticipantProva10000(posicioParticipantProva10000);
					tipusProvaSeleccionada = true;
					System.out.println("Participant esborrat");
					break;
					
				default:
					System.out.println("Opcio incorrecta");
					break;

			}
			
		}
		
	}
	
	public static void LlistarInscripcions() {
		
		boolean opcioSortir = false;
		
		while (!opcioSortir) {
			
			System.out.println("Que vols llistar?");
			System.out.println("A - Llistar participants de una Marato");
			System.out.println("B - Llistar participants de una Marxa popular");
			System.out.println("C - Llistar participants de una Prova10000");
			System.out.println("S - Sortir");
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
				case "A":
					
					int posicioMarato = Support2.RetornarPosicioMarato(); //Posa codi de la marato, retorna la posicio de la marato
					
					System.out.println("*******************************************************************************");
					System.out.println("*****************************INSCRIPCIONS MARATO******************************");
					System.out.println("*******************************************************************************");
					System.out.println("");
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("Nom Marato: "+DadesObjectes.marato.get(posicioMarato).getNom());
					System.out.println("Any Marato: "+DadesObjectes.marato.get(posicioMarato).getAny());
					System.out.println("Numero participants: "+DadesObjectes.marato.get(posicioMarato).getParticipantsMarato().size());
					System.out.println("Codi Prova Marato: "+DadesObjectes.marato.get(posicioMarato).getCodiProva());
					System.out.println("Data: "+DadesObjectes.marato.get(posicioMarato).getData());
					System.out.println("Hora Sortida: "+DadesObjectes.marato.get(posicioMarato).getHoraSortida());
					System.out.println("-------------------------------------------------------------------------------");
					
					System.out.println("Participant	Dni		Categoria	h:m:s");
					
					for (int i = 0; i < DadesObjectes.marato.get(posicioMarato).getParticipantsMarato().size(); i++) {
						
						long segons = DadesObjectes.marato.get(posicioMarato).getParticipantsMarato().get(i).getTempsProva().getSeconds();
						int horesInt = (int) (segons/3600);
						int minutsInt = (int) (segons%3600)/60;
						int segonsInt = (int) ((segons%3600)%60);
						
						System.out.print(DadesObjectes.marato.get(posicioMarato).getParticipantsMarato().get(i).getNom());
						System.out.print("		"+DadesObjectes.marato.get(posicioMarato).getParticipantsMarato().get(i).getDni());
						System.out.print("	"+DadesObjectes.marato.get(posicioMarato).getParticipantsMarato().get(i).getCategoria()+"		"+horesInt+":"+minutsInt+":"+segonsInt);
						
						System.out.println();
					}
					
					break;
				
				case "B":
					int posicioMarxaPopular = Support2.RetornarPosicioMarxaPopular(); //Posa codi de la MarxaPopular, retorna la posicio de la MarxaPopular
					
					System.out.println("*******************************************************************************");
					System.out.println("*************************INSCRIPCIONS MARXA POPULAR****************************");
					System.out.println("*******************************************************************************");
					System.out.println("");
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("Nom Marxa Popular: "+DadesObjectes.marxaPopular.get(posicioMarxaPopular).getNom());
					System.out.println("Any Marxa Popular: "+DadesObjectes.marxaPopular.get(posicioMarxaPopular).getAny());
					System.out.println("Numero participants: "+DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular().size());
					System.out.println("Codi Prova Marxa Popular: "+DadesObjectes.marxaPopular.get(posicioMarxaPopular).getCodiProva());
					System.out.println("Data: "+DadesObjectes.marxaPopular.get(posicioMarxaPopular).getData());
					System.out.println("Data Sortida: "+DadesObjectes.marxaPopular.get(posicioMarxaPopular).getDataSortida().getHour()+":"
					+DadesObjectes.marxaPopular.get(posicioMarxaPopular).getDataSortida().getMinute());
					System.out.println("-------------------------------------------------------------------------------");
					
					System.out.println("Participant	Dni		Categoria	h:m:s");
					
					for (int i = 0; i < DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular().size(); i++) {
						
						long segons = DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular().get(i).getTempsProva().getSeconds();
						int horesInt = (int) (segons/3600);
						int minutsInt = (int) (segons%3600)/60;
						int segonsInt = (int) ((segons%3600)%60);
						
						System.out.print(DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular().get(i).getNom());
						System.out.print("		"+DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular().get(i).getDni());
						System.out.print("	"+DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular().get(i).getCategoria()+"		"+horesInt+":"+minutsInt+":"+segonsInt);
						
						System.out.println();
					}
					
					break;
					
				case "C":
					
					int posicioProva10000 = Support2.RetornarPosicioProva10000(); //Posa codi de la Prova10000, retorna la posicio de la Prova10000
					
					System.out.println("*******************************************************************************");
					System.out.println("***************************INSCRIPCIONS PROVA 10000****************************");
					System.out.println("*******************************************************************************");
					System.out.println("");
					System.out.println("-------------------------------------------------------------------------------");
					System.out.println("Nom Marato: "+DadesObjectes.prova10000.get(posicioProva10000).getNom());
					System.out.println("Any Marato: "+DadesObjectes.prova10000.get(posicioProva10000).getAny());
					System.out.println("Numero participants: "+DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000().size());
					System.out.println("Codi Prova Marato: "+DadesObjectes.prova10000.get(posicioProva10000).getCodiProva());
					System.out.println("Data: "+DadesObjectes.prova10000.get(posicioProva10000).getData());
					System.out.println("Club Anfitrio: "+DadesObjectes.prova10000.get(posicioProva10000).getClubAnfitrio());
					System.out.println("-------------------------------------------------------------------------------");
					
					System.out.println("Participant	Dni		Categoria	h:m:s");
					
					for (int i = 0; i < DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000().size(); i++) {
						
						long segons = DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000().get(i).getTempsProva().getSeconds();
						int horesInt = (int) (segons/3600);
						int minutsInt = (int) (segons%3600)/60;
						int segonsInt = (int) ((segons%3600)%60);
						
						System.out.print(DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000().get(i).getNom());
						System.out.print("		"+DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000().get(i).getDni());
						System.out.print("	"+DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000().get(i).getCategoria()+"		"+horesInt+":"+minutsInt+":"+segonsInt);
						
						System.out.println("");
						
					}
					
					break;
				
				case "S":
					opcioSortir = true;
					break;
					
				default:
					System.out.println("Opcio incorrecte");
					break;
			
			}	
		}
	}
	
}
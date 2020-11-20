package M3_UF4_Practica.MenusSecundaris;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import M3_UF4_Practica.DadesObjectes;
import M3_UF4_Practica.Support;
import M3_UF4_Practica.Support2;
import M3_UF4_Practica.Objectes.Participants;

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
			System.out.println("1 - Entrada Temps Prova (Assignar hora i dia inici): "); //Introduir codi prova i entrar la hora d'inici d'aquesta
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
		
		boolean sortirTempsProva = false;
		
		while (!sortirTempsProva) {
			
			System.out.println("Posa el tipus de prova");
			System.out.println("A - Entrada temps inici de una Marato");
			System.out.println("B - Entrada temps inici de una Marxa Popular");
			System.out.println("C - Entrada temps inici de una Prova10000");
			System.out.println("S - Sortir");
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
				case "A": //Marato
					int posicioMarato = Support2.RetornarPosicioMarato();
					
					LocalDateTime horaSortidaMarato = Support2.EstablirHoraSortidaProva(); //Retorna un LocalDateTime
					LocalDate dataMarato = LocalDate.of(horaSortidaMarato.getDayOfYear(), horaSortidaMarato.getMonth(), horaSortidaMarato.getDayOfMonth());
					DadesObjectes.marato.get(posicioMarato).setData(dataMarato);
					DadesObjectes.marato.get(posicioMarato).setHoraSortida(horaSortidaMarato);
					System.out.println("Valors temps de Marato cambiats");
					break;
				
				case "B": //Marxa Popular
					int posicioMarxaPopular = Support2.RetornarPosicioMarxaPopular();
					LocalDateTime horaSortidaMarxaPopular = Support2.EstablirHoraSortidaProva(); //Retorna un LocalDateTime
					LocalDate dataMarxaPopular = LocalDate.of(horaSortidaMarxaPopular.getDayOfYear(), horaSortidaMarxaPopular.getMonth(), horaSortidaMarxaPopular.getDayOfMonth());
					DadesObjectes.marxaPopular.get(posicioMarxaPopular).setData(dataMarxaPopular);
					DadesObjectes.marxaPopular.get(posicioMarxaPopular).setDataSortida(horaSortidaMarxaPopular);
					System.out.println("Valors temps de Marxa Popular cambiats");
					break;
					
				case "C": //Prova 10000
					int posicioProva10000 = Support2.RetornarPosicioProva10000();
					LocalDateTime horaSortidaProva10000 = Support2.EstablirHoraSortidaProva(); //Retorna un LocalDateTime
					LocalDate dataProva10000 = LocalDate.of(horaSortidaProva10000.getDayOfYear(), horaSortidaProva10000.getMonth(), horaSortidaProva10000.getDayOfMonth());
					DadesObjectes.prova10000.get(posicioProva10000).setData(dataProva10000);
					DadesObjectes.prova10000.get(posicioProva10000).setDataSortida(horaSortidaProva10000);
					System.out.println("Valors temps de Prova 10000 cambiats");
					break;
				
				case "S":
					sortirTempsProva = true;
					break;
					
				default:
					break;
			}
		}
		
	}
	
	/**
	 * Estableix el temps del participant
	 */
	public static void EntradaTempsArribadaParticipants() {
		
		boolean sortirTempsProva = false;
		
		while (!sortirTempsProva) {
			
			System.out.println("Posa el tipus de prova");
			System.out.println("A - Entrada temps de un participant de una Marato");
			System.out.println("B - Entrada temps de un participant de una Marxa Popular");
			System.out.println("C - Entrada temps de un participant de una Prova10000");
			System.out.println("S - Sortir");
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
				case "A": //Marato Prova
					int posicioMarato = Support2.RetornarPosicioMarato();
					int posicioParticipantMarato = Support2.ComprovarExistenciaDniIRetornarloMarato(DadesObjectes.marato.get(posicioMarato).getParticipantsMarato());
					Duration tempsParticipantMarato = Support2.EstablirTempsProvaParticipant();
					DadesObjectes.marato.get(posicioMarato).getParticipantsMarato().get(posicioParticipantMarato).setTempsProva(tempsParticipantMarato);
					System.out.println("Temps establert");
					break;
				
				case "B": //Marxa Popular
					int posicioMarxaPopular = Support2.RetornarPosicioMarxaPopular();
					int posicioParticipantMarxaPopular = Support2.ComprovarExistenciaDniIRetornarloMarato(DadesObjectes.marato.get(posicioMarxaPopular).getParticipantsMarato());
					Duration tempsParticipantMarxaPopular = Support2.EstablirTempsProvaParticipant();
					DadesObjectes.marato.get(posicioMarxaPopular).getParticipantsMarato().get(posicioParticipantMarxaPopular).setTempsProva(tempsParticipantMarxaPopular);
					System.out.println("Temps establert");
					break;
					
				case "C": //Prova 10000
					int posicioProva10000 = Support2.RetornarPosicioProva10000();
					int posicioParticipantProva10000 = Support2.ComprovarExistenciaDniIRetornarloMarato(DadesObjectes.marato.get(posicioProva10000).getParticipantsMarato());
					Duration tempsParticipantProva10000 = Support2.EstablirTempsProvaParticipant();
					DadesObjectes.marato.get(posicioProva10000).getParticipantsMarato().get(posicioParticipantProva10000).setTempsProva(tempsParticipantProva10000);
					System.out.println("Temps establert");
					break;
				
				case "S":
					sortirTempsProva = true;
					break;
					
				default:
					break;
			}
		}
		
	}
	
	/**
	 * Classificar els participant de una prova seleccionada ordenats per el temps total
	 */
	public static void ClassificacioTotal() {
		
		boolean sortirClassificacioTemps = false;
		
		while (!sortirClassificacioTemps) {
			
			System.out.println("Posa el tipus de prova");
			System.out.println("A - Classificacio participants de una Marato per temps");
			System.out.println("B - Classificacio participants de una Marxa popular per temps");
			System.out.println("C - Classificacio participants de una Prova10000 per temps");
			System.out.println("S - Sortir");
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
			case "A": //MARATO
				int posicioMarato = Support2.RetornarPosicioMarato(); //Posa codi de la marato, retorna la posicio de la marato
				ArrayList<Participants> participantsLlistarMaratoTemps = new ArrayList<Participants>();
				participantsLlistarMaratoTemps = DadesObjectes.marato.get(posicioMarato).getParticipantsMarato();
				participantsLlistarMaratoTemps.sort(new Support.CompararTemps());
				System.out.println("********************************CLASSIFICACIO MARATO PARTICIPANTS PER TEMPS********************************");
				System.out.println("Posicio	Nom	Cognom1		Cognom2	Sexe	dataNaixement	dni		club	CodiFederat	Categoria	Dorsal	TempsProva");
				for (int i = 0; i < participantsLlistarMaratoTemps.size(); i++) {
					
					long segons = participantsLlistarMaratoTemps.get(i).getTempsProva().getSeconds();
					int horesInt = (int) (segons/3600);
					int minutsInt = (int) (segons%3600)/60;
					int segonsInt = (int) ((segons%3600)%60);
					
					System.out.println((i+1)+"	"+participantsLlistarMaratoTemps.get(i).getNom()+"	"+participantsLlistarMaratoTemps.get(i).getCognom1()+"		"
					+participantsLlistarMaratoTemps.get(i).getCognom2()+"	"+participantsLlistarMaratoTemps.get(i).getSexe()+"	"+participantsLlistarMaratoTemps.get(i).getDataNaixement()
					+"	"+participantsLlistarMaratoTemps.get(i).getDni()+"	"+participantsLlistarMaratoTemps.get(i).getClub()+"		"+participantsLlistarMaratoTemps.get(i).getCodiFederat()
					+"	"+participantsLlistarMaratoTemps.get(i).getCategoria()+"	"+participantsLlistarMaratoTemps.get(i).getDorsal()+"	"+horesInt+":"+minutsInt+":"+segonsInt);
					
				}
				System.out.println("*************************************************************************************");
				break;
			
			case "B": //MARXA POPULAR
				int posicioMarxaPopular = Support2.RetornarPosicioMarxaPopular(); //Posa codi de la MarxaPopular, retorna la posicio de la MarxaPopular
				ArrayList<Participants> participantsLlistarMarxaPopularTemps = new ArrayList<Participants>();
				participantsLlistarMarxaPopularTemps = DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular();
				participantsLlistarMarxaPopularTemps.sort(new Support.CompararTemps());
				System.out.println("********************************CLASSIFICACIO MARXA POPULAR PARTICIPANTS PER TEMPS********************************");
				System.out.println("Nom	Cognom1		Cognom2	Sexe	dataNaixement	dni	Categoria	Dorsal	TempsProva");
				for (int i = 0; i < participantsLlistarMarxaPopularTemps.size(); i++) {
					
					long segons = participantsLlistarMarxaPopularTemps.get(i).getTempsProva().getSeconds();
					int horesInt = (int) (segons/3600);
					int minutsInt = (int) (segons%3600)/60;
					int segonsInt = (int) ((segons%3600)%60);
					
					System.out.println(participantsLlistarMarxaPopularTemps.get(i).getNom()+"	"+participantsLlistarMarxaPopularTemps.get(i).getCognom1()+"		"
					+participantsLlistarMarxaPopularTemps.get(i).getCognom2()+"	"+participantsLlistarMarxaPopularTemps.get(i).getSexe()+"	"+
					participantsLlistarMarxaPopularTemps.get(i).getDataNaixement()+"	"+participantsLlistarMarxaPopularTemps.get(i).getDni()
					+"	"+participantsLlistarMarxaPopularTemps.get(i).getCategoria()+"	"+participantsLlistarMarxaPopularTemps.get(i).getDorsal()+"	"+horesInt+":"+minutsInt+":"+segonsInt);
					
				}
				System.out.println("*************************************************************************************");
				break;
				
			case "C": //Prova 10000
				int posicioProva10000 = Support2.RetornarPosicioProva10000(); //Posa codi de la Prova10000, retorna la posicio de la Prova10000
				ArrayList<Participants> participantsLlistarProva10000Temps = new ArrayList<Participants>();
				participantsLlistarProva10000Temps = DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000();
				participantsLlistarProva10000Temps.sort(new Support.CompararTemps());
				System.out.println("********************************CLASSIFICACIO PROVA10000 PARTICIPANTS PER TEMPS********************************");
				System.out.println("Nom	Cognom1		Cognom2	Sexe	dataNaixement	dni		club	CodiFederat	Categoria	Dorsal	TempsProva");
				for (int i = 0; i < participantsLlistarProva10000Temps.size(); i++) {
					
					long segons = participantsLlistarProva10000Temps.get(i).getTempsProva().getSeconds();
					int horesInt = (int) (segons/3600);
					int minutsInt = (int) (segons%3600)/60;
					int segonsInt = (int) ((segons%3600)%60);
					
					System.out.println(participantsLlistarProva10000Temps.get(i).getNom()+"	"+participantsLlistarProva10000Temps.get(i).getCognom1()+"		"
					+participantsLlistarProva10000Temps.get(i).getCognom2()+"	"+participantsLlistarProva10000Temps.get(i).getSexe()+"	"+participantsLlistarProva10000Temps.get(i).getDataNaixement()
					+"	"+participantsLlistarProva10000Temps.get(i).getDni()+"	"+participantsLlistarProva10000Temps.get(i).getClub()+"		"+participantsLlistarProva10000Temps.get(i).getCodiFederat()
					+"	"+participantsLlistarProva10000Temps.get(i).getCategoria()+"	"+participantsLlistarProva10000Temps.get(i).getDorsal()+"	"+horesInt+":"+minutsInt+":"+segonsInt);
					
				}
				System.out.println("*************************************************************************************");
				break;
				
			case "S":
				sortirClassificacioTemps = true;
				break;
				
			default:
				System.out.println("Opcio incorrecta");
				break;
			}
		}
	}
	
	/**
	 * Classificar els participant de una prova seleccionada ordenats per el sexe
	 */
	public static void ClassificacioSexe() {
		
		boolean sortirClassificacioSexe = false;
		
		while (!sortirClassificacioSexe) {
			
			System.out.println("Posa el tipus de prova");
			System.out.println("A - Classificacio participants de una Marato per sexe");
			System.out.println("B - Classificacio participants de una Marxa popular per sexe");
			System.out.println("C - Classificacio participants de una Prova10000 per sexe");
			System.out.println("S - Sortir");
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
			case "A": //MARATO
				int posicioMarato = Support2.RetornarPosicioMarato(); //Posa codi de la marato, retorna la posicio de la marato
				ArrayList<Participants> participantsLlistarMaratoSexe = new ArrayList<Participants>();
				participantsLlistarMaratoSexe = DadesObjectes.marato.get(posicioMarato).getParticipantsMarato();
				participantsLlistarMaratoSexe.sort(new Support.CompararSexe());
				System.out.println("********************************CLASSIFICACIO MARATO PARTICIPANTS PER SEXE********************************");
				System.out.println("Nom	Cognom1		Cognom2	Sexe	dataNaixement	dni		club	CodiFederat	Categoria	Dorsal	TempsProva");
				for (int i = 0; i < participantsLlistarMaratoSexe.size(); i++) {
					
					long segons = participantsLlistarMaratoSexe.get(i).getTempsProva().getSeconds();
					int horesInt = (int) (segons/3600);
					int minutsInt = (int) (segons%3600)/60;
					int segonsInt = (int) ((segons%3600)%60);
					
					System.out.println(participantsLlistarMaratoSexe.get(i).getNom()+"	"+participantsLlistarMaratoSexe.get(i).getCognom1()+"		"
					+participantsLlistarMaratoSexe.get(i).getCognom2()+"	"+participantsLlistarMaratoSexe.get(i).getSexe()+"	"+participantsLlistarMaratoSexe.get(i).getDataNaixement()
					+"	"+participantsLlistarMaratoSexe.get(i).getDni()+"	"+participantsLlistarMaratoSexe.get(i).getClub()+"		"+participantsLlistarMaratoSexe.get(i).getCodiFederat()
					+"	"+participantsLlistarMaratoSexe.get(i).getCategoria()+"	"+participantsLlistarMaratoSexe.get(i).getDorsal()+"	"+horesInt+":"+minutsInt+":"+segonsInt);
					
				}
				System.out.println("*************************************************************************************");
				break;
			
			case "B": //MARXA POPULAR
				int posicioMarxaPopular = Support2.RetornarPosicioMarxaPopular(); //Posa codi de la MarxaPopular, retorna la posicio de la MarxaPopular
				ArrayList<Participants> participantsLlistarMarxaPopularSexe = new ArrayList<Participants>();
				participantsLlistarMarxaPopularSexe = DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular();
				participantsLlistarMarxaPopularSexe.sort(new Support.CompararSexe());
				System.out.println("********************************CLASSIFICACIO MARXA POPULAR PARTICIPANTS PER SEXE********************************");
				System.out.println("Nom	Cognom1		Cognom2	Sexe	dataNaixement	dni	Categoria	Dorsal	TempsProva");
				for (int i = 0; i < participantsLlistarMarxaPopularSexe.size(); i++) {
					
					long segons = participantsLlistarMarxaPopularSexe.get(i).getTempsProva().getSeconds();
					int horesInt = (int) (segons/3600);
					int minutsInt = (int) (segons%3600)/60;
					int segonsInt = (int) ((segons%3600)%60);
					
					System.out.println(participantsLlistarMarxaPopularSexe.get(i).getNom()+"	"+participantsLlistarMarxaPopularSexe.get(i).getCognom1()+"		"
					+participantsLlistarMarxaPopularSexe.get(i).getCognom2()+"	"+participantsLlistarMarxaPopularSexe.get(i).getSexe()+"	"+
					participantsLlistarMarxaPopularSexe.get(i).getDataNaixement()+"	"+participantsLlistarMarxaPopularSexe.get(i).getDni()
					+"	"+participantsLlistarMarxaPopularSexe.get(i).getCategoria()+"	"+participantsLlistarMarxaPopularSexe.get(i).getDorsal()+"	"+horesInt+":"+minutsInt+":"+segonsInt);
					
				}
				System.out.println("*************************************************************************************");
				break;
				
			case "C": //PROVA10000
				int posicioProva10000 = Support2.RetornarPosicioProva10000(); //Posa codi de la Prova10000, retorna la posicio de la Prova10000
				ArrayList<Participants> participantsLlistarProva10000Sexe = new ArrayList<Participants>();
				participantsLlistarProva10000Sexe = DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000();
				participantsLlistarProva10000Sexe.sort(new Support.CompararCategoria());
				System.out.println("********************************CLASSIFICACIO PROVA10000 PARTICIPANTS PER SEXE********************************");
				System.out.println("Nom	Cognom1		Cognom2	Sexe	dataNaixement	dni		club	CodiFederat	Categoria	Dorsal	TempsProva");
				for (int i = 0; i < participantsLlistarProva10000Sexe.size(); i++) {
					
					long segons = participantsLlistarProva10000Sexe.get(i).getTempsProva().getSeconds();
					int horesInt = (int) (segons/3600);
					int minutsInt = (int) (segons%3600)/60;
					int segonsInt = (int) ((segons%3600)%60);
					
					System.out.println(participantsLlistarProva10000Sexe.get(i).getNom()+"	"+participantsLlistarProva10000Sexe.get(i).getCognom1()+"		"
					+participantsLlistarProva10000Sexe.get(i).getCognom2()+"	"+participantsLlistarProva10000Sexe.get(i).getSexe()+"	"+participantsLlistarProva10000Sexe.get(i).getDataNaixement()
					+"	"+participantsLlistarProva10000Sexe.get(i).getDni()+"	"+participantsLlistarProva10000Sexe.get(i).getClub()+"		"+participantsLlistarProva10000Sexe.get(i).getCodiFederat()
					+"	"+participantsLlistarProva10000Sexe.get(i).getCategoria()+"	"+participantsLlistarProva10000Sexe.get(i).getDorsal()+"	"+horesInt+":"+minutsInt+":"+segonsInt);
					
				}
				System.out.println("*************************************************************************************");
				break;
			case "S":
				sortirClassificacioSexe = true;
				break;
				
			default:
				System.out.println("Opcio incorrecta");
				break;
			
			}
			
		}
	}
	
	/**
	 * Classificar els participant de una prova seleccionada ordenats per la categoria
	 */
	public static void ClassificacioCategoria() {
		
		boolean sortirClassificacioCategoria = false;
		
		while (!sortirClassificacioCategoria) {
			
			System.out.println("Posa el tipus de prova");
			System.out.println("A - Classificacio participants de una Marato per categoria");
			System.out.println("B - Classificacio participants de una Marxa popular per categoria");
			System.out.println("C - Classificacio participants de una Prova10000 per categoria");
			System.out.println("S - Sortir");
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
			case "A": //MARATO
				int posicioMarato = Support2.RetornarPosicioMarato(); //Posa codi de la marato, retorna la posicio de la marato
				ArrayList<Participants> participantsLlistarMaratoCategoria = new ArrayList<Participants>();
				participantsLlistarMaratoCategoria = DadesObjectes.marato.get(posicioMarato).getParticipantsMarato();
				participantsLlistarMaratoCategoria.sort(new Support.CompararCategoria());
				System.out.println("********************************CLASSIFICACIO MARATO PARTICIPANTS PER CATEGORIA********************************");
				System.out.println("Nom	Cognom1		Cognom2	Sexe	dataNaixement	dni		Club Nom	CodiFederat	Categoria	Dorsal	TempsProva");
				for (int i = 0; i < participantsLlistarMaratoCategoria.size(); i++) {
					
					long segons = participantsLlistarMaratoCategoria.get(i).getTempsProva().getSeconds();
					int horesInt = (int) (segons/3600);
					int minutsInt = (int) (segons%3600)/60;
					int segonsInt = (int) ((segons%3600)%60);
					System.out.println(participantsLlistarMaratoCategoria.get(i).getNom()+"	"+participantsLlistarMaratoCategoria.get(i).getCognom1()+"	"
					+participantsLlistarMaratoCategoria.get(i).getCognom2()+"	"+participantsLlistarMaratoCategoria.get(i).getSexe()+"	"+participantsLlistarMaratoCategoria.get(i).getDataNaixement()
					+"	"+participantsLlistarMaratoCategoria.get(i).getDni()+"	"+participantsLlistarMaratoCategoria.get(i).getClub()+"		"+participantsLlistarMaratoCategoria.get(i).getCodiFederat()
					+"	"+participantsLlistarMaratoCategoria.get(i).getCategoria()+"	"+participantsLlistarMaratoCategoria.get(i).getDorsal()+"	"+horesInt+":"+minutsInt+":"+segonsInt);
					
				}
				System.out.println("*************************************************************************************");
				break;
			
			case "B": //MARXA POPULAR
				int posicioMarxaPopular = Support2.RetornarPosicioMarxaPopular(); //Posa codi de la MarxaPopular, retorna la posicio de la MarxaPopular
				ArrayList<Participants> participantsLlistarMarxaPopularCategoria = new ArrayList<Participants>();
				participantsLlistarMarxaPopularCategoria = DadesObjectes.marxaPopular.get(posicioMarxaPopular).getParticipantsMarxaPopular();
				participantsLlistarMarxaPopularCategoria.sort(new Support.CompararCategoria());
				System.out.println("********************************CLASSIFICACIO MARXA POPULAR PARTICIPANTS PER CATEGORIA********************************");
				System.out.println("Nom	Cognom1		Cognom2	Sexe	dataNaixement	dni	Categoria	Dorsal	TempsProva");
				for (int i = 0; i < participantsLlistarMarxaPopularCategoria.size(); i++) {
					
					long segons = participantsLlistarMarxaPopularCategoria.get(i).getTempsProva().getSeconds();
					int horesInt = (int) (segons/3600);
					int minutsInt = (int) (segons%3600)/60;
					int segonsInt = (int) ((segons%3600)%60);
					
					System.out.println(participantsLlistarMarxaPopularCategoria.get(i).getNom()+"	"+participantsLlistarMarxaPopularCategoria.get(i).getCognom1()+"		"
					+participantsLlistarMarxaPopularCategoria.get(i).getCognom2()+"	"+participantsLlistarMarxaPopularCategoria.get(i).getSexe()+"	"+
					participantsLlistarMarxaPopularCategoria.get(i).getDataNaixement()+"	"+participantsLlistarMarxaPopularCategoria.get(i).getDni()
					+"	"+participantsLlistarMarxaPopularCategoria.get(i).getCategoria()+"	"+participantsLlistarMarxaPopularCategoria.get(i).getDorsal()+"	"+horesInt+":"+minutsInt+":"+segonsInt);
					
				}
				System.out.println("*************************************************************************************");
				break;
				
			case "C": //PROVA 10000
				int posicioProva10000 = Support2.RetornarPosicioProva10000(); //Posa codi de la Prova10000, retorna la posicio de la Prova10000
				ArrayList<Participants> participantsLlistarProva10000Categoria = new ArrayList<Participants>();
				participantsLlistarProva10000Categoria = DadesObjectes.prova10000.get(posicioProva10000).getParticipantsProva10000();
				participantsLlistarProva10000Categoria.sort(new Support.CompararCategoria());
				System.out.println("********************************CLASSIFICACIO PROVA10000 PARTICIPANTS PER CATEGORIA********************************");
				System.out.println("Nom	Cognom1		Cognom2	Sexe	dataNaixement	dni		club	CodiFederat	Categoria	Dorsal	TempsProva");
				for (int i = 0; i < participantsLlistarProva10000Categoria.size(); i++) {
					
					long segons = participantsLlistarProva10000Categoria.get(i).getTempsProva().getSeconds();
					int horesInt = (int) (segons/3600);
					int minutsInt = (int) (segons%3600)/60;
					int segonsInt = (int) ((segons%3600)%60);
					
					System.out.println(participantsLlistarProva10000Categoria.get(i).getNom()+"	"+participantsLlistarProva10000Categoria.get(i).getCognom1()+"		"
					+participantsLlistarProva10000Categoria.get(i).getCognom2()+"	"+participantsLlistarProva10000Categoria.get(i).getSexe()+"	"+participantsLlistarProva10000Categoria.get(i).getDataNaixement()
					+"	"+participantsLlistarProva10000Categoria.get(i).getDni()+"	"+participantsLlistarProva10000Categoria.get(i).getClub()+"		"+participantsLlistarProva10000Categoria.get(i).getCodiFederat()
					+"	"+participantsLlistarProva10000Categoria.get(i).getCategoria()+"	"+participantsLlistarProva10000Categoria.get(i).getDorsal()+"	"+horesInt+":"+minutsInt+":"+segonsInt);
					
				}
				System.out.println("*************************************************************************************");
				break;
				
			case "S":
				sortirClassificacioCategoria = true;
				break;
				
			default:
				System.out.println("Opcio incorrecta");
				break;
			
			}
			
		}
	}

}

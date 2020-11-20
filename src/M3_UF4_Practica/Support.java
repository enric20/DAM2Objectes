package M3_UF4_Practica;
import M3_UF4_Practica.Objectes.Clubs;
import M3_UF4_Practica.Objectes.Esportistes;
import M3_UF4_Practica.Objectes.Participants;
import M3_UF4_Practica.Objectes.Proves;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Version 1.0
 * @author enric
 * Classe amb totes les funcions secundaries o repetibles
 * Mètodes de tercer nivell i quart nivell
 */
public class Support {
	
	static Scanner lector = new Scanner(System.in);

	/**
	 * Comprova la existencia de un texte dintre de un array
	 * @param array String[]
	 * @param numero String
	 * @return boolean
	 */
	public static boolean ComprovarExistenciaStringArray(String[] array, String texte) {
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i] != null) { //Evitem que el programa exploti si busca en un lloc on no hi ha dades
				if (array[i].equalsIgnoreCase(texte)) {
					return true;
				}
			}
			
			else {
				return false;
			}
			
		}
		
		return false;
	}
	
	/**
	 * Comprova la existencia de un numero INTEGER donat dintre de un array
	 * @param array int[]
	 * @param numero int
	 * @return boolean
	 */
	public static boolean ComprovarExistenciaIntArray(int[] array, int numero) {
		
		for (int i = 0; i < array.length; i++) {

			if (array[i] == numero) {
				return true;
			}
			
		}
		
		return false;
	}
	
	/**
	 * Estableix la categoria d'un participant segons la seva data de naixement
	 * @param naixement LocalDate
	 * @return "Vetera" o "Absolut"
	 */
	public static String RetornarAbsolutVetera(LocalDate naixement) {
		
		if (naixement.isBefore(LocalDate.of(1969, 12, 31))) { //Si la data naixement es abans del 1969 12 31
			return "Absolut";
		}
		else {
			return "Vetera";
		}
		
	}
	
	/**
	 * Comprova l'existencia d'un club en una llista a través del seu nom
	 * @param nomClub String
	 * @param dades ArrayList<Clubs>
	 * @return false o true si existeix el club
	 */
	public static boolean ComprovarExistenciaClubs(String nomClub, ArrayList<Clubs> dades) {
		
		for (int i = 0; i < dades.size(); i++) {
			if (nomClub.equals(dades.get(i).getNom())) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Cmoprova l'existencia del codi del club en una llista
	 * @param codiClub int
	 * @param dades ArrayList<Clubs>
	 * @return false o true
	 */
	public static boolean ComprovarExistenciaClubsPerCodiClub(int codiClub, ArrayList<Clubs> dades) {
		
		for (int i = 0; i < dades.size(); i++) {
			if (codiClub == dades.get(i).getCodiClub()) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Comprova que el codi federat de l'esportista existeix
	 * @param codiFederatEsportista String
	 * @param dades  ArrayList<Esportistes>
	 * @return false o true
	 */
	public static boolean ComprovarExistenciaCodiFederatEsportista(String codiFederatEsportista, ArrayList<Esportistes> dades) {
		
		for (int i = 0; i < dades.size(); i++) {
			if (codiFederatEsportista.equals(dades.get(i).getCodiFederat())) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Comprova si el codi introduit existeix i retorna la seva posicio
	 * @param codiProva int
	 * @param provaLlista ArrayList<Proves>
	 * @return int i (posicio de la prova) o -1 si no existeix
	 */
	public static int ComprovarCodiProvaExistent(int codiProva, ArrayList<Proves> provaLlista) {
		
		for (int i = 0; i < provaLlista.size(); i++) {
			if (codiProva == provaLlista.get(i).getCodiProva()) {
				return i;
			}
		}
		return -1; //Codi no existeix
	}
	
	/**
	 * Comprova si el codi introduit existeix, retorna un true o false
	 * @param codiProva int
	 * @param provaLlista ArrayList<Proves>
	 * @return false o true si existeix
	 */
	public static boolean ComprovarCodiProvaRepetit(int codiProva, ArrayList<Proves> provaLlista) {
		
		for (int i = 0; i < provaLlista.size(); i++) {
			if (codiProva == provaLlista.get(i).getCodiProva()) {
				return true;
			}
			
		}
		
		return false; //Codi no existeix
	}
	
	/**
	 * Comprova si el dni introduit esta en la llista introduida
	 * @param dni Stromg
	 * @param esportistesLlista ArrayList<Esportistes>
	 * @return int i Retorna la posicio
	 */
	public static int ComprovarDniExistent(String dni, ArrayList<Esportistes> esportistesLlista) {
		
		int posicio = 0;
		
		for (int i = 0; i < esportistesLlista.size(); i++) {
		
			if (dni.equals(esportistesLlista.get(i).getDni())) {
				return i;
			}
			
		}
		
		return -1; //No trobat
	}
	
	public static boolean ComprovarDniRepetit(String dni, ArrayList<Esportistes> esportistesLlista) {
		
		for (int i = 0; i < esportistesLlista.size(); i++) {
		
			if (dni.equals(esportistesLlista.get(i).getDni())) {
				return true;
			}
			
		}
		
		return false; //No trobat
	}
	
	// ------------------------------------- Mostrar Dades i retornar posicions -------------------------------------
	
	/**
	 * Mostra les dades del esportista i retorna la posicio actual
	 * @param dni String
	 * @param esportistesLlista ArrayList<Esportistes>
	 * @return i o -1 (-1 significa que no ha trobat el codi del club)
	 */
	public static int MostrarDadesEsportistaIRetornarPosicio (String dni, ArrayList<Esportistes> esportistesLlista) {
		
		for (int i = 0; i < esportistesLlista.size(); i++) {
		
			if (dni.equals(esportistesLlista.get(i).getDni())) {
				System.out.println("Nom: "+esportistesLlista.get(i).getNom());
				System.out.println("Cognoms: "+esportistesLlista.get(i).getCognom1()+"	"+esportistesLlista.get(i).getCognom2());
				System.out.println("DNI: "+esportistesLlista.get(i).getDni());
				System.out.println("Sexe: "+esportistesLlista.get(i).getSexe());
				System.out.println("Data Naixement: "+esportistesLlista.get(i).getDataNaixement());
				if (esportistesLlista.get(i).getClub() != null) { //Si esta federat mostra el texte seguent
					System.out.println("Club: "+esportistesLlista.get(i).getClub());
				}
				if (esportistesLlista.get(i).getCodiFederat() != null) {
					System.out.println("Codi Federat: "+esportistesLlista.get(i).getCodiFederat());
				}
				
				
				return i;
			}
			
		}
		
		return -1;
	}
	
	/**
	 * Mostra les dades del club i retorna la posicio actual
	 * @param codiClub int
	 * @param clubsLlista ArrayList<Clubs>
	 * @return i o -1 (-1 significa que no ha trobat el codi del club)
	 */
	public static int MostrarDadesClubIRetornarPosicio (int codiClub, ArrayList<Clubs> clubsLlista) {
		
		for (int i = 0; i < clubsLlista.size(); i++) {
		
			if (codiClub == clubsLlista.get(i).getCodiClub()) { //Codi club mirar si es igual al introduit
				System.out.println("Nom Club: "+clubsLlista.get(i).getNom());
				System.out.println("Poblacio: "+clubsLlista.get(i).getPoblacio());
				System.out.println("Codi Postal: "+clubsLlista.get(i).getCodiPostal());
				System.out.println("Any Fundacio: "+clubsLlista.get(i).getAnyFundacio());
				System.out.println("Codi Club: "+clubsLlista.get(i).getCodiClub());
				return i;
			}
			
		}
		
		return -1; //Codi club no trobat
	}
	
	// ---------------------------------------------- ESPORTISTA ----------------------------------------------
	
	/**
	 * Demana noms i cognoms
	 * @return String[] nomComplet (3 valors: nom, cognom, cognom2)
	 */
	public static String[] EstablirNomICognomsEsportista () {
		
		System.out.print("Nom de l'esportista: ");
		String nomEsportista = lector.nextLine();
		System.out.print("Primer cognom de l'esportista: ");
		String primerCognomEsportista = lector.nextLine();
		System.out.print("Segon cognom de l'esportista: ");
		String segonCognomEsportista = lector.nextLine();
		
		String[] nomComplet = new String[3];
		nomComplet[0] = nomEsportista;
		nomComplet[1] = primerCognomEsportista;
		nomComplet[2] = segonCognomEsportista;
		
		return nomComplet;
	}
	
	/**
	 * Establir sexe esportista, revisara que sigui correcte
	 * @return char sexeEsportista.charAt(0)
	 */
	public static char EstablirSexeEsportista () {
		
		String sexeEsportista = "";
		
		boolean sortir = false;
		do {
			sortir = true;
			System.out.print("Sexe del esportista ('H') ('D'): ");
			sexeEsportista = lector.nextLine();
			if (sexeEsportista.length() >= 1) {
				if (sexeEsportista.charAt(0) != 'H' && sexeEsportista.charAt(0) != 'D') {
					System.out.println("La primera lletra ha de ser una H o D mayuscula");
					sortir = false;
				}
			}
			else {
				System.out.println("Sexe no especificat");
				sortir = false;
			}
			
			
		} while (!sortir);
		
		return sexeEsportista.charAt(0);
	}
	
	/**
	 * Estableix la data naixement de l'esportista, revisa que estigui correcte
	 * @return LocalDate dataNaixementEsportista
	 */
	public static LocalDate EstablirDataNaixementEsportista () {
		
		System.out.println("Data naixement esportista: "); //DATA NAIXEMENT
		boolean dataNaixementCorrecte = false;
		LocalDate dataNaixementLDEsportista = LocalDate.of(1, 1, 1);
		
		while (!dataNaixementCorrecte) {
			
			System.out.println("Posa data naixement amb el següent format: ' DD-MM-YYYY ': ");
			String dataNaixement = lector.nextLine();
			String[] dataNaixementSplit = dataNaixement.split("-");
			
			if (dataNaixementSplit.length == 3) { //Mirar si hi ha 3 valors: dia-mes-any
				
				try { //Si un dels valors no es integer o la data naixement es pasa de rang, retornara un error
					int dia = Integer.parseInt(dataNaixementSplit[0]);
					int mes = Integer.parseInt(dataNaixementSplit[1]);
					int any = Integer.parseInt(dataNaixementSplit[2]);
					dataNaixementLDEsportista = LocalDate.of(any, mes, dia);
					dataNaixementCorrecte = true;
				}
				
				catch (Exception e) { //Mirara si els numeros son enters, si no ho son retorna un valor i torna a demanar data naixement
					System.out.println("Data naixement incorrecte, els valors no son numeros enters o sobrepassen la data");
				}
			}
			else {
				System.out.println("Format incorrecte, escriu un altre cop la data de naixement");
			}
		}
		
		return dataNaixementLDEsportista;
	}
	
	/**
	 * Establir dni esportista, si el dni es inferior a 9 retorna un error
	 * @return String dniEsportista
	 */
	public static String EstablirDniEsportista() {
		
		String dniEsportista = "";
		boolean dniRepetit = true;
		
		while (dniRepetit) {
			
			try {
				System.out.print("DNI de l'esportista: ");
				dniEsportista = lector.nextLine().substring(0, 9); //Si es superior a 9 el retalla
				dniRepetit = Support.ComprovarDniRepetit(dniEsportista, DadesObjectes.esportistes);
				if (dniRepetit == true) {
					System.out.println("El DNI esta repetit");
				}
			}
			
			catch (Exception e) { //Si la longitud del string es inferior a 9 retornara el següent error
				System.out.println("El DNI ha de ser un codi de 9 digits");
			}
			
		}
		
		return dniEsportista;
	}
	
	/**
	 * Establir Club Esportista, revisara que el club existeixi, si no existeix tornarà a preguntar
	 * @return String clubEsportista
	 */
	public static String EstablirClubEsportista() {
		
		String clubEsportista = "";
		boolean clubExisteix = false;
		while (!clubExisteix) { //Mentres el club no existeixi demanara el nom del club
			System.out.print("Club de l'esportista, buscarà si existeix: "); //Revisar si el club existeix
			clubEsportista = lector.nextLine();
			clubExisteix = Support.ComprovarExistenciaClubs(clubEsportista, DadesObjectes.clubs); //Retornara true si el club especificat existeix
			if (!clubExisteix) {
				System.out.println("No s'ha trobat el club");
			}
		}
		return clubEsportista;
	}
	
	/**
	 * Establir el codi federat esportista manualment, revisara que no estigui repetit
	 * @return String codiFederatEsportista
	 */
	public static String EstablirCodiFederatEsportista() {
		
		String codiFederatEsportista = "";
		boolean codiFederatRepetit = true;
		while (codiFederatRepetit) { //Mentres el codi federat estigui repetit
			System.out.print("Codi federat l'esportista: "); //Revisar si existeix un altre codiFederat
			codiFederatEsportista = lector.nextLine();
			codiFederatRepetit = Support.ComprovarExistenciaCodiFederatEsportista(codiFederatEsportista, //Codi federat, revisar
					DadesObjectes.esportistes); //Llistar a la cual revisar, retorna true si esta repetit
			if (codiFederatRepetit) {
				System.out.println("El codi federat esta repetit, posa un diferent");
			}
		}
		return codiFederatEsportista;
		
	}
	// ---------------------------------------------- CLUB ----------------------------------------------
	
	/**
	 * Establir el codi postal club manualment, revisara que sigui un numero superior a 0
	 * @return int codiPostalClub
	 */
	public static int EstablirCodiPostalClub() {
		
		boolean codiPostalComprovat = false;
		int codiPostalClub = 0;
		
		while (!codiPostalComprovat) {
			System.out.print("Codi Postal: ");
			while (!lector.hasNextInt()) {
				System.out.println("Ha de ser un numero");
				lector.nextLine();
			}
			codiPostalClub = lector.nextInt();
			lector.nextLine();
			if (codiPostalClub > 0) {
				codiPostalComprovat = true;
			}
			else {
				System.out.println("El codi postal no pot ser un numero negatiu");
			}
			
		}
		
		return codiPostalClub;
	}
	
	/**
	 * Estableix l'any de la prova (en localdate), comprovara que el format sigui correcte i que no es pasi de rang
	 * @return LocalDate anyFundacioLDClub
	 */
	public static LocalDate EstablirAnyFundacioClub() {
		
		boolean anyFundacioCorrecte = false;
		LocalDate anyFundacioLDClub = LocalDate.of(1, 1, 1);
		
		while (!anyFundacioCorrecte) {
			System.out.println("Posa la data amb el següent format: ' DD-MM-YYYY ': ");
			String anyFundacio = lector.nextLine();
			String[] anyFundacioSplit = anyFundacio.split("-");
			if (anyFundacioSplit.length == 3) { //Mirar si hi ha 3 valors: dia-mes-any
				
				try { //Si un dels valors no es integer o l'any fundacio club es pasa de rang, retornara un error
					int dia = Integer.parseInt(anyFundacioSplit[0]);
					int mes = Integer.parseInt(anyFundacioSplit[1]);
					int any = Integer.parseInt(anyFundacioSplit[2]);
					anyFundacioLDClub = LocalDate.of(any, mes, dia);
					anyFundacioCorrecte = true;
				}
				
				catch (Exception e) { //Mirara si els numeros son enters, si no ho son torna a demanar any fundacio club
					System.out.println("Els valors no son numeros enters o sobrepassen la data");
				}
			}
			else {
				System.out.println("Format incorrecte, escriu un altre cop la data");
			}
		}
		
		return anyFundacioLDClub;
	}
	
	/**
	 * Estebleix el codi del club, s'estableix manualment, comprovara que sigui un numero superior a 0 i no estigui repetit
	 * @return int codiClub
	 */
	public static int EstablirCodiClub() {
		
		boolean codiClubRepetit = true;
		int codiClub = 0;
		while (codiClubRepetit) { //Mentres el codi federat estigui repetit
			System.out.print("Codi del club: "); //Revisar si existeix un altre codiFederat
			while (!lector.hasNextInt()) {
				System.out.print("Codi del club ha de ser un numero: ");
				lector.nextLine();
			}
			codiClub = lector.nextInt();
			lector.nextLine();
			if (codiClub > 0) {
				codiClubRepetit = Support.ComprovarExistenciaClubsPerCodiClub(codiClub, DadesObjectes.clubs); //Codi club, revisar
				//Llistar a la cual revisar, retorna true si esta repetit
				if (codiClubRepetit) {
					System.out.println("El club esta repetit, posa un diferent");
				}
			}
			else {
				System.out.println("Codi club no pot ser un numero negatiu");
			}
		}
		
		return codiClub;
	}
	
	// ---------------------------------------------- PROVES ----------------------------------------------
	
	/**
	 * Estableix l'any de la prova, es posa manualment, comprovara que sigui un numero superior a 0
	 * @return int anyProva
	 */
	public static int EstablirAnyProva() {
		
		boolean anyProvaComprovat = false;
		int anyProva = 0;
		while (!anyProvaComprovat) {
			System.out.print("Posa l'any de la prova: ");
			while (!lector.hasNextInt()) {
				System.out.println("L'any ha de ser un numero: ");
				lector.nextLine();
			}
			
			anyProva = lector.nextInt();
			lector.nextLine();
			
			if (anyProva > 0) {
				anyProvaComprovat = true;
			}
			
			else {
				System.out.println("L'any de la prova no pot ser un numero negatiu");
			}
		}
		return anyProva;
	}
	
	/**
	 * Estableix el codi de prova
	 * @param anyProva int Es necessari saber l'any de la prova per a establir el codi de la prova
	 * @return int codiProva
	 */
	public static int EstablirCodiProva(int anyProva) {
		
		boolean codiProvaRepetit = true;
		
		int codiProva = 0;
		String codiProvaStr = anyProva+""+codiProva;
		
		while (codiProvaRepetit) { //Mentres el codi de la prova estigui repetit, incrementara el codi prova
			codiProva++; //Incrementa el numero si detecta un codiProva que esta repetit
			codiProvaStr = anyProva+""+codiProva;
			codiProvaRepetit = Support.ComprovarCodiProvaRepetit(Integer.parseInt(codiProvaStr), DadesObjectes.proves); //Comprovar si el codi prova establert esta repetit
		}
		/*
		String codiProvaStr = "";
		 //Millorar l'estetic del codi prova (Ex: 20210332, 20211892) AAAAPPPP (A = Any, P = Prova)
		if (codiProva > 1000) { //No afegir 0 
			codiProvaStr = anyProva+""+codiProva;
		}
		
		else if (codiProva > 100) { //Afegeix un 0
			codiProvaStr = anyProva+"0"+codiProva;
		}
		
		else if (codiProva > 10) { //Afegeix 2 0
			codiProvaStr = anyProva+"00"+codiProva;
		}
		
		else  { //Afegeix 3 0
			codiProvaStr = anyProva+"000"+codiProva;
		}
		
		codiProva = Integer.parseInt(codiProvaStr);
		*/
		codiProva = Integer.parseInt(codiProvaStr);
		return codiProva;
	}
	
	//-------------------------------------------INSCRIPCIONS-----------------------------------------
	
	/**
	 * Comprova l'existencia dels dorsals i retorna un dorsal no repetit 
	 * @return dorsalParticipant
	 */
	public static int RetornarDorsalParticipants(ArrayList<Participants> participantsLlista) {
		
		int dorsal = 1;
		
		for (int i = 0; i < participantsLlista.size(); i++) {
			
			if (participantsLlista.get(i).getDorsal() != dorsal) {
				return i+1;
			}
			
		}
		return 1;
	}
	
	//-------------------------------------------INSCRIPCIONS-----------------------------------------
	
	/**
	 * Comparar la categoria, mostrar "absolut" primer i "vetera" com a ultims
	 */
	public static class CompararCategoria implements Comparator<Participants> {
	    @Override
	    public int compare(Participants p1, Participants p2) {
	        // TODO Auto-generated method stub
	        return  p1.getCategoria().compareTo(p2.getCategoria());
	    }
	 
	}
	
	/**
	 * Comparar el sexe, mostrar en ordre alfabetic
	 */
	public static class CompararSexe implements Comparator<Participants> {
	    @Override
	    public int compare(Participants p1, Participants p2) {
	        // TODO Auto-generated method stub
	    	
	    	String sexe1 = p1.getSexe()+"";
	    	String sexe2 = p2.getSexe()+"";
	    	
	        return sexe1.compareTo(sexe2);
	        // return p1.getSexe().compareTo(p2.getSexe());
	    }
	 
	}
	
	/**
	 * Comparar el temps, mostrar en menys temps a mes temps
	 */
	public static class CompararTemps implements Comparator<Participants> {
	    @Override
	    public int compare(Participants p1, Participants p2) {
	        // TODO Auto-generated method stub	    	
	        return p1.getTempsProva().compareTo(p2.getTempsProva());
	        // return p1.getSexe().compareTo(p2.getSexe());
	    }
	 
	}
	
	//-------------------------------------------PROVES-----------------------------------------
	
	public static int EstablirHoraTipusProva() {
	
		int maratoHora = 0;
		boolean horaComprovada = false;
		
		while (!horaComprovada) {
			
			System.out.println("Posa la hora de sortida (numero absolut): ");
			while (!lector.hasNextInt()) {
				
				System.out.println("Hora sortida ha de ser un numero absolut: ");
				lector.nextLine();
				
			}
			maratoHora = lector.nextInt();
			lector.nextLine();
			
			if (maratoHora >= 1 && maratoHora <= 23) {
				horaComprovada = true;
			}
			else {
				System.out.println("La hora esta fora de rang");
			}
		}
		
		return maratoHora;
	}
}
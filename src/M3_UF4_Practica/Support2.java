package M3_UF4_Practica;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import M3_UF4_Practica.Objectes.Esportistes;
import M3_UF4_Practica.Objectes.Marato;
import M3_UF4_Practica.Objectes.MarxaPopular;
import M3_UF4_Practica.Objectes.Participants;
import M3_UF4_Practica.Objectes.Prova10000;
import M3_UF4_Practica.Objectes.Proves;

public class Support2 {

	static Scanner lector = new Scanner(System.in);
	
	public static int ComprovarCodiMaratoExistent(int codiMarato, ArrayList<Marato> provaLlista) {
		
		for (int i = 0; i < provaLlista.size(); i++) {
			if (codiMarato == provaLlista.get(i).getCodiProva()) {
				return i;
			}
		}
		return -1; //Codi no existeix
	}
	
	public static int ComprovarCodiProva10000Existent(int codiProva10000, ArrayList<Prova10000> provaLlista) {
		
		for (int i = 0; i < provaLlista.size(); i++) {
			if (codiProva10000 == provaLlista.get(i).getCodiProva()) {
				return i;
			}
		}
		return -1; //Codi no existeix
	}
	
	public static int ComprovarCodiMarxaPopularExistent(int codiMarxaPopular, ArrayList<MarxaPopular> provaLlista) {
		
		for (int i = 0; i < provaLlista.size(); i++) {
			if (codiMarxaPopular == provaLlista.get(i).getCodiProva()) {
				return i;
			}
		}
		return -1; //Codi no existeix
	}
	
	//-----------------------------------RETORNA LES POSCIONS DELS ARRAYS A TRAVES DE UN CODI
	
	/**
	 * Busca un codi dintre de la marato i retorna la seva posicio en l'array
	 * @return posicioMaratoExistent int (la posicio en l'arrray del codi especificat)
	 */
	public static int RetornarPosicioMarato() {
		
		int posicioMaratoExistent = -1;
		int codiMarato = 0;
		
		while (posicioMaratoExistent == -1) {
			System.out.println("Posa el codi de la marato: ");
			while (!lector.hasNextInt()) {
				System.out.println("Codi marato ha de ser un numero");
				lector.nextLine();
			}
			codiMarato = lector.nextInt();
			lector.nextLine();
			posicioMaratoExistent = ComprovarCodiMaratoExistent(codiMarato, DadesObjectes.marato); //Busca el codi de la prova en marato
			if (posicioMaratoExistent == -1) {
				System.out.println("El codi de la marato no existeix");
			}
		}
		
		return posicioMaratoExistent;
	}
	
	/**
	 * Busca un codi dintre de la Prova10000 i retorna la seva posicio en l'array
	 * @return posicioProva10000Existent int (la posicio en l'arrray del codi especificat)
	 */
	public static int RetornarPosicioProva10000() {
		
		int posicioProva10000Existent = -1;
		int codiProva10000 = 0;
		
		while (posicioProva10000Existent == -1) {
			System.out.println("Posa el codi de la Prova10000: ");
			while (!lector.hasNextInt()) {
				System.out.println("Codi marato ha de ser un numero");
				lector.nextLine();
			}
			codiProva10000 = lector.nextInt();
			lector.nextLine();
			posicioProva10000Existent = ComprovarCodiProva10000Existent(codiProva10000, DadesObjectes.prova10000); //Busca el codi de la prova en Prova 10000
			if (posicioProva10000Existent == -1) {
				System.out.println("El codi de la marato no existeix");
			}
		}
		
		return posicioProva10000Existent;
	}
	
	/**
	 * Busca un codi dintre de la Marxa popular i retorna la seva posicio en l'array
	 * @return posicioMarxaPopularExistent int (la posicio en l'arrray del codi especificat)
	 */
	public static int RetornarPosicioMarxaPopular() {
		
		int posicioMarxaPopularExistent = -1;
		int codiMarxaPopular = 0;
		
		while (posicioMarxaPopularExistent == -1) {
			System.out.println("Posa el codi de la Marxa Popular: ");
			while (!lector.hasNextInt()) {
				System.out.println("Codi marato ha de ser un numero");
				lector.nextLine();
			}
			codiMarxaPopular = lector.nextInt();
			lector.nextLine();
			posicioMarxaPopularExistent = ComprovarCodiMarxaPopularExistent(codiMarxaPopular, DadesObjectes.marxaPopular); //Busca el codi de la prova en Marxa pular
			if (posicioMarxaPopularExistent == -1) {
				System.out.println("El codi de la marato no existeix");
			}
		}
		
		return posicioMarxaPopularExistent;
	}
	
	//--------------------------------BUSCAR PARTICIPANTS DINTRE DE UN TIPUS DE PROVA
	
	/**
	 * Buscar un dni en una llista participants i retorna la posicio
	 * @param dni String (Dni del participant a buscar)
	 * @param participantsLlista (Llista de participants a la qual buscar)
	 * @return
	 */
	public static int ComprovarDniParticipantExistent(String dni, ArrayList<Participants> participantsLlista) {
		
		for (int i = 0; i < participantsLlista.size(); i++) {
			if (dni.equals(participantsLlista.get(i).getDni())) {
				return i;
			}
		}
		return -1; //Codi no existeix
	}
	
	/**
	 * Demana el dni i el retorna si existeix
	 * @return dniEsportista int (si existeix)
	 */
	public static int ComprovarExistenciaDniIRetornarloMarato(ArrayList<Participants> participantsLlista) {
		
		int dniEsportistaPosicio = -1;
		String dniEsportista = "";
		
		while (dniEsportistaPosicio == -1) { //Comprovar l'existencia del dni
			System.out.println("Posa el dni del esportista: ");
			dniEsportista = lector.nextLine();
			dniEsportistaPosicio = ComprovarDniParticipantExistent(dniEsportista, participantsLlista); //Revisar si el dni existeix en la llista especificada
			if (dniEsportistaPosicio == -1) {
				System.out.println("DNI no trobat");
			}
		}
		
		return dniEsportistaPosicio;
	}
	
	/**
	 * 
	 * @param dni String
	 * @param participantsLlista ArrayList<Participants>
	 * @return true (si existeix el dni) o false
	 */
	public static boolean ComprovarDniRepetitParticipants(String dni, ArrayList<Participants> participantsLlista) {
		
		for (int i = 0; i < participantsLlista.size(); i++) {
		
			if (dni.equals(participantsLlista.get(i).getDni())) {
				return true;
			}
			
		}
		
		return false; //No trobat
	}
	
	/**
	 * Establir la hora i minut de sortida de un LocalDateTime
	 */
	public static LocalDateTime EstablirHoraSortidaProva() {
		
		System.out.println("Data sortida Prova: "); //DATA NAIXEMENT
		boolean dataCorrecte = false;
		LocalDate data = LocalDate.of(1, 1, 1);
		
		while (!dataCorrecte) {
			
			System.out.println("Posa la sortida de la prova: ' DD-MM-YYYY ': ");
			String dataNaixement = lector.nextLine();
			String[] dataSplit = dataNaixement.split("-");
			
			if (dataSplit.length == 3) { //Mirar si hi ha 3 valors: dia-mes-any
				
				try { //Si un dels valors no es integer o la data es pasa de rang, retornara un error
					int dia = Integer.parseInt(dataSplit[0]);
					int mes = Integer.parseInt(dataSplit[1]);
					int any = Integer.parseInt(dataSplit[2]);
					data = LocalDate.of(any, mes, dia);
					dataCorrecte = true;
				}
				
				catch (Exception e) { //Mirara si els numeros son enters, si no ho son retorna un valor i torna a demanar la data
					System.out.println("Data prova incorrecte");
				}
			}
			else {
				System.out.println("Format incorrecte, escriu un altre cop la data de la prova");
			}
		}
		
		boolean horaCorrecte = false;
		int hora = 0;
		while (!horaCorrecte) {
			System.out.println("Posa la hora de sortida (numero absolut) ");
			while (!lector.hasNextInt()) {
				System.out.println("Ha de ser un numero absolut");
				lector.nextLine();
			}
			hora = lector.nextInt();
			lector.nextLine();
			if (hora >= 1 && hora <= 23) {
				horaCorrecte = true;
			}
			else {
				System.out.println("La hora es pasa de rang");
			}
		}
		
		boolean minutCorrecte = false;
		int minut = 0;
		while (!minutCorrecte) {
			System.out.println("Posa el minut de sortida (numero absolut) ");
			while (!lector.hasNextInt()) {
				System.out.println("Ha de ser un numero absolut");
				lector.nextLine();
			}
			minut = lector.nextInt();
			lector.nextLine();
			if (minut >= 1 && minut <= 59) {
				minutCorrecte = true;
			}
			else {
				System.out.println("El minut es pasa de rang");
			}
		}
		
		LocalDateTime dataSortida = LocalDateTime.of(data.getYear(), data.getMonthValue(), data.getDayOfMonth(), hora, minut);
		
		return dataSortida;
	}
	
	public static Duration EstablirTempsProvaParticipant() {
		
		boolean horaCorrecte = false;
		int hora = 0;
		
		while (!horaCorrecte) {
			System.out.println("Posa les hores totals de recorregut (0 - 23) ");
			while (!lector.hasNextInt()) {
				System.out.println("Ha de ser un numero absolut");
				lector.nextLine();
			}
			hora = lector.nextInt();
			lector.nextLine();
			if (hora >= 0 && hora <= 23) {
				horaCorrecte = true;
			}
			else {
				System.out.println("La hora es pasa de rang");
			}
		}
		
		boolean minutCorrecte = false;
		int minut = 0;
		
		while (!minutCorrecte) {
			System.out.println("Posa els minuts totals (0 - 59) ");
			while (!lector.hasNextInt()) {
				System.out.println("Ha de ser un numero absolut");
				lector.nextLine();
			}
			minut = lector.nextInt();
			lector.nextLine();
			if (minut >= 0 && minut <= 59) {
				minutCorrecte = true;
			}
			else {
				System.out.println("Els minuts es pasen de rang");
			}
		}
		
		boolean segonCorrecte = false;
		int segon = 0;
		
		while (!segonCorrecte) {
			System.out.println("Posa els segons totals (0 - 59) ");
			while (!lector.hasNextInt()) {
				System.out.println("Ha de ser un numero absolut");
				lector.nextLine();
			}
			segon = lector.nextInt();
			lector.nextLine();
			if (segon >= 0 && segon <= 60) {
				segonCorrecte = true;
			}
			else {
				System.out.println("Els segons es pasen de rang");
			}
		}
		
		Duration totalDuration = Duration.ofHours(hora).plusMinutes(minut).plusSeconds(segon);
		return totalDuration;
		
	}
}

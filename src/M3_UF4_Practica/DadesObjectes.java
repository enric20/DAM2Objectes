package M3_UF4_Practica;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import M3_UF4_Practica.Objectes.*;

/**
 * Guardar la dades en ArrayLists de objectes i bateria de dades
 * @author enric
 * Version 1.0
 */
public class DadesObjectes {

	//Esportistes[] esportistes = new Esportistes[100];
	public static ArrayList<Clubs> clubs = new ArrayList<Clubs>();
	public static ArrayList<Esportistes> esportistes = new ArrayList<Esportistes>();
		public static ArrayList<Participants> participants = new ArrayList<Participants>();
	
	public static ArrayList<Proves> proves = new ArrayList<Proves>();
		public static ArrayList<Marato> marato = new ArrayList<Marato>();
		public static ArrayList<MarxaPopular> marxaPopular = new ArrayList<MarxaPopular>();
		public static ArrayList<Prova10000> prova10000 = new ArrayList<Prova10000>();
		
	
		
	public static void OmplirVariables() {
		
		for (int i = 0; i < 50; i++) { //Omplir Clubs
			String[] c = {"Nom Club"+i, "Poblacio"+i};
			LocalDate anyFundacio = LocalDate.of(2000-i, 1, 31);
			int codiPostal = 1700+i;
			int codiClub = 1+i;
			clubs.add(new Clubs(c[0], c[1], codiPostal, anyFundacio, codiClub));
						
		}
		
		for (int i = 0; i < 50; i++) { //Omplir Esportistes
			//String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat
			String[] c = {"nom"+i, "cognom"+i, "cognom"+i, "H", "416032"+(10+i)+"X", "club"+i, "federacio"+i};
			LocalDate anyNaixement = LocalDate.of(2000-i, 1, 31);
			esportistes.add(new Esportistes(c[0], c[1], c[2], c[3].charAt(0), anyNaixement, c[4], c[5], c[6]));
						
		}
		
		for (int i = 0; i < 5; i++) { //Omplir Proves
			//String nom, int any, ArrayList<String> participants, int codiProva
			String nomProva = "Prova"+i;
			int any = 2000+i;
			String codiProva = any+""+proves.size(); //AAAAPPPP | A= any, P = Prova //codiProva = (any.toString()+numeroSequencial.toString()).toInteger()
			DadesObjectes.marato.add(new Marato(nomProva, any, participants, Integer.parseInt(codiProva), LocalDate.of(2020, 05, 27-i), 
					LocalDateTime.of(2020, 05, 27-i, 18-i, 30)));
			DadesObjectes.marxaPopular.add(new MarxaPopular(nomProva, any, participants, Integer.parseInt(codiProva), "Pala", LocalDate.of(2020, 05, 27-i), 
					LocalDateTime.of(2020, 05, 27-i, 18-i, 30)));
			DadesObjectes.prova10000.add(new Prova10000(nomProva, any, participants, Integer.parseInt(codiProva), "club"+i, "Pala", LocalDate.of(2020, 05, 27-i), 
					LocalDateTime.of(2020, 05, 27-i, 18-i, 30)));
		}
		
		for (int i = 0; i < 30; i++) { //Omplir Participants
			//String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat, String categoria, int dorsal, Duration tempsProva
			String[] c = {"nom"+i, "cognom"+i, "cognom"+i, "H", "416032"+(10+i)+"X", "club"+i, "federacio"+i};
			LocalDate naixement = LocalDate.of(1963+i, ((int) (Math.random()*11)+1), ((int)(Math.random()*26)+1) );
			String absolutVetera = Support.RetornarAbsolutVetera(naixement);
			Duration tempsProva = Duration.ofMinutes(1+i);
			if (i >= 10) {
				tempsProva = Duration.ofMinutes(4);
			}
			DadesObjectes.marato.get(0).afegirParticipantMarato(c[0], c[1], c[2], c[3].charAt(0), naixement, c[4], c[5], c[6], absolutVetera, i, tempsProva);
			DadesObjectes.marxaPopular.get(0).afegirParticipantMarxaPopular(c[0], c[1], c[2], c[3].charAt(0), naixement, c[4], c[5], c[6], absolutVetera, i, tempsProva);
			DadesObjectes.prova10000.get(0).afegirParticipantProva10000(c[0], c[1], c[2], c[3].charAt(0), naixement, c[4], c[5], c[6], absolutVetera, i, tempsProva);
		}
		DadesObjectes.marxaPopular.get(0).afegirParticipantMarxaPopular("Enric", "Bahi", "Delgado", 'H', LocalDate.of(2000, 10, 19), "41601668G", "Club Henry", "W120", "Vetera", 666, Duration.ofHours(2));;
		DadesObjectes.marato.get(0).afegirParticipantMarato("Kursa", "Previchozky", "Malduvi", 'D', LocalDate.of(1963, 8, 3), "41603208Y", "Club Henry", "JL1", "Absolut", 734, Duration.ofHours(1));
		
		//proves.add(new Proves("Prova 100m", 2020, participantsLlistat, 0));
		
		
		
	}
}

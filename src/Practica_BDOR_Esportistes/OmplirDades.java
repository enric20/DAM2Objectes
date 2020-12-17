package Practica_BDOR_Esportistes;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import M3_UF4_Practica.Objectes.*;
import M3_UF4_Practica.*;
import M3_UF4_Practica.Objectes.Marato;
import M3_UF4_Practica.Objectes.MarxaPopular;
import M3_UF4_Practica.Objectes.Participants;
import M3_UF4_Practica.Objectes.Prova10000;
import M3_UF4_Practica.DadesObjectes;

public class OmplirDades {

	public static void entrarDades() {

		DadesObjectes.esportistes.add(new Esportistes("nom1", "cognom11", "cognom21", 'H', LocalDate.of(1975, 2, 28), "45540001Y"));
		DadesObjectes.esportistes.add(new Esportistes("nom2", "cognom12", "cognom22", 'D', LocalDate.of(1985, 2, 28), "45540002Y"));
		DadesObjectes.esportistes.add(new Esportistes("nom3", "cognom13", "cognom23", 'H', LocalDate.of(1995, 2, 28), "45540003Y"));
		DadesObjectes.esportistes.add(new Esportistes("nom4", "cognom14", "cognom24", 'D', LocalDate.of(1996, 2, 28), "45540004Y"));
		DadesObjectes.esportistes.add(new Esportistes("nom5", "cognom15", "cognom25", 'H', LocalDate.of(1997, 2, 28), "45540005Y"));
		DadesObjectes.esportistes.add(new Esportistes("nom6", "cognom16", "cognom26", 'D', LocalDate.of(1998, 2, 28),"45540006Y"));
		DadesObjectes.esportistes.add(new Esportistes("nom7", "cognom17", "cognom27", 'H', LocalDate.of(1999, 2, 28), "45540007Y"));
		DadesObjectes.esportistes.add(new Esportistes("nom8", "cognom18", "cognom28", 'D', LocalDate.of(1963, 2, 28), "85540008Y"));
		DadesObjectes.esportistes.add(new Esportistes("nom9", "cognom19", "cognom29", 'H', LocalDate.of(1940, 2, 28), "45540009Y"));
		DadesObjectes.esportistes.add(new Esportistes("nom10", "cognom110", "cognom210", 'D', LocalDate.of(1935, 2, 28), "45540010Y"));
		DadesObjectes.esportistes.add(new Esportistes("nom11", "cognom111", "cognom211", 'H', LocalDate.of(1979, 2, 28), "45540011Y"));
		DadesObjectes.esportistes.add(new Esportistes("nom12", "cognom112", "cognom212", 'D', LocalDate.of(2005, 2, 28), "45540012Y"));
		

		DadesObjectes.clubs.add(new Clubs("Palamós", "Palamós", 17230, LocalDate.of(1995, 1, 1), 1));
		DadesObjectes.clubs.add(new Clubs("Blanes", "Blanes", 17300, LocalDate.of(1990, 1, 1), 2));
		DadesObjectes.clubs.add(new Clubs("Olot", "Olot", 17100, LocalDate.of(1985, 1, 1), 3));


		ArrayList<Participants> participantsMarato = new ArrayList<Participants>();
		ArrayList<Participants> participantsMarxaPopular = new ArrayList<Participants>();
		ArrayList<Participants> participantsProva10000 = new ArrayList<Participants>();
		
		//String nom, String cognom1, String cognom2, char sexe, LocalDate dataNaixement, String dni, String club, String codiFederat, String categoria, int dorsal, Duration tempsProva
		participantsMarato.add(new Participants("nomp11", "cognomp11", "cognomp21", 'D', LocalDate.of(2000,12,2), "465461180P", "club1", "CF0", "Vetera", 0, Duration.ofHours(0)));
		participantsMarato.add(new Participants("nomp12", "cognomp12", "cognomp22", 'H', LocalDate.of(1997,10,8), "465461181P", "club2", "CF1", "Vetera", 1, Duration.ofHours(0)));
		participantsMarato.add(new Participants("nomp13", "cognomp13", "cognomp23", 'H', LocalDate.of(1963,11,21), "465461182P", "club3", "CF2", "Absolut", 2, Duration.ofHours(0)));
		participantsMarato.add(new Participants("nomp14", "cognomp14", "cognomp24", 'H', LocalDate.of(1977,5,11), "465461183P", "club3", "CF3", "Vetera", 3, Duration.ofHours(0)));
		participantsMarato.add(new Participants("nomp15", "cognomp15", "cognomp25", 'H', LocalDate.of(1999,12,17), "465461184P", "club4", "CF4", "Vetera", 4, Duration.ofHours(0)));
		
		participantsMarxaPopular.add(new Participants("nomp111", "cognomp111", "cognomp211", 'D', LocalDate.of(1968,9,2), "465461185P", "club2", "CF5", "Absolut", 5, Duration.ofHours(0)));
		participantsMarxaPopular.add(new Participants("nomp112", "cognomp112", "cognomp212", 'D', LocalDate.of(1997,7,26), "465461186P", "club1", "CF6", "Vetera", 6, Duration.ofHours(0)));
		participantsMarxaPopular.add(new Participants("nomp113", "cognomp112", "cognomp213", 'H', LocalDate.of(1987,7,26), "465461187P", "club1", "CF7", "Vetera", 7, Duration.ofHours(0)));
		participantsMarxaPopular.add(new Participants("nomp114", "cognomp114", "cognomp214", 'D', LocalDate.of(1962,7,26), "465461188P", "club1", "CF8", "Absolut", 8, Duration.ofHours(0)));
		
		participantsProva10000.add(new Participants("nomp121", "cognomp121", "cognomp221", 'D', LocalDate.of(1959,9,5), "465461189P", "club2", "CF9", "Absolut", 9, Duration.ofHours(0)));
		participantsProva10000.add(new Participants("nomp122", "cognomp122", "cognomp222", 'D', LocalDate.of(2003,8,21), "465461190P", "club3", "CF10", "Vetera", 10, Duration.ofHours(0)));
		participantsProva10000.add(new Participants("nomp123", "cognomp123", "cognomp223", 'H', LocalDate.of(1990,7,28), "465461191P", "club4", "CF11", "Vetera", 11, Duration.ofHours(0)));
		participantsProva10000.add(new Participants("nomp124", "cognomp124", "cognomp224", 'D', LocalDate.of(1967,2,3), "465461192P", "club4", "CF12", "Absolut", 12, Duration.ofHours(0)));

		//String nom, int any, ArrayList<Participants> participants, int codiProva, LocalDate data, LocalDateTime horaSortida
		DadesObjectes.marato.add(new Marato("m1", 2020, participantsMarato, 20201, LocalDate.now(), LocalDateTime.now()));
		DadesObjectes.marato.get(0).setParticipantsMarato(participantsMarato);
		
		//String nom, int any, ArrayList<Participants> participants, int codiProva,  String ubicacio, LocalDate data, LocalDateTime dataSortida
		DadesObjectes.marxaPopular.add(new MarxaPopular("mp1", 2020, participantsMarxaPopular, 20202, "Vilobi", LocalDate.now(), LocalDateTime.now()));
		DadesObjectes.marxaPopular.get(0).setParticipantsMarxaPopular(participantsMarxaPopular);
		
		//String nom, int any, ArrayList<Participants> participants, int codiProva, String clubAnfitrio, String ubicacio, LocalDate data, LocalDateTime dataSortida
		DadesObjectes.prova10000.add(new Prova10000("prova10000", 2020, participantsProva10000, 20203, "club1", "Vilobi", LocalDate.now(), LocalDateTime.now()));
		DadesObjectes.prova10000.get(0).setParticipantsProva10000(participantsProva10000);

	}
	
}

package Practica_BDOR_Esportistes;

import Practica_BDOR_Esportistes.MenusSecundaris.*;
import M3_UF4_Practica.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Menu principal
 * @author enric
 * Version 1.0
 */
public class Main {

	static Scanner lector = new Scanner(System.in);
	
	static M3_UF4_Practica.Objectes.Esportistes esportistes;
	
	public static void main(String[] args) {
		
		//DadesObjectes.OmplirVariables(); //Funcio utilitzada per omplir dades, comentar-la si no es vol tenir cap dada introduida
		OmplirDades.entrarDades();
		MenuPrincipal();
		
	}

	
	public static void MenuPrincipal() {
		
		boolean sortir = false;
		
		while (!sortir) {
			System.out.println("BASES DE DADES");
			System.out.println("---------------- Menu Principal: ---------------");
			System.out.println("Selecciona una opció: ");
			System.out.println("1 - Dades (obre el menú de Dades) (Introduir dades): ");
			System.out.println("2 - Inscripció (obre el menú de Inscripció) (Inscriure personal, clubs i visualitzar): ");
			System.out.println("3 - Proves (Obre el menú de Proves) ");
			System.out.println("4 - Sortir (Sortir del programa) ");
			
			if (lector.hasNextInt()) {
				int opcio = lector.nextInt();
				lector.nextLine();
				switch (opcio) {
				
					case 1:
						Practica_BDOR_Esportistes.MenusSecundaris.Dades.MenuDades(); //Primer menu per afegir, modificar i llisar clubs, esportistes i proves
						break;
						
					case 2:
						Practica_BDOR_Esportistes.MenusSecundaris.Inscripcio.MenuInscripcio(); //Segon menu per a inscriure, anular i llistar participants
						break;
						
					case 3:
						Practica_BDOR_Esportistes.MenusSecundaris.ProvesM.MenuProves(); //Tercer menu per a veure les classificacions de les proves i classificar participants i proves
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
		System.out.println("Sortint del programa");
	}
}

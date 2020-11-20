package M3_UF4_Act3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String nomRestaurant = "PepPerles"; 
		int opcio = 0;
		Restaurant restaurant = new Restaurant(10, 80, 32);
		boolean sortir = false;
		
		Scanner lector = new Scanner(System.in);
		
		while (!sortir) {
			
			System.out.println("Benvingut al restaurant "+nomRestaurant+", que vols fer?");
			
			System.out.println("1 - Veure existencies");
			System.out.println("2 - Servir Plat");
			System.out.println("3 - Afegir ous");
			System.out.println("4 - Afegir mongetes");
			System.out.println("5 - Afegir Botifarres");
			System.out.println("6 - Sortir");
			
			if (lector.hasNextInt()) {
				opcio = lector.nextInt();
				lector.nextLine();
			}
			else {
				System.out.println("Has de posar un numero");
				lector.nextLine();
			}
			
			
			switch (opcio) {
			
			case 1: //Veure existencies d'ingredients i plats preparables
				System.out.println("----- Veure existencies -----");
				System.out.println("Dotzenes d'ous: "+restaurant.getDotzenesOusNum());
				System.out.println("Botifarres: "+restaurant.getBotifarresNum());
				System.out.println("Mongetes: "+restaurant.getKgMongetes()+" Kg");
				System.out.println("\nPlats disponibles: "+restaurant.getNumPlats());
				break;
				
			case 2: //Servir plats, resta el numero maxim de ingredients i comprova si es pot servir el plat
				if (restaurant.getNumPlats() >= 1) {
					restaurant.servirPlats();
					System.out.println("Gracies per la seva ordre");
				}
				
				else {
					System.out.println("Ho sentim, no ens queden plats per servir");
				}
				
				break;
				
			case 3: //Afegir Ous
				System.out.println("Indica la quantitat d'ous que vols demanar: ");
				if (lector.hasNextInt()) { //Comprovar numero
					int quantitatDotzenesOus = lector.nextInt();
					lector.nextLine();
					restaurant.afegirOus(quantitatDotzenesOus);
				}
				else {
					System.out.println("Dotzenes d'ous ha de ser un numero enter");
					lector.nextLine();
				}
				
				break;
				
			case 4: //Afegir Mongetes
				System.out.println("Indica la quantitat en Kilograms de mongetes que vols demanar: ");
				if (lector.hasNextDouble()) { //Comprovar numero
					double kgMongetes = lector.nextDouble();
					lector.nextLine();
					restaurant.afegirMongetes(kgMongetes);
				}
				else {
					System.out.println("Mongetes ha de ser un numero absolut");
					lector.nextLine();
				}
				
				break;
				
			case 5: //Afegir Botifarres
				System.out.println("Indica la quantitat de botifarres que vols demanar ");
				if (lector.hasNextInt()) { //Comprovar numero
					int botifarres = lector.nextInt();
					lector.nextLine();
					restaurant.afegirBotifarres(botifarres);
				}
				else {
					System.out.println("Botifarres ha de ser un numero enter");
					lector.nextLine();
				}
				
				break;
				
			case 6: //Sortir
				sortir = true;
				break;
			default: //Opcio incorrecte, no especificada
				System.out.println("Opcio incorrecte");
				break;
			
			}
			
			
		}
		
		
	}
	
}

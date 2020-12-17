package M3_UF5_Practica;

import java.time.Duration;
import java.util.Scanner;

public class GenerarFutbolistes {

	public static void GenerarFutbolistes() {
		
		Scanner lector = new Scanner(System.in);
		boolean sortir = false;
		
		String nom;
		Float salari;
		Duration temps;
		int hores;
		int minuts;

		while(!sortir) 
		{			
			System.out.println("Per Sortir Escriu 0: ");
			System.out.println("Insereix Nom Futbolista: ");
			nom = lector.nextLine();
			
			if(nom.equalsIgnoreCase("0")) 
			{
				MainMenu.main(null);
			}
			
			System.out.println("Insereix Salari Mensual: ");
			while(!lector.hasNextFloat()) 
			{
				GenerarFutbolistes.GenerarFutbolistes();
			}
			salari = lector.nextFloat();
			lector.nextLine();
			
			System.out.println("Insereix Temps Entrenament Setmanal HH MM: ");
			while(!lector.hasNextInt()) 
			{
				GenerarFutbolistes.GenerarFutbolistes();
			}
			hores = lector.nextInt();
			while(!lector.hasNextInt()) 
			{
				GenerarFutbolistes.GenerarFutbolistes();
			}
			minuts = lector.nextInt();
			lector.nextLine();
			
			
			temps = Duration.ofHours(hores).plusMinutes(minuts);			
			
			MainMenu.nomFutbolistes.add(nom);
			MainMenu.salari.add(salari);
			MainMenu.entrenamentSetmanal.add(temps);
			
			
			GuardarFutbolistes.GuardarEsportistes(MainMenu.nomFutbolistes, MainMenu.salari, MainMenu.entrenamentSetmanal);
		}
	}
}
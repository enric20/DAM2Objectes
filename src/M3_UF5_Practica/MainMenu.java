package M3_UF5_Practica;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

	public static ArrayList<String> nomFutbolistes = new ArrayList<String>();
	public static ArrayList<Duration> entrenamentSetmanal = new ArrayList<Duration>();
	public static ArrayList<Float> salari = new ArrayList<Float>();
	
	public static void main(String[] args) {
		System.out.println("Futbolistes en el fitxer: ");
		LlegirFutbolistes.LlegirEsportistes(nomFutbolistes, salari, entrenamentSetmanal);
		
		Scanner lector = new Scanner(System.in);
		int opcio;
		boolean sortir = false;
		
		
		while(!sortir) {
		System.out.println("---Esportistes---");
		System.out.println("1 - Generar Futbolistes i guardar-los");
		System.out.println("2 - Mostrar Futbolistes en l'axiu");
		System.out.println("3 - Sortir");
		System.out.print("Opcio: ");


		while(!lector.hasNextInt()) 
		{
			main(args);
		}
		
		opcio = lector.nextInt();
		lector.nextLine();
		
			switch(opcio) 
			{
			case 1:
				GenerarFutbolistes.GenerarFutbolistes();
				break;
			case 2:
				LlegirFutbolistes.LlegirEsportistes(nomFutbolistes, salari, entrenamentSetmanal);
				break;

			case 3:
				sortir = true;
				break;
			}
		}
	}
}

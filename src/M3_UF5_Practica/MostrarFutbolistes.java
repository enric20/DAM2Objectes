package M3_UF5_Practica;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Currency;

public class MostrarFutbolistes {

	public static void MostrarFutbolistes() 
	{
	     Currency curr = Currency.getInstance("EUR");
	      String simbol = curr.getSymbol();
		
		for(int x = 0; x < MainMenu.nomFutbolistes.size(); x++) 
		{
			System.out.println
			("Nom: " + MainMenu.nomFutbolistes.get(x) +
			" Entrenament Setmanal: "+MainMenu.entrenamentSetmanal.get(x).toString() +
			" Salari Mensual: "+MainMenu.salari.get(x)+simbol);
		}
	}
	
}

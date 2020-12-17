package M3_UF5_Practica;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;

public class LlegirFutbolistes {

	static File file = new File("C:\\fitxers\\futbolistes.txt");
	
	public static void LlegirEsportistes(ArrayList<String> nom, ArrayList<Float> salari, ArrayList<Duration> entrenamentSetmanal) {
		
		try {
		
			nom.clear();
			salari.clear();
			entrenamentSetmanal.clear();
			
			FileInputStream fileInputStream = new FileInputStream(file);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			
			
			while (dataInputStream.available() > 0) {
				
				nom.add(dataInputStream.readUTF());
				salari.add(dataInputStream.readFloat());
				int hours = dataInputStream.readInt();
				entrenamentSetmanal.add(Duration.ofHours(hours));
								
			}
			
			MostrarFutbolistes.MostrarFutbolistes();
			
			
			
		}
		
		catch (Exception e) {
			
			System.out.println("Error de lectura");
			
		}
		
		
	}
	
}

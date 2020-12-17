package M3_UF5_Practica;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class GuardarFutbolistes {

	static File file = new File("C:\\fitxers\\futbolistes.txt");
	
	public static void GuardarEsportistes(ArrayList<String> nom, ArrayList<Float> salari, ArrayList<Duration> entrenamentSetmanal) {
		
		try {
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
			
			for (int i = 0; i < nom.size(); i++) {
				
				dataOutputStream.writeUTF(nom.get(i));
				dataOutputStream.writeFloat(salari.get(i));
				int hours = (int) entrenamentSetmanal.get(i).toHours();
				dataOutputStream.writeInt(hours);
				
			}
			
			dataOutputStream.close();
		}
		
		catch(Exception e) {
			
			System.out.println("Error");
			
		}
		
		
	}
	
}

package M3_UF5_Practica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 * @author enric
 * @version 1.0
 */
public class ProvesDataOutputStream {
	
	static ArrayList<String> alumnes = new ArrayList<String>();
	static ArrayList<LocalDate> dataNaixementAlumnes = new ArrayList<LocalDate>();
	static ArrayList<String> cursAlumnes = new ArrayList<String>();

	public static void main(String[] args) {

		File file = new File("C:"+File.separator+"fitxers"+File.separator+"prova.txt");
		
		//Generar alumnes
		for (int i = 0; i < 20; i++) {
			alumnes.add("Alumne "+i);
			dataNaixementAlumnes.add(LocalDate.of((2000-i), (int) (Math.random()*11+1), (int) (Math.random()*26+1)));
			cursAlumnes.add("DAM2");
		}
		
		//Mostrar alumnnes
		System.out.println("Alumne		Data Naixement	Curs");
		for (int i = 0; i < alumnes.size(); i++) {
			System.out.println("");
			System.out.print(alumnes.get(i)+"	");
			System.out.print(dataNaixementAlumnes.get(i)+"	");
			System.out.print(cursAlumnes.get(i)+"	");
		}
		System.out.println("");
		/**
		 * ------------------------------------------------------------------------------
		 * 	   -------------------------- MÈTODES --------------------------
		 * ------------------------------------------------------------------------------
		 */
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file); //Crear una sortida de l'arxiu (arxiu el cual es modificarà)
			DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream); //Crear la sortida de les dades (a on escriura les dades)
			
			//Escriure (OUTPUT)
			
			System.out.println("--------------------------------------------------------------------");
			System.out.println("--------------------OUTPUT STREAM (ESCRIPTURA)----------------------");
			System.out.println("--------------------------------------------------------------------");
			
			for (int i = 0; i < alumnes.size(); i++) {
				
				dataOutputStream.writeUTF(alumnes.get(i)); //Escriure un String (2 + numCaracters bytes)
				dataOutputStream.writeInt(dataNaixementAlumnes.get(i).getYear()); //Escriure un int (4 bytes)
				dataOutputStream.writeInt(dataNaixementAlumnes.get(i).getMonthValue()); //Escriure un int (4 bytes)
				dataOutputStream.writeInt(dataNaixementAlumnes.get(i).getDayOfMonth()); //Escriure un int (4 bytes)
				dataOutputStream.writeUTF(cursAlumnes.get(i));
			}
			System.out.println("");
			
			//Llegir (INPUT)
			
			System.out.println("--------------------------------------------------------------------");
			System.out.println("--------------------INPUT STREAM (LECTURA)----------------------");
			System.out.println("--------------------------------------------------------------------");
			
			FileInputStream fileInputStream = new FileInputStream(file);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			
			ArrayList<String> alumnesLectura = new ArrayList<String>();
			ArrayList<LocalDate> dataNaixementAlumnesLectura = new ArrayList<LocalDate>();
			ArrayList<String> cursAlumnesLectura = new ArrayList<String>();
			
			
			for (int i = 0; i < alumnes.size(); i++) {
				
				alumnesLectura.add(dataInputStream.readUTF()); //Escriure un String (2 + numCaracters bytes)
				int year = dataInputStream.readInt(); //Escriure un int (4 bytes)
				int month = dataInputStream.readInt(); //Escriure un int (4 bytes)
				int day = dataInputStream.readInt(); //Escriure un int (4 bytes)
				dataNaixementAlumnesLectura.add(LocalDate.of(year, month, day));
				cursAlumnesLectura.add(dataInputStream.readUTF());
			}
			
			//Mostrar alumnes importats
			System.out.println("Alumne		Data Naixement	Curs");
			for (int i = 0; i < alumnes.size(); i++) {
				System.out.println("");
				System.out.print(alumnesLectura.get(i)+"	");
				System.out.print(dataNaixementAlumnesLectura.get(i)+"	");
				System.out.print(cursAlumnesLectura.get(i)+"	");
			}
			System.out.println("");
		}
		
		catch (Exception e) {
			System.out.println("Exception "+e);
		}
		

	}

}

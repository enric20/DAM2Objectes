package M3_UF5_Practica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Serveix per a guardar dades de forma primitiva (string, int, float, boolean) en arxius
 * @author enric
 * @version 1.0
 */
public class ProvesDataOutputStream {
	
	static ArrayList<String> alumnes = new ArrayList<String>();
	static ArrayList<LocalDate> dataNaixementAlumnes = new ArrayList<LocalDate>();
	static ArrayList<String> cursAlumnes = new ArrayList<String>();
	
	static File file = new File("C:"+File.separator+"fitxers"+File.separator+"prova.txt");

	public static void main(String[] args) {

		Scanner lector = new Scanner(System.in);
		
		boolean sortir = false;
		while (!sortir) {
			
			System.out.println("");
			System.out.println("A - Generar dades a la memoria");
			System.out.println("B - Guardar dades al fitxer");
			System.out.println("C - Mostrar dades del fitxer");
			System.out.println("D - Esborrar dades del fitxer");
			System.out.println("S - Sortir del programa");
			
			String opcio = lector.nextLine();
			
			switch (opcio) {
			
			case "A":
				GenerarDadesMemoria();
				break;
				
			case "B":
				GuardarDadesEnFitxer();
				break;
				
			case "C":
				LlegirDadesFitxer();
				break;
				
			case "D":
				EsborrarDadesFitxer();
				break;
				
			case "S":
				sortir = true;
				System.out.println("Sortint del programa");
				break;
				
			default:
				System.out.println("Opcio incorrecta");
				break;
			
			
			
			}
		}
		
	}
	
	/**
	 * ------------------------------------------------------------------------------
	 * 	   -------------------------- MÈTODES --------------------------
	 * ------------------------------------------------------------------------------
	 */
	
	/**
	 * Generar les dades a la memoria i mostrar-les per pantalla
	 */
	public static void GenerarDadesMemoria() {
		
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
		
		
	}
	
	/**
	 * Guardar les dades que tenima a la memoria (array list) en el fitxer de sortida
	 */
	public static void GuardarDadesEnFitxer() { //FILE OUTPUT STREAM
	
		try {
			System.out.println("-------------------------------");
			
			FileOutputStream fileOutputStream = new FileOutputStream(file); //Crear una sortida de l'arxiu (arxiu el cual es modificarà)
			DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream); //Crear la sortida de les dades (a on escriura les dades)
			
			//Escriure (OUTPUT)
			
			System.out.println("--------------------------------------------------------------------");
			System.out.println("--------------------OUTPUT STREAM (ESCRIPTURA)----------------------");
			System.out.println("--------------------------------------------------------------------");
			
			
			
			for (int i = 0; i < alumnes.size(); i++) { //Agafar les dades del array list y guardar-les al arxiu
				
				//Quant guardem un UTF i volem tenir un tamany fixe haurem de fer el següent
				if (alumnes.get(i).length() > 18) { //Si es superior a 18 el trunquem
					alumnes.set(i, alumnes.get(i).substring(0, 17));
				}
				else {
					alumnes.set(i, String.format("%-18s", alumnes.get(i))); //Si es inferior a 18, li afegim espais
				}
				
				dataOutputStream.writeUTF(alumnes.get(i)); //Escriure un String (2 + numCaracters bytes)
				dataOutputStream.writeInt(dataNaixementAlumnes.get(i).getYear()); //Escriure un int (4 bytes)
				dataOutputStream.writeInt(dataNaixementAlumnes.get(i).getMonthValue()); //Escriure un int (4 bytes)
				dataOutputStream.writeInt(dataNaixementAlumnes.get(i).getDayOfMonth()); //Escriure un int (4 bytes)
				
				if (cursAlumnes.get(i).length() > 18) { //Si es superior a 18 el trunquem
					cursAlumnes.set(i, cursAlumnes.get(i).substring(0, 17));
				}
				else {
					cursAlumnes.set(i, String.format("%-18s", cursAlumnes.get(i))); //Si es inferior a 18, li afegim espais
				}
				
				dataOutputStream.writeUTF(cursAlumnes.get(i)); //Escriure un String (2 + numCaracters bytes)
				
			}
			
			System.out.println("");
			
		}
			
		catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
		
	}
	
	
	public static void LlegirDadesFitxer() {
		
		try {
			//Llegir (INPUT)
			
			System.out.println("--------------------------------------------------------------------");
			System.out.println("--------------------INPUT STREAM (LECTURA)----------------------");
			System.out.println("--------------------------------------------------------------------");
			
			FileInputStream fileInputStream = new FileInputStream(file);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			
			ArrayList<String> alumnesLectura = new ArrayList<String>();
			ArrayList<LocalDate> dataNaixementAlumnesLectura = new ArrayList<LocalDate>();
			ArrayList<String> cursAlumnesLectura = new ArrayList<String>();
			
			while (dataInputStream.available() > 0) { //Lectura de l'arxiu de forma sequencial
				
				alumnesLectura.add(dataInputStream.readUTF().strip()); //Llegir un String (2 + numCaracters bytes) (Eliminem els espais sobrants)
				int year = dataInputStream.readInt(); //Llegir un int (4 bytes)
				int month = dataInputStream.readInt(); //Llegir un int (4 bytes)
				int day = dataInputStream.readInt(); //Llegir un int (4 bytes)
				dataNaixementAlumnesLectura.add(LocalDate.of(year, month, day));
				cursAlumnesLectura.add(dataInputStream.readUTF().strip());
			}
			
			//Mostrar alumnes importats
			System.out.println("Alumne		Data Naixement	Curs");
			for (int i = 0; i < alumnesLectura.size(); i++) {
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
	
	/**
	 * Esborrar les dades del fitxer especificat
	 */
	public static void EsborrarDadesFitxer() {
		
		try {
			
			FileOutputStream fileOutputStream = new FileOutputStream(file); //Crear una sortida de l'arxiu (arxiu el cual es modificarà)
			DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream); //Crear la sortida de les dades (a on escriura les dades)
			
			fileOutputStream.flush(); //Esborra les dades de l'interior del fitxer
		}
		
		catch (Exception e) {
			System.out.println("Exception "+e);
		}
		
	}

}
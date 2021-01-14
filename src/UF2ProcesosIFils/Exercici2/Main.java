package UF2ProcesosIFils.Exercici2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws InterruptedException {
						
		
		//------------------------------------------------
		//TASCA 1
		//------------------------------------------------
		ArrayList<Thread> threads = new ArrayList<Thread>(); //Crear ArrayList dels fils
		
		int repeticions = 5;
		int quantitatFils = 5;
		int tamanyArray = repeticions*quantitatFils;
		
		for (int i = 0; i < quantitatFils; i++) { //Inicialitzar els objectes amb les seves respectives variables
			
			threads.add(new Thread(new Fils(i+1, repeticions*i, tamanyArray)));
			
		}
		
		for (int i = 0; i < quantitatFils; i++) {
			threads.get(i).start(); //Initialitza el fil i executar la tasca 1
			threads.get(i).sleep(1);
		}
	
		Fils.LlegirArrayUnic();
		
		//----------------------------------------------
		//TASCA 2
		//----------------------------------------------
		
		ArrayList<Thread> threadsSegonaTasca = new ArrayList<Thread>(); //Crear ArrayList dels fils
		int[][] multiplicacio = new int[11][11];
		
		int quantitatFilsT2 = 11;
		
		for (int i = 0; i < quantitatFilsT2; i++) { //Inicialitzar els objectes amb les seves respectives variables
			
			threadsSegonaTasca.add(new Thread(new FilsT2(10, i, multiplicacio)));
			
		}
		
		for (int i = 0; i < quantitatFilsT2; i++) { //Initialitza el fil i executar la tasca 2
			threadsSegonaTasca.get(i).start();
			//threadsSegonaTasca.get(i).sleep(1);
		}
		System.out.println("===============================================");
		System.out.println("===============================================");
		System.out.println("===============================================");
		System.out.println("===============================================");

		for (int i = 0; i < multiplicacio.length; i++) {
			System.out.println("---------------TAULA "+i+"------------------");
			for (int j = 0; j < multiplicacio.length; j++) {
				System.out.print(i+"*"+j+"="+multiplicacio[j][i]);
				System.out.println();
			}
		}
	}	
	
}
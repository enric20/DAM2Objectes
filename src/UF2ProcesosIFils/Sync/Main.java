package UF2ProcesosIFils.Sync;

import java.util.ArrayList;

import UF2ProcesosIFils.Exercici2.Fils;

public class Main {

	private static final int MAX_CONSUMIDORS = 5;
	
	public static void main(String[] args) throws InterruptedException {


		//Contenidor --> Guardem nombres imparells
		//Productor --> Genera nombres imparells 2*i + 1
		//Consumidor --> Comprovar si es nombre primer (mostrar per pantalla)
		
		//ArrayList<Thread> productor = new ArrayList<Thread>(); //Crear ArrayList dels fils
		
		
		Contenidor contenidor = new Contenidor();
		//Consumidor consumidor = new Consumidor(contenidor);
		Productor productor = new Productor(contenidor);
		ArrayList<Consumidor> consumidor = new ArrayList<Consumidor>();
		
		productor.start();
		
		for (int i = 0; i < MAX_CONSUMIDORS; i++) {
			
			//productor.add(new Thread(new Productor())); //Productor
			consumidor.add(new Consumidor(contenidor, i)); //Consumidor
			consumidor.get(i).start();
			//consumidor.get(i).sleep(5);
			
		}
		
		

	}

}
package UF2ProcesosIFils.LinkedBlockingQueue;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import UF2ProcesosIFils.Exercici2.Fils;

public class Main {

	private static final int MAX_CONSUMIDORS = 5;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		LinkedBlockingQueue<Integer> container = new LinkedBlockingQueue<>();
		Productor productor = new Productor(container);
		ArrayList<Consumidor> consumidor = new ArrayList<Consumidor>();
		
		
		productor.start();
		for (int i = 0; i < MAX_CONSUMIDORS; i++) {
			
			
			consumidor.add(new Consumidor(i, container)); //Consumidor
			consumidor.get(i).start();
			
			
		}
		
		

	}

}
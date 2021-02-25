package UF2ProcesosIFils.LinkedBlockingQueue;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumidor extends Thread {

	private int idConsumidor;
	LinkedBlockingQueue<Integer> c;	
	public Consumidor(int idConsumidor, LinkedBlockingQueue<Integer> c) {
		
		this.idConsumidor = idConsumidor;
		this.c = c;
		
	}
	
	public void run() {
		
		while (true) {
			
			System.out.println(" ha entrat a la cua "+idConsumidor);
			
			int num;
			
			try {
				num = c.take();
				
				boolean esPrimer = primer(num);
				//System.out.println(num);
				if (esPrimer) {
					System.out.println(num+" es primer, id: "+idConsumidor);
					
					boolean esFelic = felic(num);
					
					if (esFelic) {
						System.out.println(num+" es feliç, id: "+idConsumidor);
					}
					
					boolean esFibonacci = fibonacci(num);
					
					if (esFibonacci) {
						System.out.println(num+" es fibonacci, id: "+idConsumidor);
					}
				}
				
				System.out.println(num+" ha sigut consumit per "+idConsumidor);
			} 
			
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
					
	}
	
	boolean primer(int n) {
		 		
 		for (int i = 2; i < n; i++) {
 			//System.out.println(n +" % "+ i);
 			
 			if (n % i == 0) {
 				return false;
 			}
 			else if (i > n/2) { //OPTIMIZAR, SI I va per la meitat de n, n sera primer
 				return true;
 			}
 			
 		}
		
		
		return true;
	}
	
	boolean felic(int n) {
		int value = n;
		
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		ArrayList<Integer> numerosComprovar = new ArrayList<Integer>();
		
		boolean felic = false;
		int round = 0;
		
		while (!felic) {
			
			for (int i = 0; i < String.valueOf(value).length(); i++) { //SEPARAR VALORS
				
				
				char var = String.valueOf(value).charAt(i);
				int varInt = Integer.parseInt(String.valueOf(var)) ;
				numeros.add(varInt);
				//System.out.println("Separar "+varInt);
				
			}
			
			for (int i = 0; i < numeros.size(); i++) { //ELEVAR VALORS A 2
				
				numeros.set(i, (int) Math.pow(numeros.get(i), 2));
				//System.out.println("Elevar: "+numeros.get(i));
				
				
				
			}
			
			value = 0;
			
			for (int i = 0; i < numeros.size(); i++) { //SUMAR ELS VALORS
				 value += numeros.get(i);
				 
			}
			
			
			//System.out.println("Suma: "+value);
			
			if (value == 1) {
				felic = true;
			}
			
			else if (numerosComprovar.contains(value)) {
				return false;
			}
			//System.out.println(numeroInicialPowGuardat+" "+numeroInicialPow);
			
			numeros.removeAll(numeros);
			numerosComprovar.add(value);
			/*round++;
			if (round >= 10) {
				return false;
			}
			*/
		}
		
		
		return true;
	}
	
	boolean fibonacci(int n) {
		
		if (n == 1) {
			return true;
		}
		
		int fibonacciPrimer = 1;
		int fibonacciAnterior = 0;
		
		while (fibonacciPrimer < n) {
			
			
			int suma = fibonacciPrimer+fibonacciAnterior;
			fibonacciAnterior = fibonacciPrimer;
			fibonacciPrimer = suma;

			if (fibonacciPrimer == n) {
				return true;
			}
			
			
			
		}
		
		
		return false;
	}
	
}

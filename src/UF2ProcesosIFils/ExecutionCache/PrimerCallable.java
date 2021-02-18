package UF2ProcesosIFils.ExecutionCache;

import java.util.concurrent.Callable;

public class PrimerCallable implements Callable<Integer> {

	int numero;
	
	public PrimerCallable(int i) {

		this.numero = i;
		
	}

	@Override
	public Integer call() throws Exception {
		
		int num = this.numero;
		
		while (!esPrimer(num)) {
			System.out.println(num+" no es primer");
			num++;
		}

		return num;
	
	}
	
	boolean esPrimer(int num) {
		
		for (int i = 2; i < num; i++) {
 			//System.out.println(n +" % "+ i);
 			
 			if (num % i == 0) {
 				return false;
 			}
 			else if (i > num/2) { //OPTIMIZAR, SI I va per la meitat de n, n sera primer
 				return true;
 			}
 			
 		}
		
		return true;
	}

	

}
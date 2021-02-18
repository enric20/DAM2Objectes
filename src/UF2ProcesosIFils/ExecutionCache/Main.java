package UF2ProcesosIFils.ExecutionCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		PrimerCallable pc1 = new PrimerCallable(1732);
		PrimerCallable pc2 = new PrimerCallable(4541);
		PrimerCallable pc3 = new PrimerCallable(6666);
		
		Future<Integer> f1 = executor.submit(pc1);
		Future<Integer> f2 = executor.submit(pc2);
		Future<Integer> f3 = executor.submit(pc3);
		
		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
			System.out.println(f3.get());
		}
		catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

}
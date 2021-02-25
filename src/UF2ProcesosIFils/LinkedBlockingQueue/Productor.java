package UF2ProcesosIFils.LinkedBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class Productor extends Thread{

	LinkedBlockingQueue<Integer> c;
	
	public Productor(LinkedBlockingQueue<Integer> c) {
		
		this.c = c;
	}
	
	public void run() {
		
		int i = 3;
		
		while (true) {
			
			int num = ((i*2)+1);
			c.add(num);
			i++;

		}
		
		
	}
	
}
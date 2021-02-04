package UF2ProcesosIFils.Sync;

public class Productor extends Thread{

	Contenidor contenidor;
	
	public Productor(Contenidor c) {
		
		this.contenidor = c;
		
	}
	
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			
			int num = ((i*2)+1);
			contenidor.produir(num);
		}
		
		
	}


	
}

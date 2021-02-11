package UF2ProcesosIFils.Sync;

public class Productor extends Thread{

	Contenidor contenidor;
	
	public Productor(Contenidor c) {
		
		this.contenidor = c;
		
	}
	
	public void run() {
		
		int i = 3;
		
		while (true) {
			
			int num = ((i*2)+1);
			contenidor.produir(num);
			i++;
			
			try {
				Thread.sleep(5);
			}
			
			catch (Exception e) {
				System.out.println("Error "+e);
			}
		}
		
		
	}


	
}

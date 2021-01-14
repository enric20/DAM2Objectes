package UF2ProcesosIFils.Exercici1;

public class Fils extends Thread{
	
	String threadName;
	private int count;
	private int finalitzarComptador;
	
	public Fils(int initialitzarComptador, int finalitzarComptador, String thread) {
		
		this.count = initialitzarComptador;
		this.finalitzarComptador = finalitzarComptador;
		this.threadName = thread;

	}
	
	public void run() {
		
		for (int i = count; i < finalitzarComptador; i++) {
			
			System.out.print(i+" ");
			
		}
		System.out.println("");
		
	}
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

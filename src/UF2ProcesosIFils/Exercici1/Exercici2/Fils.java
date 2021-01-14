package UF2ProcesosIFils.Exercici2;

public class Fils extends Thread{

	int num;
	static int[] numeros;
	int posicio;
	
	public Fils(int num, int posicio, int tamanyArray) {
		
		this.num = num;
		this.numeros = new int[tamanyArray];
		this.posicio = posicio;
	}
	
	
	public void run() {
		
		for (int i = posicio; i < numeros.length; i++) {
			
			numeros[i] = num;
		}
		
	}
	
	public static void LlegirArrayUnic() {
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i]);
		}
	}
	
}

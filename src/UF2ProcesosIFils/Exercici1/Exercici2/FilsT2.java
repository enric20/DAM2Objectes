package UF2ProcesosIFils.Exercici2;

public class FilsT2 extends Thread {

	private int taulaActual;
	static int[][] multiplicacions;

	public FilsT2(int maximaPosicio, int taulaActual, int[][] mainMultiplicacions) {
		
		this.taulaActual = taulaActual;
		multiplicacions = mainMultiplicacions;
		
	}
	
	public void run() {
		
		for (int i = 0; i < multiplicacions.length; i++) {
			int calcul = taulaActual*i;
			multiplicacions[taulaActual][i] = calcul;
		}
		LlegirArrayUnic();
	}
	
	public void LlegirArrayUnic() {
		System.out.println();
		for (int i = 0; i < multiplicacions.length; i++) {
			System.out.print(taulaActual+"*"+i+"="+multiplicacions[taulaActual][i]);
			System.out.println();
		}
	}
	
}

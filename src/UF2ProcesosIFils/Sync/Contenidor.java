package UF2ProcesosIFils.Sync;

import java.util.ArrayList;
import java.util.Vector;

public class Contenidor extends Thread{
	
	Vector<Integer> nums = new Vector<Integer>();
	int num;
	
	
	public Contenidor() {
		
	}

	public synchronized void produir(int num) {
		
		if (nums.size() != 0) { //Si hi ha un producte en el contenidor esperara a que es consumeixi
			
			try {
				wait();
			}
			catch (Exception e) {
				
				System.out.println("Exception "+e);
				
			}
		}
		
		
		nums.addElement(num);
		notify();
		
	}
	
	public synchronized int consumir() {
		
		if (nums.size() == 0) { //Si no hi ha productes per consumir en el contenidor esperara a que s'afegeixin
			
			try {
				wait();
			}
			catch (Exception e) {
				
				System.out.println("Exception "+e);
				
			}
		}
		
		int numero = nums.elementAt(0); //Guardar el numero en una variable
		nums.removeElementAt(0); //Consumir el numero
		notify();
		return numero; //Retornar-lo
		
	}

}

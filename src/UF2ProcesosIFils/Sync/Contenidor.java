package UF2ProcesosIFils.Sync;

import java.util.ArrayList;
import java.util.Vector;

public class Contenidor extends Thread{
	
	//Vector<Integer> nums = new Vector<Integer>();
	int num;
	boolean emplenat;
	
	
	public Contenidor() {
		this.num = 0;
		this.emplenat = false;
		
	}

	public synchronized void produir(int num) {
		
		while (emplenat) { //Si hi ha un producte en el contenidor esperara a que es consumeixi
			
			try {
				wait();
			}
			catch (Exception e) {
				
				System.out.println("Exception "+e);
				
			}
		}
		
		emplenat = true;
		this.num = num;
		notify();
		
	}
	
	public synchronized int consumir() {
		
		while (!emplenat) { //Si no hi ha productes per consumir en el contenidor esperara a que s'afegeixin
			
			try {
				wait();
			}
			catch (Exception e) {
				
				System.out.println("Exception "+e);
				
			}
		}
		
		emplenat = false;
		notify();
		return this.num; //Retornar-lo
		
	}

}

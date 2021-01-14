package UF2ProcesosIFils.Exercici1;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Fils fils = new Fils(0, 0, "");
		
		Thread t1 = new Thread(new Fils(0, 10, "T1"));
		Thread t2 = new Thread(new Fils(10, 20, "T2"));
		Thread t3 = new Thread(new Fils(20, 30, "T3"));
		Thread t4 = new Thread(new Fils(30, 40, "T4"));
		Thread t5 = new Thread(new Fils(40, 50, "T5"));
		
		//Thread t6 = new Thread(new Fils(0, 500000));
		System.out.print("Thread 1: ");
		t1.start();
		t1.sleep(500);
		System.out.print("Thread 2: ");
		t2.start();
		t2.sleep(500);
		System.out.print("Thread 3: ");
		t3.start();
		t3.sleep(500);
		System.out.print("Thread 4: ");
		t4.start();
		t4.sleep(500);
		System.out.print("Thread 5: ");
		t5.start();
				
	}
	
}

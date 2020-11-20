package M3_UF4_Act1;
import java.util.Scanner;

public class Rectangle { //Clase de tot l'objecte rectangle

	static Scanner lector = new Scanner(System.in);
	private float base;
	private float alcada;

	public float CalcularPerimetreRectangle() {
		
		float perimetre = (base*2)+(alcada*2);
		//System.out.println("Perimetre: "+perimetre);
		return perimetre;
	}
		
	public float CalcularAreaRectangle() {
		
		float area = base*alcada;
		//System.out.println("Area: "+area);
		return area;
	}
	
	public static void MostrarDades(float[][] rectangles) {
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println("Rectangle: "+i+" = Perimetre: "+rectangles[i][0]+" | Area: "+rectangles[i][1]);
			
		}
	}
	
	//Constructor de la classe rectangle, this. significa la variable dintre del propi script
	public Rectangle(float base, float alcada) {
		this.setAlcada(alcada); //Definir la variable "alcada" dintre del objecte
		this.setBase(base);
	}

	private void setAlcada(float alcada) {
		this.alcada = alcada;
	}

	private void setBase(float base) {
		this.base = base;
	}

	public float getBase(float base) {
		return base;
	}

	private float getAlcada(float alcada) {
		return alcada;
	}

}

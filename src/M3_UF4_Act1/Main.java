package M3_UF4_Act1;
import java.util.Scanner;


public class Main { 
	
	private static int MAX_RECTANGLES = 5;
	private static float[][] resultatRectangle;
	
	public static void main(String[] args) {
		
		Scanner lector = new Scanner(System.in);
		boolean acabar = false;
		int rectanglesInt = 0;
		float[][] rectanglesAreaPerimetre = new float[5][2];
		Rectangle[] rectangles = new Rectangle[MAX_RECTANGLES];
		
		while (rectanglesInt < MAX_RECTANGLES) {
			System.out.println("Calcular perimetre rectangle, posa 2 numeros separats per espai");
			float costat1 = lector.nextInt();
			float costat2 = lector.nextInt();
			lector.nextLine();
			
			rectangles[rectanglesInt] = new Rectangle(costat1, costat2);
			
			rectanglesAreaPerimetre[rectanglesInt][1] = rectangles[rectanglesInt].CalcularAreaRectangle();
			rectanglesAreaPerimetre[rectanglesInt][0] = rectangles[rectanglesInt].CalcularPerimetreRectangle();
			
			//rectanglesAreaPerimetre[rectangles][0] = Rectangle.CalcularPerimetreRectangle(costat1, costat2);
			//rectanglesAreaPerimetre[rectangles][1] = Rectangle.CalcularAreaRectangle(costat1, costat2);
			
			rectanglesInt++;
		}
		
		Rectangle.MostrarDades(rectanglesAreaPerimetre);
		RectangleMesGran(rectanglesAreaPerimetre);
		
		
	}
	
	private static void RectangleMesGran(float[][] resultatsRectangle) {
		
		float rectangleMesGran = resultatsRectangle[0][1];
		int rectangle = 0;
		
		for (int i = 0; i < resultatsRectangle.length; i++) {
			if (resultatsRectangle[i][1] > rectangleMesGran) {
				
				rectangleMesGran = resultatsRectangle[i][1];
				rectangle = i;
			}	
		}
		
		System.out.println("El rectamgle mes gran es el numero "+rectangle+" amb un area de "+rectangleMesGran);
	}

}

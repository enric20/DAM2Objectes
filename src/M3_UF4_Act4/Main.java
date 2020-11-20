package M3_UF4_Act4;

import java.util.Scanner;
/**
 * Version 1.0
 * @author Herk
 * Programa principal per a definir figures geometriques
 */
public class Main {

	public static void main(String[] args) {

		Scanner lector = new Scanner(System.in);

		Rectangle rectangle = new Rectangle("Vermell", false, 3, 5); //Color | colorFons | costat | altura
		Cercle cercle = new Cercle("Verd", true, 3); //Color | colorFons | radi
		Quadrat quadrat = new Quadrat("Groc", false, 3, 2); //Color | colorFons | costat | amplitud (substituit per costat, valor heredat, no important per al quadrat
		//rectangle.setColorFons(false);
		System.out.println(rectangle.toString());
		System.out.println(cercle.toString());
		System.out.println(quadrat.toString());
		
		
	}

}

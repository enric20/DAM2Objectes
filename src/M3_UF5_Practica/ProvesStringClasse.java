package M3_UF5_Practica;

public class ProvesStringClasse {

	public static void main(String[] args) {

		/**
		 * ------------------------------------------------------------------------------
		 * 	   -------------------------- MÈTODES SIMPLES --------------------------
		 * ------------------------------------------------------------------------------
		 */
		String frase = "Hola com estás?"; //Crear un String com a nom frase
		System.out.println(frase); //Mostrar el contingut de la variable frase per pantalla
		
		/**
		 * Lletres & Strings
		 */
		frase.charAt(0); //Agafa la lletra en la posicio 0 de la paraula, retorna un char
		String f1 = "";
		f1 = f1+""+frase.charAt(0); //Afegix la lletra en la posicio 0 de frase en el string especificat
		f1 = f1+""+frase.charAt(12); //Afegix la lletra en la posicio 12 de frase en el string especificat
		System.out.println(f1);
		
		int longitudString = f1.length(); //Retorna la longitud del string, retorna un integer
		String lletresNumeros = ""+String.valueof(longitudString);
		
		
		
	}
	

}

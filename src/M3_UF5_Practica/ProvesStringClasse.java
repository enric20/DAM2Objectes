package M3_UF5_Practica;

/**
 * String es una variable utilitzada per a emmagtzemar qualsevol tipus de data que sigui simplificada.
 * @author enric
 * @version 1.0
 */
public class ProvesStringClasse {

	public static void main(String[] args) { 

		/**
		 * ------------------------------------------------------------------------------
		 * 	   -------------------------- M�TODES SIMPLES --------------------------
		 * ------------------------------------------------------------------------------
		 */
		
		String frase = "Hola com est�s?"; //Crear un String com a nom frase
		System.out.println(frase); //Mostrar el contingut de la variable frase per pantalla
		
		
		//M�TODE --- charAt(posicio)
		frase.charAt(0); //Agafa la lletra en la posicio 0 de la paraula, retorna un char
		
		//EXEMPLES
		String f1 = "";
		
		f1 += frase.charAt(0); //Afegix la lletra en la posicio 0 de frase en el string especificat
		
		f1 += frase.charAt(12); //Afegix la lletra en la posicio 12 de frase en el string especificat
		
		System.out.println(f1);
		
		System.out.println("-------------------------------------");
		
		
		//M�TODE --- string.length()
		f1.length();
		//EXEMPLES
		int longitudString = f1.length(); //Retorna la longitud del string, retorna un integer
		
		longitudString = f1.length()-2; //Agafar la pen�ltima lletra del string
		
		longitudString += f1.charAt(f1.length()-1); //Afegir L'�ltima lletra del string
		
		System.out.println(longitudString);
		
		System.out.println("-------------------------------------");
		
		//M�TODE --- String.valueOf(variable)
		String.valueOf(longitudString); //Transforma el integer/char/boolean seleccionat en un string
		
		//EXEMPLES
		String lletresNumeros = ""+String.valueOf(longitudString); //Transforma la variable integer longtitudString a un integer
		
		lletresNumeros = lletresNumeros + " - objectes"; //Afegir el string
		
		System.out.println(lletresNumeros);
		
		System.out.println("-------------------------------------");
		
		
		//M�TODES --- frase.concat(afegirCadena) | frase.contains(lletraBuscar) | frase.equals(fraseComparar) | frase.equalsIgnoreCase(fraseComparar)
		lletresNumeros = lletresNumeros.concat(" totals"); //Afegeix una cadena al final de una string
		
		lletresNumeros.contains("e"); //Mirar si la cadena t� la paraula especificada (e) (retornara un true o false)
		
		lletresNumeros.endsWith("totals"); //Mirar si la cadena acaba amb la paraula especificada
		
		lletresNumeros.equals("224 - objectes"); //Mirar si tot el contingut de la cadena coincideix
		
		lletresNumeros.equalsIgnoreCase("224 - OBJECTES"); //Mirar si tot el contingut de la cadena coincideix (ignorar maj�scules)
		
		//EXEMPLES
		System.out.println(lletresNumeros.concat(" totals"));
		
		System.out.println("Paraula 'e' existeix: "+lletresNumeros.contains("e"));
		
		System.out.println("Acaba amb 'totals': "+lletresNumeros.endsWith("totals"));
		
		System.out.println("La cadena (224 - objectes) coincideix amb ("+lletresNumeros+") : "+lletresNumeros.equals("224 - objectes"));

		System.out.println("La cadena (224 - objectes totals) coincideix amb ("+lletresNumeros+") : "+lletresNumeros.equals("224 - objectes totals"));
		
		System.out.println("La cadena (224 - OBJECTES totals) coincideix (ignorar maj�scules) amb ("+lletresNumeros+") : "+lletresNumeros.equalsIgnoreCase("224 - OBJECTES totals"));
		
		System.out.println("-------------------------------------");
		
		
		//ALTRES M�TODES
		
		System.out.println("Est� en blanc?: "+lletresNumeros.isBlank()); //Retorna true si no cont� res o te l�nies en blanc
		
		System.out.println("Est� vuit? "+lletresNumeros.isEmpty()); //Retorna true si la longitud de la cadena es 0
		
		System.out.println("Sense maj�scules: "+lletresNumeros.toLowerCase()); //Retorna la cadena sense majuscules
		
		System.out.println("Amb maj�scules: "+lletresNumeros.toUpperCase()); //Retorna la cadena amb tot maj�scules
		
		System.out.println("Sense espais al principi i al final: "+"      sense espais blancs al principi   i al final     ".strip()); //Retorna la cadena sense espais blancs al principi i final de la cadena
		
		String[] fraseRetallada = lletresNumeros.split("-"); //Retallar el string a partir del caracter '-'
		
		for (int i = 0; i < fraseRetallada.length; i++) {
			System.out.println("Split "+i+" : "+fraseRetallada[i].strip());
		}
		
		System.out.println("-------------------------------------");
		
		
		/**
		 * ------------------------------------------------------------------------------
		 * 	   -------------------------- M�TODES AVAN�ATS --------------------------
		 * ------------------------------------------------------------------------------
		 */
		
		
		//M�TODE --- string.compareTo(strin2);
		"A".compareTo("B"); //Comparar si la lletra A va abans que la lletra B (-1 si es abans, 1 si es despres)
		
		//EXEMPLES
		System.out.println("Lletra A es abans: "+"A".compareTo("B"));
		System.out.println("Lletra B es despres: "+"B".compareTo("A"));
		System.out.println("-------------------------------------");
		
		
		//M�TODE --- string.getBytes()
		byte[] tamany = lletresNumeros.getBytes(); //Convertir el string a bytes (serveix per traduir a sistema informatica i obtenir la posicio en el codi ascii
		for (int i = 0; i < tamany.length; i++) {
			System.out.println(tamany[i]+" "+ (char) tamany[i]); //Traduir els numeros a ASCII
		}
		System.out.println("-------------------------------------");
		
		
		//M�TODE --- string.replaceAll(lletraASubstituir, lletraPerSubstituir) | string.replaceAll(lletraASubstituir, lletraPerSubstituir)
		System.out.println("Substituir totes les e per 3: "+lletresNumeros.replaceAll("e", "3")); //Substituir tots els caracters per un altre
		System.out.println("La primera o per 0: "+lletresNumeros.replaceFirst("o", "0")); //Substuir el primer 
		System.out.println("Retallar entre 5 i 10: "+lletresNumeros.substring(5, 10)); //Retallar un string
		
		String formatarFrase = "Frase formatada";
		
		formatarFrase = String.format("%-20s", formatarFrase); //Afegir espais
		
		System.out.println(formatarFrase); //Ens retorna la frase amb espais afegits

	}
	

}
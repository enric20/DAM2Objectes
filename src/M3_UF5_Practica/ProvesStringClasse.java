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
		 * 	   -------------------------- MÈTODES SIMPLES --------------------------
		 * ------------------------------------------------------------------------------
		 */
		
		String frase = "Hola com estàs?"; //Crear un String com a nom frase
		System.out.println(frase); //Mostrar el contingut de la variable frase per pantalla
		
		
		//MÈTODE --- charAt(posicio)
		frase.charAt(0); //Agafa la lletra en la posicio 0 de la paraula, retorna un char
		
		//EXEMPLES
		String f1 = "";
		
		f1 += frase.charAt(0); //Afegix la lletra en la posicio 0 de frase en el string especificat
		
		f1 += frase.charAt(12); //Afegix la lletra en la posicio 12 de frase en el string especificat
		
		System.out.println(f1);
		
		System.out.println("-------------------------------------");
		
		
		//MÈTODE --- string.length()
		f1.length();
		//EXEMPLES
		int longitudString = f1.length(); //Retorna la longitud del string, retorna un integer
		
		longitudString = f1.length()-2; //Agafar la penúltima lletra del string
		
		longitudString += f1.charAt(f1.length()-1); //Afegir L'última lletra del string
		
		System.out.println(longitudString);
		
		System.out.println("-------------------------------------");
		
		//MÈTODE --- String.valueOf(variable)
		String.valueOf(longitudString); //Transforma el integer/char/boolean seleccionat en un string
		
		//EXEMPLES
		String lletresNumeros = ""+String.valueOf(longitudString); //Transforma la variable integer longtitudString a un integer
		
		lletresNumeros = lletresNumeros + " - objectes"; //Afegir el string
		
		System.out.println(lletresNumeros);
		
		System.out.println("-------------------------------------");
		
		
		//MÈTODES --- frase.concat(afegirCadena) | frase.contains(lletraBuscar) | frase.equals(fraseComparar) | frase.equalsIgnoreCase(fraseComparar)
		lletresNumeros = lletresNumeros.concat(" totals"); //Afegeix una cadena al final de una string
		
		lletresNumeros.contains("e"); //Mirar si la cadena té la paraula especificada (e) (retornara un true o false)
		
		lletresNumeros.endsWith("totals"); //Mirar si la cadena acaba amb la paraula especificada
		
		lletresNumeros.equals("224 - objectes"); //Mirar si tot el contingut de la cadena coincideix
		
		lletresNumeros.equalsIgnoreCase("224 - OBJECTES"); //Mirar si tot el contingut de la cadena coincideix (ignorar majúscules)
		
		//EXEMPLES
		System.out.println(lletresNumeros.concat(" totals"));
		
		System.out.println("Paraula 'e' existeix: "+lletresNumeros.contains("e"));
		
		System.out.println("Acaba amb 'totals': "+lletresNumeros.endsWith("totals"));
		
		System.out.println("La cadena (224 - objectes) coincideix amb ("+lletresNumeros+") : "+lletresNumeros.equals("224 - objectes"));

		System.out.println("La cadena (224 - objectes totals) coincideix amb ("+lletresNumeros+") : "+lletresNumeros.equals("224 - objectes totals"));
		
		System.out.println("La cadena (224 - OBJECTES totals) coincideix (ignorar majúscules) amb ("+lletresNumeros+") : "+lletresNumeros.equalsIgnoreCase("224 - OBJECTES totals"));
		
		System.out.println("-------------------------------------");
		
		
		//ALTRES MÈTODES
		
		System.out.println("Està en blanc?: "+lletresNumeros.isBlank()); //Retorna true si no conté res o te línies en blanc
		
		System.out.println("Està vuit? "+lletresNumeros.isEmpty()); //Retorna true si la longitud de la cadena es 0
		
		System.out.println("Sense majúscules: "+lletresNumeros.toLowerCase()); //Retorna la cadena sense majuscules
		
		System.out.println("Amb majúscules: "+lletresNumeros.toUpperCase()); //Retorna la cadena amb tot majúscules
		
		System.out.println("Sense espais al principi i al final: "+"      sense espais blancs al principi   i al final     ".strip()); //Retorna la cadena sense espais blancs al principi i final de la cadena
		
		String[] fraseRetallada = lletresNumeros.split("-"); //Retallar el string a partir del caracter '-'
		
		for (int i = 0; i < fraseRetallada.length; i++) {
			System.out.println("Split "+i+" : "+fraseRetallada[i].strip());
		}
		
		System.out.println("-------------------------------------");
		
		
		/**
		 * ------------------------------------------------------------------------------
		 * 	   -------------------------- MÈTODES AVANÇATS --------------------------
		 * ------------------------------------------------------------------------------
		 */
		
		
		//MÈTODE --- string.compareTo(strin2);
		"A".compareTo("B"); //Comparar si la lletra A va abans que la lletra B (-1 si es abans, 1 si es despres)
		
		//EXEMPLES
		System.out.println("Lletra A es abans: "+"A".compareTo("B"));
		System.out.println("Lletra B es despres: "+"B".compareTo("A"));
		System.out.println("-------------------------------------");
		
		
		//MÈTODE --- string.getBytes()
		byte[] tamany = lletresNumeros.getBytes(); //Convertir el string a bytes (serveix per traduir a sistema informatica i obtenir la posicio en el codi ascii
		for (int i = 0; i < tamany.length; i++) {
			System.out.println(tamany[i]+" "+ (char) tamany[i]); //Traduir els numeros a ASCII
		}
		System.out.println("-------------------------------------");
		
		
		//MÈTODE --- string.replaceAll(lletraASubstituir, lletraPerSubstituir) | string.replaceAll(lletraASubstituir, lletraPerSubstituir)
		System.out.println("Substituir totes les e per 3: "+lletresNumeros.replaceAll("e", "3")); //Substituir tots els caracters per un altre
		System.out.println("La primera o per 0: "+lletresNumeros.replaceFirst("o", "0")); //Substuir el primer 
		System.out.println("Retallar entre 5 i 10: "+lletresNumeros.substring(5, 10)); //Retallar un string
		
		String formatarFrase = "Frase formatada";
		
		formatarFrase = String.format("%-20s", formatarFrase); //Afegir espais
		
		System.out.println(formatarFrase); //Ens retorna la frase amb espais afegits

	}
	

}
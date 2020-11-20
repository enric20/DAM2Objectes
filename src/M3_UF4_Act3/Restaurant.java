package M3_UF4_Act3;

public class Restaurant {
	
	private int dotzenesOusNum;
	private int botifarresNum;
	private double kgMongetes;
	/**
	 * Constructor de rastaurant
	 * @param dotzenesOusNum int (unitats en dotzenes)
	 * @param botifarresNum int (unitats)
	 * @param kgMongetes double (kg)
	 */
	public Restaurant (int dotzenesOusNum, int botifarresNum, double kgMongetes)
	{
		
		this.setDotzenesOusNum(dotzenesOusNum);
		this.setBotifarresNum(botifarresNum);
		this.setKgMongetes(kgMongetes);
		
	}

	
	//DotzenesOus
	public int getDotzenesOusNum() {
		return dotzenesOusNum;
	}

	public void setDotzenesOusNum(int dotzenesOusNum) {
		this.dotzenesOusNum = dotzenesOusNum;
	}
	
	public void afegirOus(int quantitat) {
		dotzenesOusNum = dotzenesOusNum+quantitat;
	}

	
	//Botifarres
	public int getBotifarresNum() {
		return botifarresNum;
	}

	public void setBotifarresNum(int botifarresNum) {
		this.botifarresNum = botifarresNum;
	}
	
	public void afegirBotifarres(int quantitat) {
		botifarresNum = botifarresNum+quantitat;
	}

	//Mongetes
	public double getKgMongetes() {
		return kgMongetes;
	}

	public void setKgMongetes(double kgMongetes) {
		this.kgMongetes = kgMongetes;
	}
	
	public void afegirMongetes(double pes) {
		kgMongetes = kgMongetes + pes;
	}
	
	/**
	 * Retorna el numero de plats maxim que es poden fer amb els aliments disponibles
	 * @return numPlats Numero de plats possibles
	 */
	public int getNumPlats() {
		int numPlats = 999999;
		
		int[] platsMaxim = new int[3];
		
		platsMaxim[0] = (int) (kgMongetes/0.2); //0.2 kg de mongetes per PLAT
		platsMaxim[1] = (int) (dotzenesOusNum/2); //2 ous per PLAT
		platsMaxim[2] = (int) (botifarresNum/1); //1 botifarra per PLAT (ho divideixo per a que es vegi, no es necessaria cap divisió.
		
		for (int i = 0; i < platsMaxim.length; i++) {
			
			if (platsMaxim[i] < numPlats) { //Agafara la quantitat minima que es poden fer de plats
				numPlats = platsMaxim[i];
			}
			
		}
		
		return numPlats;
	}
	/**
	 * Serveix 1 plat, resta la quantitat actual a les variables
	 */
	public void servirPlats() {
		
		kgMongetes -= 0.2;
		dotzenesOusNum -= 2;
		botifarresNum -= 1;
		
	}
	
	
}

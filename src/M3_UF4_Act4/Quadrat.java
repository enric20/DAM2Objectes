package M3_UF4_Act4;

public class Quadrat extends Rectangle{

	private double costat;
	private double ample;
	
	/**
	 * Constructor classe Quadrat, valors heredats de rectangle i figura geometrica
	 * @param color 
	 * @param colorFons
	 * @param costat
	 * @param ample
	 */
	protected Quadrat(String color, boolean colorFons, double costat, double ample) {
		super(color, colorFons, costat, ample);
		this.setCostat(costat);
		this.setAmple(costat);
		
	}

	public double getCostat() {
		return costat;
	}

	public void setCostat(double costat) {
		this.costat = costat;
	}
	
	//Ample
	
	/**
	 * Substitueix l'amplitud del quadrat per a que siguin iguals (per a que sigui un rectangle).
	 * @param costat Costat del Quadrat
	 */
	public void setAmple(double costat) {
		this.ample = costat;
	}
	/**
	 * Retorna per pantalla les especificacion del quadrat, de la classe rectangle i les de la figurageometrica
	 * @return especficacions
	 */
	public String toString() {

		return "Sóc un quadrat de costat "+costat+", la meva superclasse: "+super.toString();
	}
	
}

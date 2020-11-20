package M3_UF4_Act4;

public class Cercle extends FiguraGeometrica {

	private double radi = 1;
	
	/**
	 * Constructor de cercle a partir de la figura geometrica, hereda el color
	 * @param color String
	 * @param radi double
	 */
	protected Cercle(String color, boolean colorFons, double radi) {
		super(color, colorFons);
		this.setRadi(radi);
		
		//toString(color, colorFons);
	}
	
	/**
	 * Mostra especificacions del cercle i de la figura geometrica
	 * return String
	 */
	public String toString() {
		
		return "Sóc un cercle de radi "+radi+" i la meva superclasse: "+super.toString()+": ";
	}
	
	public double getArea() {
		
		return (2*radi*3.1415);
		
	}

	public double getRadi() {
		return radi;
	}

	public void setRadi(double radi) {
		this.radi = radi;
	}
	
}

package M3_UF4_Act4;

public class Rectangle extends FiguraGeometrica{

	private double base = 2;
	private double alcada = 1;
	
	/**
	 * Constructor Rectangle, hereda el color de figura geometrica
	 * @param base double
	 * @param alcada double
	 * @param color String
	 */
	protected Rectangle(String color, boolean colorFons, double base, double alcada) {
		super(color, colorFons);
		this.setBase(base);
		this.setAlcada(alcada);
		
	}
	/**
	 * Donat les especificació del rectangle, imprimeix un texte per pantalla especificant les seves característiques incluint las de la seva superclasse
	 */
	public String toString() {
		
		return "Sóc un rectangle de base "+base+" i alcada "+alcada+" i la meva superclasse: "+super.toString()+": ";
	}
	
	public double getArea() {
		
		return (base*alcada);
		
	}
	
	public double getPerimetre() {
		
		return (base*2+alcada*2);
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAlcada() {
		return alcada;
	}

	public void setAlcada(double alcada) {
		this.alcada = alcada;
	}
	
}

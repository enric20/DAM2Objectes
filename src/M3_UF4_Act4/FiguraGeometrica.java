package M3_UF4_Act4;

public class FiguraGeometrica {

	private String color = "Vermell";
	private boolean colorFons = true;
	
	/**
	 * Constructor Figura geometrica
	 * @param color String boolean colorFons
	 */
	public FiguraGeometrica(String color, boolean colorFons) {
		
		this.setColor(color);
		this.setColorFons(colorFons);
		
	}
	
	/**
	 * Mostra especificacions de la figura geometrica
	 */
	public String toString() {
		
		String teFons = "";
		if (colorFons) {
			teFons = "tinc";
		}
		else {
			teFons = "no tinc";
		}
		return "Sóc una figura de color "+color+" i "+teFons+" color de fons";
	}
	
	/**
	 * Retorna el color de la figura geometrica
	 * @return color
	 */
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Retorna el color de fons de la figura geometrica
	 * @return color
	 */
	public boolean getColorFons() {
		return colorFons;
	}

	public void setColorFons(boolean colorFons) {
		this.colorFons = colorFons;
	}
	
	
	
}

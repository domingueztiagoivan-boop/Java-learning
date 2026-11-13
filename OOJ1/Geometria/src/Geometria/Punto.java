package Geometria;

public class Punto {

	private double x;
	private double y;

//constructor
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

//m�todos getter y setter
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}


	public boolean equals(Punto p) {
		return ((x == p.getX()) && (y == p.getY()));
	}


	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public double calcularDistancia(Punto p) {
		
		double dx = this.x - p.getX();
		double dy = this.x - p.getY();
		
		return Math.sqrt(dx * dx + dy * dy);
	}
}

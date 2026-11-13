package Test;

import Geometria.Punto;

public class TestPunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Punto p1 = new Punto(10, 5);
		Punto p2 = new Punto(5, 5);
		Punto p3 = new Punto(10, 5);
		
		System.out.print(p1.equals(p2));
		System.out.print("\n" + p1.equals(p3));
		
		System.out.print("\n" + p1.calcularDistancia(p2));
		
	}

}

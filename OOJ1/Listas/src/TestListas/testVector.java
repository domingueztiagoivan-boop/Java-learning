package TestListas;

import Listas.Vector;

public class testVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vector v1 = new Vector(10);
		
		v1.agregarValor(1);
		v1.agregarValor(56);
		v1.agregarValor(31);
		v1.agregarValor(9);
		v1.agregarValor(12);
		v1.agregarValor(6);
		v1.agregarValor(12);
		v1.agregarValor(8);
		v1.agregarValor(45);
		
		
		
		System.out.print("\n" + v1.traerElMayor());
		System.out.print("\n" + v1.traerElMenor());
		System.out.print("\n" + v1.getTamaño() + "  " + v1.getTamañoTotal());
		System.out.print("\n" + v1.calcularPromedio());
		v1.imprimirVector();
		v1.ordenarAscendente();
		v1.imprimirVector();
		v1.ordenarDescendente();
		v1.imprimirVector();
		System.out.print("\n" + v1.traerFrecuencia(2));
		System.out.print("\n" + v1.traerModa());
	}

}

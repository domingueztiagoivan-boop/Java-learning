package test;

import modelo.Numero;

public class TestNumero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Numero n = new Numero(5);
		
		System.out.print(n.getEntero() + "\n");
		System.out.print(n.sumar(1) + "\n");
		System.out.print(n.multiplicar(1) + "\n");
		System.out.print(n.esPar() + "\n");
		System.out.print(n.esPrimo() + "\n");
		System.out.print(n.convertirAString() + "\n");
		System.out.print(n.convertirDouble() + "\n");
		System.out.print(n.calcularPotencia(2) + "\n");
		System.out.print(n.calcularFactorial() + "\n");
		System.out.print(n.numeroCombinatorio(3) + "\n");
		
	}

}

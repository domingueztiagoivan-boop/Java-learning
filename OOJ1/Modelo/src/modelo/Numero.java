package modelo;


public class Numero {
		
	private int n;

	
	public Numero(int n) {
		this.n = n;
	}
	
	public int getEntero() {
		return n;
	}
	
	public void setEntero(int n) {
		this.n = n;
	}
	
	public int sumar(int n1) {
		n = n + n1;
		return n;
	}
	
	public int multiplicar(int n1) {
		n = n * n1;
		return n;
	}
	
	public boolean esPar() {
		return ((n % 2) == 0); 
	}
	
	public boolean esPrimo() {
		if (n <= 1) {
			return false;
		}
		if ((n % 2) == 0) {
			return false;
		}
		
		return true;
	}
	
	public String convertirAString() {
		return String.valueOf(n);
	}
	
	public double convertirDouble() {
		
		return (double) n;
	}
	
	public double calcularPotencia(int exp) {
		return Math.pow(n, exp);
	}
	
	public int calcularFactorial() {
		
		if (n <= 0) {
			return 1;
		}
		
		int resultado = 1;
		
		for (int i=1; i <= n; i++) {
			resultado *=  i;
		}
		
		return resultado;
	}
	
	public int numeroCombinatorio(int n1) {
		
		if (n1 < 0 || n1 > this.n) {
	        System.out.println("Error: numero ingresado debe ser >= 0 y <= n");
	        return 0;
	    }

	    return this.calcularFactorial() / (new Numero(n1).calcularFactorial() * new Numero(this.n - n1).calcularFactorial());

	}
}

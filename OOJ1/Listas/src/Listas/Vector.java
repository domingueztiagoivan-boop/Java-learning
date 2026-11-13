package Listas;

public class Vector {
	private int[] vector;
	private int cantidad;
	
	
	public Vector(int tamaño){
		
		vector = new int[tamaño];
		this.cantidad = 0;
	}
	
	
	public int getTamaño() {
		return cantidad;
	}
	
	public int getTamañoTotal() {
		return vector.length;
	}
	
	
	
	
	public int traerElMenor() {
		
		if (cantidad < 0) {
			System.out.print("\n Lista vacia.");
		}
		
		int menor = vector[0];
		
		for (int i= 1;i < cantidad; i++) {
			if (vector[i] < menor) {
				menor = vector[i];
			}
		}
		
		return menor;
	}
	
	public int traerElMayor() {
		
		if (cantidad < 0) {
			System.out.print("\n Lista vacia.");
		}
		
		int mayor = vector[0];
		
		for (int i= 0 ;i < cantidad; i++) {
			if (vector[i] > mayor) {
				mayor = vector[i];
			}
		}
		
		return mayor;
	}
	
	public void agregarValor(int numero) {
		
		if (cantidad < vector.length) {
			vector[cantidad] = numero;
			cantidad++;
		} else {
			System.out.print("\n Lista llena. ");
		}
	}
	
	
	public double calcularPromedio() {
		
		double total = 0;
		
		for (int i=0; i<=cantidad; i++) {
			total += vector[i];
		}
		
		return (total / cantidad);
		
	}
	
	
	public void ordenarAscendente() {
		
		for (int i=1; i<cantidad; i++) {
			for (int f=i+1; f<cantidad; f++) {
				if (vector[f] > vector[i]) {
					int aux = vector[i];
					vector[i] = vector[f];
					vector[f] = aux;
					
				}
			}
		}
	}
	
public void ordenarDescendente() {
		
		for (int i=0; i<cantidad; i++) {
			for (int f=i+1; f<cantidad; f++) {
				if (vector[f] < vector[i]) {
					int aux = vector[i];
					vector[i] = vector[f];
					vector[f] = aux;
					
				}
			}
		}
	}
	
	public void imprimirVector() {
		
		System.out.print("\n");
		
		for (int i=1; i<cantidad; i++) {
			System.out.print(vector[i] + "  ");
		}
	}
	
	
	public double traerFrecuencia(int numero) {
		
		double total = 0;
		
		for (int i=0; i<cantidad; i++) {
			if (vector[i] == numero) {
				total += 1;
			}
		}
		
		return (total / cantidad);
	}
	
	public int traerModa() {
		
		double maxFrecuencia = traerFrecuencia(vector[0]);
		int moda = 0;
		
		for (int i=0; i<cantidad; i++) {
			
			double frecuenciaActual = traerFrecuencia(vector[i]);
			
			if (frecuenciaActual > maxFrecuencia) {
				maxFrecuencia = frecuenciaActual;
				moda = vector[i];
			}
		}
		
		return moda;
	}	
}

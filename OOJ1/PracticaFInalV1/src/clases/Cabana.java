package clases;

public class Cabana {
	private int idCabana;
	private int numero;
	private int capacidad;
	
	
	
	
	public Cabana(int idCabana, int numero, int capacidad) {
		this.idCabana = idCabana;
		this.numero = numero;
		this.capacidad = capacidad;
	}




	public int getIdCabana() {
		return idCabana;
	}
	public void setIdCabana(int idCabana) {
		this.idCabana = idCabana;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}




	@Override
	public String toString() {
		return "Cabana [idCabana=" + idCabana + ", numero=" + numero + ", capacidad=" + capacidad + "]";
	}
	
	public boolean equals(Cabana cabana) {
		return  (cabana.numero == this.numero);
	}
	
	
}

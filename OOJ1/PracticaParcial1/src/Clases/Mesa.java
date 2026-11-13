package Clases;

public class Mesa {
	private int idMesa;
	private int numeroMesa;
	private int capacidad;
	
	
	public Mesa(int numeroMesa, int capacidad){
		this.numeroMesa = numeroMesa;
		this.capacidad = capacidad;
	}
	
	public int getMesa() {
		return this.idMesa;
	}
	
	public int getNumeroMesa() {
		return this.numeroMesa;
	}
	
	public int getCapacidad() {
		return this.capacidad;
	}
	
	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public int getIdMesa() {
		return this.idMesa;
	}
	
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	
	public boolean validarComensales(int cantComensales) throws Exception{
		if (this.capacidad < cantComensales) throw new Exception("Error. El numero de comensales (" + cantComensales + ") supera la capacidad de la mesa:  " + this.capacidad);
		return true;
		}
	
}

package modelos;

public class Camion {
	private int idCamion;
	private String patente;
	private double capacidadCargaKg;
	
	
	public Camion(int idCamion, String patente, double capacidadCargaKg) {
		this.idCamion = idCamion;
		this.patente = patente;
		this.capacidadCargaKg = capacidadCargaKg;
	}


	public int getIdCamion() {
		return idCamion;
	}
	public void setIdCamion(int idCamion) {
		this.idCamion = idCamion;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public double getCapacidadCargaKg() {
		return capacidadCargaKg;
	}
	public void setCapacidadCargaKg(double capacidadCargaKg) {
		this.capacidadCargaKg = capacidadCargaKg;
	}
	
	
	@Override
	public String toString() {
		return "[ID: "+ this.idCamion + " Patente: " + this.patente + " Capacidad: " + this.capacidadCargaKg + "]";
	}
	
	public boolean equals(Camion camion) {
		return (camion.getIdCamion() == this.idCamion);
	}
	
	
}

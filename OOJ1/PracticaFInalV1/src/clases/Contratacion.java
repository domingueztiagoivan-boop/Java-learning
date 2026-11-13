package clases;

import java.time.LocalDate;

public class Contratacion {
	private int idContratacion;
	private LocalDate fecha;
	private Cabana cabana;
	private Excursion excursion;
	private int cantPersonas;
	
	
	
	public Contratacion(int idContratacion, LocalDate fecha, Cabana cabana, Excursion excursion, int cantPersonas)throws Exception {
		this.idContratacion = idContratacion;
		this.fecha = fecha;
		this.cabana = cabana;
		this.excursion = excursion;
		setCantPersonas(cantPersonas);;
	}



	public int getIdContratacion() {
		return idContratacion;
	}
	public void setIdContratacion(int idContratacion) {
		this.idContratacion = idContratacion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Cabana getCabana() {
		return cabana;
	}
	public void setCabana(Cabana cabana) {
		this.cabana = cabana;	
	}
	public Excursion getExcursion() {
		return excursion;
	}
	public void setExcursion(Excursion excursion) {
		this.excursion = excursion;
	}
	public int getCantPersonas() {
		return cantPersonas;
	}
	public void setCantPersonas(int cantPersonas) throws Exception{
		if (this.cabana.getCapacidad() < cantPersonas) throw new Exception ("ERROR. La cantidad de personas ("+ cantPersonas + ") supera la capacidad ("+ this.cabana.getCapacidad() + ") de la cabana.");
		
		this.cantPersonas = cantPersonas;
	}
	
	
	
	
	
	
	
}

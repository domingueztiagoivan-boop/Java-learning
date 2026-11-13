package clases;

public abstract class Excursion {
	protected int idExcursion;
	protected String descripcion;
	protected int cantDias;
	
	
	
	public Excursion(int idExcursion, String descripcion, int cantDias) {
		this.idExcursion = idExcursion;
		this.descripcion = descripcion;
		this.cantDias = cantDias;
	}
	
	
	
	
	
	public int getIdExcursion() {
		return idExcursion;
	}
	public void setIdExcursion(int idExcursion) {
		this.idExcursion = idExcursion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantDias() {
		return cantDias;
	}
	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
	
	@Override
	public String toString() {
		return "[ID: " + this.idExcursion + " Descripcion: " + this.descripcion + " Cantidad Dias: " + this.cantDias + "]";
	}
	
	public boolean equals(Excursion excursion) {
		return (excursion.getIdExcursion() == this.idExcursion);
	}
	
	
	public abstract float costoTotal(int cantPersonas);

}

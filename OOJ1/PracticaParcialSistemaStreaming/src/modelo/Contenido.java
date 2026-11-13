package modelo;

public abstract class Contenido {
	protected int idContenido;
	protected String titulo;
	protected int duracionMinutos;
	protected double precioBase;
	
	
	public Contenido(int idContenido, String titulo, int duracionMinutos, double precioBase) {
		this.idContenido = idContenido;
		this.titulo = titulo;
		this.duracionMinutos = duracionMinutos;
		this.precioBase = precioBase;
	}


	public int getIdContenido() {
		return idContenido;
	}
	public void setIdContenido(int idContenido) {
		this.idContenido = idContenido;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracionMinutos() {
		return duracionMinutos;
	}
	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}
	
	
	
	@Override
	public String toString() {
		return "[ID: " + this.idContenido + " Titulo: " + this.titulo + " Duracion: " + this.duracionMinutos + " Precio: " + this.precioBase + "]";
	}
	
	public boolean equals(Contenido contenido) {
		return (contenido.getIdContenido() == this.idContenido);
	}
	
	public abstract String hablar();
	
	public abstract double calcularCostoFinal();
	
	
}

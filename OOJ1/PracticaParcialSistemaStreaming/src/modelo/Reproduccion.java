package modelo;

import java.time.LocalDate;

public class Reproduccion {
	private int idReproduccion;
	private Usuario usuario;
	private Contenido contenido;
	private LocalDate fecha;
	
	
	
	public Reproduccion(int idReproduccion, Usuario usuario, Contenido contenido, LocalDate fecha)throws Exception {
		this.idReproduccion = idReproduccion;
		setUsuario(usuario);
		this.contenido = contenido;
		this.fecha = fecha;
	}



	public int getIdReproduccion() {
		return idReproduccion;
	}
	public void setIdReproduccion(int idReproduccion) {
		this.idReproduccion = idReproduccion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario)throws Exception{
		if (this.contenido instanceof Pelicula) {
			Pelicula peli = (Pelicula) this.contenido;
			if (peli.getEsEstreno() == true && usuario.getEsPremium() == true) throw new Exception("Error. El usuario estándar no puede reproducir películas de estreno.");
		}
		this.usuario = usuario;
	}
	public Contenido getContenido() {
		return contenido;
	}
	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	
	@Override
	public String toString() {
		return "[ID: " + this.idReproduccion + " Usuario: " + this.usuario + " Contenido: " + this.contenido + " Fecha: " + this.fecha + "]"; 
	}
	
	public boolean equals(Reproduccion reproduccion) {
		return (reproduccion.getIdReproduccion() == this.idReproduccion);
	}
}

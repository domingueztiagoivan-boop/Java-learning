package Clases;

import Clases.Genero;

public class Pelicula {
	private int idPelicula;
	private String pelicula;
	private Genero genero;
	
	
	public Pelicula(int idPelicula, String pelicula, Genero genero) {
		this.idPelicula = idPelicula;
		this.pelicula = pelicula;
		this.genero = genero;
	}

	
	public int getIdPelicula() {
		return idPelicula;
	}
	
	public String getPelicula() {
		return pelicula;
	}
	
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	
	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	
	public boolean equalsIdPelicula(int idPelicula) {
		if (this.idPelicula == idPelicula) {
			return true;
		} else {
			return false;
		}
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public boolean equalsGenero(Pelicula pelicula) {
		if (pelicula.getGenero() == genero) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "("+pelicula+", "+idPelicula+")";
	}
}

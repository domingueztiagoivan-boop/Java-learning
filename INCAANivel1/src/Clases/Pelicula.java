package Clases;


public class Pelicula {
	private int idPelicula;
	private String pelicula;
	
	
	public Pelicula(int idPelicula, String pelicula) {
		this.idPelicula = idPelicula;
		this.pelicula = pelicula;
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
	
	public boolean equalsId(int idPelicula) {
		if (this.idPelicula == idPelicula) {
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

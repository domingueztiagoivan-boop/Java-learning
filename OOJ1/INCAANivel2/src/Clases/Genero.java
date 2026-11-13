package Clases;

public class Genero {
	private int idGenero;
	private String genero;
	
	
	public Genero(int idGenero, String genero) {
		this.idGenero = idGenero;
		this.genero = genero;
	}
	
	public int getIdGenero() {
		return idGenero;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	public boolean equalsIdGenero(Genero genero) {
		if (genero.getIdGenero() == idGenero) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
	    // Así, cuando hagas p.getGenero(), Java imprimirá el nombre real
	    return this.genero; 
	}	
	
}

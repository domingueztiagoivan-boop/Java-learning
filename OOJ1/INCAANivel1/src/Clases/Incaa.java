package Clases;
		
import java.util.ArrayList;
import java.util.List;




public class Incaa {
	private List<Pelicula> catalogo;



	public Incaa(){
		
		this.catalogo = new ArrayList<Pelicula>();
	}
	
	
	
	public boolean agregarPelicula(String nombrePelicula) {
		
		int proxId = 1;
		
		if (catalogo.size() == 0) {
			Pelicula peliculaNueva = new Pelicula(1, nombrePelicula);
			return catalogo.add(peliculaNueva);
		} else {
			
			Pelicula ultimaPeli = catalogo.get(catalogo.size() - 1);
			proxId = ultimaPeli.getIdPelicula() + 1;
		}
		
		Pelicula peliculaNueva = new Pelicula(proxId, nombrePelicula);
		
		return catalogo.add(peliculaNueva);
	}
	
	
	
	
	public Pelicula traerPelicula(int idPelicula) {
		
		for (Pelicula p : catalogo) {
			if (p.equalsId(idPelicula)) {
				return p;
			} 
		}
		
		System.out.print("\n No se encuentra ese id.");
		return null;
	}
	

	
	
	
	public List<Pelicula> traerPeliculaList(String partePelicula) {
		
		Incaa partesPeliculas = new Incaa();
		
		for (Pelicula p : catalogo) {
			if (p.getPelicula().contains(partePelicula)) {
				partesPeliculas.agregarPelicula(p.getPelicula()); 
			}
		}
		
		if (partesPeliculas.catalogo.size() > 0) {
			return  (List<Pelicula>) partesPeliculas;
		} else {
			System.out.print("\n" + "No se encuentra peliculas con tal nombre.");
			return null;
		}
	}
	
	
	public void  modificarPelicula (int idPelicula, String pelicula) {
		
		int cambio = 0;
		
		for (Pelicula p : catalogo) {
			if (p.equalsId(idPelicula)) {
				p.setPelicula(pelicula);
				cambio++;
			}
		}
		
		if (cambio > 0) {
			System.out.print("\nLa pelicula cambio su nombre con exito.");
		} else {
			System.out.print("\nNo se encontro una pelicula con tal id.");
		}
	}
	
	public boolean eliminarPelicula (int idPelicula) {
		
		int cambio = 0;
		
		for (Pelicula p : catalogo) {
			if (p.equalsId(idPelicula)) {
				catalogo.remove(p);
				cambio++;
				break;
			}
		}
		
		if (cambio > 0) {
			return true;
		} else {
			return false;
		}
	}
		
	public void mostrarPeliculas() {
		
		for (Pelicula p : catalogo) {
			System.out.print("\nNombre Pelicula: " + p.getPelicula());
			System.out.print("\nID de la pelicula: " + p.getIdPelicula());
		}
	}

}

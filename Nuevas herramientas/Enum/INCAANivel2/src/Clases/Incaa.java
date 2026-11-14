package Clases;
		
import java.util.ArrayList;
import java.util.List;




public class Incaa {
	private List<Pelicula> catalogo;



	public Incaa(){
		
		this.catalogo = new ArrayList<Pelicula>();
	}
	
	
	
	public boolean agregarPelicula(String nombrePelicula, Genero genero) {
	    int proxId = 1;

	    if (catalogo.size() > 0) {
	        Pelicula ultimaPeli = catalogo.get(catalogo.size() - 1);
	        proxId = ultimaPeli.getIdPelicula() + 1;
	    }

	    Genero peliGenero = genero;
	    Pelicula peliculaNueva = new Pelicula(proxId, nombrePelicula, peliGenero);
	    
	    return catalogo.add(peliculaNueva);
	}
	
	
	
	
	public Pelicula traerPelicula(int idPelicula) {
		
		for (Pelicula p : catalogo) {
			if (p.equalsIdPelicula(idPelicula)) {
				return p;
			} 
		}
		
		System.out.print("\n No se encuentra ese id.");
		return null;
	}
	

	
	
	
	public List<Pelicula> traerPeliculaList(String partePelicula) {
	    // 1. Creamos una lista real de películas para guardar los resultados
	    List<Pelicula> listaResultado = new ArrayList<Pelicula>();
	    
	    // 2. Recorremos el catálogo original
	    for (Pelicula p : catalogo) {
	        // 3. Verificamos si el nombre de la película contiene la "parte" buscada
	        // .toLowerCase() sirve para que si buscás "akira" encuentre "Akira"
	        if (p.getPelicula().toLowerCase().contains(partePelicula.toLowerCase())) {
	            listaResultado.add(p); 
	        }
	    }
	    
	    // 4. Si la lista está vacía, avisamos por consola (opcional)
	    if (listaResultado.isEmpty()) {
	        System.out.println("\nNo se encontraron películas que contengan: " + partePelicula);
	    }
	    
	    // 5. Devolvemos la lista (que puede tener 0, 1 o muchas películas)
	    return listaResultado;
	}
	
	public List<Pelicula> traerPeliculaListGenero(Genero genero) {
	    // 1. Creamos una LISTA real, no un objeto Incaa
	    List<Pelicula> listaResultado = new ArrayList<Pelicula>();
	    
	    for (Pelicula p : catalogo) {
	        if (genero == p.getGenero()) {
	            listaResultado.add(p); 
	        }
	    }
	    
	    if (listaResultado.size() == 0) {
	        System.out.println("No se encuentran peliculas con tal genero.");
	    }
	    
	    return listaResultado; // Devolvemos la LISTA directamente
	}
	
	
	public void  modificarPelicula (int idPelicula, String pelicula) {
		
		int cambio = 0;
		
		for (Pelicula p : catalogo) {
			if (p.equalsIdPelicula(idPelicula)) {
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
			if (p.equalsIdPelicula(idPelicula)) {
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
			System.out.print("  Genero de la pelicula: " + p.getGenero());
		}
	}

}

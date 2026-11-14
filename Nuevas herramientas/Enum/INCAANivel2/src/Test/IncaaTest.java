package Test;

import Clases.Genero;
import Clases.Incaa;
import Clases.Pelicula;
import java.util.ArrayList;
import java.util.List;

public class IncaaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Incaa test = new Incaa();

		Genero genero1 = Genero.DRAMA;
		Genero genero2 = Genero.TERROR;
		Genero genero3 = Genero.COMEDIA;
		Genero genero4 = Genero.AVENTURA;
		Genero genero5 = Genero.ACCION;

		
		test.agregarPelicula("Palito Pablo I", genero1);
		test.agregarPelicula("Palito Pablo II", genero2);
		test.agregarPelicula("Palito Pablo III", genero2);
		test.agregarPelicula("Palito Pablo IV", genero2);
		test.agregarPelicula("Palito Pablo V", genero2);
		test.agregarPelicula("Palito Pablo VI", genero2);
		test.agregarPelicula("Palito Pablo VII", genero2);
		test.agregarPelicula("La venganza de Akira I", genero4);
		test.agregarPelicula("La venganza de Akira II", genero5);
		test.agregarPelicula("La venganza de Akira III", genero5);
		
		test.mostrarPeliculas();
		
		Pelicula peli1 = test.traerPelicula(1);
		System.out.print("\n\n" + peli1.toString());
		
		
		test.modificarPelicula(4, "Righteous");
		Pelicula peli2 = test.traerPelicula(4);
		System.out.print("\n\n" + peli2.toString());
		test.eliminarPelicula(4);
		test.mostrarPeliculas();
		
		
		List<Pelicula> Test2 = new ArrayList<Pelicula>();
		System.out.print("\n\nPeliculas de genero: " + genero2.getGenero() + "\n-----------------------------------\n");
		Test2 = test.traerPeliculaListGenero(genero2);
		for (Pelicula p : Test2) {
			System.out.print("\nNombre Pelicula: " + p.getPelicula());
			System.out.print("\nID de la pelicula: " + p.getIdPelicula());
			System.out.print("  Genero de la pelicula: " + p.getGenero());
		}
		System.out.print("\n\n");		
   }
}

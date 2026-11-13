package Test;

import java.util.ArrayList;
import java.util.List;

import Clases.Genero;
import Clases.Incaa;
import Clases.Pelicula;

public class IncaaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Incaa test = new Incaa();
		
		test.agregarPelicula("Palito Pablo I", "Drama");
		test.agregarPelicula("Palito Pablo II", "Drama");
		test.agregarPelicula("Palito Pablo III", "Drama");
		test.agregarPelicula("Palito Pablo IV", "Drama");
		test.agregarPelicula("La venganza de Akira I", "Terror");
		test.agregarPelicula("La venganza de Akira II", "Terror");
		test.agregarPelicula("La venganza de Akira III", "Terror");
		
		test.mostrarPeliculas();
		
		Pelicula peli1 = test.traerPelicula(1);
		System.out.print("\n\n" + peli1.toString());
		
		
		test.modificarPelicula(4, "Righteous");
		Pelicula peli2 = test.traerPelicula(4);
		System.out.print("\n\n" + peli2.toString());
		test.eliminarPelicula(3);
		test.mostrarPeliculas();
		
		Genero genero = new Genero(1, "Drama"); ///imprime con idGenero = 1 porque todas las id se asignan a 1, si pruebo con 2, no trae nada (deberia cambiar esa logica de setear estandar 1 en la funcion)
		List<Pelicula> Test2 = new ArrayList<Pelicula>();
		Test2 = test.traerPeliculaListGenero(genero);
		
		
		System.out.print("\n-----------------------------------\n");
		
		for (Pelicula p : Test2) {
			System.out.print("\nNombre Pelicula: " + p.getPelicula());
			System.out.print("\nID de la pelicula: " + p.getIdPelicula());
			System.out.print("  Genero de la pelicula: " + p.getGenero());
	}
   }
}

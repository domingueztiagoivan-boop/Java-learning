package Tests;

import Clases.Incaa;
import Clases.Pelicula;

public class IncaaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Incaa test = new Incaa();
		
		test.agregarPelicula("Palito Pablo I");
		test.agregarPelicula("Palito Pablo II");
		test.agregarPelicula("Palito Pablo III");
		test.agregarPelicula("Palito Pablo IV");
		test.agregarPelicula("La venganza de Akira I");
		test.agregarPelicula("La venganza de Akira II");
		test.agregarPelicula("La venganza de Akira III");
		
		test.mostrarPeliculas();
		
		Pelicula peli1 = test.traerPelicula(1);
		System.out.print("\n\n" + peli1.toString());
		
		
		test.modificarPelicula(4, "Righteous");
		Pelicula peli2 = test.traerPelicula(4);
		System.out.print("\n\n" + peli2.toString());
		test.eliminarPelicula(3);
		test.mostrarPeliculas();
		
	}

}

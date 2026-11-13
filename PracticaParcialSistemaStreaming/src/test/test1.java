package test;

import java.time.LocalDate;
import java.util.List;
import modelo.*;
import modelo.sistemaStreaming;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sistemaStreaming sistema = new sistemaStreaming();

        System.out.println("=== 1) REGISTRO DE USUARIOS ===");
        try {
            // Un usuario Estándar y uno Premium
            sistema.agregarUsuario("Carlos Estandar", "carlos@mail.com", false);
            sistema.agregarUsuario("Ana Premium", "ana@mail.com", true);
            System.out.println("-> Usuarios registrados exitosamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== 2) CARGA DE CONTENIDOS (PELÍCULAS Y SERIES) ===");
        try {
            // Película Estreno, Película Común y una Serie
            sistema.agregarPelicula("Avengers: Doomsday", 150, 500.0, true); // Estreno
            sistema.agregarPelicula("Shrek 2", 90, 200.0, false);            // No estreno
            sistema.agregarSerie("Breaking Bad", 50, 300.0, 62);            // Serie (62 episodios)
            System.out.println("-> Catálogo de contenidos inicializado.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Recuperamos los objetos para armar las reproducciones (Simulamos lo que haría la capa de negocio)
        Usuario uEstandar = sistema.getLstUsuarios().get(0); // Carlos
        Usuario uPremium = sistema.getLstUsuarios().get(1);  // Ana

        Contenido peliEstreno = sistema.getLstContenido().get(0); // Avengers
        Contenido peliComun = sistema.getLstContenido().get(1);   // Shrek 2
        Contenido serie = sistema.getLstContenido().get(2);       // Breaking Bad

        System.out.println("\n=== 3) TEST DE REPRODUCCIONES Y EXCEPCIONES ===");
        
        // Caso A: Usuario Premium ve un estreno (Debe funcionar)
        try {
            sistema.agregarReproduccion(uPremium, peliEstreno, LocalDate.of(2026, 5, 25));
            System.out.println("-> Éxito: Ana Premium pudo reproducir el estreno.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Caso B: Usuario Estándar intenta ver un estreno (Debe saltar la excepción del setter)
        try {
            sistema.agregarReproduccion(uEstandar, peliEstreno, LocalDate.of(2026, 5, 25));
        } catch (Exception e) {
            System.out.println("Excepción esperada correctamente: " + e.getMessage());
        }

        // Caso C: Usuario Estándar ve contenido común (Debe funcionar)
        try {
            sistema.agregarReproduccion(uEstandar, peliComun, LocalDate.of(2026, 5, 26));
            sistema.agregarReproduccion(uEstandar, serie, LocalDate.of(2026, 5, 26));
            // Sumamos más reproducciones a Breaking Bad para probar el TOP más vistos
            sistema.agregarReproduccion(uPremium, serie, LocalDate.of(2026, 5, 27)); 
            System.out.println("-> Éxito: Reproducciones comunes registradas.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== 4) TOTAL RECAUDADO (POLIMORFISMO DE COSTOS) ===");
        // Rango de fechas que cubre todas nuestras reproducciones del test
        LocalDate desde = LocalDate.of(2026, 5, 20);
        LocalDate hasta = LocalDate.of(2026, 5, 28);
        
        /* Cálculo teórico de costos:
           - Avengers (Estreno): 500 + 20% = 600
           - Shrek 2 (Común): 200
           - Breaking Bad (Serie x2 reps): (300 + (62 * 10)) = 920 por reproducción. Como se vio 2 veces = 1840.
           Total esperado = 600 + 200 + 1840 = 2640
        */
        double recaudacion = sistema.calcularRecaudacionTotal(desde, hasta);
        System.out.println("Recaudación total entre " + desde + " y " + hasta + ": $" + recaudacion);

        System.out.println("\n=== 5) RANKING: TOP CONTENIDOS MÁS VISTOS ===");
        // Le pedimos el Top 2 de contenidos. Debería figurar 1° Breaking Bad (2 reps) y 2° Avengers (1 rep)
        List<Contenido> masVistos = sistema.traerContenidosMasVistos(2);
        int puesto = 1;
        for (Contenido c : masVistos) {
            System.out.println(puesto + "° Puesto: " + c.getTitulo());
            puesto++;
        }
		
	}

}

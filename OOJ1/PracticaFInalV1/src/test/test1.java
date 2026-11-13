package test;

import java.time.LocalDate;
import java.util.List;
import clases.*;


public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("==================================================");
        System.out.println("     INICIANDO TESTEO DE EXAMEN FINAL - ECOTURISMO");
        System.out.println("==================================================");

        Sistema sistema = new Sistema();

        // ----------------------------------------------------------------
        // 1. CARGA DE CABAÑAS
        // ----------------------------------------------------------------
        System.out.println("\n1) Agregando Cabañas ---");
        try {
            sistema.agregarCabana(101, 4);
            sistema.agregarCabana(102, 2);
            sistema.agregarCabana(201, 6);
            System.out.println("✔ Cabañas agregadas con éxito: " + sistema.getLstCabanas());
        } catch (Exception e) {
            System.out.println("❌ Excepción inesperada: " + e.getMessage());
        }

        // ----------------------------------------------------------------
        // 2. CARGA DE EXCURSIONES (TREKKING Y NAVEGACIÓN)
        // ----------------------------------------------------------------
        System.out.println("\n2) Agregando Excursiones ---");
        try {
            // Trekking: (descripcion, cantDias, kmRecorrido, dificultad)
            sistema.agregarExcursionTrekking("Sendero Esmeralda", 1, 12.5f, 2); // Premium (Dif <= 2)
            sistema.agregarExcursionTrekking("Cruce de los Andes", 3, 45.0f, 4); // No Premium (Dif > 3 -> +$8000 seguro)
            
            // Navegacion: (descripcion, cantDias, tieneAlmuerzo, costoBaseLancha)
            sistema.agregarExcursionNavegacion("Paseo de la Bahia", 1, false, 15000f); // No Premium
            sistema.agregarExcursionNavegacion("Aventura Glaciar", 1, true, 25000f);  // Premium (Con Almuerzo)
            
            System.out.println("✔ Excursiones agregadas con éxito.");
        } catch (Exception e) {
            System.out.println("❌ Excepción inesperada: " + e.getMessage());
        }

        // ----------------------------------------------------------------
        // 3. CARGA DE CONTRATACIONES
        // ----------------------------------------------------------------
        System.out.println("\n3) Agregando Contrataciones ---");
        try {
            Cabana cab101 = sistema.traerCabana(101); // Capacidad: 4
            Cabana cab102 = sistema.traerCabana(102); // Capacidad: 2
            Cabana cab201 = sistema.traerCabana(201); // Capacidad: 6

            Excursion excursionT1 = sistema.traerExcursion(1); // Sendero Esmeralda
            Excursion excursionN2 = sistema.traerExcursion(4); // Aventura Glaciar

            // Altas correctas
            sistema.agregarContratacion(LocalDate.of(2026, 7, 10), cab101, excursionT1, 3);
            sistema.agregarContratacion(LocalDate.of(2026, 7, 12), cab201, excursionN2, 5);
            sistema.agregarContratacion(LocalDate.of(2026, 7, 15), cab102, excursionT1, 2);

            System.out.println("✔ Contrataciones vinculadas de forma segura.");
        } catch (Exception e) {
            System.out.println("❌ Excepción inesperada: " + e.getMessage());
        }

        // ----------------------------------------------------------------
        // 4. TESTEO DE FILTRO: CONTRATACIONES POR FECHA Y COSTO MÁXIMO
        // ----------------------------------------------------------------
        System.out.println("\n4) Reporte: Contrataciones por Fecha y Costo Máximo ---");
        // Filtramos entre el 9 y el 13 de Julio, con costo máximo de $50.000
        List<Contratacion> filtradas = sistema.traerContratacionesPorFechaYCostoMaximo(LocalDate.of(2026, 7, 9), LocalDate.of(2026, 7, 13), 100000f);
  
        for (Contratacion c : filtradas) {
            System.out.println("Contratación ID: " + c.getIdContratacion() + " - Fecha: " + c.getFecha() + " - Personas: " + c.getCantPersonas());
        }

        // ----------------------------------------------------------------
        // 5. TESTEO DE FILTRO POLIMÓRFICO: EXCURSIONES PREMIUM (CU #8)
        // ----------------------------------------------------------------
        System.out.println("\n5) Reporte: Excursiones Premium (Filtros con instanceof) ---");
        List<Excursion> premiun = sistema.traerExcursionesPremium();
        for (Excursion ex : premiun) {
            System.out.println("Premium -> " + ex.getDescripcion());
        }

        // ----------------------------------------------------------------
        // 6. VALIDACIÓN DE EXCEPCIONES: DUPLICADOS
        // ----------------------------------------------------------------
        System.out.println("\n6) Validando Excepción: Duplicado de Excursión ---");
        try {
            // Intentamos agregar un Trekking con una descripción que ya existe
            sistema.agregarExcursionTrekking("Sendero Esmeralda", 1, 10f, 1);
            System.out.println("❌ ERROR: El sistema permitió duplicar una descripción.");
        } catch (Exception e) {
            System.out.println("✔ Excepción capturada correctamente: " + e.getMessage());
        }

        // ----------------------------------------------------------------
        // 7. VALIDACIÓN DE EXCEPCIONES: RESTRICCIÓN DE CAPACIDAD
        // ----------------------------------------------------------------
        System.out.println("\n7) Validando Excepción: Superar Capacidad de Cabaña ---");
        try {
            Cabana cab102 = sistema.traerCabana(102); // Capacidad máxima: 2 personas
            Excursion excursionT1 = sistema.traerExcursion(1);

            // Intentamos meter 4 personas en la excursión para esa cabaña de 2
            sistema.agregarContratacion(LocalDate.of(2026, 7, 20), cab102, excursionT1, 4);
            System.out.println("❌ ERROR: El sistema permitió más pasajeros que la capacidad disponible.");
        } catch (Exception e) {
            System.out.println("✔ Excepción capturada correctamente: " + e.getMessage());
        }

        System.out.println("\n==================================================");
        System.out.println("     FIN DEL TESTEO DE CASOS DE USO");
        System.out.println("==================================================");
		
		
	}

}

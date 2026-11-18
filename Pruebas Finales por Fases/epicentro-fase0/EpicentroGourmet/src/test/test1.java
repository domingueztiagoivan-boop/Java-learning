package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelos.*;

public class test1 {

	public static void main(String[] args) {
		System.out.println("==================================================");
        System.out.println("   INICIANDO TESTEO DE CASOS DE USO - FESTIVAL    ");
        System.out.println("==================================================");

        Sistema sistema = new Sistema();

        try {
            System.out.println("\n--- [Carga de Datos] ---");           

            Costo costoFest = new Costo(100000, 500, 5000, 10, 2000);
            
            sistema.agregarFestival("Festival de la Cerveza", "Primavera", LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 5), costoFest);
            sistema.agregarFestival("Festival de la Hamburguesa", "Verano", LocalDate.of(2027, 1, 1), LocalDate.of(2027, 1, 5), costoFest);
            System.out.println("✔ Festivales agregados con éxito.");

            // Cargamos un staff amplio (10 personas)
            sistema.agregarPersonalCocinero("Juan", "Pérez", 35111222, LocalDate.of(1990, 5, 15), LocalDate.of(2020, 1, 1), "Gourmet", 5000);
            sistema.agregarPersonalCajero("Ana", "Gómez", 40333444, LocalDate.of(1997, 8, 20), LocalDate.of(2022, 3, 1), "Tarde");
            sistema.agregarPersonalCocinero("Luis", "Rodríguez", 38555666, LocalDate.of(1994, 12, 10), LocalDate.of(2021, 5, 1), "Barra", 3000);
            sistema.agregarPersonalCajero("Pedro", "Martínez", 42111222, LocalDate.of(1999, 3, 25), LocalDate.of(2023, 2, 15), "Mañana");
            sistema.agregarPersonalCocinero("Carlos", "López", 33444555, LocalDate.of(1988, 7, 14), LocalDate.of(2019, 6, 10), "Pescados", 6000);
            sistema.agregarPersonalCocinero("Pablo", "Gil", 36412905, LocalDate.of(2000, 1, 16), LocalDate.of(2020, 8, 15), "Hamburguesas", 4500);
            sistema.agregarPersonalCocinero("Jose", "Fernandez", 19902341, LocalDate.of(1985, 2, 24), LocalDate.of(2018, 4, 20), "Gourmet", 5000);
            sistema.agregarPersonalCajero("Matias", "Lescano", 42544248, LocalDate.of(2001, 7, 9), LocalDate.of(2023, 10, 18), "Tarde");
            sistema.agregarPersonalCocinero("Alan", "López", 39342560, LocalDate.of(1998, 6, 30), LocalDate.of(2022, 5, 20), "Gourmet", 5000);
            sistema.agregarPersonalCajero("Santiago", "Mendez", 42323049, LocalDate.of(2001, 5, 21), LocalDate.of(2023, 10, 10), "Mañana");
            System.out.println("✔ Personal agregado con éxito.");
        } catch  (Exception e) {
            System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            e.printStackTrace();
        }

            Personal resp1 = sistema.traerPersonal(35111222);
            Personal resp2 = sistema.traerPersonal(40333444);
            Personal resp3 = sistema.traerPersonal(33444555);
            Personal resp4 = sistema.traerPersonal(19902341);
            
            try {

            // Agregamos 4 unidades para poder armar un Top 3 real en el CU 13
            sistema.agregarUnidadFoodTruck("Burger Truck", resp1, 15.5, "FT-01", "AAA111", true);
            sistema.agregarUnidadPuestoDesarmable("Beer Stand", resp2, 20.0, "PD-01", 2, 60);
            sistema.agregarUnidadFoodTruck("Taco Truck", resp3, 12.0, "FT-02", "BBB222", false);
            sistema.agregarUnidadPuestoDesarmable("Delicias Stand", resp4, 18.0, "PD-02", 2, 50);
            System.out.println("✔ 3 Unidades de Venta agregadas con éxito.");


            sistema.agregarPlato("Hamburguesa", 15000.0, 6500.0);
            sistema.agregarPlato("Taco de Carne", 12000, 5100);
            sistema.agregarPlato("Papas Fritas", 10000.0, 4000.0);
            sistema.agregarPlato("Cerveza Artesanal", 4500.0, 1500.0);
            sistema.agregarPlato("Hamburguesa Gourmet", 17500.0, 8000.0);
            sistema.agregarPlato("Bondiola Braseada", 17000.0, 7600.0);
            sistema.agregarPlato("Risotto de Hongos", 14500.0, 6300.0);
            sistema.agregarPlato("Cannoli de Pistacho", 11500.0, 4500.0);
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }
         
            System.out.println("✔ Platos agregados al menú global.");

            UnidadVenta ft01 = sistema.traerUnidadVenta("FT-01");
            UnidadVenta pd01 = sistema.traerUnidadVenta("PD-01");
            UnidadVenta ft02 = sistema.traerUnidadVenta("FT-02");
            UnidadVenta pd02 = sistema.traerUnidadVenta("PD-02");
            Festival festival = sistema.traerFestival("Festival de la Cerveza");
            Festival festival2 = sistema.traerFestival("Festival de la Hamburguesa");
            
            Plato hamb = sistema.traerPlato("Hamburguesa");
            Plato papas = sistema.traerPlato("Papas Fritas");
            Plato birra = sistema.traerPlato("Cerveza Artesanal");
            Plato taco = sistema.traerPlato("Taco de Carne");
            Plato hambGourm = sistema.traerPlato("Hamburguesa Gourmet");
            Plato bond = sistema.traerPlato("Bondiola Braseada");
        	Plato ris = sistema.traerPlato("Risotto de Hongos");
        	Plato cann = sistema.traerPlato("Cannoli de Pistacho");
        	
        	try {
            ft01.agregarPlatoUnidadVenta(hamb);
            ft01.agregarPlatoUnidadVenta(papas);
            ft01.agregarPlatoUnidadVenta(hambGourm);
            ft01.agregarPersonalCocineroUnidadVenta(sistema.traerPersonal(35111222));
            ft01.agregarPersonalCajeroUnidadVenta(sistema.traerPersonal(42323049));

            pd01.agregarPlatoUnidadVenta(birra); 
            pd01.agregarPersonalCajeroUnidadVenta(sistema.traerPersonal(40333444));
            pd01.agregarPersonalCocineroUnidadVenta(sistema.traerPersonal(38555666));

            ft02.agregarPlatoUnidadVenta(taco);
            ft02.agregarPlatoUnidadVenta(papas);
            ft02.agregarPersonalCajeroUnidadVenta(sistema.traerPersonal(42111222));
            ft02.agregarPersonalCocineroUnidadVenta(sistema.traerPersonal(39342560));
            
            pd02.agregarPlatoUnidadVenta(bond);
            pd02.agregarPlatoUnidadVenta(cann);
            pd02.agregarPlatoUnidadVenta(ris);
            pd02.agregarPersonalCocineroUnidadVenta(sistema.traerPersonal(36412905));
            pd02.agregarPersonalCocineroUnidadVenta(sistema.traerPersonal(19902341));
            pd02.agregarPersonalCajeroUnidadVenta(sistema.traerPersonal(42544248));
            
        	} catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }
            System.out.println("✔ Menús y Staff asignados a cada puesto correctamente.");

            // ----------------------------------------------------------------
            // 2. REGISTRAR PEDIDOS Y CARGAR DETALLES (CU #5)
            // ----------------------------------------------------------------
            System.out.println("\n--- [CU #5: Registrar Pedidos] ---");
            
            // Registramos pedidos en días diferentes 
            // Registramos pedidos festival bIRRA
            try {
            sistema.registrarPedido(LocalDate.of(2026, 10, 2), festival, ft01);
            sistema.registrarPedido(LocalDate.of(2026, 10, 2), festival, pd01);
            sistema.registrarPedido(LocalDate.of(2026, 10, 3), festival, ft02);
            sistema.registrarPedido(LocalDate.of(2026, 10, 4), festival, ft01); // Segundo pedido de Burger Truck
            
            // Registramos pedidos festival Hamburguesa
            sistema.registrarPedido(LocalDate.of(2027, 1, 2), festival2, ft01);
            sistema.registrarPedido(LocalDate.of(2027, 1, 2), festival2, pd01);
            sistema.registrarPedido(LocalDate.of(2027, 1, 3), festival2, pd01);
            sistema.registrarPedido(LocalDate.of(2027, 1, 3), festival2, ft01);
            sistema.registrarPedido(LocalDate.of(2027, 1, 4), festival2, pd02);
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }
            

            Pedido ped1 = sistema.traerPedido(1);
            Pedido ped2 = sistema.traerPedido(2);
            Pedido ped3 = sistema.traerPedido(3);
            Pedido ped4 = sistema.traerPedido(4);
            Pedido ped5 = sistema.traerPedido(5);
            Pedido ped6 = sistema.traerPedido(6);
            Pedido ped7 = sistema.traerPedido(7);
            Pedido ped8 = sistema.traerPedido(8);
            Pedido ped9 = sistema.traerPedido(9);
            

            // Carga de detalles pedidos
            
            try {
            ped1.agregarDetallePedido(hamb, 30); 
            ped1.agregarDetallePedido(papas, 15);
            ped2.agregarDetallePedido(birra, 150);
            ped3.agregarDetallePedido(taco, 35); 
            ped3.agregarDetallePedido(papas, 15);
            ped4.agregarDetallePedido(papas, 10);
            
            ped5.agregarDetallePedido(cann, 30);
            ped5.agregarDetallePedido(papas, 15);
            ped6.agregarDetallePedido(birra, 45);
            ped7.agregarDetallePedido(birra, 50);
            ped8.agregarDetallePedido(hambGourm, 45);
            ped8.agregarDetallePedido(hamb, 35);
            ped9.agregarDetallePedido(cann, 40);
            ped9.agregarDetallePedido(ris, 20);
            ped9.agregarDetallePedido(bond, 35);
            
            
            festival.agregarPedidoFestival(ped1);
            festival.agregarPedidoFestival(ped2);
            festival.agregarPedidoFestival(ped3);
            festival.agregarPedidoFestival(ped4);

            festival2.agregarPedidoFestival(ped5);
            festival2.agregarPedidoFestival(ped6);
            festival2.agregarPedidoFestival(ped7);
            festival2.agregarPedidoFestival(ped8);
            festival2.agregarPedidoFestival(ped9);
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }
            
            
            
            System.out.println("✔ Múltiples pedidos y detalles vinculados.");

            // ----------------------------------------------------------------
            // 3. EJECUCIÓN DE REPORTES Y FILTROS (CU #6 al #13)
            // ----------------------------------------------------------------
            
            System.out.println("\n--- [CU #6: Reporte Recaudación] ---");
            try {
	            List<ReporteVenta> recaudaciones = sistema.generarReporteRecaudacion(festival);
	            List<ReporteVenta> recaudaciones2 = sistema.generarReporteRecaudacion(festival2);
	            
	            System.out.println("\n---------- Festival Birras ----------");
	            for (ReporteVenta r : recaudaciones) {
	                System.out.println("Unidad: " + r.getUnidadVenta().getNombreComercial() + " - Recaudó: $" + r.getRecaudacionTotal());
	            }
	            
	            System.out.println("\n---------- Festival Hamburguesas ----------");
	            for (ReporteVenta r : recaudaciones2) {
	                System.out.println("Unidad: " + r.getUnidadVenta().getNombreComercial() + " - Recaudó: $" + r.getRecaudacionTotal());
	            }
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println("\n--- [CU #7: Personal Nacido Entre Fechas] ---");
            // Filtramos 1990 de forma estricta
            try {
	            List<Personal> filtrados = sistema.traerPersonalNacidaEntre(LocalDate.of(1990, 1, 1), LocalDate.of(1999, 12, 31));
	            for (Personal p : filtrados) {
	                System.out.println("Empleado: " + p.getNombre() + " " + p.getApellido() + " - F. Nac: " + p.getFechaNacimiento());
	            }
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println("\n--- [CU #8: Rentabilidad Neta de Unidad] ---");
            try {
	            double rentabilidadFT1 = sistema.calcularRentabilidadNetaUnidad(ft01, festival2);
	            System.out.println("Rentabilidad Neta de '" + ft01.getNombreComercial() + "': $" + rentabilidadFT1);
	            double rentabilidadFT2 = sistema.calcularRentabilidadNetaUnidad(ft02, festival);
	            System.out.println("Rentabilidad Neta de '" + ft02.getNombreComercial() + "': $" + rentabilidadFT2);
	            double rentabilidadPD1 = sistema.calcularRentabilidadNetaUnidad(pd01, festival);
	            System.out.println("Rentabilidad Neta de '" + pd01.getNombreComercial() + "': $" + rentabilidadPD1);
	            double rentabilidadPD2 = sistema.calcularRentabilidadNetaUnidad(pd02, festival2);
	            System.out.println("Rentabilidad Neta de '" + pd02.getNombreComercial() + "': $" + rentabilidadPD2);
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println("\n--- [CU #9: Rentabilidad Entre Fechas] ---");
            try {
	            // Filtramos solo los primeros 2 días del festival para ver si el CU9 discrimina correctamente el último pedido
	            double rentabilidadRango1 = sistema.calcularRentabilidadNetaUnidadEntreFechas(ft01, LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 2));
	            System.out.println("Rentabilidad 'Burger Truck' (Rango 1 al 5 de Oct): $" + rentabilidadRango1);
	            double rentabilidadRango2 = sistema.calcularRentabilidadNetaUnidadEntreFechas(ft01, LocalDate.of(2027, 1, 1), LocalDate.of(2027, 1, 5));
	            System.out.println("Rentabilidad 'Burger Truck' (Rango 1 al 5 de Ene): $" + rentabilidadRango2);
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println("\n--- [CU #10: Ranking Unidades Mayor Recaudación] ---");
            try { 
	            System.out.println("\n---------- Festival Birras ----------");
	            List<ReporteVenta> ranking = sistema.generarRankingUnidadesMayorRecaudacion(festival);
	            int puesto = 1;
	            for (ReporteVenta r : ranking) {
	                System.out.println(puesto + "° Puesto: " + r.getUnidadVenta().getNombreComercial() + " ($" + r.getRecaudacionTotal() + ")");
	                puesto++;
	            }
            
	            System.out.println("\n---------- Festival Hamburguesas ----------");
	            
	            List<ReporteVenta> ranking2 = sistema.generarRankingUnidadesMayorRecaudacion(festival2);
	            int puesto2 = 1;
	            for (ReporteVenta r : ranking2) {
	                System.out.println(puesto2 + "° Puesto: " + r.getUnidadVenta().getNombreComercial() + " ($" + r.getRecaudacionTotal() + ")");
	                puesto2++;
	            }
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }


            System.out.println("\n--- [CU #11: Plato Estrella] ---");
            try {
	            // Con el segundo pedido que sumó 10 papas, las papas deberían ganarle a la hamburguesa (12 unidades totales contra 3)
	            Plato estrella = sistema.obtenerPlatoEstrella(ft01, festival);
	            System.out.println("El plato estrella real de '" + ft01.getNombreComercial() + "' fue: " + (estrella != null ? estrella.getNombrePlato() : "Ninguno"));
	            Plato estrella1 = sistema.obtenerPlatoEstrella(pd01, festival);
	            System.out.println("El plato estrella real de '" + pd01.getNombreComercial() + "' fue: " + (estrella1 != null ? estrella1.getNombrePlato() : "Ninguno"));
	            Plato estrella2 = sistema.obtenerPlatoEstrella(ft02, festival);
	            System.out.println("El plato estrella real de '" + ft02.getNombreComercial() + "' fue: " + (estrella2 != null ? estrella2.getNombrePlato() : "Ninguno"));
	            Plato estrella3 = sistema.obtenerPlatoEstrella(pd02, festival2);
	            System.out.println("El plato estrella real de '" + pd02.getNombreComercial() + "' fue: " + (estrella3 != null ? estrella3.getNombrePlato() : "Ninguno"));
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }
            
            
            System.out.println("\n--- [CU #12: Auditoría de Personal por Festival] ---");
            try {
            	System.out.println("\n---------- Festival Birras ----------");
	            List<Personal> personalAuditoria = sistema.traerPersonalPorFestival(festival);
	            for (Personal p : personalAuditoria) {
	                System.out.println("Trabajó de forma activa: " + p.getNombre() + " " + p.getApellido());
	            }
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }
            
            System.out.println("\n-------------------------------------------------\n");
            try { 
	            System.out.println("\n---------- Festival Hamburguesas ----------");
	            List<Personal> personalAuditoria2 = sistema.traerPersonalPorFestival(festival2);
	            for (Personal p : personalAuditoria2) {
	                System.out.println("Trabajó de forma activa: " + p.getNombre() + " " + p.getApellido());
	            }
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println("\n--- [CU #13: Top 3 Unidades con Mayor Canon] ---");
            try {
	            System.out.println("\n---------- Festival Birras ----------");
	            List<ReporteMayoresCanon> topCanones = sistema.obtenerUnidadesConMayorCanon(festival);
	            for (ReporteMayoresCanon r : topCanones) {
	                System.out.println("Podio Canon -> Unidad: " + r.getNombreComercial() + " [" + r.getTipoUnidad() + "] - Canon: $" + r.getCanon());
	            }
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }
            
            System.out.println("\n-------------------------------------------------\n");
            try {
	            System.out.println("\n---------- Festival Hamburguesas ----------");
	            List<ReporteMayoresCanon> topCanones2 = sistema.obtenerUnidadesConMayorCanon(festival2);
	            for (ReporteMayoresCanon r : topCanones2) {
	                System.out.println("Podio Canon -> Unidad: " + r.getNombreComercial() + " [" + r.getTipoUnidad() + "] - Canon: $" + r.getCanon());
	            }
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
                e.printStackTrace();
            }
        
        
        System.out.println("\n==================================================");
        System.out.println("         FIN DEL TESTEO DE CASOS DE USO           ");
        System.out.println("==================================================");

	}

}

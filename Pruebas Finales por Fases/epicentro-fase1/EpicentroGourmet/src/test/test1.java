package test;

import java.math.BigDecimal;
import java.time.LocalDate;
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

            //Costo costoFest = new Costo(100000, 500, 5000, 10, 2000);
            try{
                Costo costoFest = new Costo(1, new BigDecimal("100000"), new BigDecimal("500"), new BigDecimal("5000"), new BigDecimal("10"), new BigDecimal("2000"));
                sistema.agregarFestival("Festival de la Cerveza", Temporada.PRIMAVERA, LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 5), costoFest);
                sistema.agregarFestival("Festival de la Hamburguesa", Temporada.VERANO, LocalDate.of(2027, 1, 1), LocalDate.of(2027, 1, 5), costoFest);
            } catch  (ExceptionMenorZero | ExceptionYaRegistrado | ExceptionFechasLimites e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } 
            
            System.out.println("✔ Festivales agregados con éxito.");

            // Cargamos un staff amplio (10 personas)
            sistema.agregarPersonalCocinero("Juan", "Pérez", 35111222L, LocalDate.of(1990, 5, 15), LocalDate.of(2020, 1, 1), "Gourmet", new BigDecimal("5000"));
            sistema.agregarPersonalCajero("Ana", "Gómez", 40333444L, LocalDate.of(1997, 8, 20), LocalDate.of(2022, 3, 1), Turno.TARDE);
            sistema.agregarPersonalCocinero("Luis", "Rodríguez", 38555666L, LocalDate.of(1994, 12, 10), LocalDate.of(2021, 5, 1), "Barra", new BigDecimal("3000"));
            sistema.agregarPersonalCajero("Pedro", "Martínez", 42111222L, LocalDate.of(1999, 3, 25), LocalDate.of(2023, 2, 15), Turno.MANANA);
            sistema.agregarPersonalCocinero("Carlos", "López", 33444555L, LocalDate.of(1988, 7, 14), LocalDate.of(2019, 6, 10), "Pescados", new BigDecimal("6000"));
            sistema.agregarPersonalCocinero("Pablo", "Gil", 36412905L, LocalDate.of(2000, 1, 16), LocalDate.of(2020, 8, 15), "Hamburguesas", new BigDecimal("4500"));
            sistema.agregarPersonalCocinero("Jose", "Fernandez", 19902341L, LocalDate.of(1985, 2, 24), LocalDate.of(2018, 4, 20), "Gourmet", new BigDecimal("5000"));
            sistema.agregarPersonalCajero("Matias", "Lescano", 42544248L, LocalDate.of(2001, 7, 9), LocalDate.of(2023, 10, 18), Turno.TARDE);
            sistema.agregarPersonalCocinero("Alan", "López", 39342560L, LocalDate.of(1998, 6, 30), LocalDate.of(2022, 5, 20), "Gourmet", new BigDecimal("5000"));
            sistema.agregarPersonalCajero("Santiago", "Mendez", 42323049L, LocalDate.of(2001, 5, 21), LocalDate.of(2023, 10, 10), Turno.MANANA);
            System.out.println("✔ Personal agregado con éxito.");
        } catch  (ExceptionYaRegistrado | ExceptionFechaNacimiento | ExceptionMenorZero e) {
            System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
        } 
            
            
            try {

            // Agregamos 4 unidades para poder armar un Top 3 real en el CU 13
            sistema.agregarUnidadFoodTruck("Burger Truck", sistema.traerPersonal(35111222L), 15.5, "FT-01", "AAA111", true);
            sistema.agregarUnidadPuestoDesarmable("Beer Stand", sistema.traerPersonal(40333444L), 20.0, "PD-01", 2, 60);
            sistema.agregarUnidadFoodTruck("Taco Truck", sistema.traerPersonal(33444555L), 12.0, "FT-02", "BBB222", false);
            sistema.agregarUnidadPuestoDesarmable("Delicias Stand", sistema.traerPersonal(19902341L), 18.0, "PD-02", 2, 50);
            } catch (ExceptionYaRegistrado | ExceptionSinRegistro | ExceptionMenorZero e){
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            }
            

            System.out.println("✔ 3 Unidades de Venta agregadas con éxito.");

            try{
            sistema.agregarPlato("Hamburguesa", new BigDecimal("15000.0"), new BigDecimal("6500.0"));
            sistema.agregarPlato("Taco de Carne", new BigDecimal("12000"), new BigDecimal("5100"));
            sistema.agregarPlato("Papas Fritas", new BigDecimal("10000.0"), new BigDecimal("4000.0"));
            sistema.agregarPlato("Cerveza Artesanal", new BigDecimal("4500.0"), new BigDecimal("1500.0"));
            sistema.agregarPlato("Hamburguesa Gourmet", new BigDecimal("17500.0"), new BigDecimal("8000.0"));
            sistema.agregarPlato("Bondiola Braseada", new BigDecimal("17000.0"), new BigDecimal("7600.0"));
            sistema.agregarPlato("Risotto de Hongos", new BigDecimal("14500.0"), new BigDecimal("6300.0"));
            sistema.agregarPlato("Cannoli de Pistacho", new BigDecimal("11500.0"), new BigDecimal("4500.0"));
            } catch (ExceptionYaRegistrado | ExceptionMenorZero e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } 
         
            System.out.println("✔ Platos agregados al menú global.");

            // try {
            //     UnidadVenta ft01 = sistema.traerUnidadVenta("FT-01");
            //     UnidadVenta pd01 = sistema.traerUnidadVenta("PD-01");
            //     UnidadVenta ft02 = sistema.traerUnidadVenta("FT-02");
            //     UnidadVenta pd02 = sistema.traerUnidadVenta("PD-02");
            //     Festival festival = sistema.traerFestival("Festival de la Cerveza");
            //     Festival festival2 = sistema.traerFestival("Festival de la Hamburguesa");
            // } catch (ExceptionSinRegistro e){
            //     System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            //     e.printStackTrace();
            // }
            
            // try {
            //     Plato hamb = sistema.traerPlato("Hamburguesa");
            //     Plato papas = sistema.traerPlato("Papas Fritas");
            //     Plato birra = sistema.traerPlato("Cerveza Artesanal");
            //     Plato taco = sistema.traerPlato("Taco de Carne");
            //     Plato hambGourm = sistema.traerPlato("Hamburguesa Gourmet");
            //     Plato bond = sistema.traerPlato("Bondiola Braseada");
            //     Plato ris = sistema.traerPlato("Risotto de Hongos");
            //     Plato cann = sistema.traerPlato("Cannoli de Pistacho");
            // } catch (ExceptionSinRegistro e){
            //     System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            //     e.printStackTrace();
            // }
        	
        	try {
                sistema.traerUnidadVenta("FT-01").agregarPlatoUnidadVenta(sistema.traerPlato("Hamburguesa"));
                sistema.traerUnidadVenta("FT-01").agregarPlatoUnidadVenta(sistema.traerPlato("Papas Fritas"));
                sistema.traerUnidadVenta("FT-01").agregarPlatoUnidadVenta(sistema.traerPlato("Hamburguesa Gourmet"));
                sistema.traerUnidadVenta("FT-01").agregarPersonalCocineroUnidadVenta(sistema.traerPersonal(35111222));
                sistema.traerUnidadVenta("FT-01").agregarPersonalCajeroUnidadVenta(sistema.traerPersonal(42323049));
            } catch (ExceptionYaRegistrado | ExceptionSinRegistro e){
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } 

            try {
                sistema.traerUnidadVenta("PD-01").agregarPlatoUnidadVenta(sistema.traerPlato("Cerveza Artesanal")); 
                sistema.traerUnidadVenta("PD-01").agregarPersonalCajeroUnidadVenta(sistema.traerPersonal(40333444));
                sistema.traerUnidadVenta("PD-01").agregarPersonalCocineroUnidadVenta(sistema.traerPersonal(38555666));
            } catch (ExceptionSinRegistro | ExceptionYaRegistrado e){
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } 


            try {
                sistema.traerUnidadVenta("FT-02").agregarPlatoUnidadVenta(sistema.traerPlato("Taco de Carne"));
                sistema.traerUnidadVenta("FT-02").agregarPlatoUnidadVenta(sistema.traerPlato("Papas Fritas"));
                sistema.traerUnidadVenta("FT-02").agregarPersonalCajeroUnidadVenta(sistema.traerPersonal(42111222));
                sistema.traerUnidadVenta("FT-02").agregarPersonalCocineroUnidadVenta(sistema.traerPersonal(39342560));
            } catch (ExceptionSinRegistro | ExceptionYaRegistrado e){
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            }
            
            try {
                sistema.traerUnidadVenta("PD-02").agregarPlatoUnidadVenta(sistema.traerPlato("Bondiola Braseada"));
                sistema.traerUnidadVenta("PD-02").agregarPlatoUnidadVenta(sistema.traerPlato("Cannoli de Pistacho"));
                sistema.traerUnidadVenta("PD-02").agregarPlatoUnidadVenta(sistema.traerPlato("Risotto de Hongos"));
                sistema.traerUnidadVenta("PD-02").agregarPersonalCocineroUnidadVenta(sistema.traerPersonal(36412905));
                sistema.traerUnidadVenta("PD-02").agregarPersonalCocineroUnidadVenta(sistema.traerPersonal(19902341));
                sistema.traerUnidadVenta("PD-02").agregarPersonalCajeroUnidadVenta(sistema.traerPersonal(42544248));    
        	} catch (ExceptionSinRegistro | ExceptionYaRegistrado e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } 

            System.out.println("✔ Menús y Staff asignados a cada puesto correctamente.");

            // ----------------------------------------------------------------
            // 2. REGISTRAR PEDIDOS Y CARGAR DETALLES (CU #5)
            // ----------------------------------------------------------------
            System.out.println("\n--- [CU #5: Registrar Pedidos] ---");
            
            // Registramos pedidos en días diferentes 
            // Registramos pedidos festival bIRRA
            try {
                sistema.registrarPedido(LocalDate.of(2026, 10, 2), sistema.traerFestival("Festival de la Cerveza"), sistema.traerUnidadVenta("FT-01"));
                sistema.registrarPedido(LocalDate.of(2026, 10, 2), sistema.traerFestival("Festival de la Cerveza"), sistema.traerUnidadVenta("PD-01"));
                sistema.registrarPedido(LocalDate.of(2026, 10, 3), sistema.traerFestival("Festival de la Cerveza"), sistema.traerUnidadVenta("FT-02"));
                sistema.registrarPedido(LocalDate.of(2026, 10, 4), sistema.traerFestival("Festival de la Cerveza"), sistema.traerUnidadVenta("FT-01")); // Segundo pedido de Burger Truck
            } catch (ExceptionSinRegistro | ExceptionYaRegistrado | ExceptionMenorZero e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } 
            
            // Registramos pedidos festival Hamburguesa

            try{
            sistema.registrarPedido(LocalDate.of(2027, 1, 2), sistema.traerFestival("Festival de la Hamburguesa"), sistema.traerUnidadVenta("FT-01"));
            sistema.registrarPedido(LocalDate.of(2027, 1, 2), sistema.traerFestival("Festival de la Hamburguesa"), sistema.traerUnidadVenta("PD-01"));
            sistema.registrarPedido(LocalDate.of(2027, 1, 3), sistema.traerFestival("Festival de la Hamburguesa"), sistema.traerUnidadVenta("PD-01"));
            sistema.registrarPedido(LocalDate.of(2027, 1, 3), sistema.traerFestival("Festival de la Hamburguesa"), sistema.traerUnidadVenta("FT-01"));
            sistema.registrarPedido(LocalDate.of(2027, 1, 4), sistema.traerFestival("Festival de la Hamburguesa"), sistema.traerUnidadVenta("FT-02"));
            } catch (ExceptionSinRegistro | ExceptionYaRegistrado | ExceptionMenorZero e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } 
            
            // try {
            //     Pedido ped1 = sistema.traerPedido(1);
            //     Pedido ped2 = sistema.traerPedido(2);
            //     Pedido ped3 = sistema.traerPedido(3);
            //     Pedido ped4 = sistema.traerPedido(4);
            //     Pedido ped5 = sistema.traerPedido(5);
            //     Pedido ped6 = sistema.traerPedido(6);
            //     Pedido ped7 = sistema.traerPedido(7);
            //     Pedido ped8 = sistema.traerPedido(8);
            //     Pedido ped9 = sistema.traerPedido(9);
            // } catch (ExceptionSinRegistro e) {
            //     System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            //     e.printStackTrace();
            // }
            

            // Carga de detalles pedidos
            
            try {
            sistema.traerPedido(1).agregarDetallePedido(sistema.traerPlato("Hamburguesa"), 30); 
            sistema.traerPedido(1).agregarDetallePedido(sistema.traerPlato("Papas Fritas"), 15);
            sistema.traerPedido(2).agregarDetallePedido(sistema.traerPlato("Cerveza Artesanal"), 150);
            sistema.traerPedido(3).agregarDetallePedido(sistema.traerPlato("Taco de Carne"), 35); 
            sistema.traerPedido(3).agregarDetallePedido(sistema.traerPlato("Papas Fritas"), 15);
            sistema.traerPedido(4).agregarDetallePedido(sistema.traerPlato("Papas Fritas"), 10);
            } catch (ExceptionSinRegistro | ExceptionDetallePedidoPlatoYaInlcuido | ExceptionMenorZero e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } 

            try {
                sistema.traerPedido(5).agregarDetallePedido(sistema.traerPlato("Cannoli de Pistacho"), 30);
                sistema.traerPedido(5).agregarDetallePedido(sistema.traerPlato("Papas Fritas"), 15);
                sistema.traerPedido(6).agregarDetallePedido(sistema.traerPlato("Cerveza Artesanal"), 45);
                sistema.traerPedido(7).agregarDetallePedido(sistema.traerPlato("Cerveza Artesanal"), 50);
                sistema.traerPedido(8).agregarDetallePedido(sistema.traerPlato("Hamburguesa Gourmet"), 45);
                sistema.traerPedido(8).agregarDetallePedido(sistema.traerPlato("Hamburguesa"), 35);
                sistema.traerPedido(9).agregarDetallePedido(sistema.traerPlato("Cannoli de Pistacho"), 40);
                sistema.traerPedido(9).agregarDetallePedido(sistema.traerPlato("Risotto de Hongos"), 20);
                sistema.traerPedido(9).agregarDetallePedido(sistema.traerPlato("Bondiola Braseada"), 35);
            } catch (ExceptionSinRegistro | ExceptionDetallePedidoPlatoYaInlcuido | ExceptionMenorZero e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            }
            
            // try {
            //     sistema.traerFestival("Festival de la Cerveza").agregarPedidoFestival(sistema.traerPedido(1));
            //     sistema.traerFestival("Festival de la Cerveza").agregarPedidoFestival(sistema.traerPedido(2));
            //     sistema.traerFestival("Festival de la Cerveza").agregarPedidoFestival(sistema.traerPedido(3));
            //     sistema.traerFestival("Festival de la Cerveza").agregarPedidoFestival(sistema.traerPedido(4));
            // } catch (ExceptionSinRegistro e) {
            //     System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            //     e.printStackTrace();
            // } catch (ExceptionYaRegistrado e) {
            //     System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            //     e.printStackTrace();
            // }

            // try {
            //     sistema.traerFestival("Festival de la Hamburguesa").agregarPedidoFestival(sistema.traerPedido(5));
            //     sistema.traerFestival("Festival de la Hamburguesa").agregarPedidoFestival(sistema.traerPedido(6));
            //     sistema.traerFestival("Festival de la Hamburguesa").agregarPedidoFestival(sistema.traerPedido(7));
            //     sistema.traerFestival("Festival de la Hamburguesa").agregarPedidoFestival(sistema.traerPedido(8));
            //     sistema.traerFestival("Festival de la Hamburguesa").agregarPedidoFestival(sistema.traerPedido(9));
            // } catch (ExceptionSinRegistro e) {
            //     System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            //     e.printStackTrace();
            // } catch (ExceptionYaRegistrado e) {
            //     System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            //     e.printStackTrace();
            // }
            
            
            
            System.out.println("✔ Múltiples pedidos y detalles vinculados.");

            // ----------------------------------------------------------------
            // 3. EJECUCIÓN DE REPORTES Y FILTROS (CU #6 al #13)
            // ----------------------------------------------------------------
            
            System.out.println("\n--- [CU #6: Reporte Recaudación] ---");
            try {
	            List<ReporteVenta> recaudaciones = sistema.generarReporteRecaudacion(sistema.traerFestival("Festival de la Cerveza"));
	            List<ReporteVenta> recaudaciones2 = sistema.generarReporteRecaudacion(sistema.traerFestival("Festival de la Hamburguesa"));
	            
	            System.out.println("\n---------- Festival Birras ----------");
	             for (ReporteVenta r : recaudaciones) {
	                 System.out.println("Unidad: " + r.getUnidadVenta().getNombreComercial() + " - Recaudó: $" + r.getRecaudacionTotal());
	             }
	            
	            System.out.println("\n---------- Festival Hamburguesas ----------");
	            for (ReporteVenta r : recaudaciones2) {
	                System.out.println("Unidad: " + r.getUnidadVenta().getNombreComercial() + " - Recaudó: $" + r.getRecaudacionTotal());
	            }
            } catch (ExceptionSinRegistro | ExceptionMenorZero e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
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
            }

            System.out.println("\n--- [CU #8: Rentabilidad Neta de Unidad] ---");
            try {
	            BigDecimal rentabilidadFT1 = sistema.calcularRentabilidadNetaUnidad(sistema.traerUnidadVenta("FT-01"), sistema.traerFestival("Festival de la Hamburguesa"));
	            System.out.println("Rentabilidad Neta de '" + sistema.traerUnidadVenta("FT-01").getNombreComercial() + "': $" + rentabilidadFT1);
	            BigDecimal rentabilidadFT2 = sistema.calcularRentabilidadNetaUnidad(sistema.traerUnidadVenta("FT-02"), sistema.traerFestival("Festival de la Cerveza"));
	            System.out.println("Rentabilidad Neta de '" + sistema.traerUnidadVenta("FT-02").getNombreComercial() + "': $" + rentabilidadFT2);
	            BigDecimal rentabilidadPD1 = sistema.calcularRentabilidadNetaUnidad(sistema.traerUnidadVenta("PD-01"), sistema.traerFestival("Festival de la Cerveza"));
	            System.out.println("Rentabilidad Neta de '" + sistema.traerUnidadVenta("PD-01").getNombreComercial() + "': $" + rentabilidadPD1);
	            BigDecimal rentabilidadPD2 = sistema.calcularRentabilidadNetaUnidad(sistema.traerUnidadVenta("PD-02"), sistema.traerFestival("Festival de la Hamburguesa"));
	            System.out.println("Rentabilidad Neta de '" + sistema.traerUnidadVenta("PD-02").getNombreComercial() + "': $" + rentabilidadPD2);
            } catch (ExceptionSinRegistro e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } 

            System.out.println("\n--- [CU #9: Rentabilidad Entre Fechas] ---");
            try {
	            // Filtramos solo los primeros 2 días del festival para ver si el CU9 discrimina correctamente el último pedido
	            BigDecimal rentabilidadRango1 = sistema.calcularRentabilidadNetaUnidadEntreFechas(sistema.traerUnidadVenta("FT-01"), LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 2));
	            System.out.println("Rentabilidad 'Burger Truck' (Rango 1 al 5 de Oct): $" + rentabilidadRango1);
	            BigDecimal rentabilidadRango2 = sistema.calcularRentabilidadNetaUnidadEntreFechas(sistema.traerUnidadVenta("FT-01"), LocalDate.of(2027, 1, 1), LocalDate.of(2027, 1, 5));
	            System.out.println("Rentabilidad 'Burger Truck' (Rango 1 al 5 de Ene): $" + rentabilidadRango2);
            } catch (ExceptionSinRegistro e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            }
            catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } 

            System.out.println("\n--- [CU #10: Ranking Unidades Mayor Recaudación] ---");
            try { 
	            System.out.println("\n---------- Festival Birras ----------");
	            List<ReporteVenta> ranking = sistema.generarRankingUnidadesMayorRecaudacion(sistema.traerFestival("Festival de la Cerveza"));
	            int puesto = 1;
	            for (ReporteVenta r : ranking) {
	                System.out.println(puesto + "° Puesto: " + r.getUnidadVenta().getNombreComercial() + " ($" + r.getRecaudacionTotal() + ")");
	                puesto++;
	            }
            
	            System.out.println("\n---------- Festival Hamburguesas ----------");
	            
	            List<ReporteVenta> ranking2 = sistema.generarRankingUnidadesMayorRecaudacion(sistema.traerFestival("Festival de la Hamburguesa"));
	            int puesto2 = 1;
	            for (ReporteVenta r : ranking2) {
	                System.out.println(puesto2 + "° Puesto: " + r.getUnidadVenta().getNombreComercial() + " ($" + r.getRecaudacionTotal() + ")");
	                puesto2++;
	            }
            } catch (ExceptionSinRegistro e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            }  catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } 

            System.out.println("\n--- [CU #11: Plato Estrella] ---");
            try {
	            // Con el segundo pedido que sumó 10 papas, las papas deberían ganarle a la hamburguesa (12 unidades totales contra 3)
	            Plato estrella = sistema.obtenerPlatoEstrella(sistema.traerUnidadVenta("FT-01"), sistema.traerFestival("Festival de la Cerveza"));
	            System.out.println("El plato estrella real de '" + sistema.traerUnidadVenta("FT-01").getNombreComercial() + "' fue: " + (estrella != null ? estrella.getNombrePlato() : "Ninguno"));
	            Plato estrella1 = sistema.obtenerPlatoEstrella(sistema.traerUnidadVenta("PD-01"), sistema.traerFestival("Festival de la Cerveza"));
	            System.out.println("El plato estrella real de '" + sistema.traerUnidadVenta("PD-01").getNombreComercial() + "' fue: " + (estrella1 != null ? estrella1.getNombrePlato() : "Ninguno"));
	            Plato estrella2 = sistema.obtenerPlatoEstrella(sistema.traerUnidadVenta("FT-02"), sistema.traerFestival("Festival de la Cerveza"));
	            System.out.println("El plato estrella real de '" + sistema.traerUnidadVenta("FT-02").getNombreComercial() + "' fue: " + (estrella2 != null ? estrella2.getNombrePlato() : "Ninguno"));
	            Plato estrella3 = sistema.obtenerPlatoEstrella(sistema.traerUnidadVenta("PD-02"), sistema.traerFestival("Festival de la Hamburguesa"));
	            System.out.println("El plato estrella real de '" + sistema.traerUnidadVenta("PD-02").getNombreComercial() + "' fue: " + (estrella3 != null ? estrella3.getNombrePlato() : "Ninguno"));
            } catch (ExceptionSinRegistro e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage()); 
            }
             
            
            System.out.println("\n--- [CU #12: Auditoría de Personal por Festival] ---");
            try {
            	System.out.println("\n---------- Festival Birras ----------");
	            List<Personal> personalAuditoria = sistema.traerPersonalPorFestival(sistema.traerFestival("Festival de la Cerveza"));
	            for (Personal p : personalAuditoria) {
	                System.out.println("Trabajó de forma activa: " + p.getNombre() + " " + p.getApellido());
	            }
            } catch (ExceptionSinRegistro e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            }
            
            System.out.println("\n-------------------------------------------------\n");
            try { 
	            System.out.println("\n---------- Festival Hamburguesas ----------");
	            List<Personal> personalAuditoria2 = sistema.traerPersonalPorFestival(sistema.traerFestival("Festival de la Hamburguesa"));
	            for (Personal p : personalAuditoria2) {
	                System.out.println("Trabajó de forma activa: " + p.getNombre() + " " + p.getApellido());
	            }
            } catch (ExceptionSinRegistro e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            }

            System.out.println("\n--- [CU #13: Top 3 Unidades con Mayor Canon] ---");
            try {
	            System.out.println("\n---------- Festival Birras ----------");
	            List<ReporteMayoresCanon> topCanones = sistema.obtenerUnidadesConMayorCanon(sistema.traerFestival("Festival de la Cerveza"));
	            for (ReporteMayoresCanon r : topCanones) {
	                System.out.println("Podio Canon -> Unidad: " + r.getNombreComercial() + " [" + r.getTipoUnidad().getDescripcion() + "] - Canon: $" + r.getCanon());
	            }
            } catch (ExceptionSinRegistro e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            }
            
            System.out.println("\n-------------------------------------------------\n");
            try {
	            System.out.println("\n---------- Festival Hamburguesas ----------");
	            List<ReporteMayoresCanon> topCanones2 = sistema.obtenerUnidadesConMayorCanon(sistema.traerFestival("Festival de la Hamburguesa"));
	            for (ReporteMayoresCanon r : topCanones2) {
	                System.out.println("Podio Canon -> Unidad: " + r.getNombreComercial() + " [" + r.getTipoUnidad().getDescripcion() + "] - Canon: $" + r.getCanon());
	            }
            } catch (ExceptionSinRegistro e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("\n❌ ERROR DETECTADO DURANTE EL TEST: " + e.getMessage());
            }
        
        
        System.out.println("\n==================================================");
        System.out.println("         FIN DEL TESTEO DE CASOS DE USO           ");
        System.out.println("==================================================");
        
	}

}

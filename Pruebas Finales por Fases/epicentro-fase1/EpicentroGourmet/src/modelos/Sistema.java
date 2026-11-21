package modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.math.RoundingMode;

public class Sistema {
	private final Map<String, Festival> mapFestivales;
	private final Map<Long, Personal> mapPersonal;
	private final Map<Integer, Pedido> mapPedidos;
	private final Map<String, UnidadVenta> mapUnidadVentas;
	private final Map<String, Plato> mapPlatos;
	private int lastIdFestivales;
	private int lastIdPersonal;
	private int lastIdPedidos;
	private int lastIdUnidadVenta;
	private int lastIdPlatos;
	private int lastIdReporteVenta;
	
	
	public Sistema() {
		this.mapFestivales = new HashMap<>();
		this.mapPersonal = new HashMap<>();
		this.mapPedidos = new HashMap<>();
		this.mapUnidadVentas = new HashMap<>();
		this.mapPlatos = new HashMap<>();
		this.lastIdFestivales = 0;
		this.lastIdPedidos = 0;
		this.lastIdPersonal = 0;
		this.lastIdPlatos = 0;
		this.lastIdUnidadVenta = 0;
		this.lastIdReporteVenta = 0;
	}


	public Map<String, Festival> getMapFestivales() {
		return Map.copyOf(mapFestivales);
	}
	
	public Map<Long, Personal> getMapPersonal() {
		return Map.copyOf(mapPersonal);
	}
	
	public Map<Integer, Pedido> getMapPedidos() {
		return Map.copyOf(mapPedidos);
	}
	
	public Map<String, UnidadVenta> getMapUnidadVentas() {
		return Map.copyOf(mapUnidadVentas);
	}

	public Map<String, Plato> getMapPlatos(){
		return Map.copyOf(mapPlatos); 
	}
	
	

	/// Todos los traer ------------------------
	
	public Festival traerFestival(String nombreFestival)throws 	ExceptionSinRegistro {
		Festival resultado = mapFestivales.get(nombreFestival);
		if (resultado == null)  throw new ExceptionSinRegistro("ERROR. El festival '" + nombreFestival + "' no se ecnunetra registrado.");
		return resultado;
	}
	
	public Personal traerPersonal(long dni) throws ExceptionSinRegistro{
		Personal resultado = mapPersonal.get(dni);
		if (resultado == null) throw new ExceptionSinRegistro("ERROR. El personal con DNI " + dni + " no se encuentra registrado.");
	    return resultado;
	}
	
	public UnidadVenta traerUnidadVenta(String codigo) throws ExceptionSinRegistro{
		UnidadVenta resultado = mapUnidadVentas.get(codigo);
		if (resultado == null) throw new ExceptionSinRegistro("ERROR. La unidad venta con codigo " + codigo + " no se encuentra registrada.");
	    return resultado;
	}
	
	public Plato traerPlato(String nombrePlato)throws ExceptionSinRegistro {
		Plato resultado = mapPlatos.get(nombrePlato);
		if (resultado == null) throw new ExceptionSinRegistro("ERROR. El plato " + nombrePlato + " no se encuentra registrado.");
	    return resultado;
	}
	
	public Pedido traerPedido(int idPedido)  throws ExceptionSinRegistro{
		Pedido resultado = mapPedidos.get(idPedido);
		if (resultado == null) throw new ExceptionSinRegistro("ERROR. El pedido con id " + idPedido + " no se encuentra registrado.");
	    return resultado;
	}
	
	/// Todos los agregar ------------------------
	
	
	public boolean agregarFestival(String nombreFestival, Temporada temporadaFestival, LocalDate fechaInicio, LocalDate fechaFin, Costo costoFestival)throws ExceptionYaRegistrado, ExceptionMenorZero, ExceptionFechasLimites{
		if (mapFestivales.containsKey(nombreFestival)) throw new ExceptionYaRegistrado("ERROR. El nombre " + nombreFestival + " Ya se encuentra registrado como festival.");
		
		int proxId = lastIdFestivales + 1;
		
		mapFestivales.put(nombreFestival, new Festival(proxId, nombreFestival, temporadaFestival, fechaInicio, fechaFin, costoFestival));
		lastIdFestivales++;
		return true;
	}
	
	public boolean agregarPersonalCocinero(String nombre, String apellido, Long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, String especialidad, BigDecimal plus) throws ExceptionYaRegistrado, ExceptionFechaNacimiento, ExceptionMenorZero {
			if (mapPersonal.containsKey(dni)) throw new ExceptionYaRegistrado("ERROR. El personal con DNI " + dni + " ya se encuentra registrado.");
		
			int proxId = lastIdPersonal + 1;
			
			mapPersonal.put(dni, new Cocinero(proxId, nombre, apellido, dni, fechaNacimiento, fechaIngreso, especialidad, plus));
			lastIdPersonal++;
			return true;
			}
	
	public boolean agregarPersonalCajero(String nombre, String apellido, Long dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, Turno turno) throws ExceptionYaRegistrado, ExceptionFechaNacimiento, ExceptionMenorZero{
			if (mapPersonal.containsKey(dni)) throw new ExceptionYaRegistrado("ERROR. El personal con DNI " + dni + " ya se encuentra registrado.");

			int proxId = lastIdPersonal + 1;
			
			mapPersonal.put(dni, new Cajero(proxId, nombre, apellido, dni, fechaNacimiento, fechaIngreso, turno));
			lastIdPersonal++;
			return true;
		}
	
	public boolean agregarUnidadFoodTruck(String nombreComercial, Personal responsable, double superficie, String codigo, String patente, boolean electricidad) throws ExceptionYaRegistrado, ExceptionMenorZero {
			if (mapUnidadVentas.containsKey(codigo)) throw new ExceptionYaRegistrado("ERROR. La unidad con código " + codigo + " ya se encuentra registrada.");
			
			int proxId = lastIdUnidadVenta + 1;

			mapUnidadVentas.put(codigo, new FoodTruck(proxId, nombreComercial, responsable, superficie, codigo,patente, electricidad));
			lastIdUnidadVenta++;
			return true;
			}
	
	public boolean agregarUnidadPuestoDesarmable(String nombreComercial, Personal responsable, double superficie, String codigo, int cantidadCarpas, int tiempoMontaje) throws ExceptionYaRegistrado, ExceptionMenorZero {
			if (mapUnidadVentas.containsKey(codigo)) throw new ExceptionYaRegistrado("ERROR. La unidad con código " + codigo + " ya se encuentra registrada.");
		
			int proxId = lastIdUnidadVenta + 1;
			
			mapUnidadVentas.put(codigo, new PuestoDesarmable(proxId, nombreComercial, responsable, superficie, codigo, cantidadCarpas, tiempoMontaje));
			lastIdUnidadVenta++;
			return true;
			}
	
	public boolean agregarPlato(String nombrePlato, BigDecimal precioVenta, BigDecimal costoProduccion)throws ExceptionYaRegistrado, ExceptionMenorZero{
		if (mapPlatos.containsKey(nombrePlato)) throw new ExceptionYaRegistrado("ERROR. El plato " + nombrePlato + " ya se encuentra regitrado.");
		
		int proxId = lastIdPlatos + 1;
		
		mapPlatos.put(nombrePlato, new Plato(proxId, nombrePlato, precioVenta, costoProduccion));
		lastIdPlatos++;
		return true;
	}
	
	
	/// CU #5 -------------------
	
	public boolean registrarPedido(LocalDate fecha, Festival festival, UnidadVenta unidadVenta) throws ExceptionSinRegistro, ExceptionYaRegistrado, ExceptionMenorZero{
		
		UnidadVenta v = traerUnidadVenta(unidadVenta.getCodigo());

		Festival f = traerFestival(festival.getNombreFestival());

		int proxId = lastIdPedidos + 1;
		
		
		Pedido p =  new Pedido(proxId, fecha, f, v);

		f.agregarPedidoFestival(p);

		mapPedidos.put(proxId, p);

		lastIdPedidos++;
		return true;
	}
	
	
	
	/// CU #6
	
	public List<ReporteVenta> generarReporteRecaudacion(Festival festival)throws ExceptionSinRegistro, ExceptionMenorZero{
		if (!(mapFestivales.containsKey(festival.getNombreFestival()))) throw new ExceptionSinRegistro ("ERROR. El festival " + festival.getNombreFestival() + " no existe.");
		
		List<ReporteVenta> lstReporte = new ArrayList<ReporteVenta>();
		
		if (festival.getLstPedidos() == null) {
			return lstReporte;
		}
		
		for (UnidadVenta unidad: mapUnidadVentas.values()) {
			BigDecimal recaudacionTotal = BigDecimal.ZERO;
			
			for (Pedido pedido: festival.getLstPedidos()) {
				if (pedido.getUnidadVenta().equals(unidad)) {
					//recaudacionTotal += pedido.calcularTotalPedido();
					recaudacionTotal = recaudacionTotal.add(pedido.calcularTotalPedido());
				}
			}
			
			int proxId = lastIdReporteVenta + 1;
			lastIdReporteVenta++;

			ReporteVenta nuevoReporte = new ReporteVenta(proxId, unidad, recaudacionTotal);
			
			lstReporte.add(nuevoReporte);
		}
		return lstReporte;
	}
	

	/// CU #7
	
	
	public List<Personal> traerPersonalNacidaEntre(LocalDate inicio, LocalDate fin){
		
		List<Personal> lstPersonalFechas = new ArrayList<>();
		
		for (Personal persona: mapPersonal.values()) {
			if ((persona.getFechaNacimiento().isAfter(inicio) || persona.getFechaNacimiento().equals(inicio))  &&  (persona.getFechaNacimiento().isBefore(fin) || persona.getFechaNacimiento().equals(fin))) {
				lstPersonalFechas.add(persona);
			}
		}
		return lstPersonalFechas;
	}
	
	
	/// CU #8
	

	public BigDecimal calcularRentabilidadNetaUnidad(UnidadVenta unidadVenta, Festival festival)throws ExceptionSinRegistro {

		traerUnidadVenta(unidadVenta.getCodigo());
		
		traerFestival(festival.getNombreFestival());
		
		BigDecimal totalUnidadVenta = BigDecimal.ZERO;
		BigDecimal totalPersonalCoste = BigDecimal.ZERO;
		
		for (Pedido pedido: mapPedidos.values()) {
			if (pedido.getUnidadVenta().equals(unidadVenta) && pedido.getFestival().equals(festival)) {
				//totalUnidadVenta += (pedido.calcularTotalPedido() - pedido.calcularTotalCosteProduccion());
				//BigDecimal totalPedido = pedido.calcularTotalPedido();
				//BigDecimal totalCosteProduccion = pedido.calcularTotalCosteProduccion();
				//totalUnidadVenta = totalUnidadVenta.add(totalPedido.subtract(totalCosteProduccion));
				//totalUnidadVenta = totalUnidadVenta.add(pedido.calcularTotalPedido().subtract(pedido.calcularTotalCosteProduccion()));
				totalUnidadVenta = totalUnidadVenta.add(pedido.calcularTotalPedido().subtract(pedido.calcularTotalCosteProduccion()));
			}
		}
			
		for (Personal persona: unidadVenta.getLstPersonal()) {
			//totalPersonalCoste += persona.calcularSueldo(festival.getCostoFestival());
			totalPersonalCoste = totalPersonalCoste.add(persona.calcularSueldo(festival.getCostoFestival()));
		}
			
			
		//totalUnidadVenta -= (unidadVenta.calcularCanon(festival.getCostoFestival()) + totalPersonalCoste);
		BigDecimal costoFestival = unidadVenta.calcularCanon(festival.getCostoFestival()).add(totalPersonalCoste);
		totalUnidadVenta = totalUnidadVenta.subtract(costoFestival);
		
		return totalUnidadVenta.setScale(2, RoundingMode.HALF_UP);
	}
	
	
	/// CU #9
	
	
	public BigDecimal calcularRentabilidadNetaUnidadEntreFechas(UnidadVenta unidadVenta, LocalDate inicio, LocalDate fin)throws ExceptionSinRegistro {
		
		traerUnidadVenta(unidadVenta.getCodigo());
		
		BigDecimal totalRentabilidad = BigDecimal.ZERO;
		List<Festival> festivales = new ArrayList<>();
		
		for (Pedido pedido: mapPedidos.values()) {
			if (pedido.getUnidadVenta().equals(unidadVenta)) {
			
				if ((pedido.getFechaTransaccion().isAfter(inicio) || pedido.getFechaTransaccion().equals(inicio)) && (pedido.getFechaTransaccion().isBefore(fin) ||pedido.getFechaTransaccion().equals(fin))) {
			
						//totalRentabilidad += (pedido.calcularTotalPedido() - pedido.calcularTotalCosteProduccion());
						//BigDecimal totalPedido = pedido.calcularTotalPedido().subtract(pedido.calcularTotalCosteProduccion());
						BigDecimal totalPedido = calcularTotalGananciaPedido(pedido);
						totalRentabilidad = totalRentabilidad.add(totalPedido);
		                
		  
		                if (!festivales.contains(pedido.getFestival())) {
		                    festivales.add(pedido.getFestival());
		                }
				}
			}
		}
			
			for (Festival festival : festivales) {
		        
		        BigDecimal canonFestival = unidadVenta.calcularCanon(festival.getCostoFestival());
		        //totalRentabilidad -= canonFestival;
				totalRentabilidad = totalRentabilidad.subtract(canonFestival);
		        
		        BigDecimal sueldosFestival = BigDecimal.ZERO;
		        for (Personal persona : unidadVenta.getLstPersonal()) {
		            //sueldosFestival += persona.calcularSueldo(festival.getCostoFestival());
					sueldosFestival = sueldosFestival.add(persona.calcularSueldo(festival.getCostoFestival()));
		        }
		        totalRentabilidad = totalRentabilidad.subtract(sueldosFestival);
		    }

		    return totalRentabilidad.setScale(2, RoundingMode.HALF_UP);
	}
	
	
	
	/// CU #10
	 

	public List<ReporteVenta> generarRankingUnidadesMayorRecaudacion(Festival festival)throws ExceptionSinRegistro, ExceptionMenorZero{
		traerFestival(festival.getNombreFestival());
		
		List<ReporteVenta> lstRecaudacionUnidades = generarReporteRecaudacion(festival);
		
		for (int i = 0; i < lstRecaudacionUnidades.size(); i++) {
			for (int j = i + 1; j <lstRecaudacionUnidades.size(); j++) {
				//if (lstRecaudacionUnidades.get(j).getRecaudacionTotal() > lstRecaudacionUnidades.get(i).getRecaudacionTotal()) {
				if (lstRecaudacionUnidades.get(j).getRecaudacionTotal().compareTo(lstRecaudacionUnidades.get(i).getRecaudacionTotal()) > 0)  {
					ReporteVenta aux = lstRecaudacionUnidades.get(i);
					lstRecaudacionUnidades.set(i, lstRecaudacionUnidades.get(j));
					lstRecaudacionUnidades.set(j, aux);
					
				}
			}
		}
		return lstRecaudacionUnidades;
		
	}
	
	
	
	/// CU #11
	
	
	public Plato obtenerPlatoEstrella(UnidadVenta unidadVenta, Festival festival) throws ExceptionSinRegistro{
		
		traerFestival(festival.getNombreFestival());
		
		traerUnidadVenta(unidadVenta.getCodigo());	
		
		Plato platoEstrella = null;
	    int maxCantidadGlobal = -1; 
	    

	    for (Plato plato : unidadVenta.getLstPlatos()) {
	        int acumuladorCantidadPlato = 0;
	        

	        for (Pedido pedido : mapPedidos.values()) {
	            if (pedido.getUnidadVenta().equals(unidadVenta) && pedido.getFestival().equals(festival)) {
	                

	                for (DetallePedido detalle : pedido.getLstDetallePedido()) {
	                    if (detalle.getPlato().equals(plato)) {
	                        acumuladorCantidadPlato += detalle.getCantidad();
	                    }
	                }
	            }
	        }
	        

	        if (acumuladorCantidadPlato > maxCantidadGlobal && acumuladorCantidadPlato > 0) {
	            maxCantidadGlobal = acumuladorCantidadPlato;
	            platoEstrella = plato;
	        }
	    }
	    

	    return platoEstrella;
	}

	
	/// CU #12

	
	
	public 	List<Personal> traerPersonalPorFestival(Festival festival) throws ExceptionSinRegistro{
		
		traerFestival(festival.getNombreFestival());
		
		List<Personal> lstPersonalFestival = new ArrayList<Personal>();
		
		
		for (Pedido pedido: traerFestival(festival.getNombreFestival()).getLstPedidos()) {
			for (Personal persona: pedido.getUnidadVenta().getLstPersonal()) {
				
				if (!lstPersonalFestival.contains(persona)) {
					lstPersonalFestival.add(persona);
				}
			}
		}
		return lstPersonalFestival;
	}
	
	
	
	/// CU #13
	
	
	public List<ReporteMayoresCanon> obtenerUnidadesConMayorCanon(Festival festival)throws ExceptionSinRegistro{
		
		traerFestival(festival.getNombreFestival());
		
		List<ReporteMayoresCanon> lstTodosLosCanones = new ArrayList<>();

	    
	    for (UnidadVenta unidad : mapUnidadVentas.values()) {
	    	
	    	boolean estuvoPresente = false;
	    	//int i = 0;
	    	
	    //    while (i < mapPedidos.values().size() && estuvoPresente == false) {
	    //         if (mapPedidos.values().get(i).getUnidadVenta().equals(unidad) && mapPedidos.values().get(i).getFestival().equals(festival)) {
	    //             estuvoPresente = true;
	    //         }
	    //         i++;
	    //     }

	        // if (!estuvoPresente) {
	        //     continue;
	        // }

			for (Pedido pedido : mapPedidos.values()) {
        		if (pedido.getUnidadVenta().equals(unidad) && pedido.getFestival().equals(festival)) {
					estuvoPresente = true;
					break;
        		}
    		}

			if (!estuvoPresente) {
				continue;
			}
	    	

	    	
	        BigDecimal canonCalculado = unidad.calcularCanon(festival.getCostoFestival()).setScale(2, RoundingMode.HALF_UP);
	        
	        
	        // String tipoUnidad = "Puesto Desarmable";
	        // if (unidad instanceof FoodTruck) { 
	        //     tipoUnidad = "Food Truck";
	        // }

			TipoUnidad tipoUnidad = TipoUnidad.PUESTODESARMABLE;
			if (unidad instanceof FoodTruck){
				tipoUnidad = TipoUnidad.FOODTRUCK;
			}

	        lstTodosLosCanones.add(new ReporteMayoresCanon(unidad.getNombreComercial(),unidad.getCodigo(), tipoUnidad, canonCalculado));
	        
	    }

	 
	    for (int i = 0; i < lstTodosLosCanones.size(); i++) {
	        for (int j = i + 1; j < lstTodosLosCanones.size(); j++) {
	            //if (lstTodosLosCanones.get(j).getCanon() > lstTodosLosCanones.get(i).getCanon()) {
				if (lstTodosLosCanones.get(j).getCanon().compareTo( lstTodosLosCanones.get(i).getCanon()) > 0) {
	                ReporteMayoresCanon aux = lstTodosLosCanones.get(i);
	                lstTodosLosCanones.set(i, lstTodosLosCanones.get(j));
	                lstTodosLosCanones.set(j, aux);
	            }
	        }
	    }

	    List<ReporteMayoresCanon> top3Canon = new ArrayList<>();
	
	    int limite = Math.min(3, lstTodosLosCanones.size()); 
	    
	    for (int i = 0; i < limite; i++) {
	        top3Canon.add(lstTodosLosCanones.get(i));
	    }

	    return top3Canon;
	}


		public BigDecimal calcularTotalGananciaPedido(Pedido pedido){

			BigDecimal total = pedido.calcularTotalPedido().subtract(pedido.calcularTotalCosteProduccion());

			return total.setScale(2, RoundingMode.HALF_UP);
		}
	
}
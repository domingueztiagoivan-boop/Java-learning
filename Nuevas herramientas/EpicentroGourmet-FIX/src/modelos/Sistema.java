package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Festival> lstFestival;
	private List<Personal> lstPersonal;
	private List<Pedido> lstPedidos;
	private List<UnidadVenta> lstUnidadVenta;
	private List<Plato> lstPlatos;
	
	
	public Sistema() {
		this.lstFestival = new ArrayList<Festival>();
		this.lstPersonal = new ArrayList<Personal>();
		this.lstPedidos = new ArrayList<Pedido>();
		this.lstUnidadVenta = new ArrayList<UnidadVenta>();
		this.lstPlatos = new ArrayList<Plato>();
	}


	public List<Festival> getLstFestival() {
		return lstFestival;
	}
	public void setLstFestival(List<Festival> lstFestival) {
		this.lstFestival = lstFestival;
	}
	public List<Personal> getLstPersonal() {
		return lstPersonal;
	}
	public void setLstPersonal(List<Personal> lstPersonal) {
		this.lstPersonal = lstPersonal;
	}
	public List<Pedido> getLstPedidos() {
		return lstPedidos;
	}
	public void setLstPedidos(List<Pedido> lstPedidos) {
		this.lstPedidos = lstPedidos;
	}
	public List<UnidadVenta> getLstUnidadVenta() {
		return lstUnidadVenta;
	}
	public void setLstUnidadVenta(List<UnidadVenta> lstUnidadVenta) {
		this.lstUnidadVenta = lstUnidadVenta;
	}
	

	/// Todos los traer ------------------------
	
	public Festival traerFestival(String nombreFestival) {
		
		Festival resultado = null;
		int i = 0;
		
		while (i < lstFestival.size() && resultado == null) {
			if (lstFestival.get(i).getNombreFestival().equals(nombreFestival)) {
				resultado = lstFestival.get(i);
			}
			i++;
		}
		return resultado;
	}
	
	public Personal traerPersonal(long dni) {
	    Personal resultado = null;
	    int i = 0;
	    
	    while (i < lstPersonal.size() && resultado == null) {
	        if (lstPersonal.get(i).getDni() == dni) {
	            resultado = lstPersonal.get(i);
	        }
	        i++;
	    }
	    return resultado;
	}
	
	public UnidadVenta traerUnidadVenta(String codigo) {
	    UnidadVenta resultado = null;
	    int i = 0;
	    
	    while (i < lstUnidadVenta.size() && resultado == null) {
	        if (lstUnidadVenta.get(i).getCodigo().equals(codigo)) {
	            resultado = lstUnidadVenta.get(i);
	        }
	        i++;
	    }
	    return resultado;
	}
	
	public Plato traerPlato(String nombrePlato) {
	    Plato resultado = null;
	    int i = 0;
	    
	    while (i < lstPlatos.size() && resultado == null) {
	        if (lstPlatos.get(i).getNombrePlato().equalsIgnoreCase(nombrePlato)) {
	            resultado = lstPlatos.get(i);
	        }
	        i++;
	    }
	    return resultado;
	}
	
	public Pedido traerPedido(int idPedido) {
	    Pedido resultado = null;
	    int i = 0;
	    
	    while (i < lstPedidos.size() && resultado == null) {
	        if (lstPedidos.get(i).getIdPedido() == idPedido) {
	            resultado = lstPedidos.get(i);
	        }
	        i++;
	    }
	    return resultado;
	}
	
	/// Todos los agregar ------------------------
	
	
	public boolean agregarFestival(String nombreFestival, String temporadaFestival, LocalDate fechaInicio, LocalDate fechaFin, Costo costoFestival)throws Exception{
		if (traerFestival(nombreFestival) != null) throw new Exception("ERROR. El nombre " + nombreFestival + " Ya se encuentra registrado como festival.");
		
		int proxId = (!lstFestival.isEmpty()) ? lstFestival.get(lstFestival.size() - 1).getIdFestival() + 1 : 1;
		
		return lstFestival.add(new Festival(proxId, nombreFestival, temporadaFestival, fechaInicio, fechaFin, costoFestival));
	}
	
	public boolean agregarPersonalCocinero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, String especialidad, double plus) throws Exception {
			if (traerPersonal(dni) != null) throw new Exception("ERROR. El personal con DNI " + dni + " ya se encuentra registrado.");
		
			int proxId = (!lstPersonal.isEmpty()) ? lstPersonal.get(lstPersonal.size() - 1).getIdPersonal() + 1 : 1;
			
			return lstPersonal.add(new Cocinero(proxId, nombre, apellido, dni, fechaNacimiento, fechaIngreso, especialidad, plus));
			}
	
	public boolean agregarPersonalCajero(String nombre, String apellido, int dni, LocalDate fechaNacimiento, LocalDate fechaIngreso, String turno) throws Exception {
			if (traerPersonal(dni) != null) throw new Exception("ERROR. El personal con DNI " + dni + " ya se encuentra registrado.");

			int proxId = (!lstPersonal.isEmpty()) ? lstPersonal.get(lstPersonal.size() - 1).getIdPersonal() + 1 : 1;
			
			return lstPersonal.add(new Cajero(proxId, nombre, apellido, dni, fechaNacimiento, fechaIngreso, turno));
			}
	
	public boolean agregarUnidadFoodTruck(String nombreComercial, Personal responsable, double superficie, String codigo, String patente, boolean electricidad) throws Exception {
			if (traerUnidadVenta(codigo) != null) throw new Exception("ERROR. La unidad con código " + codigo + " ya se encuentra registrada.");
			
			int proxId = (!lstUnidadVenta.isEmpty()) ? lstUnidadVenta.get(lstUnidadVenta.size() - 1).getIdUnidadVenta() + 1 : 1;
			
			return lstUnidadVenta.add(new FoodTruck(proxId, nombreComercial, responsable, superficie, codigo,patente, electricidad));
			}
	
	public boolean agregarUnidadPuestoDesarmable(String nombreComercial, Personal responsable, double superficie, String codigo, int cantidadCarpas, int tiempoMontaje) throws Exception {
			if (traerUnidadVenta(codigo) != null) throw new Exception("ERROR. La unidad con código " + codigo + " ya se encuentra registrada.");
		
			int proxId = (!lstUnidadVenta.isEmpty()) ? lstUnidadVenta.get(lstUnidadVenta.size() - 1).getIdUnidadVenta() + 1 : 1;
			
			return lstUnidadVenta.add(new PuestoDesarmable(proxId, nombreComercial, responsable, superficie, codigo, cantidadCarpas, tiempoMontaje));
			}
	
	public boolean agregarPlato(String nombrePlato, double precioVenta, double costoProduccion)throws Exception{
		if (traerPlato(nombrePlato) != null) throw new Exception("ERROR. El plato " + nombrePlato + " ya se encuentra regitrado.");
		
		int proxId = (!lstPlatos.isEmpty()) ? lstPlatos.get(lstPlatos.size() - 1).getIdPlato() + 1 : 1;
		
		return lstPlatos.add(new Plato(proxId, nombrePlato, precioVenta, costoProduccion));
	}
	
	
	/// CU #5 -------------------
	
	public boolean registrarPedido(LocalDate fecha, Festival festival, UnidadVenta unidadVenta) throws Exception{
		
		if (traerFestival(festival.getNombreFestival()) == null) throw new Exception ("ERROR. El festival " + festival.getNombreFestival() + " no existe.");
		
		if (traerUnidadVenta(unidadVenta.getCodigo()) == null) throw new Exception ("ERROR. La unidad " + unidadVenta.getCodigo() + " no existe.");
		
		int proxId = !lstPedidos.isEmpty() ? lstPedidos.get(lstPedidos.size() - 1).getIdPedido() + 1: 1;
		
		return lstPedidos.add(new Pedido(proxId, fecha, festival, unidadVenta));
	}
	
	
	
	/// CU #6
	
	public List<ReporteVenta> generarReporteRecaudacion(Festival festival)throws Exception{
		if (traerFestival(festival.getNombreFestival()) == null) throw new Exception ("ERROR. El festival " + festival.getNombreFestival() + " no existe.");
		
		List<ReporteVenta> lstReporte = new ArrayList<ReporteVenta>();
		
		if (festival.getLstPedidos() == null) {
			return lstReporte;
		}
		
		for (UnidadVenta unidad: lstUnidadVenta) {
			double recaudacionTotal = 0;
			
			for (Pedido pedido: festival.getLstPedidos()) {
				if (pedido.getUnidadVenta().equals(unidad)) {
					recaudacionTotal += pedido.calcularTotalPedido();
				}
			}
			
			ReporteVenta nuevoReporte = new ReporteVenta(unidad, recaudacionTotal);
			
			lstReporte.add(nuevoReporte);
		}
		return lstReporte;
	}
	

	/// CU #7
	
	
	public List<Personal> traerPersonalNacidaEntre(LocalDate inicio, LocalDate fin){
		
		List<Personal> lstPersonalFechas = new ArrayList<Personal>();
		
		for (Personal persona: lstPersonal) {
			if ((persona.getFechaNacimiento().isAfter(inicio) || persona.getFechaNacimiento().equals(inicio))  &&  (persona.getFechaNacimiento().isBefore(fin) || persona.getFechaNacimiento().equals(fin))) {
				lstPersonalFechas.add(persona);
			}
		}
		return lstPersonalFechas;
	}
	
	
	/// CU #8
	

	public double calcularRentabilidadNetaUnidad(UnidadVenta unidadVenta, Festival festival)throws Exception {
		if (traerUnidadVenta(unidadVenta.getCodigo()) == null) throw new Exception ("ERROR. La unidad " + unidadVenta.getCodigo() + " no existe.");
		
		if (traerFestival(festival.getNombreFestival()) == null) throw new Exception ("ERROR. El festival " + festival.getNombreFestival() + " no existe.");
		
		double totalUnidadVenta = 0;
		double totalPersonalCoste = 0;
		
		for (Pedido pedido: lstPedidos) {
			if (pedido.getUnidadVenta().equals(unidadVenta) && pedido.getFestival().equals(festival)) {
				totalUnidadVenta += (pedido.calcularTotalPedido() - pedido.calcularTotalCosteProduccion());
			}
		}
			
		for (Personal persona: unidadVenta.getLstPersonal()) {
			totalPersonalCoste += persona.calcularSueldo(festival.getCostoFestival());
		}
			
			
		totalUnidadVenta -= (unidadVenta.calcularCanon(festival.getCostoFestival()) + totalPersonalCoste);
		
		return totalUnidadVenta;
	}
	
	
	/// CU #9
	
	
	public double calcularRentabilidadNetaUnidadEntreFechas(UnidadVenta unidadVenta, LocalDate inicio, LocalDate fin)throws Exception {
		
		if (traerUnidadVenta(unidadVenta.getCodigo()) == null) throw new Exception ("ERROR. La unidad " + unidadVenta.getCodigo() + " no existe.");
		
		double totalRentabilidad = 0;
		List<Festival> festivales = new ArrayList<>();
		
		for (Pedido pedido: lstPedidos) {
			if (pedido.getUnidadVenta().equals(unidadVenta)) {
			
				if ((pedido.getFechaTransaccion().isAfter(inicio) || pedido.getFechaTransaccion().equals(inicio)) && (pedido.getFechaTransaccion().isBefore(fin) ||pedido.getFechaTransaccion().equals(fin))) {
		           
		                totalRentabilidad += (pedido.calcularTotalPedido() - pedido.calcularTotalCosteProduccion());
		  
		                if (!festivales.contains(pedido.getFestival())) {
		                    festivales.add(pedido.getFestival());
		                }
				}
			}
		}
			
			for (Festival festival : festivales) {
		        
		        double canonFestival = unidadVenta.calcularCanon(festival.getCostoFestival());
		        totalRentabilidad -= canonFestival;
		        
		        double sueldosFestival = 0;
		        for (Personal persona : unidadVenta.getLstPersonal()) {
		            sueldosFestival += persona.calcularSueldo(festival.getCostoFestival());
		        }
		        totalRentabilidad -= sueldosFestival;
		    }

		    return totalRentabilidad;
	}
	
	
	
	/// CU #10
	 

	public List<ReporteVenta> generarRankingUnidadesMayorRecaudacion(Festival festival)throws Exception{
		if (traerFestival(festival.getNombreFestival()) == null) throw new Exception ("ERROR. El festival " + festival.getNombreFestival() + " no existe.");
		
		List<ReporteVenta> lstRecaudacionUnidades = generarReporteRecaudacion(festival);
		
		for (int i = 0; i < lstRecaudacionUnidades.size(); i++) {
			for (int j = i + 1; j <lstRecaudacionUnidades.size(); j++) {
				if (lstRecaudacionUnidades.get(j).getRecaudacionTotal() > lstRecaudacionUnidades.get(i).getRecaudacionTotal()) {
					ReporteVenta aux = lstRecaudacionUnidades.get(i);
					lstRecaudacionUnidades.set(i, lstRecaudacionUnidades.get(j));
					lstRecaudacionUnidades.set(j, aux);
					
				}
			}
		}
		return lstRecaudacionUnidades;
		
	}
	
	
	
	/// CU #11
	
	
	public Plato obtenerPlatoEstrella(UnidadVenta unidadVenta, Festival festival) throws Exception{
		
		if (traerFestival(festival.getNombreFestival()) == null) throw new Exception ("ERROR. El festival " + festival.getNombreFestival() + " no existe.");
		
		if (traerUnidadVenta(unidadVenta.getCodigo()) == null) throw new Exception ("ERROR. La unidad " + unidadVenta.getCodigo() + " no existe.");	
		
		Plato platoEstrella = null;
	    int maxCantidadGlobal = -1; 
	    

	    for (Plato plato : unidadVenta.getLstPlatos()) {
	        int acumuladorCantidadPlato = 0;
	        

	        for (Pedido pedido : lstPedidos) {
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

	
	
	public 	List<Personal> traerPersonalPorFestival(Festival festival) throws Exception{
		
		if (traerFestival(festival.getNombreFestival()) == null) throw new Exception ("ERROR. El festival " + festival.getNombreFestival() + " no existe.");
		
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
	
	
	public List<ReporteMayoresCanon> obtenerUnidadesConMayorCanon(Festival festival)throws Exception{
		
		if (traerFestival(festival.getNombreFestival()) == null) throw new Exception ("ERROR. El festival " + festival.getNombreFestival() + " no existe.");
		
		List<ReporteMayoresCanon> lstTodosLosCanones = new ArrayList<>();

	    
	    for (UnidadVenta unidad : lstUnidadVenta) {
	    	
	    	boolean estuvoPresente = false;
	    	int i = 0;
	    	
	       while (i < lstPedidos.size() && estuvoPresente == false) {
	            if (lstPedidos.get(i).getUnidadVenta().equals(unidad) && lstPedidos.get(i).getFestival().equals(festival)) {
	                estuvoPresente = true;
	            }
	            i++;
	        }

	        if (!estuvoPresente) {
	            continue;
	        }
	    	

	    	
	        double canonCalculado = unidad.calcularCanon(festival.getCostoFestival());
	        
	        
	        String tipoUnidad = "Puesto Desarmable";
	        if (unidad instanceof FoodTruck) { 
	            tipoUnidad = "Food Truck";
	        }

	        lstTodosLosCanones.add(new ReporteMayoresCanon(unidad.getNombreComercial(),unidad.getCodigo(), tipoUnidad, canonCalculado));
	        
	    }

	 
	    for (int i = 0; i < lstTodosLosCanones.size(); i++) {
	        for (int j = i + 1; j < lstTodosLosCanones.size(); j++) {
	            if (lstTodosLosCanones.get(j).getCanon() > lstTodosLosCanones.get(i).getCanon()) {
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
}
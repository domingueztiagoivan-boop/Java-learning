package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Excursion> lstExcursiones;
	private List<Cabana> lstCabanas;
	private List<Contratacion> lstContrataciones;
	
	public Sistema() {
		this.lstExcursiones = new ArrayList<Excursion>();
		this.lstCabanas = new ArrayList<Cabana>();
		this.lstContrataciones = new ArrayList<Contratacion>();
	}

	public List<Excursion> getLstExcursiones() {
		return lstExcursiones;
	}
	public void setLstExcursiones(List<Excursion> lstExcursiones) {
		this.lstExcursiones = lstExcursiones;
	}
	public List<Cabana> getLstCabanas() {
		return lstCabanas;
	}
	public void setLstCabanas(List<Cabana> lstCabanas) {
		this.lstCabanas = lstCabanas;
	}
	public List<Contratacion> getLstContrataciones() {
		return lstContrataciones;
	}
	public void setLstContrataciones(List<Contratacion> lstContrataciones) {
		this.lstContrataciones = lstContrataciones;
	}
	
	
	
	public Cabana traerCabana(int numero) {
		Cabana resultado = null;
		int i = 0;
		
		while (i < lstCabanas.size() && resultado == null) {
			if (numero == lstCabanas.get(i).getNumero()) {
				resultado = lstCabanas.get(i);
			}
			i++;
		}
		return resultado;
	}
	
	public boolean agregarCabana(int numero, int capacidad)throws Exception{
		if (traerCabana(numero) != null) throw new Exception("ERROR. La cabana con el numero: " + numero + " ya esta registrado");
		
		int proxId = lstCabanas.isEmpty() ? 1 : lstCabanas.get(lstCabanas.size() - 1).getIdCabana() + 1;
		
		return lstCabanas.add(new Cabana(proxId, numero, capacidad));
	}
	
	public Excursion traerExcursion(int idExcursion) {
		Excursion resultado = null;
		int i = 0;
		
		while (i < lstExcursiones.size() && resultado == null) {
			if (lstExcursiones.get(i).getIdExcursion() == idExcursion) {
				resultado = lstExcursiones.get(i);
			}
			i++;
		}
		return resultado;
	}
	
	public Excursion traerExcursionDescripcion(String descripcion) {
		Excursion resultado = null;
		int i = 0;
		
		while (i < lstExcursiones.size() && resultado == null) {
			if (lstExcursiones.get(i).getDescripcion().equals(descripcion)) {
				resultado = lstExcursiones.get(i);
			}
			i++;
		}
		return resultado;
	}
	
	public boolean agregarExcursionTrekking(String descripcion, int cantDias, float kmRecorrido, int dificultad) throws Exception{
		if (traerExcursionDescripcion(descripcion) != null) throw new Exception ("ERROR. Ya existe un trekking con esta descripcion.");
		
		int proxId = lstExcursiones.isEmpty() ? 1 : lstExcursiones.get(lstExcursiones.size() - 1).getIdExcursion() + 1;
		
		return lstExcursiones.add(new Trekking(proxId, descripcion, cantDias, kmRecorrido, dificultad));
	}
	
	public boolean agregarExcursionNavegacion(String descripcion, int cantDias, boolean tieneAlmuerzo, float costoBaseLancha) throws Exception{
		if (traerExcursionDescripcion(descripcion) != null) throw new Exception ("ERROR. Ya existe un trekking con esta descripcion.");
		
		int proxId = lstExcursiones.isEmpty() ? 1 : lstExcursiones.get(lstExcursiones.size() - 1).getIdExcursion() + 1;
		
		return lstExcursiones.add(new Navegacion(proxId, descripcion, cantDias, tieneAlmuerzo, costoBaseLancha));
	}
	
	
	public Contratacion traerContratacion(LocalDate fecha, Cabana cabana, Excursion excursion) {
		Contratacion resultado = null;
		int i = 0;
		
		while (i < lstContrataciones.size() && resultado == null) {
			if (lstContrataciones.get(i).getFecha().equals(fecha) && lstContrataciones.get(i).getCabana().equals(cabana) && lstContrataciones.get(i).getExcursion().equals(excursion)) {
				resultado = getLstContrataciones().get(i);
			}
			i++;
		}
		return resultado;
	}
	
	public boolean agregarContratacion(LocalDate fecha, Cabana cabana, Excursion excursion, int cantPersonas) throws Exception{
		if (traerContratacion(fecha, cabana, excursion) != null)throw new Exception("ERROR. Ya se encuentra registrada una contratacion identica.");
		
		int proxId = lstContrataciones.isEmpty() ? 1 : lstContrataciones.get(lstContrataciones.size() - 1).getIdContratacion() + 1;
		
		return lstContrataciones.add(new Contratacion(proxId, fecha, cabana, excursion, cantPersonas));
	}
	
	public List<Contratacion> traerContratacionesPorFechaYCostoMaximo(LocalDate fechaDesde, LocalDate fechaHasta, float costoMaximo){
		
		List<Contratacion> resultado = new ArrayList<Contratacion>();
		
		for (Contratacion c: lstContrataciones) {
			if (!c.getFecha().isBefore(fechaDesde) && !c.getFecha().isAfter(fechaHasta)) {
				if (c.getExcursion().costoTotal(c.getCantPersonas()) <= costoMaximo) {
					resultado.add(c);
				}
			}
		}
		return resultado;
	}
	
	public List<Excursion> traerExcursionesPremium(){
		
		List<Excursion> resultado = new ArrayList<Excursion>();
		
		for (Excursion e: lstExcursiones) {
			if (e instanceof Navegacion) {
				Navegacion aux = (Navegacion) e;
				
				if(aux.isTieneAlmuerzo()) {
					resultado.add(e);
				}
			}else if (e instanceof Trekking){
				Trekking aux = (Trekking) e;
				
				if (aux.getDificultad() <= 2) {
					resultado.add(aux);
				}
			}

		}
			return resultado;
	}
	
}

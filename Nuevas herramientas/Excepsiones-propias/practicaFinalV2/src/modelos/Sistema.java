package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	List<Mesa> lstMesas;
	List<Repartidor> lstRepartidores;
	List<Envio> lstEnvios;
	
	
	public Sistema() {
		this.lstMesas = new ArrayList<Mesa>();
		this.lstRepartidores = new ArrayList<Repartidor>();
		this.lstEnvios = new ArrayList<Envio>();
	}


	public List<Mesa> getLstMesas() {
		return lstMesas;
	}
	public void setLstMesas(List<Mesa> lstMesas) {
		this.lstMesas = lstMesas;
	}
	public List<Repartidor> getLstRepartidores() {
		return lstRepartidores;
	}
	public void setLstRepartidores(List<Repartidor> lstRepartidores) {
		this.lstRepartidores = lstRepartidores;
	}
	public List<Envio> getLstEnvios() {
		return lstEnvios;
	}
	public void setLstEnvios(List<Envio> lstEnvios) {
		this.lstEnvios = lstEnvios;
	}
	
	public Mesa traerMesa(int sector, int numero) {
		int i = 0;
		Mesa resultado = null;
		
		while (i<lstMesas.size() && resultado == null) {
			if (lstMesas.get(i).getNumero() == numero && lstMesas.get(i).getSector() == sector) {
				resultado = lstMesas.get(i);
			}
			i++;
		}
		return resultado;
	}
	
	
	public boolean agregarMesa(int sector, int numero) throws ExceptionYaRegistrado {
		if (traerMesa(sector, numero) != null) throw new ExceptionYaRegistrado("Mesa: " + numero + ", Sector: " + sector);
		
		int proxId = lstMesas.isEmpty() ? 1 : lstMesas.get(lstMesas.size() - 1).getId() + 1;
		
		return (lstMesas.add(new Mesa(proxId, sector, numero)));
	}
	
	
	public Repartidor traerRepartidor(String patenteIdentificador) {
		int i = 0;
		Repartidor resultado = null;
		
		while (i<lstRepartidores.size() && resultado == null) {
			if (lstRepartidores.get(i).getPatenteIdentificador().equals(patenteIdentificador)) {
				resultado = lstRepartidores.get(i);
			}
			i++;
		}
		return resultado;
	}
	
	/// LAS EXCEPCIONES ExceptionYaRegistrado y ExceptionRepartidor SON CHECKED PORQUE EXTENDEN DE Exception, Y PORQUE ESPERAMOS ESTOS ERRORES.
	public boolean agregarRepartidorMoto(String patenteIdentificador, int capacidadPedidosMax, float costoFijoSeguro, float precioPorKm) throws ExceptionYaRegistrado{
		if (traerRepartidor(patenteIdentificador) != null) throw new ExceptionYaRegistrado("el repartidor con patente " + patenteIdentificador);
		
		int proxId = lstRepartidores.isEmpty() ? 1 : lstRepartidores.get(lstRepartidores.size() - 1).getId() + 1;
		
		return(lstRepartidores.add(new Moto(proxId, patenteIdentificador, capacidadPedidosMax, costoFijoSeguro, precioPorKm)));
	}
	
	public boolean agregarRepartidorCiclista(String patenteIdentificador, int capacidadPedidosMax, boolean esElectrico, float precioBaseEnvio) throws ExceptionYaRegistrado{
		if (traerRepartidor(patenteIdentificador) != null) throw new ExceptionYaRegistrado("el repartidor con patente " + patenteIdentificador);
		
		int proxId = lstRepartidores.isEmpty() ? 1 : lstRepartidores.get(lstRepartidores.size() - 1).getId() + 1;
		
		return(lstRepartidores.add(new CIclista(proxId, patenteIdentificador, capacidadPedidosMax, esElectrico, precioBaseEnvio)));
	}
	
	public boolean agregarEnvio(LocalDate fecha, Mesa mesa, Repartidor repartidor, int cantPedidosAsignados, float kmRecorridos) throws ExceptionRepartidor{
			
		int proxId = lstEnvios.isEmpty() ? 1 : lstEnvios.get(lstEnvios.size() - 1).getId() + 1;
		
		return lstEnvios.add(new Envio(proxId, fecha, mesa, repartidor, cantPedidosAsignados, kmRecorridos));
		
	}
	
	public List<Envio> traerEnviosPorFechaYCosto(LocalDate fechaDesde, LocalDate fechaHasta, float costoMaximo){
		
		List<Envio> resultado = new ArrayList<Envio>();
		
		for (Envio e: lstEnvios) {
			if (!e.getFecha().isBefore(fechaDesde) && !e.getFecha().isAfter(fechaHasta)) {
				if (e.getRepartidor().costoTotalEnvio(e.getKmRecorridos()) <= costoMaximo) {
					resultado.add(e);
				}
			}
		}
		return resultado;
	}
	
	public List<Repartidor> traerRepartidoresEficientes(){
		
		List<Repartidor> resultado = new ArrayList<Repartidor>();
		
		for (Repartidor r: lstRepartidores) {
			if (r instanceof Moto) {
				Moto m = (Moto) r;
				if (m.getPrecioPorKm() <= 100) {
					resultado.add(r);
				}
			} else if (r instanceof CIclista) {
				CIclista c = (CIclista) r;
				if (c.isEsElectrico()) {
					resultado.add(r);
				}
			}
		}
		return resultado;
	}
}

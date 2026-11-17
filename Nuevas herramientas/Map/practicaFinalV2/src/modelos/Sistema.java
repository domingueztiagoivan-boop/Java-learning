package modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Sistema {
	Map<String, Repartidor> repartidoresMap;
	Map<String, Mesa> mesasMap;
	Map<Integer, Envio> enviosMap;
	int lastIdMesa;
	int lastIdRepartidores;
	int lastIdEnvios;
	
	
	public Sistema() {
		this.repartidoresMap = new HashMap<>();
		this.mesasMap = new HashMap<>();
		this.enviosMap = new HashMap<>();
		this.lastIdMesa = 0;
		this.lastIdRepartidores = 0;
		this.lastIdEnvios = 0;
	}


	public Map<String, Mesa> getMesasMap() {
		return Map.copyOf(mesasMap);
	}
	

	public Map<String, Repartidor> getRepartidoresMap() {
		return Map.copyOf(repartidoresMap);
	}
	

	public Map<Integer, Envio> getEnviosMap() {
		return Map.copyOf(enviosMap);
	}
	
	
	public Mesa traerMesa(int sector, int numero) throws ExceptionSinRegistrar{
		String clave = sector + "-" + numero;
		if (!(mesasMap.containsKey(clave))) throw new ExceptionSinRegistrar("ERROR. La mesa no se encuentra registrada.");
		int i = 0;
		Mesa resultado = mesasMap.get(clave);
		return resultado;
	}
	
	
	public boolean agregarMesa(int sector, int numero) throws ExceptionYaRegistrado, ExceptionSinRegistrar  {
		String clave = sector + "-" + numero;
		if (mesasMap.containsKey(clave)) throw new ExceptionYaRegistrado("ERROR. Mesa ya registrada.");
	
		
		int proxId = lastIdMesa + 1;
		lastIdMesa++;
		
		mesasMap.put(clave, new Mesa(proxId, sector, numero));
		return  true;
	}
	
	
	public Repartidor traerRepartidor(String patenteIdentificador) throws ExceptionSinRegistrar {
		if (!(repartidoresMap.containsKey(patenteIdentificador))) throw new ExceptionSinRegistrar("ERROR. Repatidor " + patenteIdentificador + " no se encuntra registrado.");

		Repartidor resultado = repartidoresMap.get(patenteIdentificador);
		
		return resultado;
	}
	

	public boolean agregarRepartidorMoto(String patenteIdentificador, int capacidadPedidosMax, BigDecimal costoFijoSeguro, BigDecimal precioPorKm) throws ExceptionYaRegistrado, ExceptionRepartidorMenorCero, ExceptionSinRegistrar {
		if (repartidoresMap.containsKey(patenteIdentificador)) throw new ExceptionYaRegistrado("ERROR. El repartidor con patente " + patenteIdentificador + " ya esta registrado.");
		
		int proxId = lastIdRepartidores + 1;
		lastIdRepartidores++;
		
		repartidoresMap.put(patenteIdentificador, new Moto(proxId, patenteIdentificador, capacidadPedidosMax, costoFijoSeguro, precioPorKm));
		return true;
	}
	
	public boolean agregarRepartidorCiclista(String patenteIdentificador, int capacidadPedidosMax, boolean esElectrico, BigDecimal precioBaseEnvio) throws ExceptionYaRegistrado, ExceptionRepartidorMenorCero,ExceptionSinRegistrar{
		if (repartidoresMap.containsKey(patenteIdentificador)) throw new ExceptionYaRegistrado("ERROR. El repartidor con patente " + patenteIdentificador + " ya esta registrado.");
		
		int proxId = lastIdRepartidores + 1;
		lastIdRepartidores++;

		repartidoresMap.put(patenteIdentificador, new CIclista(proxId, patenteIdentificador, capacidadPedidosMax, esElectrico, precioBaseEnvio));
		return true;
	}
	
	public boolean agregarEnvio(LocalDate fecha, Mesa mesa, Repartidor repartidor, int cantPedidosAsignados, BigDecimal kmRecorridos) throws ExceptionSinRegistrar, ExceptionRepartidor{
		if(!(repartidoresMap.containsKey(repartidor.getPatenteIdentificador()))) throw new ExceptionSinRegistrar ("ERROR. EL repartidor no esta registrado.");
		String clave = mesa.getSector() + "-" + mesa.getNumero();
		if (!(mesasMap.containsKey(clave)))throw new ExceptionSinRegistrar("ERROR. La mesa no se encunetra registrada.");
		
		int proxId = lastIdEnvios + 1;
		lastIdEnvios++;
		
		enviosMap.put(proxId, new Envio(proxId, fecha, mesa, repartidor, cantPedidosAsignados, kmRecorridos));
		return true;
	}
	
	public List<Envio> traerEnviosPorFechaYCosto(LocalDate fechaDesde, LocalDate fechaHasta, BigDecimal costoMaximo){
		
		List<Envio> resultado = new ArrayList<Envio>();
		
		for (Envio e: enviosMap.values()) {
			if (!e.getFecha().isBefore(fechaDesde) && !e.getFecha().isAfter(fechaHasta)) {
				if (e.getRepartidor().costoTotalEnvio(e.getKmRecorridos()).compareTo(costoMaximo) <= 0) {
					resultado.add(e);
				}
			}
		}
		return resultado;
	}
	

	public List<Envio> traerEnviosPorRepartidor(String patenteIdentificador)throws NullPointerException, ExceptionSinRegistrar{
		
		if (traerRepartidor(patenteIdentificador) == null) throw new NullPointerException();
		
		List<Envio> resultado = new ArrayList<Envio>();
		
		for (Envio e: enviosMap.values()) {
			if (e.getRepartidor().getPatenteIdentificador().equals(patenteIdentificador)) {
				resultado.add(e);
			}
		}
		return resultado;
	}

	public List<Repartidor> traerRepartidoresEficientes(){
		
		List<Repartidor> resultado = new ArrayList<Repartidor>();
		
		for (Repartidor r: repartidoresMap.values()) {
			if (r instanceof Moto) {
				Moto m = (Moto) r;
				if (m.getPrecioPorKm().compareTo(new BigDecimal("100")) <= 0) {
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

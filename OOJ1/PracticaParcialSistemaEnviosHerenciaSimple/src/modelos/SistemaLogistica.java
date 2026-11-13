package modelos;

import java.util.ArrayList;
import java.util.List;

public class SistemaLogistica {
		private List<Cliente> lstClientes;
		private List<Camion> lstCamiones;
		private List<Envio> lstEnvios;
		
		
		
		public SistemaLogistica() {
			this.lstClientes = new ArrayList<Cliente>();
			this.lstCamiones = new ArrayList<Camion>();
			this.lstEnvios = new ArrayList<Envio>();
		}



		public List<Cliente> getLstClientes() {
			return lstClientes;
		}
		public void setLstClientes(List<Cliente> lstClientes) {
			this.lstClientes = lstClientes;
		}
		public List<Camion> getLstCamiones() {
			return lstCamiones;
		}
		public void setLstCamiones(List<Camion> lstCamiones) {
			this.lstCamiones = lstCamiones;
		}
		public List<Envio> getLstEnvios() {
			return lstEnvios;
		}
		public void setLstEnvios(List<Envio> lstEnvios) {
			this.lstEnvios = lstEnvios;
		}
		
		
		public Cliente traerCliente(long cuit) {
			
			Cliente resultado = null;
			int i = 0;
			
			while (i < lstClientes.size() && resultado == null) {
				if(lstClientes.get(i).getCuit() == cuit) {
					resultado = lstClientes.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		
		public boolean agregarCliente(String nombre, long cuit)throws Exception{
			if(traerCliente(cuit) != null) throw new Exception("Error. Cuit: "+ cuit + " se encuentra registrado.");
			
			int proxId = 1;
			
			if (!lstClientes.isEmpty()) {
				proxId = lstClientes.get(lstClientes.size() - 1).getIdClietnte() + 1;
			}
			
			return lstClientes.add(new Cliente(proxId, nombre, cuit));
		}
		
		public Camion traerCamion(String patente) {
			
			Camion resultado = null;
			int i = 0;
			
			while (i < lstCamiones.size() && resultado == null) {
				if(lstCamiones.get(i).getPatente().equals(patente)) {
					resultado = lstCamiones.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		
		public boolean agregarCamion(String patente, double capacidadCargaKg)throws Exception{
			if(traerCamion(patente) != null) throw new Exception("Error. Patente: "+ patente + " se encuentra registrado.");
			
			int proxId = 1;
			
			if (!lstCamiones.isEmpty()) {
				proxId = lstCamiones.get(lstCamiones.size() - 1).getIdCamion() + 1;
			}
			
			return lstCamiones.add(new Camion(proxId, patente, capacidadCargaKg));
		}
		
		public Envio traerEnvio(Cliente cliente, double pesoPaqueteKg) {
			
			Envio resultado = null;
			int i = 0;
			
			while (i < lstEnvios.size() && resultado == null) {
				if(lstEnvios.get(i).getCliente().equals(cliente) && lstEnvios.get(i).getPesoPaqueteKg() == pesoPaqueteKg) {
					resultado = lstEnvios.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		
		public boolean agregarEnvioNacional(Cliente cliente, Camion camion, double pesoPaqueteKg, int distanciaKm, String provinciaDestino)throws Exception{
			if(traerEnvio(cliente, pesoPaqueteKg) != null) throw new Exception("Error. Cliente "+ cliente.getNombre() + " con el paquete de: " + pesoPaqueteKg + " se encuentra registrado.");
			
			int proxId = 1;
			
			if (!lstEnvios.isEmpty()) {
				proxId = lstEnvios.get(lstEnvios.size() - 1).getIdEnvio() + 1;
			}
			
			return lstEnvios.add(new EnvioNacional(proxId, cliente, camion, pesoPaqueteKg, distanciaKm, provinciaDestino));
		}
		
		public boolean agregarEnvioInternacional(Cliente cliente, Camion camion, double pesoPaqueteKg, int distanciaKm, String paisDestino, boolean pagaAduana)throws Exception{
			if(traerEnvio(cliente, pesoPaqueteKg) != null) throw new Exception("Error. Cliente "+ cliente.getNombre() + " con el paquete de: " + pesoPaqueteKg + " se encuentra registrado.");
			
			int proxId = 1;
			
			if (!lstEnvios.isEmpty()) {
				proxId = lstEnvios.get(lstEnvios.size() - 1).getIdEnvio() + 1;
			}
			
			return lstEnvios.add(new EnvioInternacional(proxId, cliente, camion, pesoPaqueteKg, distanciaKm, paisDestino, pagaAduana));
		}
		
		
		public List<EnvioInternacional> traerEnviosInternacionalesEspeciales() {
			
			List<EnvioInternacional> nuevaLista = new ArrayList<EnvioInternacional>();
			
			for (Envio envio: lstEnvios) {
				if (envio instanceof EnvioInternacional) {
					EnvioInternacional e = (EnvioInternacional) envio;
					if (e.getPagaAduana() && e.getDistanciaKm() > 500) {
					nuevaLista.add(e);
					}
				}
			}
			
			return nuevaLista;
		}
		
		public double calcularCargaActualDeCamion(String patente) {
			
			double total = 0;
			
			for (Envio e: lstEnvios) {
				if (e.getCamion().getPatente().equals(patente)) {
					total += e.getPesoPaqueteKg();
				}
			}
			
			return total;
		}
		
}

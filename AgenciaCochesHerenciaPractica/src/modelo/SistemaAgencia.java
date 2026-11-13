package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaAgencia {
		private List<Cliente> lstClientes;
		private List<Vehiculo> lstVehiculos;
		private List<Reserva> lstReservas;
		
		
		
		
		
		public SistemaAgencia() {
			this.lstClientes = new ArrayList<Cliente>();
			this.lstVehiculos = new ArrayList<Vehiculo>();
			this.lstReservas = new ArrayList<Reserva>();
		}





		public List<Cliente> getLstClientes() {
			return lstClientes;
		}
		public void setLstClientes(List<Cliente> lstClientes) {
			this.lstClientes = lstClientes;
		}
		public List<Vehiculo> getLstVehiculos() {
			return lstVehiculos;
		}
		public void setLstVehiculos(List<Vehiculo> lstVehiculos) {
			this.lstVehiculos = lstVehiculos;
		}
		public List<Reserva> getLstReservas() {
			return lstReservas;
		}
		public void setLstReservas(List<Reserva> lstReservas) {
			this.lstReservas = lstReservas;
		}
		
		
		public Cliente traerCliente(long dni) {
			
			Cliente resultado = null;
			int  i = 0;
			
			while (resultado == null && i<lstClientes.size()) {
				if (lstClientes.get(i).getDni() == dni) {
					resultado = lstClientes.get(i);
				}
				i++;
			}
			
			return resultado;
		}
		
		
		public boolean agregarCliente(String nombre, String apellido, long dni, String telefono)throws Exception {
			if (traerCliente(dni) != null) throw new Exception("Error. El dni " + dni + " ya esta registrado.");
			
			int proxId = 1;
			
			if (!lstClientes.isEmpty()) {
				proxId = lstClientes.get(lstClientes.size() - 1).getIdCliente() + 1;
			}
			
			
			return lstClientes.add(new Cliente(nombre, apellido, dni, telefono, proxId));
		}
		
		
		public Vehiculo traerVehiculo(String patente) {
			
			int i = 0;
			Vehiculo resultado = null;
			
			while (resultado == null && i<lstVehiculos.size()) {
				if (lstVehiculos.get(i).getPatente().equals(patente)) {
					resultado = lstVehiculos.get(i);
				}
				i++;
			}
			
			return resultado;
		}
		
		
		public boolean agregarCamioneta(String patente, int capacidadPasajeros, int cargaMaxKg) throws Exception {
			if (traerVehiculo(patente) != null) throw new Exception("Error. Patente " + patente + " ya esta registrada.");
			
			int proxId = 1;
			
			if (!lstVehiculos.isEmpty()) {
				proxId = lstVehiculos.get(lstVehiculos.size() - 1).getIdVehiculo() + 1;
			}
			
			return lstVehiculos.add(new Camioneta(patente, capacidadPasajeros, proxId, cargaMaxKg));
		}
		
		
		public boolean agregarAuto(String patente, int capacidadPasajeros, boolean esHibrido)throws Exception {
			if (traerVehiculo(patente) != null) throw new Exception("Error. Patente " + patente + " ya esta registrada.");
			
			int proxId = 1;
			
			if (!lstVehiculos.isEmpty()) {
				proxId = lstVehiculos.get(lstVehiculos.size() - 1).getIdVehiculo() + 1;
			}
			
			return lstVehiculos.add(new Auto(patente, capacidadPasajeros, proxId, esHibrido));
		}
		
		
		public Reserva traerReserva(String patente, LocalDate fechaReserva) {	
			
			Reserva resultado = null;
			int i = 0;
			
			while (resultado == null && i<lstReservas.size()) {
				if (lstReservas.get(i).getVehiculo().getPatente().equals(patente) && lstReservas.get(i).getFechaReserva().equals(fechaReserva)) {
					resultado = lstReservas.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		
		public boolean agregarReserva(Cliente cliente, LocalDate fechaReserva, Vehiculo vehiculo, int cantPasajeros)throws Exception {
			if (traerReserva(vehiculo.getPatente(), fechaReserva) != null) throw new Exception ("Error. ya se encuentra la patente: " + vehiculo.getPatente() + " reservado para la fehca: " + fechaReserva + ".");
			
			int proxId = 1;
			
			if (!lstReservas.isEmpty()) {
				proxId = lstReservas.get(lstReservas.size() - 1).getIdReserva() + 1;
			}
			
			return lstReservas.add(new Reserva(cliente, fechaReserva, vehiculo, cantPasajeros, proxId));
		}
		
		
		public List<Vehiculo> traerVehiculosLibresPorFecha(LocalDate fecha){
			
			List<Vehiculo> nuevaLista = new ArrayList<Vehiculo>();
			
			for (Vehiculo v: lstVehiculos) {
				if (traerReserva(v.getPatente(), fecha) == null) {
					nuevaLista.add(v);
				}
			}
			return nuevaLista;
		}
}

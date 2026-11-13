package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaAlquiler {
		private List<Cancha> lstCanchas;
		private List<Cliente> lstClientes;
		private List<Reserva> lstReservas;
		
		
		
		
		public SistemaAlquiler() {
			this.lstCanchas = new ArrayList<Cancha>();
			this.lstClientes = new ArrayList<Cliente>();
			this.lstReservas = new ArrayList<Reserva>();
		}




		public List<Cancha> getLstCanchas() {
			return lstCanchas;
		}




		public void setLstCanchas(List<Cancha> lstCanchas) {
			this.lstCanchas = lstCanchas;
		}




		public List<Cliente> getLstClientes() {
			return lstClientes;
		}




		public void setLstClientes(List<Cliente> lstClientes) {
			this.lstClientes = lstClientes;
		}




		public List<Reserva> getLstReservas() {
			return lstReservas;
		}




		public void setLstReservas(List<Reserva> lstReservas) {
			this.lstReservas = lstReservas;
		}
		
		
		
		public Cliente traerCliente(int dni) {
			
			Cliente resultado = null;
			int i = 0;
			
			while (resultado == null && i < lstClientes.size()) {
				if (lstClientes.get(i).getDni() == dni) {
					resultado = lstClientes.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		
		public boolean agregarCliente(String nombre, String apellido, String numero, int dni)throws Exception {

				if (traerCliente(dni) != null) throw new Exception("Error. Ya esta registrado un cliente con este dni: " + dni);
			
			
			Cliente nuevo = new Cliente(nombre, apellido, numero, dni);
			int proxId = 1;
			
			if (!lstClientes.isEmpty()) {
				proxId = lstClientes.get(lstClientes.size() -1).getIdCliente() + 1;
			}
			
			nuevo.setIdCliente(proxId);
			return lstClientes.add(nuevo);
		}
		
		
		public Cancha traerCancha(int numeroCancha) {
			
			Cancha resultado = null;
			int i = 0;
			
			while (i < lstCanchas.size() && resultado == null) {
				Cancha temporal = lstCanchas.get(i);
				if (temporal.getNumeroCancha() == numeroCancha) {
					resultado = lstCanchas.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		
		
		public boolean agregarCancha(int capacidad, int numeroCancha)throws Exception{
			
				if(traerCancha(numeroCancha) != null)throw new Exception("Error. Ya esta registrada una cancha con el numero: " + numeroCancha);
			
			
			Cancha nueva = new Cancha(capacidad, numeroCancha);
			int proxId = 1;
			
			if (!lstCanchas.isEmpty()) {
				proxId = lstCanchas.get(lstCanchas.size() -1).getIdCancha() + 1;
			}
			
			nueva.setIdCancha(proxId);
			return lstCanchas.add(nueva);
		}
		
		
		public Reserva traerReserva(int numeroCancha, LocalDate fecha) {
			
			Reserva resultado = null;
			int i = 0;
			
			while (resultado == null && i < lstReservas.size()) {
				if (lstReservas.get(i).getCancha().getNumeroCancha() == numeroCancha && lstReservas.get(i).getFecha().equals(fecha)) {
					resultado = lstReservas.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		
		public boolean agregarReserva(Cliente cliente, Cancha cancha, LocalDate fecha, int cantJugadores)throws Exception {
			
				if (traerReserva(cancha.getNumeroCancha(), fecha) != null) throw new Exception("Error. Ya hay una reserva para la fecha: " + fecha);
			
			
			Reserva nueva = new Reserva(cliente, cancha, fecha, cantJugadores);
			int proxId = 1;
			
			if (!lstReservas.isEmpty()) {
				proxId = lstReservas.get(lstReservas.size() - 1).getIdReserva() + 1;
			}
			
			nueva.setIdReserva(proxId);
			return lstReservas.add(nueva);
		}
		
		
		
		public List<Reserva> traerReservasPorFecha(LocalDate desde, LocalDate hasta){
			
			List<Reserva> nuevaLista = new ArrayList<Reserva>();
			
			for (Reserva r: lstReservas) {
				if (!r.getFecha().isBefore(desde) && !r.getFecha().isAfter(hasta)) {
					nuevaLista.add(r);
				}
			}
			return nuevaLista;
		}
		
		
		public List<Cancha> traerCanchasLibresPorFecha(LocalDate fecha){
			
			List<Cancha> nuevaLista = new ArrayList<Cancha>();
			
			for (Cancha c: lstCanchas) {
				if (traerReserva(c.getNumeroCancha(), fecha) == null) {
					nuevaLista.add(c);
				}
			}
			return nuevaLista;
		}

}

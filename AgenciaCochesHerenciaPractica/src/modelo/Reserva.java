package modelo;

import java.time.LocalDate;

public class Reserva {
		private int idReserva;
		private Cliente cliente;
		private LocalDate fechaReserva;
		private Vehiculo vehiculo;
		private int cantPasajeros;
		
		
		
		public Reserva(Cliente cliente, LocalDate fechaReserva, Vehiculo vehiculo, int cantPasajeros, int idReserva)throws Exception {
			this.cliente = cliente;
			this.fechaReserva = fechaReserva;
			this.vehiculo = vehiculo;
			setCantPasajeros(cantPasajeros);
			this.idReserva = idReserva;
		}



		public int getIdReserva() {
			return idReserva;
		}
		public void setIdReserva(int idReserva) {
			this.idReserva = idReserva;
		}
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		public LocalDate getFechaReserva() {
			return fechaReserva;
		}
		public void setFechaReserva(LocalDate fechaReserva) {
			this.fechaReserva = fechaReserva;
		}
		public Vehiculo getVehiculo() {
			return vehiculo;
		}
		public void setVehiculo(Vehiculo vehiculo) {
			this.vehiculo = vehiculo;
		}
		public int getCantPasajeros() {
			return cantPasajeros;
		}
		public void setCantPasajeros(int cantPasajeros)throws Exception {
			if (cantPasajeros > vehiculo.getCapacidadPasajeros()) throw new Exception ("Error. Capacidad de vehiculo " + vehiculo.getCapacidadPasajeros() + " Menor a cantidad pasajeros "+ cantPasajeros + ".");
			
			this.cantPasajeros = cantPasajeros;
		}
		
		
		
		@Override
		public String toString() {
			return "[ID: " + this.idReserva + " Cliente: " + this.cliente + "Fecha: " + this.fechaReserva + " Vehiculo: " + this.vehiculo + "Pasajeros: " + this.cantPasajeros + "]";
		}
		
		public boolean equals(Reserva reserva) {
			return (reserva.getIdReserva() == this.idReserva);
		}
		
		
		
		
		
		
}

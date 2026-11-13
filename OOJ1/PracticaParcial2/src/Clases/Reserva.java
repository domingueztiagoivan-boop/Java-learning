package Clases;

import java.time.LocalDate;

public class Reserva {
		private int idReserva;
		private Cliente cliente;
		private Cancha cancha;
		private LocalDate fecha;
		private int cantJugadores;
		
		
		
		public Reserva(Cliente cliente, Cancha cancha, LocalDate fecha, int cantJugadores)throws Exception {
			this.cliente = cliente;
			this.cancha = cancha;
			this.fecha = fecha;
			this.setCantJugadores(cantJugadores);
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



		public Cancha getCancha() {
			return cancha;
		}



		public void setCancha(Cancha cancha) {
			this.cancha = cancha;
		}



		public LocalDate getFecha() {
			return fecha;
		}



		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}



		public int getCantJugadores() {
			return cantJugadores;
		}



		public void setCantJugadores(int cantJugadores)throws Exception {
			if (this.cancha.getCapacidad() < cantJugadores) throw new Exception ("Error. La cantidad de jugadores (" + cantJugadores + ") supera la capacidad de la cancha (" + this.cancha.getCapacidad() + ").");
			
			this.cantJugadores = cantJugadores;
		}
		
		@Override
		public String toString() {
			return "[Cliente: " + this.cliente + " Cancha: " + this.cancha + " Cant Jugadores: " + this.cantJugadores + " Fecha: " + this.fecha + " IdReserva: " + this.idReserva + "]";
		}
		
		public boolean equalsReserva(Reserva reserva){
			return (this.idReserva == reserva.idReserva);
		}
		
		
}

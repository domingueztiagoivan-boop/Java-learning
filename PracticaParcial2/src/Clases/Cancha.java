package Clases;

public class Cancha {
		private int idCancha;
		private int capacidad;
		private int numeroCancha;
		
		
		public Cancha(int capacidad, int numeroCancha) {
			this.capacidad = capacidad;
			this.numeroCancha = numeroCancha;
		}


		public int getIdCancha() {
			return idCancha;
		}


		public void setIdCancha(int idCancha) {
			this.idCancha = idCancha;
		}


		public int getCapacidad() {
			return capacidad;
		}


		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}


		public int getNumeroCancha() {
			return numeroCancha;
		}


		public void setNumeroCancha(int numeroCancha) {
			this.numeroCancha = numeroCancha;
		}
		
	
		
		
		@Override
		
		public String toString(){
			return "[IdCancha: " + this.idCancha + " Capacidad: " + this.capacidad + " numeroCancha: " + this.numeroCancha + "]";
		}
		
		public boolean equalsCancha(Cancha cancha) {
			return (this.idCancha == cancha.getIdCancha());
		}
}

package modelo;

public abstract class Vehiculo {
		protected int idVehiculo;
		protected String patente;
		protected int capacidadPasajeros;
		
		
		public Vehiculo(String patente, int capacidadPasajeros, int idVehiculo) {
			this.patente = patente;
			this.capacidadPasajeros = capacidadPasajeros;
			this.idVehiculo = idVehiculo;
		}
		
	
		
		public int getIdVehiculo() {
			return idVehiculo;
		}
		public void setIdVehiculo(int idVehiculo) {
			this.idVehiculo = idVehiculo;
		}
		public String getPatente() {
			return patente;
		}
		public void setPatente(String patente) {
			this.patente = patente;
		}
		public void setCapacidadPasajeros(int capacidadPasajeros) {
			this.capacidadPasajeros = capacidadPasajeros;
		}
		public int getCapacidadPasajeros() {
			return capacidadPasajeros;
		}
		
		
		public abstract String hablar();

		
		
		@Override
		public String toString() {
			return "[ID: " + this.idVehiculo + " Patente: " + this.patente + " Capacidad: " + this.capacidadPasajeros + "]";
		}
		
		public boolean equals(Vehiculo vehiculo) {
			return (vehiculo.getPatente() == this.patente);
		}
		
		
}

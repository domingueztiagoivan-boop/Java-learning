package modelos;

public abstract class Envio {
		protected int idEnvio;
		protected Cliente cliente;
		protected Camion camion;
		protected double pesoPaqueteKg;
		protected int distanciaKm;
		
		
		
		
		public Envio(int idEnvio, Cliente cliente, Camion camion, double pesoPaqueteKg, int distanciaKm) throws Exception{
			this.idEnvio = idEnvio;
			this.cliente = cliente;
			this.camion = camion;
			setPesoPaqueteKg(pesoPaqueteKg);
			this.distanciaKm = distanciaKm;
		}




		public int getIdEnvio() {
			return idEnvio;
		}
		public void setIdEnvio(int idEnvio) {
			this.idEnvio = idEnvio;
		}
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		public Camion getCamion() {
			return camion;
		}
		public void setCamion(Camion camion) {
			this.camion = camion;
		}
		public double getPesoPaqueteKg() {
			return pesoPaqueteKg;
		}
		public void setPesoPaqueteKg(double pesoPaqueteKg) throws Exception{
			if(camion.getCapacidadCargaKg() < pesoPaqueteKg) throw new Exception("Error. El peso del paquete supera la capacidad de carga del camión.");
			this.pesoPaqueteKg = pesoPaqueteKg;
		}
		public int getDistanciaKm() {
			return distanciaKm;
		}
		public void setDistanciaKm(int distanciaKm) {
			this.distanciaKm = distanciaKm;
		}
		
		
		@Override
		public String toString() {
			return "Envio: [Id: " + this.idEnvio + " Cliente: " + this.cliente + " Camion: " + this.camion + " PesoPaquete: " + this.pesoPaqueteKg + " Distancia: " + this.distanciaKm + "]";
		}
		
		public boolean equals(Envio envio) {
			return (envio.getIdEnvio() == this.idEnvio);
		}

}

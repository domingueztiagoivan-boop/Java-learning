package modelos;

public class EnvioNacional extends Envio {
		private String provinciaDestino;
		
		
		public EnvioNacional(int idEnvio, Cliente cliente, Camion camion, double pesoPaqueteKg, int distanciaKm, String provinciaDestino)throws Exception {
			super(idEnvio, cliente, camion, pesoPaqueteKg, distanciaKm);
			this.provinciaDestino = provinciaDestino;
		}
		
		public void setProvinciaDestino(String provinciaDestino) {
			this.provinciaDestino = provinciaDestino;
		}
		
		public String getProvinciaDestino() {
			return this.provinciaDestino;
		}
		
		@Override
		public String toString() {
			return super.toString() + " [Provincia destino: " + this.provinciaDestino + "]";
		}
		
	}

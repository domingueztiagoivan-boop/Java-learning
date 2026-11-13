package modelo;

public class Pelicula extends Contenido {
		private boolean esEstreno;
		
		
		
		
		
		public Pelicula(int idContenido, String titulo, int duracionMinutos, double precioBase, boolean esEstreno) {
			super(idContenido, titulo, duracionMinutos, precioBase);
			this.esEstreno = esEstreno;
		}





		public boolean getEsEstreno() {
			return esEstreno;
		}
		public void setEsEstreno(boolean esEstreno) {
			this.esEstreno = esEstreno;
		}
		
		
		
		@Override
		public String toString() {
			return super.toString() + " Estreno: " + this.esEstreno + "]";
		}
		
		public boolean equals(Pelicula pelicula) {
			return (pelicula.getIdContenido() == this.idContenido);
		}
		
		@Override
		public String hablar() {
			return "Soy pelicula";
		}
		
		
		@Override
		public double calcularCostoFinal() {
			
			double costoFinal = this.precioBase;
			
			if (this.esEstreno) {
				costoFinal += (this.precioBase*0.20);
			}
			return costoFinal;
		};
}

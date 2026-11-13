package modelo;

public class Serie extends Contenido{
		private int cantidadEpisodios;
		
		
		public Serie(int idContenido, String titulo, int duracionMinutos, double precioBase, int cantidadEpisodios) {
			super(idContenido, titulo, duracionMinutos, precioBase);
			this.cantidadEpisodios = cantidadEpisodios;
		}


		
		
		public int getCantidadEpisodios() {
			return cantidadEpisodios;
		}
		public void setCantidadEpisodios(int cantidadEpisodios) {
			this.cantidadEpisodios = cantidadEpisodios;
		}
		
		
		
		@Override
		public String toString() {
			return super.toString() + " Episodios: " + this.cantidadEpisodios + "]";
		}
		
		public boolean equals(Serie serie) {
			return (serie.getIdContenido() == this.idContenido);
		}
		
		@Override
		public String hablar() {
			return "Soy serie";
		}
		
		@Override
		public  double calcularCostoFinal() {
			return this.getPrecioBase() + (this.cantidadEpisodios * 10);
		}
		
}

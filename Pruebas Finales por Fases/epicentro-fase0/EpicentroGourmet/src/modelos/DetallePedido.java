package modelos;

public class DetallePedido {
		private int idDetallePedido;
		private Plato plato;
		private int cantidad;
		
		
		
		public DetallePedido(int idDetallePedido, Plato plato, int cantidad) {
			this.idDetallePedido = idDetallePedido;
			this.plato = plato;
			this.cantidad = cantidad;
		}



		public int getIdDetallePedido() {
			return idDetallePedido;
		}
		public void setIdDetallePedido(int idDetallePedido) {
			this.idDetallePedido = idDetallePedido;
		}
		public Plato getPlato() {
			return plato;
		}
		public void setPlato(Plato plato) {
			this.plato = plato;
		}
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		
		public boolean equals(DetallePedido detallePedido) {
			return (detallePedido.getPlato().equals(this.plato) && detallePedido.getCantidad() == this.cantidad);
		}



		@Override
		public String toString() {
			return "DetallePedido [idDetallePedido=" + idDetallePedido + ", plato=" + plato + ", cantidad=" + cantidad + "]";
		}
		
		
		public double calcularTotalDetallePedido() {
			return (this.cantidad * plato.getPrecioVenta());
		}
		
		public double calcularCosteProduccion() {
			return (this.cantidad * plato.getCostoProduccion());
		}
		
		
}

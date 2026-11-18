package modelos;

import java.math.BigDecimal;


public class DetallePedido {
		private final int idDetallePedido;
		private final Plato plato;
		private final int cantidad;
		
		
		
		public DetallePedido(int idDetallePedido, Plato plato, int cantidad) {
			this.idDetallePedido = idDetallePedido;
			this.plato = plato;
			this.cantidad = cantidad;
		}



		public int getIdDetallePedido() {
			return idDetallePedido;
		}
		
		public Plato getPlato() {
			return plato;
		}
		
		public int getCantidad() {
			return cantidad;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (!(obj instanceof DetallePedido)) return false;
			DetallePedido d = (DetallePedido) obj;
			return (this.idDetallePedido == d.getIdDetallePedido());
		}



		@Override
		public int hashCode(){
			return Integer.hashCode(idDetallePedido);
		}


		@Override
		public String toString() {
			return "DetallePedido [idDetallePedido=" + idDetallePedido + ", plato=" + plato + ", cantidad=" + cantidad + "]";
		}
		
		
		public BigDecimal calcularTotalDetallePedido() {
			BigDecimal total = plato.getPrecioVenta().multiply(BigDecimal.valueOf(cantidad));
			return total;
		}
		
		public BigDecimal calcularCosteProduccion() {
			BigDecimal total = plato.getCostoProduccion().multiply(BigDecimal.valueOf(cantidad));
			return total;
		}
		
		
}

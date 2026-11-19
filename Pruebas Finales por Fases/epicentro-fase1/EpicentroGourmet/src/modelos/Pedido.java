package modelos;

import java.math.BigDecimal;
import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.List;



public class Pedido {
		private final int idPedido;
		private final LocalDate fechaTransaccion;
		private final Festival festival;
		private final UnidadVenta unidadVenta;
		private final List<DetallePedido> lstDetallePedido; 
		
		
		public Pedido(int idPedido, LocalDate fechaTransaccion, Festival festival, UnidadVenta unidadVenta) {
			this.idPedido = idPedido;
			this.fechaTransaccion = fechaTransaccion;
			this.festival = festival;
			this.unidadVenta = unidadVenta;
			this.lstDetallePedido = new ArrayList<DetallePedido>();
		}


		public int getIdPedido() {
			return idPedido;
		}


		public LocalDate getFechaTransaccion() {
			return fechaTransaccion;
		}
		
		public Festival getFestival() {
			return festival;
		}
		
		public UnidadVenta getUnidadVenta() {
			return unidadVenta;
		}
		
		public List<DetallePedido> getLstDetallePedido() {
			return lstDetallePedido;
		}
	
		


		public DetallePedido traerDetallePedido(Plato plato) {
			
			DetallePedido resultado = null;
			int i = 0;
			
			while (i < lstDetallePedido.size() && resultado == null) {
				if (lstDetallePedido.get(i).getPlato().equals(plato)) {
					resultado = lstDetallePedido.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		public boolean agregarDetallePedido(Plato plato, int cantidad)throws ExceptionDetallePedidoPlatoYaInlcuido {
			if (traerDetallePedido(plato) != null) throw new ExceptionDetallePedidoPlatoYaInlcuido("ERROR. Este plato ya está incluido en el pedido. Modifique su cantidad.");
				
			int proxId = (!lstDetallePedido.isEmpty()) ? lstDetallePedido.get(lstDetallePedido.size() - 1).getIdDetallePedido() + 1 : 1;
			
			return lstDetallePedido.add(new DetallePedido(proxId, plato, cantidad));
		}
		
		

		@Override
		public boolean equals(Object obj){
			if (this == obj) return true;
			if (!(obj instanceof Pedido)) return false;
			Pedido p = (Pedido) obj;
			return (this.idPedido == p.getIdPedido());
		}


		@Override
		public int hashCode(){
			return Integer.hashCode(idPedido);
		}


		
		@Override
		public String toString() {
			return "Pedido [idPedido=" + idPedido + ", fechaTransaccion=" + fechaTransaccion + ", festival=" + festival + ", unidadVenta=" + unidadVenta + ", lstDetallePedido=" + lstDetallePedido + "]";
		}
		
		
		public BigDecimal calcularTotalPedido() {
			
			BigDecimal total = BigDecimal.ZERO;
			
			for (DetallePedido pedido: lstDetallePedido) {
				total = total.add(pedido.calcularTotalDetallePedido());
			}

			return total;
		}
		
		public BigDecimal calcularTotalCosteProduccion() {
			
			BigDecimal total = BigDecimal.ZERO;
			
			for (DetallePedido pedido: lstDetallePedido) {
				total = total.add(pedido.calcularCosteProduccion());
			}

			return total;
		}
		
		
		
		public int totalCantidadPlatoPedido(Plato plato) {
			
			int total = 0;
			
			for (DetallePedido pedido: lstDetallePedido) {
				if (pedido.getPlato().equals(plato)) {
					total++;
				}
			}
			return total;
		}
		
}

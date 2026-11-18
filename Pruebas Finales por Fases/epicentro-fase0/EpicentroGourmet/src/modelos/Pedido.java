package modelos;

import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.List;



public class Pedido {
		private int idPedido;
		private LocalDate fechaTransaccion;
		private Festival festival;
		private UnidadVenta unidadVenta;
		private List<DetallePedido> lstDetallePedido; 
		
		
		public Pedido(int idPedido, LocalDate fechaTransaccion, Festival festival, UnidadVenta unidadVenta) {
			super();
			this.idPedido = idPedido;
			this.fechaTransaccion = fechaTransaccion;
			this.festival = festival;
			this.unidadVenta = unidadVenta;
			this.lstDetallePedido = new ArrayList<DetallePedido>();
		}


		public int getIdPedido() {
			return idPedido;
		}


		public void setIdPedido(int idPedido) {
			this.idPedido = idPedido;
		}


		public LocalDate getFechaTransaccion() {
			return fechaTransaccion;
		}
		public void setFechaTransaccion(LocalDate fechaTransaccion) {
			this.fechaTransaccion = fechaTransaccion;
		}
		public Festival getFestival() {
			return festival;
		}
		public void setFestival(Festival festival) {
			this.festival = festival;
		}
		public UnidadVenta getUnidadVenta() {
			return unidadVenta;
		}
		public void setUnidadVenta(UnidadVenta unidadVenta) {
			this.unidadVenta = unidadVenta;
		}
		public List<DetallePedido> getLstDetallePedido() {
			return lstDetallePedido;
		}
		public void setLstDetallePedido(List<DetallePedido> lstDetallePedido) {
			this.lstDetallePedido = lstDetallePedido;
		}
			
		
		public boolean equals(Pedido pedido) {
			return (pedido.getIdPedido() == this.idPedido);
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
		
		public boolean agregarDetallePedido(Plato plato, int cantidad)throws Exception {
			if (traerDetallePedido(plato) != null) throw new Exception("ERROR. Este plato ya está incluido en el pedido. Modifique su cantidad.");
				
			int proxId = (!lstDetallePedido.isEmpty()) ? lstDetallePedido.get(lstDetallePedido.size() - 1).getIdDetallePedido() + 1 : 1;
			
			return lstDetallePedido.add(new DetallePedido(proxId, plato, cantidad));
		}
		
		
		
		@Override
		public String toString() {
			return "Pedido [idPedido=" + idPedido + ", fechaTransaccion=" + fechaTransaccion + ", festival=" + festival + ", unidadVenta=" + unidadVenta + ", lstDetallePedido=" + lstDetallePedido + "]";
		}
		
		
		public double calcularTotalPedido() {
			
			double total = 0;
			
			for (DetallePedido pedido: lstDetallePedido) {
				total += pedido.calcularTotalDetallePedido();
			}
			return total;
		}
		
		public double calcularTotalCosteProduccion() {
			
			double total = 0;
			
			for (DetallePedido pedido: lstDetallePedido) {
				total += pedido.calcularCosteProduccion();
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

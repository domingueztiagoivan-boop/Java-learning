package modelos;

import java.math.BigDecimal;
import java.util.Objects;


public class DetallePedido {
		private final int idDetallePedido;
		private final Plato plato;
		private final int cantidad;
		
		
		
		public DetallePedido(int idDetallePedido, Plato plato, int cantidad)throws ExceptionMenorZero {
			Objects.requireNonNull(plato, "ERROR. El plato no puede ser un atributo null.");
			this.idDetallePedido = validarId(idDetallePedido);
			this.plato = plato;
			this.cantidad = validarCantidad(cantidad);
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
		
		
		private static int validarCantidad(int cantidad)throws ExceptionMenorZero{
			if (cantidad <= 0) throw new ExceptionMenorZero("ERRO. La cantidad debe ser mayor a 0.");
			return cantidad;
		}


		public BigDecimal calcularTotalDetallePedido() {
			BigDecimal total = plato.getPrecioVenta().multiply(BigDecimal.valueOf(cantidad));
			return total;
		}
		
		public BigDecimal calcularCosteProduccion() {
			BigDecimal total = plato.getCostoProduccion().multiply(BigDecimal.valueOf(cantidad));
			return total;
		}
		
		private static int validarId(int id)throws ExceptionMenorZero{
		if (id < 0)throw new ExceptionMenorZero("ERROR. El id debe ser mayor o igual a 0.");
		return id; 
		}
		
}

package modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class UnidadVenta {
		protected final int idUnidadVenta;
		protected final String nombreComercial;
		protected Personal responsable;
		protected final double superficie;
		protected final String codigo;
		protected final List<Plato> lstPlatos;
		protected final List<Personal> lstPersonal;
		
		
		
		public UnidadVenta(int idUnidadVenta, String nombreComercial, Personal responsable, double superficie, String codigo) {
				this.idUnidadVenta = idUnidadVenta;
				this.nombreComercial = nombreComercial;
				this.responsable = responsable;
				this.superficie = superficie;
				this.codigo = codigo;
				this.lstPlatos = new ArrayList<Plato>();
				this.lstPersonal = new ArrayList<Personal>();
		}



		public int getIdUnidadVenta() {
			return idUnidadVenta;
		}
		
		public String getNombreComercial() {
			return nombreComercial;
		}
		
		public Personal getResponsable() {
			return responsable;
		}
		public void setResponsable(Personal responsable) {
			this.responsable = responsable;
		}
		public double getSuperficie() {
			return superficie;
		}
		
		public String getCodigo() {
			return codigo;
		}
		
		public List<Plato> getLstPlatos() {
			return lstPlatos;
		}
		
		public List<Personal> getLstPersonal() {
			return lstPersonal;
		}
		
		
		
		public boolean equals(UnidadVenta unidadVenta) {
			return (unidadVenta.getCodigo().equals(this.codigo));
		}

		@Override
		public String toString() {
			return "idUnidadVenta=" + idUnidadVenta + ", nombreComercial=" + nombreComercial + ", responsable=" + responsable + ", superficie=" + superficie + ", codigo=" + codigo + ", lstPlatos=" + lstPlatos + ", lstPersonal=" + lstPersonal;
		}
		
		
		abstract BigDecimal calcularCanon(Costo costo);
		
		public boolean agregarPlatoUnidadVenta(Plato plato)throws ExceptionYaRegistrado {
			
			Objects.requireNonNull(plato, "ERROR. No se puede registrar un plato null, verifique los datos.");
			
			if (traerPlatoUnidadVenta(plato.getNombrePlato()) != null)throw new ExceptionYaRegistrado("ERROR. El plato " + plato.getNombrePlato() + " ya esta registrado en el menu de la unidad venta.");
			
			return this.lstPlatos.add(plato);
		}
		
		public Plato traerPlatoUnidadVenta(String nombrePlato) {
			
			Plato resultado = null;
			int  i = 0;
			
			while (i < this.lstPlatos.size() && resultado == null) {
				if (this.lstPlatos.get(i).equals(nombrePlato)) {
					resultado = this.lstPlatos.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		public Personal traerPersonalUnidadVenta(long dni) {
			
			Personal resultado = null;
			int i = 0;
			
			while (i < this.lstPersonal.size() && resultado == null) {
				if (this.lstPersonal.get(i).getDni() == dni) {
					resultado = this.lstPersonal.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		public boolean agregarPersonalCocineroUnidadVenta(Personal cocinero1) throws ExceptionYaRegistrado {
			if (traerPersonalUnidadVenta(cocinero1.getDni()) != null) throw new ExceptionYaRegistrado("ERROR. El personal con DNI " + cocinero1.dni + " ya se encuentra registrado en el staff unidad vernta.");
			
			return this.lstPersonal.add(cocinero1);
			}
	
		public boolean agregarPersonalCajeroUnidadVenta(Personal cajero) throws ExceptionYaRegistrado {
			if (traerPersonalUnidadVenta(cajero.getDni()) != null) throw new ExceptionYaRegistrado("ERROR. El personal con DNI " + cajero.getDni() + " ya se encuentra registrado.");

			
			return this.lstPersonal.add(cajero);
			}
}

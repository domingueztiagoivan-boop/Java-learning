package modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class UnidadVenta {
		protected int idUnidadVenta;
		protected String nombreComercial;
		protected Personal responsable;
		protected double superficie;
		protected String codigo;
		protected List<Plato> lstPlatos;
		protected List<Personal> lstPersonal;
		
		
		
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
		public void setIdUnidadVenta(int idUnidadVenta) {
			this.idUnidadVenta = idUnidadVenta;
		}
		public String getNombreComercial() {
			return nombreComercial;
		}
		public void setNombreComercial(String nombreComercial) {
			this.nombreComercial = nombreComercial;
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
		public void setSuperficie(double superficie) {
			this.superficie = superficie;
		}
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public List<Plato> getLstPlatos() {
			return lstPlatos;
		}
		public void setLstPlatos(List<Plato> lstPlatos) {
			this.lstPlatos = lstPlatos;
		}
		public List<Personal> getLstPersonal() {
			return lstPersonal;
		}
		public void setLstPersonal(List<Personal> lstPersonal) {
			this.lstPersonal = lstPersonal;
		}
		
		
		public boolean equals(UnidadVenta unidadVenta) {
			return (unidadVenta.getCodigo().equals(this.codigo));
		}

		@Override
		public String toString() {
			return "idUnidadVenta=" + idUnidadVenta + ", nombreComercial=" + nombreComercial + ", responsable=" + responsable + ", superficie=" + superficie + ", codigo=" + codigo + ", lstPlatos=" + lstPlatos + ", lstPersonal=" + lstPersonal;
		}
		
		
		abstract double calcularCanon(Costo costo);
		
		public boolean agregarPlatoUnidadVenta(Plato plato)throws Exception {
			
			if (plato == null) {
		        throw new Exception("ERROR: No se puede agregar un plato nulo a la Unidad de Venta. Verifique que esté bien registrado en el sistema.");
		    }
			
			if (traerPlatoUnidadVenta(plato.getNombrePlato()) != null)throw new Exception("ERROR. El plato " + plato.getNombrePlato() + " ya esta registrado en el menu de la unidad venta.");
			
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
		
		public boolean agregarPersonalCocineroUnidadVenta(Personal cocinero1) throws Exception {
			if (traerPersonalUnidadVenta(cocinero1.getDni()) != null) throw new Exception("ERROR. El personal con DNI " + cocinero1.dni + " ya se encuentra registrado en el staff unidad vernta.");
			
			return this.lstPersonal.add(cocinero1);
			}
	
	public boolean agregarPersonalCajeroUnidadVenta(Personal cajero) throws Exception {
			if (traerPersonalUnidadVenta(cajero.getDni()) != null) throw new Exception("ERROR. El personal con DNI " + cajero.getDni() + " ya se encuentra registrado.");

			
			return this.lstPersonal.add(cajero);
			}
}

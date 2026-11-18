package modelos;

public class ReporteVenta {
	private UnidadVenta unidadVenta;
	private double recaudacionTotal;
	
	
	public ReporteVenta(UnidadVenta unidadVenta, double recaudacionTotal) {
		this.unidadVenta = unidadVenta;
		this.recaudacionTotal = recaudacionTotal;
	}


	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}
	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}
	public double getRecaudacionTotal() {
		return recaudacionTotal;
	}
	public void setRecaudacionTotal(double recaudacionTotal) {
		this.recaudacionTotal = recaudacionTotal;
	}


	@Override
	public String toString() {
		return "ReporteVenta [unidadVenta=" + unidadVenta + ", recaudacionTotal=" + recaudacionTotal + "]";
	}
	
	public boolean equals(ReporteVenta reporteVenta) {
		return (reporteVenta.getUnidadVenta().equals(this.unidadVenta));
	}
}

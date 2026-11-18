package modelos;

import java.math.BigDecimal;

public class ReporteVenta {
	private final int idReporteVenta;
	private final UnidadVenta unidadVenta;
	private BigDecimal recaudacionTotal;
	
	
	public ReporteVenta(int idReporteVenta, UnidadVenta unidadVenta, BigDecimal recaudacionTotal) {
		this.idReporteVenta = idReporteVenta;
		this.unidadVenta = unidadVenta;
		this.recaudacionTotal = recaudacionTotal;
	}


	public int getIdReporteVenta(){
		return this.idReporteVenta;
	}

	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}
	
	public BigDecimal getRecaudacionTotal() {
		return recaudacionTotal;
	}
	public void setRecaudacionTotal(BigDecimal recaudacionTotal) {
		this.recaudacionTotal = recaudacionTotal;
	}


	@Override
	public String toString() {
		return "ReporteVenta [unidadVenta=" + unidadVenta + ", recaudacionTotal=" + recaudacionTotal + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof ReporteVenta)) return false;
		ReporteVenta r = (ReporteVenta) obj;
		return (this.idReporteVenta == r.getIdReporteVenta());
	}

	@Override
	public int hashCode(){
		return Integer.hashCode(idReporteVenta);
	}
}

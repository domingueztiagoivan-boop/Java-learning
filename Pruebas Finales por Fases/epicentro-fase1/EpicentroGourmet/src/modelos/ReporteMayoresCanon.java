package modelos;

import java.math.BigDecimal;

public class ReporteMayoresCanon {
	private final String nombreComercial;
	private final String codigo;
	private final String tipoUnidad;
	private BigDecimal canon;
	
	
	public ReporteMayoresCanon(String nombreComercial, String codigo, String tipoUnidad, BigDecimal canon) {
		this.nombreComercial = nombreComercial;
		this.codigo = codigo;
		this.tipoUnidad = tipoUnidad;
		this.canon = canon;
	}


	public String getNombreComercial() {
		return nombreComercial;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getTipoUnidad() {
		return tipoUnidad;
	}
	
	public BigDecimal getCanon() {
		return canon;
	}
	public void setCanon(BigDecimal canon) {
		this.canon = canon;
	}


	@Override
	public String toString() {
		return "ReporteMayoresCanon [nombreComercial=" + nombreComercial + ", codigo=" + codigo + ", tipoUnidad=" + tipoUnidad + ", canon=" + canon + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof ReporteMayoresCanon))return false;
		ReporteMayoresCanon r = (ReporteMayoresCanon) obj;
		return (this.codigo.equals(r.getCodigo()));
	}

	@Override
	public int hashCode(){
		return this.codigo.hashCode();
	}
	
}

package modelos;

public class ReporteMayoresCanon {
	private String nombreComercial;
	private String codigo;
	private String tipoUnidad;
	private double canon;
	
	
	public ReporteMayoresCanon(String nombreComercial, String codigo, String tipoUnidad, double canon) {
		this.nombreComercial = nombreComercial;
		this.codigo = codigo;
		this.tipoUnidad = tipoUnidad;
		this.canon = canon;
	}


	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTipoUnidad() {
		return tipoUnidad;
	}
	public void setTipoUnidad(String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}
	public double getCanon() {
		return canon;
	}
	public void setCanon(double canon) {
		this.canon = canon;
	}


	@Override
	public String toString() {
		return "ReporteMayoresCanon [nombreComercial=" + nombreComercial + ", codigo=" + codigo + ", tipoUnidad=" + tipoUnidad + ", canon=" + canon + "]";
	}
	
	public boolean equals(ReporteMayoresCanon reporteMayoresCanon) {
		return (reporteMayoresCanon.getCodigo().equals(this.codigo));
	}
	
}

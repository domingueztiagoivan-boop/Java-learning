package modelos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class ReporteMayoresCanon {
	private final String nombreComercial;
	private final String codigo;
	private final TipoUnidad tipoUnidad;
	private BigDecimal canon;
	
	
	public ReporteMayoresCanon(String nombreComercial, String codigo, TipoUnidad tipoUnidad, BigDecimal canon) {
		Objects.requireNonNull(nombreComercial, "ERROR. El nombre no puede ser un atributo null.");
		Objects.requireNonNull(codigo, "ERROR. El codigo no puede ser un atributo null.");
		Objects.requireNonNull(tipoUnidad, "ERROR. El tipo unidad no puede ser un atributo null.");
		Objects.requireNonNull(canon, "ERROR. El canon no puede ser un atributo null.");
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
	
	public TipoUnidad getTipoUnidad() {
		return tipoUnidad;
	}
	
	public BigDecimal getCanon() {
		return canon.setScale(2, RoundingMode.HALF_UP);
	}
	public void setCanon(BigDecimal canon) {
		this.canon = canon;
	}


	@Override
	public String toString() {
		return "ReporteMayoresCanon [nombreComercial=" + nombreComercial + ", codigo=" + codigo + ", tipoUnidad=" + tipoUnidad.getDescripcion() + ", canon=" + canon + "]";
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

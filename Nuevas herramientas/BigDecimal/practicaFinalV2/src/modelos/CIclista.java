package modelos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CIclista extends Repartidor {
	private boolean esElectrico;
	private BigDecimal precioBaseEnvio;
	
	
	
	
	public CIclista(int id, String patenteIdentificador, int capacidadPedidosMax, boolean esElectrico, BigDecimal precioBaseEnvio) throws ExceptionRepartidorMenorCero {
		super(id, patenteIdentificador, capacidadPedidosMax);
		this.esElectrico = esElectrico;
		this.precioBaseEnvio = precioBaseEnvio;
	}




	public boolean isEsElectrico() {
		return esElectrico;
	}
	public void setEsElectrico(boolean esElectrico) {
		this.esElectrico = esElectrico;
	}
	public BigDecimal getPrecioBaseEnvio() {
		return precioBaseEnvio;
	}

	public void setPrecioBaseEnvio(BigDecimal precioBaseEnvio) {
		this.precioBaseEnvio = precioBaseEnvio;
	}


	@Override
	public String toString() {
		return "CIclista [esElectrico=" + esElectrico + ", precioBaseEnvio=" + precioBaseEnvio + "]";
	}
	
	
	public BigDecimal costoTotalEnvio(BigDecimal kmRecorridos) {
		
		BigDecimal extra;
		
		if (!esElectrico && kmRecorridos.compareTo(new BigDecimal("5")) >= 0) {
			extra = new BigDecimal("1500");
		}else {
			extra = new BigDecimal("0");
		}
		BigDecimal suma = (this.precioBaseEnvio.add(extra));
		return (suma.setScale(2, RoundingMode.HALF_UP));
	}
	
}

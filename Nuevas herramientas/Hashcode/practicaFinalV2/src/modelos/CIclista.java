package modelos;

public class CIclista extends Repartidor {
	private boolean esElectrico;
	private float precioBaseEnvio;
	
	
	
	
	public CIclista(int id, String patenteIdentificador, int capacidadPedidosMax, boolean esElectrico, float precioBaseEnvio) {
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
	public float getPrecioBaseEnvio() {
		return precioBaseEnvio;
	}

	public void setPrecioBaseEnvio(float precioBaseEnvio) {
		this.precioBaseEnvio = precioBaseEnvio;
	}


	@Override
	public String toString() {
		return "CIclista [esElectrico=" + esElectrico + ", precioBaseEnvio=" + precioBaseEnvio + "]";
	}
	
	
	public float costoTotalEnvio(float kmRecorridos) {
		
		float extra = 0;
		
		if (!esElectrico && kmRecorridos > 5) {
			extra = 1500;
		}
		return (precioBaseEnvio + extra);
	}

	public String getTipo() {
		return "Ciclista";
	}
	
}

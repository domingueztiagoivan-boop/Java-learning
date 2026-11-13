package modelos;

public class Moto extends Repartidor {
	private float costoFijoSeguro;
	private float precioPorKm;
	

	public Moto(int id, String patenteIdentificador, int capacidadPedidosMax, float costoFijoSeguro, float precioPorKm) {
		super(id, patenteIdentificador, capacidadPedidosMax);
		this.costoFijoSeguro = costoFijoSeguro;
		this.precioPorKm = precioPorKm;
	}

	public float getCostoFijoSeguro() {
		return costoFijoSeguro;
	}
	public void setCostoFijoSeguro(float costoFijoSeguro) {
		this.costoFijoSeguro = costoFijoSeguro;
	}
	public float getPrecioPorKm() {
		return precioPorKm;
	}
	public void setPrecioPorKm(float precioPorKm) {
		this.precioPorKm = precioPorKm;
	}


	@Override
	public String toString() {
		return "Moto [costoFijoSeguro=" + costoFijoSeguro + ", precioPorKm=" + precioPorKm + "]";
	}
	
	public float costoTotalEnvio(float kmRecorridos) {
		return (costoFijoSeguro + (kmRecorridos * precioPorKm));
	}

}

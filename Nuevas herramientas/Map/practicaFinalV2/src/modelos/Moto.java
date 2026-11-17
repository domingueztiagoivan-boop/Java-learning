package modelos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Moto extends Repartidor {
	private BigDecimal costoFijoSeguro;
	private BigDecimal precioPorKm;
	

	public Moto(int id, String patenteIdentificador, int capacidadPedidosMax, BigDecimal costoFijoSeguro, BigDecimal precioPorKm)throws ExceptionRepartidorMenorCero {
		super(id, patenteIdentificador, capacidadPedidosMax);
		this.costoFijoSeguro = costoFijoSeguro;
		this.precioPorKm = precioPorKm;
	}

	public BigDecimal getCostoFijoSeguro() {
		return costoFijoSeguro;
	}
	public void setCostoFijoSeguro(BigDecimal costoFijoSeguro) {
		this.costoFijoSeguro = costoFijoSeguro;
	}
	public BigDecimal getPrecioPorKm() {
		return precioPorKm;
	}
	public void setPrecioPorKm(BigDecimal precioPorKm) {
		this.precioPorKm = precioPorKm;
	}


	@Override
	public String toString() {
		return "Moto [costoFijoSeguro=" + costoFijoSeguro + ", precioPorKm=" + precioPorKm + "]";
	}
	
	public BigDecimal costoTotalEnvio(BigDecimal kmRecorridos) {
		BigDecimal suma = kmRecorridos.multiply(this.precioPorKm);
		BigDecimal total = this.costoFijoSeguro.add(suma);
		return (total.setScale(2, RoundingMode.HALF_UP));
	}

}

package Clases;

import java.time.LocalDate;

public class Reserva {
	private int idReserva;
	private Cliente cliente;
	private LocalDate fechaReserva;
	private Mesa mesa;
	private int cantComensales;
	
	
	public Reserva(Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales) {
		this.cliente = cliente;
		this.fechaReserva = fechaReserva;
		this.mesa = mesa;
		this.cantComensales = cantComensales;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public LocalDate getFechaReserva() {
		return fechaReserva;
	}


	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}


	public Mesa getMesa() {
		return mesa;
	}


	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}


	public int getCantComensales() {
		return cantComensales;
	}


	public void setCantComensales(int cantComensales) {
		this.cantComensales = cantComensales;
	}
	
	public int getIdReserva() {
		return this.idReserva;
	}
	
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
}

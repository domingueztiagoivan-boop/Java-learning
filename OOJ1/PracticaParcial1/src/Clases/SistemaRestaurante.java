package Clases;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class SistemaRestaurante {
	private List<Cliente> lstClientes;
	private List<Mesa> lstMesa;
	private List<Reserva> lstReserva;
	
	
	public SistemaRestaurante() {
		this.lstClientes = new ArrayList<Cliente>();
		this.lstMesa = new ArrayList<Mesa>();
		this.lstReserva = new ArrayList<Reserva>();
	}


	public List<Cliente> getLstClientes() {
		return lstClientes;
	}


	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}


	public List<Mesa> getLstMesa() {
		return lstMesa;
	}


	public void setLstMesa(List<Mesa> lstMesa) {
		this.lstMesa = lstMesa;
	}


	public List<Reserva> getLstReserva() {
		return lstReserva;
	}


	public void setLstReserva(List<Reserva> lstReserva) {
		this.lstReserva = lstReserva;
	}
	
	public Cliente traerCliente(long dni) {
		
		Cliente resuelto = null;
		
		for(Cliente c: lstClientes) {
			if (c.getDni() == dni) {
				resuelto = c;
			}
		}
		return resuelto;
	}
	
	public boolean agregarCliente(String nombre, String apellido, long dni, String telefono)throws Exception {
		
		for(Cliente c: lstClientes) {
			if (c.getDni() == dni) throw new Exception("Error. Ya esta registrado un cliente con ese DNI: " + dni);
		}
		
		int idProximo = 1;
		
		if (!lstClientes.isEmpty()) {
			idProximo = lstClientes.get(lstClientes.size() - 1).getIdCliente() + 1;
		}
		
		Cliente nuevo = new Cliente(nombre, apellido, dni, telefono);
		nuevo.setIdCliente(idProximo);
		return lstClientes.add(nuevo);

	}
	
	
	public Mesa traerMesa(int numeroMesa) {
		
		Mesa resultado = null;
		
		for (Mesa m: lstMesa) {
			if (m.getNumeroMesa() == numeroMesa) {
				resultado = m;
			}
		}
		
		return resultado;
	}
	
	
	public boolean agregarMesa(int numeroMesa, int capacidad) throws Exception{
		
		for (Mesa m: lstMesa) {
			if (m.getNumeroMesa() == numeroMesa) throw new Exception("Error. Ya se registro una mesa con ese numero. " + numeroMesa);
		}
		
		Mesa nueva = new Mesa(numeroMesa, capacidad);
		int proximoId = 0;
		
		if (!lstMesa.isEmpty()) {
			proximoId = lstMesa.get(lstMesa.size() - 1).getIdMesa() + 1;
		}
		
		nueva.setIdMesa(proximoId);
		return lstMesa.add(nueva);
	}
	
	public Reserva traerReserva(int numeroMesa, LocalDate fechaReserva) {
		
		Reserva resultado = null;
		
		for(Reserva r: lstReserva) {
			if ((r.getMesa().getNumeroMesa() == numeroMesa) && (r.getFechaReserva().equals(fechaReserva))){
				resultado = r;
			}
		}
		return resultado;
	}
	
	
	public boolean agregarReserva(Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales) throws Exception{
		for(Reserva r: lstReserva) {
			if ((r.getMesa().getNumeroMesa() == mesa.getNumeroMesa()) && (r.getFechaReserva().equals(fechaReserva))) throw new Exception("Error. La mesa ya esta reservada para la fehca: " + fechaReserva);
		}
		
		 traerMesa(mesa.getNumeroMesa()).validarComensales(cantComensales);
		
		Reserva nueva = new Reserva(cliente, fechaReserva, mesa, cantComensales);
		int idProximo = 1;
		
		if (!lstReserva.isEmpty()) {
			idProximo = lstReserva.get(lstReserva.size() - 1).getIdReserva() + 1;
		}
		
		nueva.setIdReserva(idProximo);
		return lstReserva.add(nueva);
	}
	
	public List<Reserva> traerReservasPorFecha(LocalDate fechaDesde, LocalDate fechaHasta){
		
		List<Reserva> nuevaLista = new ArrayList<Reserva>();
		
		
		
		for(Reserva r: lstReserva) {
			if (!r.getFechaReserva().isBefore(fechaDesde) && !r.getFechaReserva().isAfter(fechaHasta)) {
				nuevaLista.add(r);
			}
		}
		return nuevaLista;
	}
	
	public List<Mesa> traerMesasLibresPorFecha(LocalDate fechaReserva) {
		
		List<Mesa> nuevaLista = new ArrayList<Mesa>();
		
		for(Mesa r: lstMesa) {
			if (traerReserva(r.getNumeroMesa(), fechaReserva) == null) {
				nuevaLista.add(r);
			}
		}
		return nuevaLista;
	}
		
}

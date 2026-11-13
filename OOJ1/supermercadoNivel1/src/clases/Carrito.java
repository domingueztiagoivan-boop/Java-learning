package clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int IdCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<itemCarrito> lstCarrito;
	
	
	public Carrito(LocalDate fecha, LocalTime hora) {
		this.fecha = fecha;
		this.hora = hora;
		this.lstCarrito = new ArrayList<itemCarrito>();
	}


	public int getIdCarrito() {
		return IdCarrito;
	}


	public void setIdCarrito(int idCarrito) {
		IdCarrito = idCarrito;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public LocalTime getHora() {
		return hora;
	}


	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public List<itemCarrito> getLstCarrito(){
		return this.lstCarrito;
	}

	
	
	public boolean agregarItem(Producto producto, int cantidad) {
		
		itemCarrito nuevoItem = new itemCarrito(producto, cantidad);
		int id = 1;
		
		
		if (!lstCarrito.isEmpty()) {
			id = lstCarrito.get(lstCarrito.size() - 1).getIdItem() + 1;
		}
		
		nuevoItem.setIdItem(id);
		return lstCarrito.add(nuevoItem);
	}
	
	
	
	public itemCarrito trearItemCarrito(int idItemCarrito) {
		
		itemCarrito itemEncontrado = null;
		
		for (itemCarrito i: lstCarrito) {
			if (i.getIdItem() == idItemCarrito) {
				itemEncontrado = i;
				break;
			}
		}
		return itemEncontrado;
	}
	
	
	
	public boolean eliminarItem(Producto producto, int cantidad) {
		
		itemCarrito itemEncontrado = null;
		
		for (itemCarrito i: lstCarrito) {
			if (i.getProductoItemCarrito().getIdProducto() == producto.getIdProducto()) {
				itemEncontrado = i;
				break;
			}
		}
		
		if (itemEncontrado == null) {
			return false;
		}
		
		if (itemEncontrado.getCantidad() <= cantidad) {
			return lstCarrito.remove(itemEncontrado);
			
		} else  {
			int nuevaCantidad = itemEncontrado.getCantidad() - cantidad;
			itemEncontrado.setCantidad(nuevaCantidad);
			return true;
		}
	}

	public float calcularSubTotal() {
		
		float suma = 0;
		
		for (itemCarrito i: lstCarrito) {
			suma += i.calcularTotalItem();
		}
		return suma;
	}
	
	public float calcularTotal() {
		
		float total = calcularSubTotal();
		float iva = total * 0.21f;
		return total = total + iva;
	}

	
	
	
}

package clases;

public class Producto {
	private int idProducto;
	private String producto;
	private float precio;
	
	public Producto(String producto, float precio) {
		this.producto = producto;
		this.precio = precio;
	}
	
	public float getPrecio() {
		return this.precio;
	}
	
	public String getProducto() {
		return this.producto;
	}
	
	public int getIdProducto() {
		return this.idProducto;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	public boolean equalsIdProducto(int idProducto) {
		if (this.idProducto == idProducto) {
			return true;
		} else {
			return false;
	    }
	}
	
	@Override
	public String toString() {
		return "("+idProducto+", "+producto+", "+precio+")";
	}
	
	
	
	
}



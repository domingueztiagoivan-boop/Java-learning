package Clases;

public class Producto {
	private String nombre;
	private double precio;
	private int idProducto;
	
	
	public Producto (String nombre, double precio) throws Exception{
		this.nombre = nombre;
		this.setPrecio(precio);
	}
	
	
	public void setPrecio(double precio) throws Exception{
		if (precio <= 0) throw new Exception("Error en el precio. debe ser mayor a 0: (" + precio + ")");
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "("+nombre+", "+precio+", "+idProducto+")";
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

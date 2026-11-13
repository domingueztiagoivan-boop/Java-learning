package clases;

public class itemCarrito {
	private int idItem;
	private Producto producto;
	private int cantidad;
	
	
	
	public itemCarrito(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	
	public int getIdItem() {
		return this.idItem;
	}
	
	public Producto getProductoItemCarrito() {
		return this.producto;
	}
	
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setProductoItemCarrito(Producto producto) {
		this.producto = producto;
	}
	
	
	public boolean equalIdCarrito(int idCarrito) {
		if (this.idItem == idCarrito) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "("+idItem+", "+producto+", "+cantidad+")";
	}
	
	public float calcularTotalItem() {
		return this.cantidad * this.producto.getPrecio();
	}
	
	
	
	}

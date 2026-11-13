package clases;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private List<Producto> gondola;
	
	
	
	public Supermercado() {
		this.gondola = new ArrayList<Producto>();
	}
	
	
	public boolean agregarPoducto(String producto, float precio) {
		
		if (precio <= 0) {
			return false;
		}
		
		Producto nuevoProducto = new Producto(producto, precio);
		int newId = 1;
		
		if (!gondola.isEmpty()) {
				newId = gondola.get(gondola.size() - 1).getIdProducto() + 1;
		    } 
		
		nuevoProducto.setIdProducto(newId);
		return gondola.add(nuevoProducto);	
		}
	
		public Producto traerProducto(int idProducto) {
				
				Producto productoEncontrado = null;
			
				for (Producto p: gondola){
					if (p.getIdProducto() == idProducto) {
						productoEncontrado = p;
						break;
					}
				}
				
				if (productoEncontrado == null) {
					System.out.print("\nError. no se encuentra el producto.");
					return null;
				}
				
				return productoEncontrado;
			}
		
		
		public boolean modificarProducto(int idProducto, String producto, float precio) {
			
			if (precio <= 0) {
				return false;
			}
		
			Producto p = traerProducto(idProducto);
			
			if (p == null) {
				return false;
			}
			
			p.setPrecio(precio);
			p.setProducto(producto);
			return true;	
		}
		
		
		public boolean eliminarProducto(int idProducto) {
			
			Producto p = traerProducto(idProducto);
			
			if (p == null) {
				return false;
			}
			
			gondola.remove(p);
			return true;
		}
		
		public List<Producto> getGondola() {
		    return gondola;
		}
		
		
	
	
	}


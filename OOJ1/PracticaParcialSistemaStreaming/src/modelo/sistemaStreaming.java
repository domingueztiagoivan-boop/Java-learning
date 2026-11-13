package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class sistemaStreaming {
		private  List<Usuario> lstUsuarios;
		private  List<Contenido> lstContenido;
		private  List<Reproduccion> lstReproduccion;
		
		
		
		public sistemaStreaming() {
			this.lstUsuarios = new ArrayList<Usuario>();
			this.lstContenido = new ArrayList<Contenido>();
			this.lstReproduccion = new ArrayList<Reproduccion>();
		}



		public List<Usuario> getLstUsuarios() {
			return lstUsuarios;
		}
		public void setLstUsuarios(List<Usuario> lstUsuarios) {
			this.lstUsuarios = lstUsuarios;
		}
		public List<Contenido> getLstContenido() {
			return lstContenido;
		}
		public void setLstContenido(List<Contenido> lstContenido) {
			this.lstContenido = lstContenido;
		}
		public List<Reproduccion> getLstReproduccion() {
			return lstReproduccion;
		}
		public void setLstReproduccion(List<Reproduccion> lstReproduccion) {
			this.lstReproduccion = lstReproduccion;
		}
		
		
		public Usuario traerUsuario(String email) {
			
			Usuario resultado = null;
			int i = 0;
			
			while (resultado == null && lstUsuarios.size() > i) {
					if (lstUsuarios.get(i).getEmail().equals(email)) {
						resultado = lstUsuarios.get(i);
					}
					i++;
			}
			
			return resultado;
		}
		
		
		public boolean agregarUsuario(String nombre, String email, boolean esPremium)throws Exception {
			if (traerUsuario(email) != null)throw new Exception("Error. El mail: " + email + " ya esta registrado.");
			
			int proxId = 1;
			
			if (!lstUsuarios.isEmpty()) {
				proxId = lstUsuarios.get(lstUsuarios.size() - 1).getIdUsuario() + 1;
			}
			
			return lstUsuarios.add(new Usuario(proxId, nombre, email, esPremium));
		}
		
		
		public Contenido traerContenido(String titulo) {
			
			Contenido resultado = null;
			int i = 0;
			
			while(resultado == null && i < lstContenido.size()) {
				if (lstContenido.get(i).getTitulo().equals(titulo)) {
					resultado = lstContenido.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		public boolean agregarPelicula(String titulo,  int duracionMinutos, double precioBase, boolean esEstreno)throws Exception{
			if (traerContenido(titulo) != null)throw new Exception("Error. el titulo " + titulo + " ya esta registrado.");
			
			int proxId = 1;
			
			if (!lstContenido.isEmpty()) {
				proxId = lstContenido.get(lstContenido.size() - 1).getIdContenido() + 1;
			}
			
			return lstContenido.add(new Pelicula(proxId, titulo, duracionMinutos, precioBase, esEstreno));
		}
		
		
		public boolean agregarSerie(String titulo,  int duracionMinutos, double precioBase, int cantidadEpisodios)throws Exception{
			if (traerContenido(titulo) != null)throw new Exception("Error. el titulo " + titulo + " ya esta registrado.");
			
			int proxId = 1;
			
			if (!lstContenido.isEmpty()) {
				proxId = lstContenido.get(lstContenido.size() - 1).getIdContenido() + 1;
			}
			
			return lstContenido.add(new Serie(proxId, titulo, duracionMinutos, precioBase, cantidadEpisodios));
		}
		
		
		public Reproduccion traerReproduccion(Usuario usuario, Contenido contenido) {
			
			Reproduccion resultado = null;
			int i = 0;
			
			while (resultado == null && i < lstReproduccion.size()) {
				if (lstReproduccion.get(i).getUsuario().equals(usuario) && lstReproduccion.get(i).getContenido().equals(contenido)) {
					resultado = lstReproduccion.get(i);
				}
				i++;
			}
			return resultado;
		}
		
		public boolean agregarReproduccion(Usuario usuario, Contenido contenido, LocalDate fecha) throws Exception{
			if (traerReproduccion(usuario, contenido) != null) throw new Exception("Error. Usuario " + usuario + " y contenido " + contenido + " ya estan registrados.");
			
			int proxId = 1;
			
			if (!lstReproduccion.isEmpty()) {
				proxId = lstReproduccion.get(lstReproduccion.size() - 1).getIdReproduccion() + 1;
			}
			
			return lstReproduccion.add(new Reproduccion(proxId, usuario, contenido, fecha));
		}
		
		
		public double calcularRecaudacionTotal(LocalDate desde, LocalDate hasta) {
			double total = 0;
			
			for (Reproduccion r: lstReproduccion) {
				
				if ((r.getFecha().isAfter(desde) || r.getFecha().equals(desde)) && (r.getFecha().isBefore(hasta) || r.getFecha().equals(hasta))) {
					total += r.getContenido().calcularCostoFinal();
				}
			}
			return total;
		}
		
		
		private int contarReproduccionesDeContenido(Contenido contenido) {
		    int contador = 0;
		    for (Reproduccion r : lstReproduccion) {
		        // Usamos el .equals() que compara por ID de contenido
		        if (r.getContenido().equals(contenido)) {
		            contador++;
		        }
		    }
		    return contador;
		}

		// CU 3: Traer el TOP de contenidos más vistos
		public List<Contenido> traerContenidosMasVistos(int top) {
		    // 1. Clonamos la lista original de contenidos para no desordenar el sistema base
		    List<Contenido> listaOrdenada = new ArrayList<>(lstContenido);

		    // 2. Método de ordenamiento clásico (Burbujeo) de Mayor a Menor
		    for (int i = 0; i < listaOrdenada.size() - 1; i++) {
		        for (int j = 0; j < listaOrdenada.size() - i - 1; j++) {
		            
		            Contenido c1 = listaOrdenada.get(j);
		            Contenido c2 = listaOrdenada.get(j + 1);
		            
		            // Comparamos las cantidades usando el método auxiliar
		            if (contarReproduccionesDeContenido(c1) < contarReproduccionesDeContenido(c2)) {
		                // Intercambio (Swap)
		                listaOrdenada.set(j, c2);
		                listaOrdenada.set(j + 1, c1);
		            }
		        }
		    }

		    // 3. Armamos la sublista con el "top" solicitado
		    List<Contenido> podio = new ArrayList<>();
		    int limite = top;
		    
		    // Control de seguridad: Si piden un TOP 5 pero solo hay 3 contenidos en total, 
		    // ajustamos el límite para que el programa no tire un error de índice (IndexOutOfBounds)
		    if (limite > listaOrdenada.size()) {
		        limite = listaOrdenada.size();
		    }

		    // Pasamos solo los primeros elementos (los más vistos)
		    for (int i = 0; i < limite; i++) {
		        podio.add(listaOrdenada.get(i));
		    }

		    return podio;
		}
}

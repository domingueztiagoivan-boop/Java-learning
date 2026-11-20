package modelos;



public enum TipoUnidad {

	FOODTRUCK("Food Truck"),
    PUESTODESARMABLE("Puesto Desarmable");

	private final String descripcion;

    TipoUnidad(String descripcion) { this.descripcion = descripcion; }

    public String getDescripcion() { return descripcion; }

		
}	


package clases;

public class Navegacion extends Excursion{
	private boolean tieneAlmuerzo;
	private float costoBaseLancha;
	
	
	public Navegacion(int idExcursion, String descripcion, int cantDias, boolean tieneAlmuerzo, float costoBaseLancha) {
		super(idExcursion, descripcion, cantDias);
		this.tieneAlmuerzo = tieneAlmuerzo;
		this.costoBaseLancha = costoBaseLancha;
	}
	

	public boolean isTieneAlmuerzo() {
		return tieneAlmuerzo;
	}
	public void setTieneAlmuerzo(boolean tieneAlmuerzo) {
		this.tieneAlmuerzo = tieneAlmuerzo;
	}
	public float getCostoBaseLancha() {
		return costoBaseLancha;
	}
	public void setCostoBaseLancha(float costoBaseLancha) {
		this.costoBaseLancha = costoBaseLancha;
	}




	public float costoTotal(int cantidadPersonas) {
		float extra = 0;
		if (tieneAlmuerzo) {
			extra = 4500 * cantidadPersonas;
		}
		return (costoBaseLancha + ((6000 * cantidadPersonas) + extra));
	}
}


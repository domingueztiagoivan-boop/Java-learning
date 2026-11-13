package clases;

public class Trekking extends Excursion{
	private float kmRecorridos;
	private int dificultad;
	
	
	public Trekking(int idExcursion, String descripcion, int cantDias, float kmRecorridos, int dificultad) {
		super(idExcursion, descripcion, cantDias);
		this.kmRecorridos = kmRecorridos;
		this.dificultad = dificultad;
	}

	public float getKmRecorridos() {
		return kmRecorridos;
	}
	public void setKmRecorridos(float kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
	public int getDificultad() {
		return dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}


	public float costoTotal(int cantidadPersonas) {
		float extra = 0;
		if (dificultad >= 3) {
			extra = 8000;}
		return (((this.kmRecorridos * 2500) * cantidadPersonas) + extra);
	}
}

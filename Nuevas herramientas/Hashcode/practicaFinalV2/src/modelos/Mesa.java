package modelos;
import java.util.Objects;

public class Mesa {
	private int id;
	private int sector;
	private int numero;
	
	
	public Mesa(int id, int sector, int numero) {
		this.id = id;
		this.sector = sector;
		this.numero = numero;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSector() {
		return sector;
	}
	public void setSector(int sector) {
		this.sector = sector;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	///Primero comprobar que si son lo mismo, devuelva true, despues comprobar que son del mismo tipo y por ultimo comparar el atributo unico identificador.
	@ Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Mesa)) return false;
		Mesa o = (Mesa) obj;
		return (this.sector == o.sector && this.numero == o.numero);
	}
	
	@Override
	public String toString() {
		return "Mesa [id=" + id + ", sector=" + sector + ", numero=" + numero + "]";
	}
	

	/// el hashcode debe hacerse con el mismo atributo que el equals, osea Sector y numero en este caso.
	/// al ser un int tenemos que definir nosotros el hashcode, no como en el caso de String que ya tiene su propio hashcode. Tomamos Sector y numero como atributos únicos identificadores.
	@Override
	public int hashCode(){
		return Objects.hash(sector, numero);
	}
	

}

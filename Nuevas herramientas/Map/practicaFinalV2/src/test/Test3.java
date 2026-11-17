package test;

import java.util.HashMap;
import java.util.Map;
import modelos.Mesa;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mesa mesaMap1 = new Mesa(100, 50, 200);


		
		System.out.println("**MAP**");
		Map<String, Mesa> mapMesa = new HashMap<>();

		///Map<String, Mesa> nombreMap. TIENE DOS VARIABLES; String (key) es el identificador, y Mesa (objeto) es el tipo de objeto que guarda este map.
		///La key se busca con  hashcode, por eso hay que sobreescribrilo con @Override en la clase del objeto para que lo pueda hacer correctamente
		///tambien utiliza equals asi que los dos hay que @Override correctamente para que el HashSet y Map funcionen.

		mapMesa.put("mesa200", mesaMap1);
		System.out.println("mapMesa.get(mesa200) " + mapMesa.get("mesa200"));
		System.out.println("mapMesa.containsKey(mesa200): " + mapMesa.containsKey("mesa200"));
		System.out.println("mapMesa.values() [imprime mapMesa completo, sin mostrar keys]: " + mapMesa.values());

		System.out.println("\nMas Pruebas [Map<Integer, String]**");
		Map<Integer, String> mapString = new HashMap<>();
		mapString.put(1, "a"); /// agregamos con .put()
		System.out.println("mapString.get(1): " + mapString.get(1));
		mapString.put(1, "b");
		System.out.println("mapString.get(1): " + mapString.get(1));
		System.out.println("mapString.size() [luego de sobreescribir una key con otro valor]: " + mapString.size()); //No cambia el size, porque utiliza la misma key.
		System.out.println("mapString.get(99) [key sin valor, ni asignada]: " + mapString.get(99)); //NULL
		System.out.println("mapString.put(1, c) [Muestra valor reemplazado (b) por nuevo (c)]: " + mapString.put(1, "c")); ///Si ponemos un system.out.println con put, nos muestra el resultado viejo guardado y que fue remplzado.
		System.out.println("mapString.get(1): " + mapString.get(1));
		System.out.println("mapString.get(99).length(): " + mapString.get(99).length());
		


	}	

}

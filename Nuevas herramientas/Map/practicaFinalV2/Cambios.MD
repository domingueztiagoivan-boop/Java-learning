Maps por Listas.

un cambio necesario ya que nos ahorramos de whiles y podemos en una simple linea de codigo como:
Repartidor resultado = repartirdoresMap.get(patenteIdentificador);
devolver el repartidor que se buscaba.

tambien para exceptions es buena herrameienta:
String clave = sector + "-" + numero;
		if (mesasMap.containsKey(clave)) throw new ExceptionYaRegistrado("ERROR. Mesa ya registrada.");

El contains nos da true o false.
Es muy importante el String en este caso, porque de dos parametros int que nos llegan, lo transformamos en un solo String, que es lo que necesita el
map de Mesas (String, Mesa).

map.values() nos da un collection con toda la info sobre este map y todos los values, no revela las keys de cada objeto guardado.
los maps no son ordenados y utilizan hashcode y equals.

map.put() para agregar objeto a un map.
map.get() para obtener el objeto.
map.isEmpty()
map.copyOf()

el tipo de variable que tendran las Key de los objetos dentro del map es importante.

en resumen: Con map nos ahorramos correr whiles y listas con muchos objetos que nos quitan perfomance. Tambien hace el codigo mas facil y limpio de leer.

En test3 hay varias pruebas realizadas para entender algunos comandos y funciones de map.
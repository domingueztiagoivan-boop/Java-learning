Se complico un poco la cosa.
BigDecimal para dinero y otros atributos como kmRecorridos o precioPorKm son mejores que Double o Float.
Sin embargo cambiarlo todo en el codigo me llevo 30 mn, ya que tuve que retocar muchas funciones y actualizar lo que ya andaba con new BigDecimal en test,
tambien en metodos, su forma de comparar con compare, usar BigDecimal.ZERO y otras cosa.


En general BigDecimal es un String, el cual tenemos metodos propios de este que reemplazan el float + float / float * float / int / int, etc.
Tambien no se guarda el resultado, por Inmutabilidad, propiedad de los String, sino que debemos actualizar con redundancia( total = total.add("20")) o 
crear una nueva variable. Si no guardamos una nueva variable, la operacion se lleva a cabo pero un bug silencioso ocurre y no se guarda el resultado.

Equals utiliza el valor del string y tambien el setscale, por eso es complicado que den true, asi que un hashset no detecta la igualdad de 2.0 y 2.00, ya que
el equals da negativo por lo que lo agrega.
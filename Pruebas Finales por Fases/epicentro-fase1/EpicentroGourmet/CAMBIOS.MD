# Epicentro-Gourmet — Fase 1 (epicentro-fase1)

Refactor de la versión de OO1 (epicentro-original) aplicando los temas 1.1 a 1.6. Objetivo: mismo comportamiento, código más correcto. Referencia: salida de test1 (casos de uso 5 a 13).

**Estado al 21/11/2026: CERRADA.** Última corrida de test1 revisada el 21/11/2026 (ver sección 5).

---

## 1. Cambios aplicados

### 1.1 equals / hashCode
- `equals(Object)` con `@Override` y `hashCode` con los mismos campos en todas las clases.
- Identidad: `Personal` por dni; `Plato` y `Festival` por nombre; `UnidadVenta` por codigo; `ReporteMayoresCanon` por codigo; el resto por id.

### 1.2 Enums
- `Turno` (TARDE, MANANA) en `Cajero`; el setter se queda porque el turno puede cambiar.
- `Temporada` (VERANO, PRIMAVERA, OTONO, INVIERNO) en `Festival`.
- `TipoUnidad` (FOODTRUCK, PUESTODESARMABLE) en `ReporteMayoresCanon`; reemplaza los strings de `obtenerUnidadesConMayorCanon`.
- Cada constante tiene `descripcion` para mostrar ("Mañana", "Otoño", "Food Truck"); se comparan con `==`.

### 1.3 Excepciones propias y validaciones
- Checked: `ExceptionYaRegistrado`, `ExceptionSinRegistro`, `ExceptionFechaNacimiento`, `ExceptionDetallePedidoPlatoYaInlcuido`, `ExceptionMenorZero`, `ExceptionFechasLimites`. Cada una con comentario del porqué.
- `Objects.requireNonNull` en los constructores, solo para referencias (String, LocalDate, objetos, enums). Con `int`, `long`, `double` o `boolean` no se usa: hace boxing y nunca falla; en primitivos se valida el valor.
- Los `requireNonNull` van después de `super(...)` (antes solo compilaba en JDK 25).
- Validaciones de valor: id, dni, superficie, cantidad, precios, costos, plus, cantidad de carpas y minutos de montaje. El criterio del cero se decidió campo por campo y los mensajes dicen lo mismo que el código.
- `Festival`: la fecha fin se valida con `!isBefore` (la fecha fin no puede ser anterior al inicio), así que se permiten festivales de un día.
- `Costo` y `Cocinero.plusCategoria`: el constructor valida llamando al setter.
- Los `validarX` son privados.

### 1.4 Encapsulamiento
- `List.copyOf` en `Festival.getLstPedidos`, `Pedido.getLstDetallePedido`, `UnidadVenta.getLstPlatos` y `getLstPersonal`.
- Atributos de identidad en `private final` (id, nombre, fechas, referencias).
- Los atributos de `Personal` y `UnidadVenta` pasaron de `protected` a `private`; las subclases acceden por getters.

### 1.5 BigDecimal
- `Cocinero.plusCategoria` pasó de `double` a `BigDecimal`; `Sistema.agregarPersonalCocinero` recibe `BigDecimal`.
- Operaciones con `add`, `subtract` y `multiply` guardando el resultado; comparaciones con `compareTo`.
- `BigDecimal.valueOf` en lugar de `new BigDecimal(double)` (superficie) y de `new BigDecimal(int)`.
- `setScale(2, RoundingMode.HALF_UP)` una sola vez, al final de los cálculos de sueldos, canon, rentabilidad y recaudación (incluido el caso de una unidad sin ventas, que sale `0.00`).
- Constante con nombre para el top 3.

### 1.6 Map en Sistema
- Cinco `Map` (festivales, personal, unidades, platos, pedidos) con clave natural.
- `traerX` lanza `ExceptionSinRegistro`; los duplicados se detectan con `containsKey` y `ExceptionYaRegistrado`.
- Ids con contadores `lastIdX`; `lastIdX++` va después del `put`, para que un constructor que falle no consuma el id.
- Getters con `Map.copyOf`.
- `registrarPedido`: usa las instancias que devuelven `traerFestival` y `traerUnidadVenta`, y guarda el pedido con `festival.agregarPedidoFestival` y en `mapPedidos`.
- Se borraron los `if (traerX(...) == null) throw ...` de `Sistema` (código muerto: `traerX` ya lanza). La llamada a `traerX` se conserva porque la excepción es la que valida que exista; donde se puede se usa la instancia que devuelve.

---

## 2. Bugs encontrados y corregidos

| Dónde | Qué pasaba | Arreglo |
|---|---|---|
| `Sistema.calcularRentabilidadNetaUnidad` (CU8) | Restaba la ganancia al total y devolvía el coste de producción | `total - totalCosteProduccion` |
| `UnidadVenta.traerPlatoUnidadVenta` | Comparaba un `Plato` con un `String`: nunca detectaba duplicados | `getNombrePlato().equals(nombrePlato)` |
| `Pedido.totalCantidadPlatoPedido` | Contaba detalles (`total++`), no unidades | `total += getCantidad()` |
| `agregarX` en `Sistema` | El id se incrementaba antes de crear el objeto y quedaban huecos | `lastIdX++` al final |
| `registrarPedido` | Dos fuentes de verdad y se trabajaba con el parámetro | Una sola, con instancias del Sistema |
| CU13 | Mostraba mal el tipo de unidad | Enum `TipoUnidad` |
| `UnidadVenta` (mensaje de duplicado de cocinero) | Leía `cocinero1.dni` directo | `cocinero1.getDni()` (los atributos ahora son `private`) |

---

## 3. Decisiones de diseño

- **`Plato.costoProduccion` no se valida por valor.** El 0 es válido (un producto que se compra hecho, una cortesía), y un plato puede vender por debajo de su costo.
- **`UnidadVenta.responsable` y `Cocinero.especialidadCulinaria`:** alcanza con `requireNonNull`; no se valida nada más.
- **`ReporteVenta` y `ReporteMayoresCanon`:** sin validaciones adicionales.
- **Atributos `private` en las clases padre:** las subclases ya usan getters, así que `protected` no hace falta. (`protected` también era válido; se eligió `private`.)
- **`traerX` internos** (`Festival.traerPedidoFestival`, `Pedido.traerDetallePedido`, `UnidadVenta.traerPlatoUnidadVenta` y `traerPersonalUnidadVenta`) **devuelven `null` a propósito:** se usan en los `agregarX` para detectar duplicados, donde no existir es lo normal. Los `traerX` de `Sistema` sí lanzan excepción, porque ahí no existir es un error.
- **Primitivos:** nunca `requireNonNull`; se valida el valor.

---

## 4. Quedó para después (opcional)

- Método abstracto en `UnidadVenta` que devuelva `TipoUnidad`, en lugar del `instanceof`. Encaja con Fase 2 (interfaces y polimorfismo).
- Decidir si `especialidadCulinaria` pasa a enum (hoy es `String`).
- Limpiar las etiquetas viejas del test: "Festival Birras", "Festival Hamburguesas", "Rango 1 al 5 de Oct", "3 Unidades".
- Los reportes que recorren `values()` de un `HashMap` no tienen orden definido (el orden de las unidades en CU6 es el del mapa). Se resuelve en Fase 2 con `Comparator`, `LinkedHashMap` o `TreeMap`.

---

## 5. Verificación

- Salida de test1 comparada contra la de referencia hasta Turno, Temporada y TipoUnidad (20/11/2026): CU6 a CU13 coinciden.
- Corrida del 21/11/2026, después de las validaciones, `valueOf`, `private` y `setScale`: los montos son los mismos de las corridas anteriores del día; solo cambió el formato (2 decimales en todo). CU6, CU10 y CU13 son coherentes entre sí.
- `calcularAntiguedad()` usa `LocalDate.now()`, así que los **sueldos** cambian con el tiempo. (El canon no depende de la fecha.)

### Cambios de salida respecto de la versión original
- `Cajero.toString` imprime la descripción del turno.
- `TipoUnidad` se imprime como "Food Truck" / "Puesto Desarmable".
- Montos con 2 decimales: `$570000.00` en vez de `$570000.0`, `$0.00` en vez de `$0`; rentabilidad y canon con 2 decimales en vez de 3 (`$9750.00`).

### Valores de referencia para la Fase 2 (salida de test1 del 21/11/2026)
Sirven para comprobar "mismo comportamiento" al hacer epicentro-fase2.

| CU | Resultado |
|---|---|
| CU6 Birras | Taco Truck 570000.00; Burger Truck 700000.00; Beer Stand 675000.00; Delicias Stand 0.00 |
| CU6 Hamburguesas | Taco Truck 1345000.00; Burger Truck 1807500.00; Beer Stand 427500.00; Delicias Stand 0.00 |
| CU8 | Burger Truck 795250.00; Taco Truck 105500.00; Beer Stand 217600.00; Delicias Stand -333000.00 |
| CU9 Burger Truck | Rango Oct 115250.00; Rango Ene 795250.00 |
| CU10 Birras | 1° Burger Truck, 2° Beer Stand, 3° Taco Truck, 4° Delicias Stand |
| CU10 Hamburguesas | 1° Burger Truck, 2° Taco Truck, 3° Beer Stand, 4° Delicias Stand |
| CU11 | Burger Truck: Hamburguesa; Beer Stand: Cerveza Artesanal; Taco Truck: Taco de Carne; Delicias Stand: Ninguno |
| CU13 (ambos festivales) | Burger Truck [Food Truck] 9750.00; Beer Stand [Puesto Desarmable] 9400.00; Taco Truck [Food Truck] 6000.00 |
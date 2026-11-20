Epicentro-Gourmet — Fase 1 (epicentro-fase1)

Refactor de la versión de OO1 (epicentro-original) aplicando los temas 1.1 a 1.6. Objetivo: mismo comportamiento, código más correcto. Referencia: salida de test1 (casos de uso 5 a 13).

Estado al 20/11/2026: EN CURSO. Lo que está aplicado y lo que falta se detalla abajo.

1. Cambios aplicados
1.1 equals / hashCode
equals(Object) con @Override y hashCode con los mismos campos en todas las clases.
Identidad: Personal por dni; Plato y Festival por nombre; UnidadVenta por codigo; ReporteMayoresCanon por codigo; el resto por id.
1.2 Enums
Turno (TARDE, MANANA) en Cajero; el setter se queda porque el turno puede cambiar.
Temporada (VERANO, PRIMAVERA, OTONO, INVIERNO) en Festival.
TipoUnidad (FOODTRUCK, PUESTODESARMABLE) en ReporteMayoresCanon; reemplaza los strings de obtenerUnidadesConMayorCanon.
Cada constante tiene descripcion para mostrar ("Mañana", "Otoño", "Food Truck"); se comparan con ==.
1.3 Excepciones propias y validaciones
Checked: ExceptionYaRegistrado, ExceptionSinRegistro, ExceptionFechaNacimiento, ExceptionDetallePedidoPlatoYaInlcuido, ExceptionMenorZero, ExceptionFechasLimites. Cada una con comentario del porqué.
Objects.requireNonNull en los constructores para las referencias.
Validaciones de valor: id, dni, superficie, cantidad, precios, costos, plus y fechaFin posterior a fechaInicio.
Costo y Cocinero.plusCategoria: el constructor valida llamando al setter.
1.4 Encapsulamiento
List.copyOf en Festival.getLstPedidos, Pedido.getLstDetallePedido, UnidadVenta.getLstPlatos y getLstPersonal.
Atributos de identidad en private final (id, nombre, fechas, referencias).
1.5 BigDecimal
Cocinero.plusCategoria pasó de double a BigDecimal; Sistema.agregarPersonalCocinero recibe BigDecimal.
Operaciones con add, subtract y multiply guardando el resultado; comparaciones con compareTo.
1.6 Map en Sistema
Cinco Map (festivales, personal, unidades, platos, pedidos) con clave natural.
traerX lanza ExceptionSinRegistro; los duplicados se detectan con containsKey y ExceptionYaRegistrado.
Ids con contadores lastIdX; lastIdX++ va después del put, para que un constructor que falle no consuma el id.
Getters con Map.copyOf.
registrarPedido: usa las instancias que devuelven traerFestival y traerUnidadVenta, y guarda el pedido con festival.agregarPedidoFestival y en mapPedidos.
2. Bugs encontrados y corregidos
Dónde	Qué pasaba	Arreglo
Sistema.calcularRentabilidadNetaUnidad (CU8)	Restaba la ganancia al total y devolvía el coste de producción	total - totalCosteProduccion
UnidadVenta.traerPlatoUnidadVenta	Comparaba un Plato con un String: nunca detectaba duplicados	getNombrePlato().equals(nombrePlato)
Pedido.totalCantidadPlatoPedido	Contaba detalles (total++), no unidades	total += getCantidad()
agregarX en Sistema	El id se incrementaba antes de crear el objeto y quedaban huecos	lastIdX++ al final
registrarPedido	Dos fuentes de verdad y se trabajaba con el parámetro	Una sola, con instancias del Sistema
CU13	Mostraba mal el tipo de unidad	Enum TipoUnidad

Cambio de salida esperado: Cajero.toString imprime la descripción del turno, y TipoUnidad imprime "Food Truck" / "Puesto Desarmable".

3. Pendiente (se sigue mañana)

1.3 / 1.4

Sacar requireNonNull de primitivos (FoodTruck, PuestoDesarmable): con int o boolean no valida nada.
Mover los requireNonNull que están antes de super(...) (solo compila en JDK 25).
Unificar el criterio del cero (< 0 vs <= 0) y corregir mensajes (Plato.validarPrecio, UnidadVenta.validarId, "ERRO." en DetallePedido).
Validar Plato.costoProduccion y sus setters; valores y setters de PuestoDesarmable; null en Cocinero.setEspecialidadCulinaria y UnidadVenta.setResponsable.
validarX a private static; atributos protected a private en Personal y UnidadVenta; sin setters en ReporteVenta y ReporteMayoresCanon.
Festival.validarFechaFin con inicio y fin por parámetro y !isBefore (permite festivales de un día).

1.5

BigDecimal.valueOf en lugar de new BigDecimal(double) (superficie) y de new BigDecimal(int).
setScale(2, RoundingMode.HALF_UP) una sola vez al final de sueldos, canon y recaudación.
Constante con nombre para el top 3.

1.6 / Sistema

Borrar los if (traerX(...) == null) throw (código muerto).
Que los traerX internos (Pedido, Festival, UnidadVenta) lancen excepción como los de Sistema, o documentar por qué devuelven null.

Opcionales

Método abstracto en UnidadVenta que devuelva TipoUnidad, en lugar del instanceof.
Decidir si especialidadCulinaria pasa a enum.
Limpiar el test: el "2" suelto y las etiquetas viejas ("3 Unidades", "Rango 1 al 5 de Oct").

4. Verificación
Salida de test1 comparada hasta Turno, Temporada y TipoUnidad (20/11/2026): CU6 a CU13 coinciden.
Falta volver a correrlo después de las validaciones nuevas y de los setScale.
Nota: calcularAntiguedad() usa LocalDate.now(), así que los sueldos cambian con el tiempo.
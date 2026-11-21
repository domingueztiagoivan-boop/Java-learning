# ESTADO DE ESTUDIO JAVA (pegar al inicio de cada sesión nueva)

Última actualización: 21/11/2026, fin de sesión 8 (FASE 1 CERRADA: epicentro-fase1 terminado; sigue Fase 2)

## Cómo se usa
- Abrí una conversación nueva cada día y pegá este archivo completo.
- Escribí "retomamos". Claude responde con un resumen de 3 líneas y sigue.
- Al terminar, decí "cerramos por hoy": Claude te da este archivo actualizado.
- Reemplazá el viejo por el nuevo. No hace falta releer conversaciones.
- REGLA FIJA DE CIERRE: al terminar CADA sesión Claude remarca qué va a
  tener el proyecto final (sección "Proyecto final", con todos los cambios
  acumulados) y actualiza y entrega los DOS archivos: estado_estudio.md (posición, conceptos, pendientes,
  registro) y plan_estudio_java.md (seguimiento de la sección 9 y registro
  de la sección 10). Sin que el alumno tenga que pedirlo. Si el alumno
  pega solo este archivo, igual se actualiza el plan en la medida de lo
  posible y se avisa qué falta sincronizar.

## Perfil del alumno
- Estudiante de Orientación a Objetos 1 (ya cursado), cursará OO2.
- Ubuntu, VS Code (con Copilot activo). Español rioplatense, tono cercano.
- Quiere estudiar acompañado: explicación corta, ejercicios SIN solución,
  pistas antes que respuestas, y corrección de su código.
- Aprende bien escribiendo él mismo y comentando el porqué en el código.
- Meta: dominar Java antes de Spring Boot, SQL, Maven y conectar front + DB.

## Material de referencia
- plan_estudio_java.md: plan completo (Fases 0 a 3, bloques de conceptos,
  checklist final). Es la fuente de verdad del orden de estudio.
- Java.zip: 20 proyectos de OO1 del alumno.
- Proyectos de trabajo de la Fase 1: practicaFinalV2 (paquete modelos:
  Envio, Mesa, Repartidor, Moto, CIclista, Sistema, ExceptionYaRegistrado,
  ExceptionRepartidor; tests en src/test con `package test;`) e INCAANivel2
  (Genero, Pelicula, Incaa).
- Proyecto usado en 1.4: practicaFinalV2 (Sistema, Mesa, Repartidor, Envio;
  prueba en test/Test1.java).
- EpicentroGourmet es el TP más completo de OO1 y es el proyecto de examen
  de cada fase: se refactoriza UNA VEZ AL FINAL DE CADA FASE, en una carpeta
  propia por versión (ver sección Proyecto final, "Método por fases").

## Posición actual
- Fase 0: CERRADA. Git en uso (repo con .gitignore y README, rama main).
  JDK del alumno: OpenJDK 25 (LTS vigente).
- Fase 1: CERRADA el 21/11/2026. Temas 1.1 a 1.6 cerrados en proyectos
  chicos (practicaFinalV2, INCAANivel2) y aplicados en EpicentroGourmet:
  epicentro-fase1/EpicentroGourmet (trabajo del 19 al 21/11/2026), con
  CAMBIOS.MD final. El alumno decidió NO hacer el bug de
  Vector.traerElMenor (20/11/2026): queda como no aplicado en el plan.
- Lo que sigue: Fase 2 (Interfaces, Bloque 2). Al terminar la Fase 2 se
  crea epicentro-fase2 como copia de epicentro-fase1.

## Checklist Fase 1
- [x] 1.1 equals(Object) + hashCode en practicaFinalV2
- [x] 1.2 enums: Genero en INCAANivel2
- [x] 1.3 excepciones propias en practicaFinalV2: ExceptionYaRegistrado
      (checked, constructor con un String que describe qué se duplicó),
      ExceptionRepartidor (checked, recibe capacidad máxima y cantidad),
      Objects.requireNonNull en el constructor de Envio (fecha, mesa,
      repartidor) -> NullPointerException unchecked. Verificado con
      casos 6 a 9 del test.
      Retoques menores pendientes (opcionales): comentarios de "por qué
      checked" arriba de cada clase de excepción con // en vez de ///;
      texto distinto en el catch de NullPointerException; que el mensaje
      de repartidor repetido diga "el repartidor " + patente.
- [x] 1.4 getters que no exponen la lista interna (practicaFinalV2):
      getLstMesas / getLstRepartidores / getLstEnvios devuelven
      List.copyOf(...); setLstX eliminados. Se comprobó que antes un
      clear() vaciaba el sistema y que ahora lanza
      UnsupportedOperationException. Se descubrió que la copia es
      SUPERFICIAL (m.setNumero(999) modificó la Mesa real), así que se
      eliminaron los setters de datos que no deben cambiar (id, fecha,
      mesa, repartidor, kmRecorridos, numero, patenteIdentificador) y se
      pusieron esos atributos como final. Validaciones: capacidad del
      repartidor > 0 (nueva checked ExceptionRepartidorMenorCero) y
      cantPedidosAsignados entre 1 y la capacidad (el constructor de
      Envio valida llamando al setter).
      Retoques pendientes del 1.4 (el alumno dijo que cerró el tema; se
      confirman al arrancar la próxima sesión):
      * ExceptionRepartidor tiene constructor (int, int) y da mensajes
        falsos (ej. cantidad negativa dice "supera la capacidad"). Pasar a
        un constructor con message. Ya lo sabe y lo dejó para después.
      * Confirmar que setKmRecorridos público fue sacado: el km debe
        validarse (> 0) en el constructor con atributo final, sin setter.
      * Confirmar que no quedan getLstX sin copia en INCAANivel2 y demás.
      * Validación cruzada: no bajar la capacidad de un Repartidor por
        debajo de los pedidos ya asignados. Va en Sistema, no en
        Repartidor (Repartidor no conoce los envíos). Pendiente.
      * super() explícito innecesario en el constructor de Envio.
- [x] 1.5 BigDecimal para dinero (practicaFinalV2, cerrado 16/11/2026)
      Hecho: Test2 con experimentos (double 0.1+0.2, BigDecimal con
      String, divide con escala y RoundingMode, equals vs compareTo,
      HashSet, new BigDecimal(0.1), add sin asignar, setScale). Aplicado
      en practicaFinalV2: precios, km y costos son BigDecimal; Moto y
      CIclista calculan costoTotalEnvio con multiply/add y compareTo;
      Sistema compara costos con compareTo (traerEnviosPorFechaYCosto,
      traerRepartidoresEficientes); Test1 crea todo con String.
      Cierre: setScale(2, RoundingMode.HALF_UP) aplicado en el return de
      costoTotalEnvio de Moto y CIclista (una sola vez, al final).
      Retoques pendientes (opcionales, no bloquean):
      * Verificar el costo de MOT222 con 25 km: predecirlo a mano y
        compararlo con lo que imprime Test1 (con 2 decimales).
      * Km como BigDecimal (repasar): el alumno dijo "porque suelen ser
        decimales".
        Eso no alcanza (double también guarda decimales). La razón real:
        los km se multiplican con dinero (precioPorKm); mezclar double y
        BigDecimal obliga a conversiones y arrastra el error binario.
        Pedirle que lo reformule con sus palabras.
      * Bordes: traerEnviosPorFechaYCosto (<= costoMaximo) y el <= 100 de
        motos eficientes: confirmar con el enunciado si es inclusivo y
        probar un caso justo en el límite.
      * Test2: el comentario del HashSet está al revés (size 2 significa
        que los toma como DISTINTOS). Comprobar también que
        hashCode(2.0) != hashCode(2.00). Retocar comentarios ("sumando un
        Double", "parecido a String", nombre BigDouble en minúscula).
      Retoques en Envio/Repartidor/Sistema (ninguno bloquea):
      * validarKmRecorridos: ya corrigió el >= 0 a <= 0. Dejarlo private
        static, agregar Objects.requireNonNull(km), mensaje "mayor a
        cero" y kmRecorridos como final.
      * setCantPedidosAsignados y setCapacidadPedidosMax se llaman desde el
        constructor: hacerlos final o usar un método privado. Mensaje de
        pedidos dice "negativa" pero rechaza 0.
      * Comentarios desactualizados en Envio (requireNonNull es un método
        que lanza NullPointerException; el "FALTA MUCHOS EXCEPTION" ya no
        aplica). super() innecesario.
      * LocalDate.of(2026, 05, 15): ceros a la izquierda son octal; usar
        5, 3, 2.
      * BigDecimal.ZERO en vez de new BigDecimal("0"); new ArrayList<>();
        if (r instanceof Moto m); constante con nombre para el 100 y el
        5 (números mágicos); requireNonNull en parámetros de métodos de
        Sistema y en costoTotalEnvio.
      * Sigue pendiente de 1.4: validación cruzada de capacidad en
        Sistema y revisar getLstX de INCAANivel2. Ya resuelto: el
        constructor de ExceptionRepartidor ahora recibe message y
        setKmRecorridos ya no existe.
- [x] 1.6 Map en lugar de búsquedas con while (practicaFinalV2, cerrado
      17/11/2026)
      Hecho: Test3 con experimentos (put sobre la misma clave reemplaza y
      el size no cambia; get de clave inexistente devuelve null;
      get(99).length() lanza NullPointerException; containsKey; values()).
      Aplicado en Sistema: repartidoresMap (clave: patente String),
      mesasMap (clave: sector + "-" + numero, String) y enviosMap (clave:
      id Integer). traerMesa / traerRepartidor usan containsKey y get y
      lanzan ExceptionSinRegistrar (checked, creada por él) si no existe.
      agregarMesa / agregarRepartidorX chequean duplicados con containsKey
      (ExceptionYaRegistrado). Ids generados con contadores lastIdMesa,
      lastIdRepartidores, lastIdEnvios (nunca size()+1 ni get(size()-1)).
      Getters con Map.copyOf. Reportes con for sobre values(). Salida de
      Test1 verificada completa (reportes 4 y 5, tests 6 a 9, 3800.00).
      Cambios.MD actualizado con una sección "Maps por Listas".
      Retoques pendientes (ninguno bloquea):
      * Frase de justificación de la clave: nunca la escribió completa.
        Pedirle: "uso sector-numero porque ___" y por qué el guion (mesa 11
        del sector 1 vs mesa 1 del sector 11 darían la misma clave sin él).
      * ExceptionSinRegistrar: todavía no se revisó el archivo (comentario
        del porqué de checked con //, constructor con message).
      * agregarMesa / agregarRepartidorMoto / agregarRepartidorCiclista
        siguen declarando throws ExceptionSinRegistrar sin lanzarla: sacarlo
        de la firma y de los catch de Test1.
      * traerEnviosPorRepartidor: el if (traerRepartidor(...) == null) throw
        new NullPointerException() es código muerto (traerRepartidor ya
        lanza ExceptionSinRegistrar); sacarlo y limpiar el throws. Ese
        método y los otros "traer específicos" se revisan al terminar.
      * agregarEnvio: si mesa o repartidor llegan null, explota con NPE sin
        mensaje antes de validar; agregar Objects.requireNonNull.
      * Atributos de Sistema sin private (regla de 1.4); pueden ser final.
      * Typos en mensajes: "Repatidor", "encuntra", "encunetra", "EL".
      * int i = 0 sobrante en traerMesa (ya sacó el de traerRepartidor).
      * Cambios.MD tiene imprecisiones: Map.copyOf es un método estático
        (Map.copyOf(mapa)), no map.copyOf(); values() devuelve una
        Collection de valores, no una "colección con toda la info"; el
        título "Maps por Listas" es confuso; falta anotar que get devuelve
        null si la clave no existe (y el NPE que eso causa) y que put con
        una clave existente reemplaza el valor. "Los maps no son
        ordenados" vale para HashMap, no para todos los Map.
      * Un "2" suelto apareció en la salida un par de veces (de un println
        olvidado en alguna clase); en la última salida ya no estaba.
- [x] Retoques de 1.4, 1.5 y 1.6 en practicaFinalV2 (cerrados 18/11/2026, S6)
      Hecho y confirmado por el alumno: ExceptionSinRegistrar con comentario
      del porqué de checked (error previsible que quien llama puede
      resolver, no un error de programación); throws sobrante sacado de
      agregarX y de los catch de Test1; código muerto de
      traerEnviosPorRepartidor sacado (y su throws); atributos de Sistema
      private final (contadores private, sin final); requireNonNull en
      agregarEnvio (sin el if); typos de mensajes; int i sobrante;
      validación cruzada de capacidad en Sistema
      (cambiarRepartidorCapacidadPedidosMax: traerRepartidor una sola vez,
      compara contra el MAYOR envío, < deja pasar el límite, lanza
      ExceptionRepartidor con el mayor en el mensaje; Test1 con caso que
      falla [4] y caso en el límite). getLstX de INCAANivel2: decisión del
      alumno de no tocarlos y resolverlos en el refactor de EpicentroGourmet.
      Nota: Claude no vio el código final de algunos retoques
      (requireNonNull, retorno de cambiarRepartidorCapacidadPedidosMax,
      typos, comentario final de ExceptionSinRegistrar). Quedaron cerrados
      por palabra del alumno; si reaparece alguno al aplicarlo en
      EpicentroGourmet, se corrige ahí.
      Opcionales de 1.5 que NO se hicieron (se retoman al aplicarlos en
      EpicentroGourmet): predecir a mano el costo de MOT222 con 25 km;
      reformular por qué km son BigDecimal (se multiplican con dinero);
      bordes del <= (traerEnviosPorFechaYCosto y el <= 100); comentarios
      de Test2 (HashSet al revés); ceros a la izquierda en LocalDate.of.
      Pendiente menor: Cambios.MD con las imprecisiones anotadas en 1.6.
- [ ] Bug de Vector.traerElMenor (cantidad < 0 debería ser == 0, y
      lanzar excepción en vez de imprimir). NO APLICADO: decisión del
      alumno (20/11/2026); no insistir.
- [x] FASE 1 FINAL: epicentro-fase1 (CERRADA 21/11/2026; trabajo del 19 al
      21/11/2026). Carpeta epicentro-fase1/EpicentroGourmet. Referencia de
      "mismo comportamiento": salida de test1 (casos de uso 5 a 13).
      APLICADO:
      * 1.1 equals(Object) + hashCode en todas las clases (Personal por
        dni, Plato y Festival por nombre, UnidadVenta por codigo, el resto
        por id).
      * 1.2 enums Turno, Temporada, TipoUnidad (constantes con descripcion,
        comparacion con ==).
      * 1.3 excepciones propias (YaRegistrado, SinRegistro, FechaNacimiento,
        DetallePedidoPlatoYaInlcuido, MenorZero, FechasLimites) con
        comentario del porque; requireNonNull solo en referencias y
        despues de super(...); validacion de valor en primitivos con el
        criterio del cero decidido campo por campo; Festival.validarFechaFin
        con !isBefore (permite festivales de un dia).
      * 1.4 List.copyOf en Festival, UnidadVenta y Pedido; atributos de
        Personal y UnidadVenta pasados de protected a private (las
        subclases usan getters); constructor y setter de Costo y Cocinero
        comparten validacion.
      * 1.5 Cocinero.plusCategoria en BigDecimal; BigDecimal.valueOf en
        lugar de new BigDecimal(double/int); setScale(2, HALF_UP) UNA vez
        al final de sueldos, canon, rentabilidad y recaudacion (incluido
        el caso sin ventas: "$0.00"); constante con nombre para el top 3.
      * 1.6 Sistema con cinco Map, traerX con ExceptionSinRegistro,
        duplicados con containsKey, lastIdX incrementado DESPUES del put,
        Map.copyOf. registrarPedido usa las instancias del Sistema y agrega
        el pedido al festival y al mapPedidos. Borrados los
        if (traerX(...) == null) throw (codigo muerto), conservando la
        llamada a traerX porque la excepcion es la que valida.
      * Bugs encontrados y corregidos: CU8 restaba la ganancia en vez del
        coste; traerPlatoUnidadVenta comparaba Plato con String;
        totalCantidadPlatoPedido contaba detalles y no unidades; ids que
        se salteaban si el constructor fallaba; registrarPedido dejaba el
        pedido en dos lugares desincronizados; CU13 mostraba mal el tipo.
      DECISIONES DEL ALUMNO (21/11/2026):
      * Plato.costoProduccion sin validacion de valor (el 0 es valido).
      * responsable (UnidadVenta) y especialidadCulinaria (Cocinero): solo
        requireNonNull.
      * ReporteVenta y ReporteMayoresCanon: sin validaciones adicionales.
      * Los traerX internos (Festival.traerPedidoFestival,
        Pedido.traerDetallePedido, UnidadVenta.traerPlatoUnidadVenta /
        traerPersonalUnidadVenta) siguen devolviendo null: se usan en los
        agregarX para detectar duplicados. Los de Sistema lanzan excepcion.
      * Atributos de las clases padre en private (aunque se le dijo que
        protected tambien era valido).
      * Los numeros sueltos ("2") de la salida de test1 son saltos de
        linea del propio test; se dejan.
      VERIFICACION: salida de test1 comparada con la de referencia hasta
      Turno/Temporada/TipoUnidad (20/11). Corrida del 21/11: montos
      identicos a las corridas anteriores del dia, solo cambio el formato
      (2 decimales). Valores de referencia para la Fase 2 en CAMBIOS.MD.
      Claude NO vio el zip final: lo confirmado por codigo llega hasta el
      zip EpicentroGourmet.zip del 21/11 (revisado por diff); lo posterior
      (FoodTruck con requireNonNull despues de super, borrado de los
      if == null en Sistema, validarX private static, setScale) se dio por
      bueno por palabra del alumno y por la salida de test1.
      QUEDO PARA DESPUES (opcional, no bloquea):
      * Metodo abstracto en UnidadVenta que devuelva TipoUnidad (adios
        instanceof); encaja en Fase 2 (polimorfismo).
      * Decidir si especialidadCulinaria pasa a enum.
      * Etiquetas viejas del test ("Festival Birras", "Festival
        Hamburguesas", "Rango 1 al 5 de Oct", "3 Unidades").
      * Reportes sin orden definido (values() de un HashMap): Comparator,
        LinkedHashMap o TreeMap en Fase 2.
      * Cierre en Git: commit de la fase y, opcional, `git tag
        fase1-cerrada`.

## Proyecto final: refactor completo de EpicentroGourmet
- Decisión del alumno (13/11/2026): aprender por partes en proyectos chicos
  y aplicar todo en EpicentroGourmet. Esto reemplaza al "proyecto
  integrador" de la Fase 3 del plan (sigue valiendo su estructura en
  capas, tests y Maven).
- CAMBIO (18/11/2026, decisión del alumno): en vez de refactorizar
  EpicentroGourmet una sola vez al final de todo, se refactoriza AL
  FINAL DE CADA FASE, con las herramientas nuevas de esa fase sumadas a
  las anteriores.
### Método por fases (EpicentroGourmet es el actor principal)
- Una carpeta por versión, sin pisar las anteriores:
  * epicentro-original: la versión de OO1, intacta (con tag o rama Git
    `epicentro-original` para poder comparar).
  * epicentro-fase1: copia del original + 1.1 a 1.6 (equals/hashCode, enum,
    excepciones propias, encapsulamiento, BigDecimal, Map).
  * epicentro-fase2: copia de epicentro-fase1 + lo nuevo de la Fase 2
    (interfaces, Comparator, genéricos, streams, JUnit, patrones...).
  * (y así: cada versión parte de una copia de la anterior; nunca se
    edita una carpeta ya cerrada.)
- Trabajo dentro de cada carpeta: un tema por vez, en el orden de la lista
  acumulada, con un commit por tema.
- Corrección: el alumno escribe el código y lo pega (Claude no ve el repo);
  Claude revisa con pistas, usando la lista acumulada como checklist de
  qué debe tener cada clase. Cada versión debe mantener el mismo
  comportamiento que la anterior (se compara con la salida del test).
- Cuando una versión queda cerrada se actualiza la lista "QUÉ VA A TENER
  EL PROYECTO FINAL" marcando lo que quedó aplicado.
### QUÉ VA A TENER EL PROYECTO FINAL (lista acumulada)
Cada tema cerrado agrega acá lo que hay que aplicar en EpicentroGourmet.
Estado: [aprendido] = ya se estudió y aplicó en un proyecto chico;
[por aprender] = todavía no se vio. Al 21/11/2026 los de 1.1 a 1.6 están
aplicados en epicentro-fase1 (CERRADA; ver "FASE 1 FINAL" en el Checklist
y CAMBIOS.MD).

1.1 equals / hashCode  [aprendido]
  - Reemplazar todos los equals(X x) por equals(Object) con @Override.
  - Definir hashCode con los mismos campos que equals (el id).
  - Verificar con HashSet que no entren repetidos.

1.2 enums  [aprendido]
  - Reemplazar clases o valores fijos (tipos, estados, turnos, roles) por
    enum, con atributos final y comparación con ==.

1.3 excepciones propias  [aprendido]
  - Cambiar todos los `new Exception(...)` por clases propias
    (checked para errores esperables; unchecked para errores de
    programación).
  - Constructor de la excepción que reciba un `message` (no datos sueltos
    que armen un texto engañoso).
  - Objects.requireNonNull al principio de cada constructor.
  - Cada excepción en su propio archivo, con un comentario del porqué de
    checked o unchecked.

1.4 encapsulamiento de colecciones  [aprendido]
  - Todos los getLstX devuelven List.copyOf(...).
  - Eliminar todos los setLstX.
  - Eliminar los setters de datos que no deben cambiar (id, fechas,
    referencias a otras entidades, km, identificadores) y poner esos
    atributos como private final.
  - Constructor y setters con la misma validación (un único método
    privado de validación); atributos siempre private.
  - Reglas que cruzan entidades (ej. capacidad de un repartidor vs
    pedidos ya asignados) en la clase Sistema, no en la entidad.

1.5 BigDecimal  [aprendido]
  - Dinero y costos con BigDecimal, creados con String (nunca desde un
    double); atributos, parámetros y retornos BigDecimal.
  - Operar con add/subtract/multiply y GUARDAR siempre el resultado
    (inmutable).
  - Comparar con compareTo (== 0, < 0, > 0), nunca equals ni operadores;
    equals compara valor y scale (2.0 != 2.00).
  - No usar BigDecimal como clave de Set/Map (HashSet los trata como
    distintos); si hace falta, normalizar con setScale.
  - divide siempre con escala y RoundingMode (HALF_UP); decidir los
    decimales (2 para pesos) y redondear UNA vez al final del cálculo.
  - Sin números mágicos: precios y límites como constantes con nombre;
    BigDecimal.ZERO en vez de new BigDecimal("0").
  - requireNonNull en parámetros BigDecimal para evitar NPE sin mensaje.

1.6 Map  [aprendido]
  - Reemplazar toda lista con búsqueda por clave (while + índice) por un
    Map<K,V>: clave = atributo natural que no cambia (patente, id, o
    clave compuesta armada con separador que evite colisiones).
  - traerX con get + containsKey; si no existe, lanzar excepción propia
    checked (ej. ExceptionSinRegistrar), no devolver null.
  - Duplicados con containsKey antes del put (ExceptionYaRegistrado); el
    chequeo de agregarX NO usa traerX.
  - Ids con contador propio (lastIdX), nunca size()+1 ni get(size()-1).
  - Getters con Map.copyOf (copia inmutable y superficial).
  - Reportes con for sobre values(); no depender del orden del HashMap.
  - La clave necesita equals/hashCode bien hechos (String e Integer ya
    los tienen); nunca BigDecimal como clave.
  - Validar null de parámetros antes de usarlos (requireNonNull).

Lecciones nuevas al aplicarlo en EpicentroGourmet (20/11/2026)  [aprendido]
  - requireNonNull solo sirve con referencias (String, LocalDate, objetos,
    enums). Con int, long, double o boolean hace boxing y nunca falla: en
    primitivos se valida el VALOR (> 0, >= 0, rango), no el null.
  - Un enum tampoco impide null: requireNonNull igual.
  - Constructor y setter comparten UN metodo de validacion private (static
    si es posible), no publico ni de instancia (no llamar desde el
    constructor un metodo sobreescribible).
  - Decidir el cero campo por campo (< 0 si el cero es valido, <= 0 si no)
    y que el mensaje diga lo mismo que el codigo.
  - requireNonNull antes de super(...) solo compila desde JDK 25; ponerlo
    despues del super para que compile en versiones anteriores y no repetir
    lo que ya valida la clase base.
  - Validar con la INSTANCIA del Sistema: containsKey o traerX solo prueban
    que existe una con ese nombre; usar siempre lo que devuelve traerX, no
    el parametro, y guardar el pedido en un solo lugar logico.
  - lastIdX++ va despues del put (y despues de new, que puede lanzar), asi
    el id no se salta.
  - El tipo de una unidad se decide en la propia clase (metodo abstracto
    que devuelve el enum), no con instanceof desde afuera (mejora opcional).
  - Los traerX internos (listas chicas de una entidad) pueden seguir con
    while. DECISION (21/11/2026): devuelven null a proposito, porque los
    agregarX los usan para detectar duplicados (ahi no existir es lo
    normal). Los de Sistema lanzan excepcion (ahi no existir es un error).

Lecciones del cierre de epicentro-fase1 (21/11/2026)  [aprendido]
  - Si traerX ya lanza excepcion, un `if (traerX(...) == null) throw` es
    codigo muerto. Se borra el if pero NO la llamada: la excepcion es la
    que valida que exista. Mejor todavia: guardar lo que devuelve y usar
    esa instancia en vez del parametro.
  - new BigDecimal(double) arrastra el error binario (0.1 -> 0.1000...055);
    BigDecimal.valueOf(double) usa el texto "0.1". Con int, new
    BigDecimal(int) es exacto: valueOf es por consistencia.
  - setScale devuelve un BigDecimal NUEVO: hay que usar lo que devuelve. Si
    un camino devuelve BigDecimal.ZERO (scale 0) sin pasar por setScale, la
    salida mezcla "$0" con "$570000.00". Un formato inconsistente en la
    salida delata un camino que no pasa por el redondeo.
  - Festival de un dia: la fecha fin no puede ser ANTERIOR al inicio
    (!isBefore), no "posterior" (isAfter).
  - Atributos de la clase padre private + getters protegen la validacion;
    protected tambien es valido, pero si los hijos ya usan getters no hace
    falta. Al pasar a private hay que buscar usos directos (cocinero.dni ->
    getDni()).
  - Un enum puede sobreescribir toString() y devolver la descripcion, asi
    la salida no depende de acordarse de llamar a getDescripcion().
  - Decidir que NO validar tambien es una decision de diseno: costoProduccion
    con 0 valido. Documentarlo en CAMBIOS.MD.
  - Los numeros sueltos en una salida de test pueden ser \n del propio
    test; confirmarlo antes de "arreglar".

Más adelante  [por aprender]
  - Streams y Optional en todos los reportes.
  - Reportes con orden definido (HashMap no ordena): LinkedHashMap,
    TreeMap o Comparator al listar.
  - Clave compuesta de la mesa como record (ClaveMesa(sector, numero)) en
    lugar del String "sector-numero".
  - Interfaces (ej. CalculadorCosto) y patrones (Strategy, Factory,
    Builder); inyección de dependencias por constructor.
  - Repositorio<T> genérico, estructura en capas (modelo, repositorio,
    servicio, ui), JUnit y Maven en lugar de `main` con println.
  - Pasar clases "solo datos" a record donde corresponda.
  - Arrastrado de la Fase 1 (opcionales): metodo abstracto en UnidadVenta
    que devuelva TipoUnidad (polimorfismo en vez de instanceof);
    especialidadCulinaria como enum (decidir); etiquetas viejas del test.

Metodo de versiones (decision 20/11/2026): alcanzan las carpetas (epicentro-original,
epicentro-fase1...). Un tag de Git es opcional y complementario: al cerrar cada
fase, `git tag fase1-cerrada` marca el commit exacto.

## Conceptos ya trabajados
- equals(X x) es una sobrecarga, no sobreescribe Object.equals.
- hashCode: filtro rápido que elige el cajón; equals es el juez final.
  Regla en un solo sentido: equals => mismo hashCode. Mismos campos en
  ambos. Colisiones permitidas. HashSet: usa hashCode para el cajón y
  equals para detectar repetidos.
- Estructura de equals: mismo objeto, instanceof, casteo, comparar campo
  identificador.
- Enum: cada constante es un único objeto compartido por todo el programa
  (por eso se compara con == y sus atributos son final, sin setters).
- Excepciones: checked (extends Exception) = error esperable que quien
  llama puede resolver; el compilador obliga a try/catch o throws.
  Unchecked (extends RuntimeException) = error de programación (ej. null
  inesperado); no obliga a nada y no va en throws. Diferencia: extends va
  en la definición de la clase, throws en la firma del método, throw new
  lanza. super(...) solo dentro del constructor de la excepción, para
  armar el mensaje. new Exception es la genérica, no "la checked".
  Objects.requireNonNull es un MÉTODO; lo que lanza es NullPointerException.
  Un try puede tener varios catch (uno por tipo) o uno con |; los
  específicos van antes que los genéricos (si no, no compila). En el catch
  va el tipo de la excepción, no el método que la lanza. Cada clase
  pública va en su propio archivo. Validar null al principio del
  constructor, antes de asignar campos o llamar a otros métodos.
  Int + String se concatena con + sin toString().
- Encapsulamiento de colecciones: un getter que devuelve la lista interna
  deja borrar o agregar saltándose las validaciones. Opciones:
  new ArrayList<>(l) (copia modificable), List.copyOf(l) (copia
  inmutable, lanza UnsupportedOperationException), unmodifiableList(l)
  (vista sin copia que refleja cambios posteriores). La copia es
  superficial: la lista es nueva pero los objetos son los mismos; la
  solución habitual es objetos inmutables (sin setters, final; luego
  record), no el deep copy. El id es la identidad: no se cambia ni se
  reutiliza. Una regla que involucra varias entidades vive en quien las
  conoce (Sistema). El constructor debe cumplir las mismas reglas que el
  setter (mejor un único método de validación). No llamar desde un
  constructor a un método sobreescribible.
- BigDecimal: double/float guardan en binario y 0.1 no es exacto (0.1+0.2 =
  0.30000000000000004; sumar 0.1 diez veces no da 1.0). BigDecimal guarda
  dígitos decimales exactos. Se crea con String; new BigDecimal(0.1) trae
  el error binario completo del double. Inmutable: add/multiply devuelven
  objeto nuevo, hay que guardarlo; ignorar el resultado no da error pero
  pierde el cálculo. Scale: multiply suma los scales (2+2=4), add toma el
  mayor. divide sin parámetros exige resultado exacto (si no, lanza
  ArithmeticException); con escala y RoundingMode.HALF_UP sube solo si el
  dígito descartado es 5 o más (4.664 -> 4.66). setScale fija los
  decimales. equals compara valor y scale; compareTo solo el valor
  (devuelve -1, 0 o 1, no una diferencia); por eso compareTo(...) == 0
  para igualdad de dinero. En un HashSet 2.0 y 2.00 entran como dos
  elementos. Un compareTo mal parentizado (cerrar el paréntesis antes del
  <= 0) y una condición invertida (>= en vez de <=) son errores típicos.
- Map<K,V>: guarda pares clave -> valor; las claves no se repiten. put con
  una clave existente REEMPLAZA el valor (el size no cambia) y devuelve el
  valor anterior (o null). get de una clave inexistente devuelve null (no
  lanza nada); pedirle un método a ese null da NullPointerException
  (probado con get(99).length()). containsKey(k) responde true/false sin
  lanzar. values() devuelve una Collection solo con los valores (sin
  claves); containsValue compara contra los VALORES (un int contra objetos
  Mesa nunca coincide y compila igual). HashMap no tiene orden ni noción
  de "último elemento" (get(size()-1) no sirve); busca la clave con
  hashCode y equals, igual que HashSet. Map.copyOf(m) es un método
  estático que devuelve copia inmutable y superficial. Para identificar
  con dos datos hace falta UNA clave: se arma un String con separador
  (sector + "-" + numero). Un int es primitivo y nunca es null: chequear
  "int != null" no compila; el null está en el RESULTADO de get. En
  traerX no existir es un error (excepción); en agregarX no existir es lo
  normal y el error es que ya exista (por eso agregarX usa containsKey y
  no traerX). Los ids se generan con un contador aparte porque el Map no
  tiene "último". La NullPointerException explota lejos de la causa (en
  la línea de quien llama); una excepción propia la deja clara.
- Alcance (scope): una variable declarada entre las llaves de un try existe
  solo ahí (igual que en un if o un for); no depende de si puede lanzar
  excepción. Para usarla afuera se declara antes del try, o se usa adentro.
- Java no deja capturar una excepción checked en un catch si el try no
  puede lanzarla (error de compilación): es la señal de que sobra un
  throws. Un método que informa los errores con excepciones y nunca
  devuelve false no necesita retornar boolean.
- Después de un throw o un return el else sobra. Objects.requireNonNull ya
  chequea solo (no va dentro de un if) y va al principio, antes de usar
  el parámetro.
- Concatenación de String: "1" + "11" y "11" + "1" dan ambos "111"; por eso
  la clave de la mesa lleva guion ("1-11" distinto de "11-1"). Sin guion,
  containsKey rechazaría una mesa que no está repetida.
- Validación cruzada de capacidad: se compara contra el MAYOR envío (cada
  envío se valida contra la capacidad por separado, no suman); con <
  una capacidad igual al mayor pasa, que es lo correcto.
- Lectura de errores: empezar por el primer error (línea más arriba); los
  de abajo suelen ser en cascada.
- "Incorrect Package" en VS Code: problema de raíz del proyecto (la
  carpeta abierta es Java), no del código.
- Depuración: mostrar el estado con prints etiquetados; Ctrl+Shift+F busca
  en todo el proyecto.
- Errores recurrentes: copiar plantillas de relleno sin reemplazar,
  mezclar método con excepción, paréntesis en la declaración de clase,
  ///(Javadoc) en vez de //, código de Copilot sin entender.
- Práctico: F5 en VS Code ejecuta la última clase con main; un test nuevo
  en src/test necesita `package test;`. F2 renombra clases/variables.

- Boxing en requireNonNull: Objects.requireNonNull(unInt, ...) convierte el
  int en Integer, que nunca es null; no valida nada. Con primitivos se
  valida el valor.
- Un enum se declara con `enum` (minuscula), en su propio archivo; la
  constante es el valor (Turno.TARDE), por eso un getTurno() dentro del
  enum no tiene sentido; con atributo (descripcion) sirve para mostrar; se
  compara con ==.
- containsKey/traerX validan por equals (aqui, el nombre): un objeto
  distinto con el mismo nombre pasa el chequeo. Hay que usar la instancia
  guardada en el Sistema.
- Un error "unreported exception Object" apunta a una excepcion que no se
  pudo resolver (clase o throws roto en la clase base); mirar el PRIMER
  error en rojo de la clase de la que se hereda.
- Statements antes de super(...): permitido en JDK 25 (si no usan this); no
  compila en JDK 24 o anterior.
- Java en el sandbox de Claude: solo JRE 21, sin javac; Claude revisa leyendo
  y el alumno corre el test.

- Una llamada a un metodo que lanza excepcion valida por si sola aunque no
  uses el resultado: `traerFestival(nombre);` sin if comprueba que exista.
  Por eso se borra el `if (... == null)` y no la llamada.
- new BigDecimal(double) vs BigDecimal.valueOf(double): valueOf pasa por el
  texto del double y evita el error binario. setScale devuelve un objeto
  nuevo. BigDecimal.ZERO tiene scale 0 e imprime "0"; sin setScale no se
  alinea con "570000.00".
- !isBefore(inicio) == "fin >= inicio" (permite el mismo dia);
  isAfter(inicio) == "fin > inicio".
- private en la clase padre + getters: las subclases no tocan los campos
  directo. protected sigue siendo valido; es decision de diseno.
- Un enum puede tener toString() propio (devolver la descripcion).
- El canon depende de superficie y costos; solo el sueldo del Cajero usa
  calcularAntiguedad() (LocalDate.now()), asi que los sueldos cambian con
  el tiempo y el canon no.

## Siguiente paso concreto
1. CIERRE DE LA FASE 1 en Git (el alumno): commit de epicentro-fase1 con
   CAMBIOS.MD, y opcional `git tag fase1-cerrada`. Las carpetas alcanzan; el
   tag es complementario. No se edita mas epicentro-fase1.
2. FASE 2 / Bloque 2 (Interfaces): empezar en practicaFinalV2 con una
   interfaz tipo CalculadorCosto en Repartidor (Moto y CIclista como
   implementaciones; sumar una tercera, ej. Dron, sin tocar el Sistema).
   Orden de la Fase 2 en plan_estudio_java.md (Bloques 2 a 13).
3. Al terminar la Fase 2: crear epicentro-fase2 como COPIA de
   epicentro-fase1 y aplicar lo nuevo (interfaces, Comparator, genericos,
   streams, JUnit...). Comparar con los valores de referencia de CAMBIOS.MD.
   Arrastrar los opcionales de la Fase 1 (metodo abstracto con TipoUnidad,
   especialidadCulinaria enum, orden de los reportes).
4. Al arrancar la sesion 9: si el alumno quiere, una sola pregunta de
   repaso de Fase 1 (por que se borra el if pero no la llamada a traerX).
   Respetar el RITMO de las Notas para Claude: sin interrogatorio.

## Notas para Claude
- No dar la solución directa: primero pistas. Pedir que explique con sus
  palabras.
- Advertirle de código generado por Copilot/Eclipse.
- A veces el alumno pega código recortado o capturas. Pedir el archivo
  completo o el mensaje exacto del error si dudás.
- Mostrar sintaxis con nombres de relleno y avisar que son relleno; el
  alumno a veces los copia literal.
- Pedirle una frase de justificación en cada decisión de diseño.
- El sandbox de Claude tiene Java 21; el alumno usa Java 25.
- CIERRE DE SESIÓN (obligatorio, cada día): (1) actualizar y entregar los
  dos archivos (estado y plan) con present_files, sin esperar a que lo
  pida; (2) REMARCAR "QUÉ VA A TENER EL PROYECTO FINAL": agregar al
  listado lo del tema de hoy, revisar que los temas anteriores sigan
  bien descritos y decirle al alumno en pocas líneas qué suma hoy al
  refactor de EpicentroGourmet; (3) listar en 3 líneas qué cambió.
- Claude no puede ver el repo de GitHub ni VS Code: pedir el código o el
  mensaje exacto del error.
- Cuando un comentario del alumno en el código dice algo que contradice
  lo que probó (ej. "es una copia"), señalarlo: los comentarios mal
  escritos confunden después.
- El alumno razona bien y a veces explica lo correcto respondiendo otra
  pregunta: verificar que contestó lo que se le preguntó.
- En Map se trabó con la mecánica de "traer antes de agregar" y con
  confundir null con el parámetro int. Funciona bien: dejar que corra el
  código y lea el primer error, y cuando se frustre mostrarle que el
  círculo es aparente. Sigue copiando plantillas sin cambiar el mapa
  (traerRepartidor buscó en mesasMap): remarcarlo.
- RITMO (pedido del alumno, 18/11/2026): el alumno entiende y aplica muchas
  correcciones sin comentarlas; contestar todo se le hace pesado. No exigir
  una explicación por cada punto: si dice que algo ya lo corrigió, darlo
  por bueno. Pedir explicación o predicción solo en decisiones de diseño
  importantes o cuando la respuesta no coincide con lo que se ve. Menos
  preguntas por turno, correcciones más cortas. Mantener la exigencia con
  el código (le gusta), no con el interrogatorio.
- Sandbox (20/11/2026): Java 21 solo JRE, sin javac. Claude no puede
  compilar ni correr EpicentroGourmet: revisa leyendo el zip (descomprimir
  en /home/claude) y pide la salida del test. El alumno usa JDK 25 y a
  veces compila cosas que fallan en versiones anteriores: avisarlo.
- No marcar como pendiente lo que el plan no exige: 1.6 se aplico a las
  colecciones de Sistema; las listas chicas internas con while son
  aceptables, lo que debe unificarse es el comportamiento de los traerX
  (excepcion vs null). Antes de afirmar "el plan dice X", releer el plan (el
  20/11 Claude hablo de "tag" cuando el plan dice carpeta; el estado
  decia "tag/rama" y carpeta). Decision del alumno: alcanzan las carpetas.
- El alumno decidio (20/11/2026) no hacer el bug de Vector.traerElMenor.
  Respetarlo y dejarlo registrado como no aplicado, sin insistir.
- CAMBIOS.MD: el alumno prefiere que Claude arme el resumen final con los
  cambios aplicados (hecho el 20/11/2026 y cerrado el 21/11/2026 con la
  Fase 1; incluye valores de referencia para comparar en la Fase 2). Al
  cerrar cada fase se arma uno nuevo en la carpeta de esa version.
- Cuando el alumno da algo por corregido, darlo por bueno; pero revisar el
  zip nuevo contra el anterior (diff) para confirmar que de verdad esta.
- Cuando avisa que se queda sin tokens/tiempo: no contestar largo; el
  cierre se hace al volver, pidiendo los archivos de nuevo.

- Cierre de Fase 1 (21/11/2026): Claude NO vio el zip final; lo que llego
  despues del ultimo zip se dio por bueno por palabra del alumno y por la
  salida del test. Dejarlo dicho en los archivos y avisar que revise antes
  del commit: FoodTruck (requireNonNull despues de super, sin el de
  boolean), los if (traerX == null) borrados en Sistema, validarX private
  static, setScale en sueldos, y si hizo (o no) los opcionales.
- Verificar antes de afirmar: el 21/11 Claude dijo que el canon podia variar
  con calcularAntiguedad() y era falso (solo el sueldo del Cajero lo usa).
  Revisar el codigo antes de dar una causa. Tambien: el alumno trabaja en
  VS Code (ver perfil); el proyecto trae .classpath/.project de Eclipse, asi
  que no asumir Eclipse al sugerir pasos del IDE.
- Cuando el alumno corrige y pega la salida del test, leer el FORMATO
  ademas de los valores: "$0" junto a "$570000.0", o 3 decimales en el
  canon, delataron que faltaba setScale en dos caminos.

## Registro de sesiones
- S1 (13/11/2026): armado del plan; 1.1 y 1.2 completos. EpicentroGourmet
  definido como proyecto final.
- S2 (14/11/2026): 1.3 completo (excepciones propias checked y unchecked,
  null con requireNonNull, múltiples catch).
- S3 (15/11/2026): 1.4 completo (List.copyOf, copia superficial, setters
  eliminados, final, validaciones de pedidos y capacidad). Quedan retoques
  menores anotados arriba. Plan y estado actualizados. Se armó la lista
  acumulada "Qué va a tener el proyecto final" (1.1 a 1.4 + pendientes).
- S4 (16/11/2026): 1.5 BigDecimal completo (setScale aplicado al final). Test2 con todos los
  experimentos y aplicación real en practicaFinalV2 (Envio, Repartidor,
  Moto, CIclista, Sistema y Test1). Cerrado con setScale en los costos;
  queda repasar el porqué de km. El alumno resolvió solo errores de
  paréntesis, bug de condición invertida y de import (Set/HashSet) y
  armó Cambios.MD. Nota: tendió a copiar frases mías en comentarios y a
  sacar una conclusión al revés (HashSet size 2); pedir siempre que
  reescriba con sus palabras y que prediga antes de correr.
- S5 (17/11/2026): 1.6 Map completo. Test3 con experimentos de put/get/
  containsKey/values, NPE con get(99).length(). En practicaFinalV2, Sistema
  pasó a tres Map (patente, "sector-numero", id), traerX con excepción
  ExceptionSinRegistrar, duplicados con containsKey, ids con contadores
  lastIdX y reportes sobre values(). Resolvió solo los errores en cascada
  (traerRepartidor buscaba en mesasMap) y dejó la salida de Test1
  verificada. Armó la sección de Map en Cambios.MD (con imprecisiones
  anotadas). Quedan retoques menores listados en 1.6.
- S6 (18/11/2026): cierre de los retoques de Fase 1 en practicaFinalV2.
  Verificación de arranque: razonó bien por qué el guion en la clave de la
  mesa ("11"+"1" = "1"+"11") y predijo el test 8. Se sacó el throws
  sobrante en agregarX, el código muerto de traerEnviosPorRepartidor, y se
  agregaron private final en Sistema y requireNonNull en agregarEnvio.
  Armó cambiarRepartidorCapacidadPedidosMax (validación cruzada contra el
  mayor envío, excepción propia, sin println). Aclaró el alcance de una
  variable dentro de try. Explicó que ExceptionSinRegistrar es checked por
  ser un error previsible y no de código. Decisión de método: EpicentroGourmet
  se refactoriza al final de cada fase en carpetas separadas
  (epicentro-original, epicentro-fase1, epicentro-fase2...). Pidió un
  ritmo con menos interrogatorio (ver Notas para Claude).
- S7 (19 y 20/11/2026): FASE 1 FINAL en epicentro-fase1. El alumno aplico 1.1 a
  1.6 en EpicentroGourmet y Claude reviso zip por zip. Bugs hallados y
  corregidos: CU8 (restaba ganancia en vez de coste), traerPlatoUnidadVenta
  (Plato vs String), totalCantidadPlatoPedido (contaba detalles), ids que
  se salteaban, registrarPedido con instancia del parametro y pedido en dos
  lugares, CU13 con tipo mal. Aprendio: enums Turno/Temporada/TipoUnidad,
  excepciones MenorZero y FechasLimites, requireNonNull no sirve con
  primitivos (boxing), validar con la instancia del Sistema, orden del
  lastIdX++, error en cascada "unreported exception Object". Decisiones:
  carpetas alcanzan (tag opcional), no hace Vector.traerElMenor, setScale
  lo agrega manana. Salida de test1 verificada hasta Turno/Temporada/
  TipoUnidad. El resto se cerro en S8 (21/11/2026).
- S8 (21/11/2026): CIERRE DE LA FASE 1. Se revisaron dos zips (el primero
  resulto identico al anterior; el tercero, EpicentroGourmet.zip, trajo
  los cambios). Confirmado por diff: requireNonNull despues de super en
  Cajero y Cocinero, sin requireNonNull de primitivos en PuestoDesarmable,
  BigDecimal.valueOf (4 lugares), Festival.validarFechaFin con isBefore,
  Personal y UnidadVenta en private, cocinero1.getDni(). Decisiones del
  alumno: costoProduccion sin validar (0 valido), solo requireNonNull en
  responsable y especialidad, traerX internos con null, private en lugar de
  protected. Aplico el consejo de borrar los if (traerX == null) en Sistema.
  Salida de test1: primero tipo de unidad inconsistente en CU13 (el test
  usaba getTipoUnidad() y getDescripcion()), despues montos sin setScale
  (3 decimales y "$0"), y en la ultima corrida todo con 2 decimales. Se
  armo CAMBIOS.MD final con valores de referencia. Aprendio: la llamada a
  traerX valida aunque se borre el if, valueOf vs new BigDecimal(double),
  setScale devuelve objeto nuevo, !isBefore para festivales de un dia.
  Queda en opcionales: metodo abstracto TipoUnidad, especialidadCulinaria
  enum, etiquetas del test, orden de reportes. Proxima sesion: Fase 2 /
  Bloque 2 (Interfaces).
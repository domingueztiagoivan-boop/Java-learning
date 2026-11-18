# ESTADO DE ESTUDIO JAVA (pegar al inicio de cada sesión nueva)

Última actualización: 17/11/2026, fin de sesión 5 (1.6 Map cerrado en practicaFinalV2)

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
- EpicentroGourmet es el TP más completo de OO1 y NO se toca hasta el
  final: es el proyecto de examen (ver sección Proyecto final).

## Posición actual
- Fase 0: CERRADA. Git en uso (repo con .gitignore y README, rama main).
  JDK del alumno: OpenJDK 25 (LTS vigente).
- Fase 1: temas 1.1 a 1.6 CERRADOS (1.6 = Map en lugar de while). Siguiente:
  retoques pendientes de Sistema y bug de Vector.traerElMenor; después
  Fase 2 (Interfaces).

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
- [ ] Bug de Vector.traerElMenor (cantidad < 0 debería ser == 0, y
      lanzar excepción en vez de imprimir)
- [ ] Corregir EpicentroGourmet: se deja para el PROYECTO FINAL (no ahora).

## Proyecto final: refactor completo de EpicentroGourmet
- Decisión del alumno (13/11/2026): aprender todo por partes en proyectos
  chicos y, al terminar, reescribir EpicentroGourmet aplicando todas las
  herramientas. Esto reemplaza al "proyecto integrador" de la Fase 3 del
  plan (sigue valiendo su estructura en capas, tests y Maven).
- Antes de empezar el refactor: crear en Git un tag o rama con la versión
  original (ej. `epicentro-original`) para poder comparar antes y después.
### QUÉ VA A TENER EL PROYECTO FINAL (lista acumulada)
Cada tema cerrado agrega acá lo que hay que aplicar en EpicentroGourmet.
Estado: [aprendido] = ya se estudió y aplicó en un proyecto chico;
[por aprender] = todavía no se vio. Ningún ítem está aplicado en
EpicentroGourmet todavía (se toca recién en el refactor final).

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

Antes de empezar el refactor: crear el tag o rama `epicentro-original`.

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

## Siguiente paso concreto
1. Arrancar con 3 minutos de verificación: ¿puede escribir con sus palabras
   la frase "uso sector-numero como clave de mesa porque ___" y explicar
   para qué sirve el guion? ¿Puede predecir qué imprime Test1 en el test 8
   (mesa repetida) sin correrlo? Pedir también el archivo
   ExceptionSinRegistrar.java (nunca se revisó).
2. Retoques pendientes de 1.6 y 1.4/1.5 (ver listas): sacar el throws
   sobrante en agregarX, el código muerto de traerEnviosPorRepartidor,
   private en los atributos de Sistema, requireNonNull en agregarEnvio,
   validación cruzada de capacidad, getLstX de INCAANivel2. Elegir 2 o 3
   por sesión, no todos juntos.
3. Siguiente ítem de Fase 1: bug de Vector.traerElMenor (cantidad < 0
   debería ser == 0 y lanzar excepción en vez de imprimir). Ejercicio sin
   solución: primero que lo reproduzca (vector vacío) y prediga el
   resultado.
4. Después, Fase 2 / Bloque 2: Interfaces (por ejemplo CalculadorCosto en
   Repartidor), siguiendo el plan.
5. Recordar el Cambios.MD (corregir las imprecisiones anotadas en 1.6) y
   subir a Git las versiones actualizadas de estado_estudio.md y
   plan_estudio_java.md.

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
- Cuando avisa que se queda sin tokens/tiempo: no contestar largo; el
  cierre se hace al volver, pidiendo los archivos de nuevo.

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
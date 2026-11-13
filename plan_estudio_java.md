# PLAN DE ESTUDIO: DOMINAR JAVA ANTES DE SPRING BOOT

Armado el 12/11/2026 a partir de la revisión de tus 20 proyectos de
Orientación a Objetos 1 (unas 7.700 líneas de código).

Este archivo es texto plano (Markdown). Lo podés abrir con cualquier editor,
leer en la terminal con `less plan_estudio_java.md`, o abrirlo en VS Code y
apretar Ctrl+Shift+V para verlo formateado.

---------------------------------------------------------------------------

## ÍNDICE

0. Dónde estás parado
1. Meta: cuándo podés decir "manejo Java"
2. Mapa completo de conceptos (qué estudiar y qué tenés que saber hacer)
3. Plan por fases, con orden y ejercicios
4. Checklist final (listo para Spring Boot)
5. Fuentes de estudio
6. Preparar el entorno en Ubuntu
7. Cómo estudiar (método) y cómo usar a Claude para estudiar
8. Después de Java: el camino hacia el backend completo
9. Seguimiento de progreso

---------------------------------------------------------------------------

## 0. DÓNDE ESTÁS PARADO

LO QUE YA MANEJÁS
- Clases, encapsulamiento, constructores, getters/setters, toString.
- Herencia: extends, super(...), clases y métodos abstractos, protected,
  @Override, instanceof con casteo.
- ArrayList / List y arrays a mano.
- Excepciones básicas: throw, throws, try/catch.
- LocalDate y LocalTime.
- El patrón "clase Sistema con listas + agregarX / traerX", que es la base
  de cómo se estructura un backend.

LO QUE NO USASTE NI UNA VEZ EN TUS PROYECTOS
- interface / implements
- enum
- HashMap, HashSet, TreeMap
- Comparable / Comparator
- Lambdas y Streams
- Genéricos propios (<T>) y Optional
- hashCode()
- JUnit (tus tests son `main` con println)

ERRORES REALES ENCONTRADOS EN TU CÓDIGO (para corregir en la Fase 1)
1. `public boolean equals(Envio envio)` NO sobreescribe `Object.equals`.
   Es una sobrecarga. `lista.contains(...)` e `indexOf(...)` no la usan.
   Tampoco definiste `hashCode()`. Correcto:

   ```java
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (!(o instanceof Envio)) return false;
       Envio otro = (Envio) o;
       return id == otro.id;
   }

   @Override
   public int hashCode() {
       return Integer.hashCode(id);
   }
   ```
   Regla: si dos objetos son equals, tienen que dar el mismo hashCode.
   Siempre se redefinen los dos juntos.

2. `Vector.traerElMenor()`: el chequeo `if (cantidad < 0)` nunca es verdadero
   (debería ser `== 0`) y además imprime en vez de lanzar excepción, así que
   sigue y devuelve basura.

3. Todo lanza `new Exception(...)`. Conviene tener excepciones propias.
4. `Genero` es una clase con id y nombre: debería ser un `enum`.
5. Los `setLstX` / `getLstX` exponen la lista interna a cualquiera.
6. Dinero con `float`/`double`: se usa `BigDecimal`.
7. Búsquedas con `while` + índice: después se reemplazan por Map / streams.
8. Detalles: `super()` explícito sin necesidad, `CIclista` (typo), paquetes
   con nombres inconsistentes (Clases / clases / modelos / modelo), atributos
   sin `private`, carpetas bin/ y .settings/ dentro del zip.

---------------------------------------------------------------------------

## 1. META: CUÁNDO PODÉS DECIR "MANEJO JAVA"

No significa saberlo todo (nadie lo sabe). Significa poder, sin copiar de
ningún lado:

- Diseñar un sistema chico en capas, con interfaces, y que sea testeable.
- Elegir bien la estructura de datos (List, Set, Map) para cada problema.
- Resolver reportes con Streams.
- Manejar errores con excepciones propias.
- Escribir tests automáticos (JUnit).
- Leer código ajeno y reconocer patrones.
- Leer la documentación oficial (Javadoc) para resolver dudas por tu cuenta.

La prueba final es el proyecto de la Fase 3 y la checklist de la sección 4.

---------------------------------------------------------------------------

## 2. MAPA COMPLETO DE CONCEPTOS

Prioridad:  [A] imprescindible   [B] importante   [C] entender lo básico

Para cada tema: qué es, qué tenés que ser capaz de hacer, y dónde practicarlo
en tus propios proyectos.

### BLOQUE 1: Arreglar y completar lo que ya viste [A]

**1.1 equals / hashCode / toString**
- Contrato: reflexivo, simétrico, transitivo, consistente; equals iguales
  implican hashCode iguales.
- Debés poder: escribirlos de memoria y explicar por qué un HashSet/HashMap
  se rompe sin hashCode.
- Practicá en: Envio, Repartidor, Cliente, UnidadVenta (todas tus clases con
  `equals(X x)`).

**1.2 enum**
- Conjunto fijo de valores, con atributos y métodos propios.
- Debés poder: modelar estados, tipos y roles con enum; usarlos en `switch`.
- Practicá en: Genero (INCAA), tipos de contenido, turnos, estados de pedido.

**1.3 Excepciones propias**
- Heredar de Exception (checked) o RuntimeException (unchecked).
- Debés poder: crear `MesaYaRegistradaException`, decidir checked vs
  unchecked, capturar solo donde se puede resolver el problema.

**1.4 Encapsulamiento de colecciones**
- No devolver la lista interna: devolver copia o `List.copyOf(...)` /
  `Collections.unmodifiableList(...)`.
- Quitar los `setLstX` que no tienen sentido.

**1.5 BigDecimal**
- Para dinero. Entender por qué float/double dan errores de redondeo.
- Debés poder: sumar, multiplicar, comparar (`compareTo`, no `equals`) y
  redondear con `setScale`.

### BLOQUE 2: Interfaces y polimorfismo [A]

- Una interface define un CONTRATO (qué se puede hacer), la clase decide cómo.
- Herencia ("es un") vs interfaz ("sabe hacer"); métodos default y static.
- Programar contra la interfaz: `List<Envio> x = new ArrayList<>()`, tipos de
  parámetros como interfaz, no como clase concreta.
- Debés poder: explicar cuándo usar interfaz en vez de clase abstracta, y
  reemplazar una jerarquía tuya por una interfaz.
- Practicá en: Repartidor (interfaz `CalculadorCosto`), Contenido/Pelicula/
  Serie, Personal.

### BLOQUE 3: Colecciones completas + ordenamiento [A]

- List (ArrayList, LinkedList), Set (HashSet, LinkedHashSet, TreeSet),
  Map (HashMap, LinkedHashMap, TreeMap), Queue/Deque.
- Iterator, `for-each`, colecciones inmutables (`List.of`, `Map.of`).
- Comparable (orden natural) y Comparator (orden a medida:
  `Comparator.comparing(...).thenComparing(...)`).
- Complejidad aproximada: por qué buscar en un Map es más rápido que
  recorrer una lista.
- Debés poder: reemplazar tus `traerX` con `while` por búsquedas en `Map`;
  ordenar rankings por varios criterios; evitar duplicados con Set.
- Practicá en: Sistema de cualquier proyecto; los rankings de EpicentroGourmet.

### BLOQUE 4: Genéricos [A]

- Usar `List<T>`, `Map<K,V>` con comprensión real (no solo copiar).
- Escribir clases y métodos genéricos propios (`Repositorio<T>`,
  `<T extends Comparable<T>> T maximo(List<T> l)`).
- Tipos acotados, y una idea básica de comodines (`? extends`, `? super`).
- Debés poder: escribir `Repositorio<T>` con agregar / traer / listar.
- Por qué importa: Spring Data se usa como `JpaRepository<Entidad, Long>`.

### BLOQUE 5: Lambdas, Streams y Optional [A]

- Interfaces funcionales: Function, Predicate, Consumer, Supplier.
- Lambdas y referencias a métodos (`Envio::getFecha`).
- Streams: filter, map, sorted, distinct, limit, reduce, count, anyMatch,
  allMatch, `collect`, `Collectors.groupingBy`, `toMap`, `summingDouble`,
  `.toList()`.
- Optional: `orElse`, `orElseThrow`, `ifPresent`, `map`.
- Debés poder: reescribir cualquier método de reporte tuyo con streams.
  Ejemplo (tu `traerEnviosPorFechaYCosto`):

  ```java
  return lstEnvios.stream()
      .filter(e -> !e.getFecha().isBefore(desde) && !e.getFecha().isAfter(hasta))
      .filter(e -> e.getRepartidor().costoTotalEnvio(e.getKmRecorridos()) <= costoMax)
      .toList();
  ```
- Practicá en: todos los reportes de EpicentroGourmet.

### BLOQUE 6: Excepciones a fondo [A]

- Checked vs unchecked, jerarquía (Throwable, Exception, RuntimeException,
  Error).
- `finally`, `try-with-resources` (AutoCloseable), multi-catch.
- Relanzar con causa (`new MiExcepcion("...", causa)`).
- Buenas prácticas: no capturar `Exception` genérico sin motivo, no tragarse
  errores, mensajes útiles, validar al principio.

### BLOQUE 7: Testing con JUnit 5 [A]

- Tests automáticos: `@Test`, `assertEquals`, `assertTrue`, `assertThrows`.
- `@BeforeEach`, tests parametrizados (idea básica).
- Qué es un mock y por qué se usa (Mockito: nociones).
- Debés poder: convertir cada `main` de prueba tuyo en tests que fallan solos
  si algo se rompe, incluyendo los casos de error.
- Nota: JUnit es mucho más cómodo con Maven (ver sección 6 y 8).

### BLOQUE 8: Diseño orientado a objetos [A]

- Principios SOLID (uno por uno, con ejemplos propios).
- Composición vs herencia ("preferí composición").
- Bajo acoplamiento, alta cohesión, responsabilidad única.
- Inyección de dependencias A MANO: pasar las dependencias por constructor
  (`new Servicio(repositorio)`). Es exactamente lo que Spring automatiza.
- Patrones mínimos: Strategy, Factory, Builder, Template Method, Singleton,
  Observer. Más los conceptos de DTO y Repository/DAO.
- Debés poder: reconocerlos en código ajeno y aplicar al menos Strategy,
  Factory y Builder en un ejercicio propio.
- Pista: tus métodos abstractos (`costoTotalEnvio`, `calcularCanon`) ya son
  Template Method / Strategy sin que lo supieras.

### BLOQUE 9: Java moderno (17 / 21 / 25) [B]

- `record` (se usan muchísimo como DTOs), `var`, `switch` como expresión,
  text blocks, pattern matching para `instanceof`, `sealed` (nociones).
- Debés poder: reescribir una clase "solo datos" tuya como `record`.

### BLOQUE 10: Strings, tipos y memoria [B]

- String inmutable, `StringBuilder`, `String.format`, `==` vs `equals`.
- Wrappers (Integer, Double), autoboxing, comparar wrappers.
- Manejo de null (y por qué Optional).
- Más de java.time: Duration, Period, Instant, DateTimeFormatter.
- Modelo de memoria: pila vs heap, paso por valor de las referencias, copia
  superficial vs profunda, idea del garbage collector.
- Modificadores: static, final, acceso por paquete; clases anidadas y
  anónimas.

### BLOQUE 11: Archivos y E/S [B]

- `java.nio.file` (`Files`, `Path`), leer y escribir texto, CSV, nociones de
  JSON, serialización.
- Debés poder: guardar y cargar tus entidades desde un archivo.

### BLOQUE 12: Concurrencia básica [C]

- Thread, `ExecutorService`, `synchronized`, condiciones de carrera,
  `CompletableFuture` (nociones).
- Idea clave de backend: cada request corre en un hilo distinto, por eso un
  objeto compartido con estado modificable es peligroso.

### BLOQUE 13: Anotaciones y reflection (conceptual) [C]

- Qué es una anotación, cómo se crea una (idea) y cómo se lee. Reflection:
  código que inspecciona clases en ejecución. Spring funciona con esto por
  debajo; con entender la idea alcanza.

### BLOQUE 14: Herramientas del ecosistema [B]

- JDK / JVM / JRE / classpath / `.jar`: saber qué ejecutás realmente.
- Git (empezá YA; no depende de Java).
- Maven (aprendelo cuando armes tests o el proyecto final).
- Javadoc: aprender a leer la documentación oficial de las clases de Java.
- Logging (idea de niveles; SLF4J) y estructura en capas:
  model / repository / service / ui o controller.
- `module-info.java`: Eclipse te lo genera en cada proyecto. Los proyectos
  Spring normalmente NO lo usan; no le dediques tiempo.

---------------------------------------------------------------------------

## 3. PLAN POR FASES

Los tiempos son orientativos, asumiendo ~1 hora diaria. Lo que importa es el
orden y que cada fase termine con código tuyo funcionando.

### FASE 0: Preparar el entorno (1 día)
- Instalar JDK 25 LTS, IDE, Git (ver sección 6).
- Subir tus proyectos a un repo de GitHub con un `.gitignore` que excluya
  `bin/`, `.settings/`, `.classpath`, `.project`.

### FASE 1: Consolidar lo que ya hiciste (1 a 2 semanas)
Elegí 2 o 3 proyectos (recomendados: practicaFinalV2 y EpicentroGourmet) y
aplicá, uno por uno, en commits separados:
1. `equals(Object)` + `hashCode()` correctos con `@Override`.
2. Tipos y estados como `enum`.
3. Excepciones propias en lugar de `new Exception(...)`.
4. Atributos con `private`; getters que no exponen la lista interna.
5. Búsquedas `traerX` con `Map` donde corresponda.
6. Dinero con `BigDecimal`.
7. Corregir el bug de `Vector.traerElMenor`.
Objetivo: mismo comportamiento, código más correcto.

### FASE 2: Conceptos nuevos, en este orden (6 a 10 semanas)
Cada paso usa el anterior, no los saltees. Para cada uno: ver / leer la
explicación, hacer ejercicios chicos, aplicarlo a un proyecto tuyo.

1. Interfaces y polimorfismo por contrato                  (Bloque 2)
2. Colecciones, Comparable / Comparator                    (Bloque 3)
3. Genéricos                                               (Bloque 4)
4. Lambdas, Streams y Optional                             (Bloque 5)
5. Excepciones a fondo, try-with-resources                 (Bloque 6)
6. JUnit 5 (+ Maven mínimo para correr tests)              (Bloque 7)
7. SOLID, composición, inyección por constructor, patrones (Bloque 8)
8. Java moderno, Strings/memoria                           (Bloques 9, 10)
9. Archivos                                                (Bloque 11)
10. Concurrencia y anotaciones (nociones)                  (Bloques 12, 13)

Ejercicios sugeridos por paso:
- (1) Convertí la jerarquía Repartidor en una interfaz `Repartidor` con dos
  implementaciones, y sumá una tercera (por ejemplo Dron) sin tocar el
  `Sistema`.
- (2) "Top 3 platos más vendidos", "envíos agrupados por repartidor",
  clientes sin duplicados con Set.
- (3) Escribí `Repositorio<T>` con agregar / traerPorId / listar y usalo
  para Mesa, Repartidor y Envio.
- (4) Reescribí con streams todos los reportes de EpicentroGourmet y
  compará con tu versión con `for`.
- (5) Jerarquía de excepciones propia para un sistema completo.
- (6) Al menos 10 tests por Sistema, incluyendo casos de error con
  `assertThrows`.
- (7) Strategy para el cálculo de costos, Builder para objetos con muchos
  parámetros (ej. Envio), Factory para crear repartidores.
- (9) Guardar y cargar el sistema desde CSV.

### FASE 3: PROYECTO INTEGRADOR en Java puro, sin frameworks (2 a 4 semanas)
Un sistema de consola (podés rehacer uno tuyo en grande) con esta estructura:

```
modelo/        entidades, enums, excepciones propias
repositorio/   interfaz Repositorio<T>
               + implementación en memoria
               + implementación que guarda en archivo (CSV o JSON)
servicio/      lógica de negocio; recibe el repositorio por constructor
ui/            menú de consola
test/          JUnit para servicio y modelo
```

Condiciones que lo hacen valioso:
- El servicio depende de la INTERFAZ del repositorio, no de la clase concreta.
- Podés cambiar de memoria a archivo sin tocar el servicio.
- Reportes hechos con Streams.
- Excepciones propias manejadas en la capa de ui.
- Todo corre con Maven (`mvn test`).
- Subido a GitHub con un README que explique qué hace y cómo correrlo.

Si hacés esto entendiendo cada línea, vas a ver por qué existen Spring Data
y la inyección de dependencias. Ese es el momento de pasar a Spring.

---------------------------------------------------------------------------

## 4. CHECKLIST FINAL: ¿LISTO PARA SPRING BOOT?

Pasá a Spring cuando puedas hacer TODO esto sin copiar:

- [ ] Explicar con tus palabras qué es una interfaz, cuándo usarla en vez de
      herencia, y escribir un ejemplo.
- [ ] Escribir equals/hashCode correctos y explicar por qué van juntos.
- [ ] Elegir entre List, Set y Map según el problema y justificarlo.
- [ ] Resolver un reporte (filtrar, agrupar, ordenar, sumar) con Streams.
- [ ] Escribir una clase genérica simple y ordenar con Comparator.
- [ ] Crear excepciones propias, decidir si son checked o unchecked y saber
      dónde capturarlas.
- [ ] Escribir tests JUnit para un servicio, incluyendo casos de error.
- [ ] Armar una app en capas donde cambiar la implementación del repositorio
      no rompe nada.
- [ ] Reconocer un Strategy, un Factory o un Builder en código ajeno.
- [ ] Explicar por qué un objeto compartido con estado modificable es
      peligroso con varios hilos.
- [ ] Usar Optional sin llamar a `.get()` a ciegas.
- [ ] Leer el Javadoc de una clase que no conocías y usarla bien.

Si marcás casi todo: estás listo.
Si no podés explicar interfaces, genéricos o Streams: Spring va a ser copiar
y pegar sin entender.

---------------------------------------------------------------------------

## 5. FUENTES DE ESTUDIO

### Curso principal (el que más te recomiendo)
- MOOC de Java de la Universidad de Helsinki: https://java-programming.mooc.fi/
  Gratis, con ejercicios que se corrigen solos. Es la versión moderna del
  curso "Programación orientada a objetos con Java". Está en inglés
  (el traductor del navegador funciona bien). Hacé la Parte II completa:
  ahí aparecen polimorfismo, interfaces, genéricos, colecciones, streams y
  lambdas, y hacia el final llega hasta Maven.
  Hacé los ejercicios, no solo leas.

### Documentación oficial (acostumbrate a usarla)
- dev.java (sitio oficial de aprendizaje de Java): https://dev.java
- The Java Tutorials: https://docs.oracle.com/javase/tutorial/
- Javadoc oficial: buscá "Java SE 25 API" en docs.oracle.com. Aprender a
  leer el Javadoc de List, Map, Stream, Optional, LocalDate vale oro.

### Práctica con ejercicios
- Exercism, pista de Java: https://exercism.org/tracks/java
  Gratis, con tests automáticos y opción de mentorías.
- Codewars, HackerRank (dominio Java): para entrenar sintaxis y colecciones.
  No te obsesiones con algoritmos de entrevista; tu objetivo es diseño y
  manejo del lenguaje.

### Patrones y diseño
- Refactoring Guru (en español): https://refactoring.guru/es
  Patrones de diseño explicados con diagramas y ejemplos en Java.
  También tiene una sección de "code smells" y refactorización.
- Repositorio "java-design-patterns" (iluwatar) en GitHub, para ver los
  patrones en código.

### Tutoriales por tema
- Baeldung: https://www.baeldung.com  (inglés). Excelente para temas
  puntuales: Streams, Optional, equals/hashCode, JUnit 5, genéricos.

### Libros (inglés, de a uno, no todos juntos)
- "Head First Java" (Sierra, Bates): introducción amena, buen repaso.
- "Effective Java" (Joshua Bloch): EL libro de buenas prácticas. Leelo
  después de la Fase 2; trata equals/hashCode, Optional, excepciones,
  genéricos, enums, lambdas y streams.
- "Head First Design Patterns": patrones, de forma muy visual.
- "Clean Code" (Robert C. Martin): nombres, funciones, comentarios.
- "Modern Java in Action": lambdas y streams en profundidad.
- "Java Concurrency in Practice": solo cuando quieras profundizar en hilos.

### YouTube y videos
- Hay muchos cursos de Java en español en YouTube, y la calidad y la
  actualización varían mucho (varios usan Java 8). Un criterio útil: elegí
  videos que usen Java 17 o superior, y que traten el tema puntual que estás
  estudiando (por ejemplo "Java Streams", "Java interfaces", "JUnit 5").
  Probá 10 minutos de un video: si repite todo el tiempo sin explicar el
  porqué, cambialo.
- Complementá siempre el video con ejercicios propios. Mirar sin escribir
  código no sirve.

---------------------------------------------------------------------------

## 6. PREPARAR EL ENTORNO EN UBUNTU

Versión de Java: hoy (nov 2026) la versión LTS vigente es JDK 25
(lanzada en septiembre de 2025). JDK 21 es la LTS anterior y también se usa
mucho. Para aprender usá la 25 (o la 21 si tu facultad pide algo específico).
No uses versiones no-LTS (26, 27) para estudiar.

Instalar con SDKMAN (permite cambiar de versión fácil):

```bash
sudo apt update && sudo apt install -y curl zip unzip git
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk list java                 # elegí una versión de Temurin 25.x
sdk install java <identificador-que-elijas>
java --version
```

Cuando llegues a JUnit / proyecto final:

```bash
sdk install maven
mvn --version
```

IDE: seguí con Eclipse si es el de tu facultad, o probá IntelliJ IDEA
Community (muy usado en el mundo laboral) o VS Code con el "Extension Pack
for Java". Elegí uno y quedate un buen tiempo: lo importante es el Java, no
el IDE. Aprendé los atajos de refactorización (renombrar, extraer método).

Git básico a aprender ya: `git init`, `add`, `commit`, `status`, `log`,
`branch`, `push`, `pull`, y hacer un `.gitignore` bueno.

---------------------------------------------------------------------------

## 7. CÓMO ESTUDIAR (MÉTODO)

Para CADA concepto, repetí este ciclo:

1. ENTENDER: leer o ver una explicación corta (máx. 30 a 40 minutos).
2. ESCRIBIR: un ejemplo mínimo tuyo, SIN copiar y pegar.
3. ROMPER: cambiá algo para que falle y mirá el error. Así se aprende de
   verdad qué hace cada cosa.
4. EXPLICAR: contalo en voz alta o por escrito como si se lo explicaras a
   alguien (técnica Feynman). Si no podés, no lo entendiste todavía.
5. APLICAR: usalo en uno de tus proyectos (ya conocés el dominio, así que
   solo te concentrás en la técnica).
6. TESTEAR: escribí un test que lo verifique.

Hábitos que ayudan:
- Poco todos los días rinde más que mucho una vez por semana.
- Un cuaderno (o archivo) de "errores que cometí y por qué".
- Cuando algo te falle, leé el mensaje de error completo antes de preguntar:
  es la habilidad número uno de un programador.
- Commits chicos y frecuentes: te sirve de diario de progreso.

### Cómo usarme (Claude) para estudiar con vos

Podés venir y preguntarme cada tema. Algunas formas de pedirme cosas que
funcionan bien:

- "Explicame interfaces con un ejemplo de mi sistema de envíos."
- "Dame 5 ejercicios de Streams sin solución; después te paso mis respuestas
  y me corregís."
- "Tomame un quiz de Colecciones."
- "Revisá este código mío y decime qué mejoraría y por qué."
- "No me des la solución, dame una pista."
- "¿Cuál es la diferencia entre X y Z? Y cuándo usaría cada una?"
- "Reescribí este método con streams y explicame paso a paso qué hace cada
  línea."
- "Mostrame el antes y el después de refactorizar este proyecto."

Un consejo: pedime ejercicios sin solución y probá primero. Si te doy la
solución antes de intentar, aprendés mucho menos.

---------------------------------------------------------------------------

## 8. DESPUÉS DE JAVA: EL CAMINO HACIA EL BACKEND COMPLETO

(No esperes a terminar Java para empezar las dos primeras.)

1. Git y GitHub .......... desde YA (no depende de nada).
2. SQL .................... desde YA, en paralelo: tablas, claves primarias
                           y foráneas, SELECT, JOIN, GROUP BY, subconsultas,
                           índices. Usá MySQL o PostgreSQL.
3. Maven .................. durante la Fase 2 / 3 (tests y proyecto final).
4. JDBC ................... después de la Fase 3: cómo Java habla con una
                           base de datos "a mano".
5. HTTP, REST y JSON ...... verbos, códigos de estado, qué es un endpoint.
6. Spring Boot ............ controllers, services, repositories, inyección de
                           dependencias, JPA/Hibernate (mapear clases a
                           tablas), DTOs, validaciones, manejo de errores.
7. Seguridad .............. Spring Security, autenticación, JWT.
8. Testing de la API ...... JUnit 5, Mockito, Postman.
9. Conectar un frontend ... CORS, consumir la API desde un front.
10. Docker y deploy ....... nociones básicas.

Idea clave: tus clases `Sistema` con agregarX / traerX se convierten casi
directo en un Service + Repository, y tus clases del modelo en entidades
JPA. Esa mentalidad ya la tenés.

---------------------------------------------------------------------------

## 9. SEGUIMIENTO DE PROGRESO

Marcá con [x] a medida que avanzás.

FASE 0
- [ ] JDK 25 instalado y `java --version` funciona
- [ ] Git instalado y proyectos subidos a GitHub con .gitignore

FASE 1
- [ ] equals(Object) + hashCode en mis clases
- [ ] enums en lugar de clases tipo "Genero"
- [ ] excepciones propias
- [ ] getters que no exponen listas internas
- [ ] Map en lugar de búsquedas con while
- [ ] BigDecimal para dinero
- [ ] bug de Vector corregido

FASE 2
- [ ] 1. Interfaces
- [ ] 2. Colecciones + Comparator
- [ ] 3. Genéricos
- [ ] 4. Lambdas + Streams + Optional
- [ ] 5. Excepciones a fondo
- [ ] 6. JUnit 5 + Maven mínimo
- [ ] 7. SOLID + patrones + DI por constructor
- [ ] 8. Java moderno + Strings/memoria
- [ ] 9. Archivos
- [ ] 10. Concurrencia y anotaciones (nociones)

FASE 3
- [ ] Proyecto integrador terminado, con tests y README
- [ ] Checklist de la sección 4 completa

Y SIGUE: Spring Boot.

---------------------------------------------------------------------------

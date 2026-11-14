# ESTADO DE ESTUDIO JAVA (pegar al inicio de cada sesión nueva)

Última actualización: 13/11/2026, fin de sesión 1

## Cómo se usa
- Abrí una conversación nueva cada día y pegá este archivo completo.
- Escribí "retomamos". Claude responde con un resumen de 3 líneas y sigue.
- Al terminar, decí "cerramos por hoy": Claude te da este archivo actualizado.
- Reemplazá el viejo por el nuevo. No hace falta releer conversaciones.

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
  Envio, Mesa, Repartidor, Moto, CIclista, Sistema; tests en src/test con
  `package test;`) e INCAANivel2 (Genero, Pelicula, Incaa).
- Siguiente proyecto: practicaFinalV2 para 1.3.
- EpicentroGourmet es el TP más completo de OO1 y NO se toca hasta el
  final: es el proyecto de examen (ver sección Proyecto final).

## Posición actual
- Fase 0: Git ya en uso (repo con .gitignore y README, rama main).
  Versión de JDK del alumno sin confirmar (en el sandbox de Claude hay 21;
  el JDK vigente LTS es 25).
- Fase 1: temas 1.1 y 1.2 CERRADOS. Siguiente: 1.3 excepciones propias.

## Checklist Fase 1
- [x] 1.1 equals(Object) + hashCode en practicaFinalV2 (Envio, Mesa,
      Repartidor). Verificado con prueba (contains true, HashSet 2,
      motos con misma patente iguales y mismo hashCode).
- [x] 1.2 enums: Genero en INCAANivel2 convertido a enum (id + nombre
      "lindo"), Incaa.agregarPelicula recibe Genero, filtro con ==.
      Verificado: el filtro por TERROR devuelve las películas correctas.
- [ ] 1.3 excepciones propias  <- SIGUIENTE
- [ ] 1.4 getters que no exponen la lista interna
- [ ] 1.5 BigDecimal para dinero
- [ ] Map en lugar de búsquedas con while (traerX)
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
- Pendientes que se van sumando a medida que se estudia cada tema:
  - 1.1 equals/hashCode: corregir el patrón equals(X x) en todas sus
    clases.
  - 1.2 enums: reemplazar clases/valores fijos por enum donde corresponda.
  - 1.3 excepciones propias: reemplazar `new Exception(...)`.
  - 1.4 no exponer listas internas; 1.5 BigDecimal para dinero.
  - Map en lugar de traerX con while; streams en los reportes;
    interfaces y patrones (Strategy, etc.); JUnit en lugar de main.

## Conceptos ya trabajados
- equals(X x) es una sobrecarga, no sobreescribe Object.equals. Se demostró
  con código (contains false, HashSet duplicado).
- hashCode: número que "resume" al objeto, usado por HashSet/HashMap para
  elegir cajón; equals decide dentro del cajón. Regla: objetos equals =>
  mismo hashCode, calculado con los MISMOS campos que equals. Colisiones
  permitidas.
- Estructura de equals: mismo objeto, instanceof, casteo, comparar campo
  identificador (== para primitivos, .equals para objetos).
- Decisiones del proyecto: Envio se compara por id; Mesa por
  sector+numero (así lo identifica Sistema); Repartidor por
  patenteIdentificador. Moto y CIclista heredan equals/hashCode.
- No modificar campos del equals/hashCode con el objeto dentro de un
  HashSet/HashMap.
- Enum: tipo con conjunto fijo y cerrado de valores; cada constante es un
  único objeto (se compara con ==, no necesita equals/hashCode); atributos
  final y sin setters; constructor sin public; values(), valueOf(), name(),
  switch con enum. Con enum el cambio "agregar un género" es tocar un solo
  lugar.
- Depuración: si un resultado sorprende, revisar los datos que cambian en
  las líneas anteriores del test (ej. eliminarPelicula(3) borraba una
  película del filtro) y mostrar el estado con prints etiquetados.
  Ctrl+Shift+F busca texto en todo el proyecto.
- Errores que cometió y corrigió: this.equals(obj) (recursión infinita),
  .equals sobre un int, falta de import java.util.Objects, hashCode con más
  campos que equals (por código generado por Copilot), enum sin coma /
  atributos / public, parámetro String sin usar en agregarPelicula.
- Práctico: F5 en VS Code ejecuta la última clase con main, no el archivo
  abierto; usar el "Run" sobre el main. Un test nuevo en src/test necesita
  `package test;` arriba.

## Siguiente paso concreto
1. Mini repaso oral (2 preguntas): por qué hace falta hashCode además de
   equals, y por qué los enums se comparan con == y no tienen setters.
2. Tema 1.3: excepciones propias en practicaFinalV2. Hoy Sistema y el
   constructor de Envio lanzan `new Exception(...)` genérico. Explicar
   checked vs unchecked, crear una clase que extienda Exception (por
   ejemplo para mesa o envío ya registrado) y capturarla donde corresponda.
   Ejercicio sin solución.

## Notas para Claude
- No dar la solución directa: primero pistas. Pedir que explique con sus
  palabras.
- Advertirle de código generado por Copilot/Eclipse: entenderlo antes de
  aceptarlo (generan equals/hashCode con todos los campos).
- A veces el alumno pega código recortado (falta @Override o una llave por
  copiar mal). Pedir el archivo completo si dudás.
- El sandbox de Claude tiene Java 21 (se ejecuta con `java Archivo.java`).
  El entorno del alumno puede ser distinto.

## Registro de sesiones
- S1 (13/11/2026): armado del plan; revisión del código; 1.1 y 1.2
  completos. El alumno define EpicentroGourmet como proyecto final.

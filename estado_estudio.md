# ESTADO DE ESTUDIO JAVA (pegar al inicio de cada sesión nueva)

Última actualización: 14/11/2026, fin de sesión 2

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
  Envio, Mesa, Repartidor, Moto, CIclista, Sistema, ExceptionYaRegistrado,
  ExceptionRepartidor; tests en src/test con `package test;`) e INCAANivel2
  (Genero, Pelicula, Incaa).
- Siguiente proyecto: elegir uno para 1.4 (practicaFinalV2 o INCAANivel2).
- EpicentroGourmet es el TP más completo de OO1 y NO se toca hasta el
  final: es el proyecto de examen (ver sección Proyecto final).

## Posición actual
- Fase 0: CERRADA. Git en uso (repo con .gitignore y README, rama main).
  JDK del alumno: OpenJDK 25 (LTS vigente).
- Fase 1: temas 1.1, 1.2 y 1.3 CERRADOS. Siguiente: 1.4 getters que no
  exponen la lista interna.

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
- [ ] 1.4 getters que no exponen la lista interna  <- SIGUIENTE
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
  - 1.3 excepciones propias: reemplazar `new Exception(...)` por clases
    propias; validar null con Objects.requireNonNull.
  - 1.4 no exponer listas internas; 1.5 BigDecimal para dinero.
  - Map en lugar de traerX con while; streams en los reportes;
    interfaces y patrones (Strategy, etc.); JUnit en lugar de main.

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
1. (Opcional) hacer los retoques menores de 1.3.
2. Tema 1.4: getters que no exponen la lista interna. Problema: un
   getLstX() que devuelve la lista original permite que cualquiera la
   modifique desde afuera, saltándose las validaciones del Sistema.
   Explicar corto, mostrar el problema con una demostración y que el
   alumno lo corrija (copia, vista de solo lectura) en practicaFinalV2.
   Ejercicio sin solución.

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

## Registro de sesiones
- S1 (13/11/2026): armado del plan; 1.1 y 1.2 completos. EpicentroGourmet
  definido como proyecto final.
- S2 (14/11/2026): 1.3 completo (excepciones propias checked y unchecked,
  null con requireNonNull, múltiples catch).

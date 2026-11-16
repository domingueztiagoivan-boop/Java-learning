Hicimos varios cambios, No solamente el Lista.copyOf().
Cambiamos tambien exception checked y en ves de recibir mas parametros, solo recibe un string y definimos la exception
en el momento de lanzarla, ya que definirla de antemano y solo pasar los parametros lo hace mas limpio
pero mas complicado de reutilizarlo.

tambien cambios generales en validaciones necesarias para no admitir variables nulas o negativas, y probamos 
varias formas de rompar a proposito en el test el sistema y sus listas, ya que el objetivo es que si -
llamamos un get, este nos da la lista duplicada, y no podemos modificarla directamente a la original.
por otro lado tambien si tomamos del getLstMesa().get(o).set(999) si lo va a modificar, aunque el get nos de una copia.
Esto pasa principalmente porque el get aunque utilice copyOf() y no permita modificar la lista, lanzando exception,
sigue tomando referencia los objetos originales, por lo que si estamos modificando la lista original pero no directamente, sino tomando cada posicion de esta separada. Para que no pase esto tenemos que duplicar los objetos, y ahi si tenemos una Lista duplicada completamente segura de evitar alteraciones en la lista original. "Deep-Copy"
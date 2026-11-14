package modelos;

///REGISTRAMOS LA CLASE DE LA EXCEPTION PROPIA, QUE EXTENDERÁ DE Exception, PARA QUE SEA CHECKED.

public class ExceptionRepartidor extends Exception{
    public ExceptionRepartidor(int capacidadmax, int cantidad) {
        super("Error. Los pedidos asignados [" + cantidad + "] superan la cantidad del repartidor maxima [" + capacidadmax + "].");
    }
}
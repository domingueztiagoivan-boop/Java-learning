package modelos;

///REGISTRAMOS LA CLASE DE LA EXCEPTION PROPIA, QUE EXTENDERÁ DE Exception, PARA QUE SEA CHECKED.

public class ExceptionRepartidor extends Exception{
    public ExceptionRepartidor(String message) {
        super(message);
    }
}
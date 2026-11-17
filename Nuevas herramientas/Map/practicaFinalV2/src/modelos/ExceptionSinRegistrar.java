package modelos;

///REGISTRAMOS LA CLASE DE LA EXCEPTION PROPIA, QUE EXTENDERÁ DE Exception, PARA QUE SEA CHECKED.

public class ExceptionSinRegistrar extends Exception{
    public ExceptionSinRegistrar(String message) {
        super(message);
    }
}
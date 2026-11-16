package modelos;

///REGISTRAMOS LA CLASE DE LA EXCEPTION PROPIA, QUE EXTENDERÁ DE Exception, PARA QUE SEA CHECKED.

public class ExceptionRepartidorMenorCero extends Exception{
    public ExceptionRepartidorMenorCero(String message) {
        super(message);
    }
}
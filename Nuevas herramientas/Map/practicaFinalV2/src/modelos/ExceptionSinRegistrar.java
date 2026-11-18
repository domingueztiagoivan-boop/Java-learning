package modelos;

// Exception Checked que lanza los metodos "traer" cuando no encuentran en el map tal objeto.
// Si no encuentra el objeto que esta buscando en map, automaticamente se lanza esta exception con un mensaje explicando el motivo.

public class ExceptionSinRegistrar extends Exception{
    public ExceptionSinRegistrar(String message) {
        super(message);
    }
}
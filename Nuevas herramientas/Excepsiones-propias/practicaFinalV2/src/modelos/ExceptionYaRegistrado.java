package modelos;


///REGISTRAMOS LA CLASE DE LA EXCEPTION PROPIA, QUE EXTENDERÁ DE Exception, PARA QUE SEA CHECKED.
////// LAS EXCEPCIONES ExceptionYaRegistrado y ExceptionRepartidor SON CHECKED PORQUE EXTENDEN DE Exception, Y PORQUE ESPERAMOS ESTOS ERRORES.

public class ExceptionYaRegistrado extends Exception {

    public ExceptionYaRegistrado(String txt1) {
        super("Error. Ya esta registrado " + txt1 + ".");
    }
}
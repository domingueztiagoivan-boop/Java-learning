package modelos;

//Esta exception se lanza cuando se intenta devolver de un map un objecto solicitado y este no se encuetra con el map.contains().



public class ExceptionSinRegistro extends Exception{
    
    public ExceptionSinRegistro(String message){
        super (message);
    } 
}
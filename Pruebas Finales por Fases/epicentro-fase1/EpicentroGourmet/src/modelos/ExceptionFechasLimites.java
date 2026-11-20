package modelos;

//Esta exception se lanza cuando hay que validar una fecha que sea correcta. Ejemplo fecha fin / inicio, se comprueba que tengan sentido y que una 
//fecha inicio no este despues de una fecha fin y viceversa.


public class ExceptionFechasLimites extends Exception{
    
    public ExceptionFechasLimites(String message){
        super (message);
    } 
}
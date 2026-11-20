package modelos;

//Esta exception se lanza cuando se valida que un atributo sea mayor o igual que cero...



public class ExceptionMenorZero extends Exception{
    
    public ExceptionMenorZero(String message){
        super (message);
    } 
}
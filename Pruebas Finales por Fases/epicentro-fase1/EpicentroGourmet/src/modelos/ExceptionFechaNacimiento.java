package modelos;

//Esta exception se lanza cuando se le asigna a un personal un atributo fechaNacimiento menor a los 18 años. 


public class ExceptionFechaNacimiento extends Exception{
    
    public ExceptionFechaNacimiento(String message){
        super (message);
    } 
}
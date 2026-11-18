package modelos;

//Esta exception se lanza cuando se intenta agregar un nuevo Plato a un DetallePedido de un Pedido pero este ya esta dentro del DetallePedido. 


public class ExceptionFechaNacimiento extends Exception{
    
    public ExceptionFechaNacimiento(String message){
        super (message);
    } 
}
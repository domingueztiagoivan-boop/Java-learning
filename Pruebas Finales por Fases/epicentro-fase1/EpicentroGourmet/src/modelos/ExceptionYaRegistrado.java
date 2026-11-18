package modelos;

//Esta exception se lanza cuando se intenta agregar un nuevo Plato a un DetallePedido de un Pedido pero este ya esta dentro del DetallePedido.
//Tambien salta si se intenta agregar un Plato a una UnidadVenta y este ya esta.
//Personal repetido(Cocinero y Cajero).


public class ExceptionYaRegistrado extends Exception{
    
    public ExceptionYaRegistrado(String message){
        super (message);
    } 
}
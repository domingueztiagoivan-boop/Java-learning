package modelos;

//Se lanza cuando en un detalle pedido se quiere agregar un plato , pero este ya esta en el detalle pedido, por lo que deberia de modificar su cantidad.

public class ExceptionDetallePedidoPlatoYaInlcuido extends Exception{
    
    public ExceptionDetallePedidoPlatoYaInlcuido(String message){
        super (message);
    } 
}
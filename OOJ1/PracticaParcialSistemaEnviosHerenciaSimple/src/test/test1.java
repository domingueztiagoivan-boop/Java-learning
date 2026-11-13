package test;
	
import java.util.List;
import modelos.*;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SistemaLogistica sistema = new SistemaLogistica();
		
		System.out.println("=== 1) REGISTRO DE CLIENTES Y CAMIONES ===");
        try {
            sistema.agregarCliente("Empresa Alimentos S.A.", 30123456789L);
            sistema.agregarCliente("Tech Import SRL", 30987654321L);
            sistema.agregarCliente("Empresa Cortinas S.A.", 30143856250L);
            
            sistema.agregarCamion("AAA111", 1000.0); 
            sistema.agregarCamion("BBB222", 5000.0); 
            sistema.agregarCamion("CCC333", 2000.0); 
            System.out.println("-> Clientes y Camiones registrados exitosamente.");
            System.out.println(sistema.getLstClientes() + "\n\n" + sistema.getLstCamiones());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
        Cliente cliente1 = sistema.traerCliente(30123456789L); // Alimentos S.A.
        Cliente cliente2 = sistema.traerCliente(30987654321L); // Tech Import
        Cliente cliente3 = sistema.traerCliente(30143856250L); // Tech Import
        
        Camion camionChico = sistema.traerCamion("AAA111"); 
        Camion camionGrande = sistema.traerCamion("BBB222");
        Camion camionMediano = sistema.traerCamion("CCC333");

        System.out.println("\n=== 2) REGISTRO DE ENVÍOS  ===");
        try {

            sistema.agregarEnvioNacional(cliente1, camionChico, 500.0, 350, "Córdoba");
            sistema.agregarEnvioInternacional(cliente2, camionGrande, 1200.0, 600, "Brasil", true);
            sistema.agregarEnvioInternacional(cliente1, camionGrande, 300.0, 150, "Uruguay", false);
            
            System.out.println("-> Envíos cargados correctamente en el sistema.");
            System.out.println(sistema.getLstEnvios());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== 3) TEST DE EXCEPCIÓN: SOBRECARGA DE CAMIÓN ===");
        try {
            // Intentamos meter un paquete de 1500kg en el camión chico de 1000kg. Exception
            sistema.agregarEnvioNacional(cliente2, camionChico, 1500.0, 400, "Mendoza");
            System.out.println("-> Alerta: El sistema falló en detectar la sobrecarga.");
        } catch (Exception e) {
            System.out.println("Excepción esperada correctamente: " + e.getMessage());
        }

        System.out.println("\n=== 4) TEST DE EXCEPCIÓN: ENVÍO DUPLICADO ===");
        try {
            // Volvemos a intentar el mismo envío del punto 2 (cliente1 con un paquete de 500.0). Exeception
            sistema.agregarEnvioNacional(cliente1, camionChico, 500.0, 350, "Córdoba");
            System.out.println("-> Alerta: El sistema permitió duplicar el envío.");
        } catch (Exception e) {
            System.out.println("Excepción esperada correctamente: " + e.getMessage());
        }
        
        System.out.println("\n=== 5) CARGA DE ENVÍOS ADICIONALES PARA NUEVOS CU ===");
        try {

            sistema.agregarEnvioInternacional(cliente2, camionGrande, 400.0, 800, "Chile", false);
            sistema.agregarEnvioNacional(cliente1, camionGrande, 600.0, 200, "Rosario");
            sistema.agregarEnvioInternacional(cliente3, camionMediano, 900.0, 1200, "China", true);
            
            System.out.println("-> Envíos adicionales cargados con éxito.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== 6) TEST CU: ENVÍOS INTERNACIONALES ESPECIALES ===");
        List<EnvioInternacional> especiales = sistema.traerEnviosInternacionalesEspeciales();
        System.out.println("Cantidad de envíos especiales encontrados (Esperado: 2): " + especiales.size());
        for (EnvioInternacional ei : especiales) {
            System.out.println(ei.toString());
        }

        System.out.println("\n=== 7) TEST CU: CARGA ACTUAL DE CAMIONES ===");
        
        double cargaGrande = sistema.calcularCargaActualDeCamion("BBB222");
        double cargaChico = sistema.calcularCargaActualDeCamion("AAA111");
        double cargaMediano = sistema.calcularCargaActualDeCamion("CCC333");
        
        System.out.println("Carga total del camión chico AAA111 (Esperado: 500.0): " + cargaChico + " Kg");
        System.out.println("Carga total del camión grande BBB222 (Esperado: 2500.0): " + cargaGrande + " Kg");
        System.out.println("Carga total del camión mediano CCC333 (Esperado: 900.0): " + cargaMediano + " Kg");
		
	}

}

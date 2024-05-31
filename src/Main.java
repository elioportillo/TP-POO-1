import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner opcion = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        menuPrincipal(opcion, listaClientes);
    }

    public static void menuPrincipal(Scanner entrada, List<Cliente> listaClientes) {
        boolean salir = false;
        while (!salir) {
            System.out.println("Menú Principal\n");
            System.out.println("1- Crear una cuenta");
            System.out.println("2- Ya tengo una cuenta");
            System.out.println("0- Salir\n");
            System.out.print("Seleccione una opción: ");
            

            int opcion = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcion) {
                case 1:
                    Cliente nuevoCliente = Cliente.crearCliente(entrada, listaClientes);
                    if (nuevoCliente != null) {
                        System.out.println("Cliente creado: " + nuevoCliente);
                    }
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada: Ya tengo una cuenta.");
                    System.out.print("Ingrese el Email: ");
                    String email = entrada.nextLine();
                    System.out.print("Ingrese el Password: ");
                    String password = entrada.nextLine();
                    Cliente clienteEncontrado = Cliente.buscarCliente(email, password, listaClientes);
                    if (clienteEncontrado != null) {
                        System.out.println("Cliente encontrado: " + clienteEncontrado);
                        clienteOpciones(entrada, clienteEncontrado);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.\n\n");
                    break;
            }
        }
    }
    
    
    // Dejaré acá por el momento la función con las opciones
    
    public static void clienteOpciones(Scanner entrada, Cliente cliente) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú de opciones: \n");
            System.out.println("1 - Realizar reserva");
            System.out.println("2 - Realizar consulta");
            System.out.println("3 - Cancelar reserva");
            System.out.println("0 - Salir a Menú Principal\n");
            System.out.print("Ingrese una opción: ");
            System.out.println("\n");
            
            int opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    menuProductos(entrada);
                    break;
                case 2:
                    System.out.println("Esto representa la parte de realizar consultas");
                    break;
                case 3:
                    System.out.println("Esto representa la parte de cancelar reservas");
                    break;
                case 0:
                    salir = true;
                    System.out.println("Regresando al menú...");
                    break;
                default:
                    System.out.println("Error, ingrese una opción válida");
                    break;
            }
        }
        
        
    }
    
    public static void menuProductos(Scanner entrada) {
    	System.out.println("1- Pasaje");
        System.out.println("2- Experiencia");
        System.out.println("3- Day Tour");
        System.out.println("4- Paquete\n");
        System.out.print("Seleccione su producto: ");
        System.out.println("\n");
        int opcionProducto = entrada.nextInt();
        entrada.nextLine();
        switch (opcionProducto) {
            case 1:
                // Lógica para seleccionar un pasaje
                Pasaje pasaje = new Pasaje("Nombre del pasaje", 0, null, "", "", "", "",0);
                pasaje.crearPasaje(entrada);
                break;
            case 2:
                // Lógica para seleccionar una experiencia
            	 Experiencia experiencia = new Experiencia("", 0, "", "");
 	             experiencia = experiencia.crearExperiencia(entrada);
 	             break; 	            
            case 3:
                // Lógica para seleccionar un Day Tour
                System.out.println("Seleccionaste un Day Tour");
                break;
            case 4:
                // Lógica para seleccionar un paquete
                System.out.println("Seleccionaste un paquete");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                break;
        }
        
}
    
}

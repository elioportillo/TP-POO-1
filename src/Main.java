import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner opcion = new Scanner(System.in);
        List<Cliente> listaClientes = new ArrayList<>();
        
        // Crear un cliente predefinido
        Cliente clienteEjemplo = null;
        try {
            clienteEjemplo = new Cliente(
                1,  // ID del cliente
                false,  // Tipo de cliente VIP (false para no VIP, true para VIP)
                "Juan",  // Nombre del cliente
                "Perez",  // Apellido del cliente
                "12345678",  // DNI del cliente
                "Calle Falsa 123",  // Domicilio del cliente
                new Fecha("01/01/1990"),  // Fecha de nacimiento del cliente
                0,  // Incumplimientos del cliente
                "test",  // Email del cliente
                "123"  // Contraseña del cliente
            );
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha de nacimiento del cliente: " + e.getMessage());
        }

        if (clienteEjemplo != null) {
            listaClientes.add(clienteEjemplo); // Agregar el cliente predefinido a la lista de clientes
        }

        // Crear listas de experiencias y pasajes
        List<Experiencia> listaExperiencias = new ArrayList<>();
        listaExperiencias.add(new Experiencia("Playa del Carmen", 100.0, "Una experiencia inolvidable en la playa", "Vacaciones"));
        listaExperiencias.add(new Experiencia("Montañas Rocosas", 200.0, "Aventura en las montañas", "Aventura"));
        listaExperiencias.add(new Experiencia("Amazonas", 150.0, "Exploración en la selva", "Exploración"));

        List<Pasaje> listaPasajes = new ArrayList<>();
        listaPasajes.add(new Pasaje("Pasaje a Argentina", 300.0, new Fecha("15/06/2024"), "Nueva York", "10:00", "18:00", "A1", 0));
        listaPasajes.add(new Pasaje("Pasaje a Uruguay", 450.0, new Fecha("20/07/2024"), "París", "12:00", "20:00", "B2", 0));

        menuPrincipal(opcion, listaClientes, listaExperiencias, listaPasajes);
    }

    public static void menuPrincipal(Scanner entrada, List<Cliente> listaClientes, List<Experiencia> listaExperiencias, List<Pasaje> listaPasajes) {
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
                        clienteOpciones(entrada, clienteEncontrado, listaExperiencias, listaPasajes);
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

    public static void clienteOpciones(Scanner entrada, Cliente cliente, List<Experiencia> listaExperiencias, List<Pasaje> listaPasajes) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú de opciones: \n");
            System.out.println("1 - Realizar reserva");
            System.out.println("2 - Realizar consulta");
            System.out.println("3 - Cancelar reserva");
            System.out.println("4 - Métodos de pago");
            System.out.println("5 - Mis reservas");
            System.out.println("0 - Salir a Menú Principal\n");
            System.out.print("Ingrese una opción: ");

            int opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    menuProductos(entrada, cliente, listaExperiencias, listaPasajes);
                    break;
                case 2:
                    System.out.println("Esto representa la parte de realizar consultas");
                    break;
                case 3:
                    System.out.println("Esto representa la parte de cancelar reservas");
                    break;
                case 4:
                    menuMetodoPago(entrada, cliente);
                    break;
                case 5:
                    menuReservas(entrada, cliente);
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

    public static void menuProductos(Scanner entrada, Cliente cliente, List<Experiencia> listaExperiencias, List<Pasaje> listaPasajes) {
        System.out.println("1- Pasaje");
        System.out.println("2- Experiencia");
        System.out.println("3- Day Tour");
        System.out.println("4- Paquete\n");
        System.out.print("Seleccione su producto: ");

        int opcionProducto = entrada.nextInt();
        entrada.nextLine();
        switch (opcionProducto) {
            case 1:
                // Mostrar lista de pasajes
                System.out.println("Lista de Pasajes Disponibles:");
                for (int i = 0; i < listaPasajes.size(); i++) {
                    System.out.println((i + 1) + ". " + listaPasajes.get(i).toString());
                }
                System.out.print("Seleccione el pasaje que desea reservar: ");
                int seleccionPasaje = entrada.nextInt();
                entrada.nextLine();
                if (seleccionPasaje > 0 && seleccionPasaje <= listaPasajes.size()) {
                    Pasaje pasaje = listaPasajes.get(seleccionPasaje - 1);
                    Pago pagoPasaje = new Pago(cliente);
                    try {
                        pagoPasaje.seleccionarMetodoDePago(entrada);
                        Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", new Fecha("01/06/2024"), pasaje.getPrecio());
                        nuevaReserva.agregarProducto(pasaje);
                        cliente.agregarReserva(nuevaReserva);
                        System.out.println("Reserva realizada para: " + pasaje.getNombre());
                        System.out.println("¡Gracias por elegir Buquealtoque!");
                    } catch (Exception e) {
                        System.out.println("Error al realizar el pago: " + e.getMessage());
                        System.out.println("La reserva no ha podido realizarse.");
                    }
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
                break;
            case 2:
                // Mostrar lista de experiencias
                System.out.println("Lista de Experiencias Disponibles:");
                for (int i = 0; i < listaExperiencias.size(); i++) {
                    System.out.println((i + 1) + ". " + listaExperiencias.get(i).toString());
                }
                System.out.print("Seleccione la experiencia que desea reservar: ");
                int seleccionExperiencia = entrada.nextInt();
                entrada.nextLine();
                if (seleccionExperiencia > 0 && seleccionExperiencia <= listaExperiencias.size()) {
                    Experiencia experiencia = listaExperiencias.get(seleccionExperiencia - 1);
                    Pago pagoExperiencia = new Pago(cliente);
                    try {
                        pagoExperiencia.seleccionarMetodoDePago(entrada);
                        Reserva nuevaReserva = new Reserva(cliente.getNombre() + ' ' + cliente.getApellido(), 1, "Hecha", new Fecha("01/06/2024"), experiencia.getPrecio());
                        nuevaReserva.agregarProducto(experiencia);
                        cliente.agregarReserva(nuevaReserva);
                        System.out.println("Reserva realizada para: " + experiencia.getNombre());
                        System.out.println("¡Gracias por elegir Buquealtoque!");
                    } catch (Exception e) {
                        System.out.println("Error al realizar el pago: " + e.getMessage());
                        System.out.println("La reserva no ha podido realizarse.");
                    }
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
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

    public static void menuMetodoPago(Scanner entrada, Cliente cliente) {
        System.out.println("1- Añadir una tarjeta");
        System.out.println("2- Añadir una cuenta bancaria");
        System.out.println("3- Añadir mercado pago");
        System.out.print("Ingrese una opción: ");

        int opcionMetodoPago = entrada.nextInt();
        entrada.nextLine();
        switch (opcionMetodoPago) {
            case 1:
                //Lógica para añadir una tarjeta al cliente
                Tarjeta nuevaTarjeta = Tarjeta.crearTarjeta(entrada);
                cliente.agregarTarjeta(nuevaTarjeta);
                System.out.println("Tarjeta agregada al cliente: " + nuevaTarjeta);
                break;
            case 2:
                //Lógica para añadir una cuenta bancaria al cliente
                CuentaBancaria nuevaCuentaBancaria = CuentaBancaria.crearCuentaBancaria(entrada);
                cliente.agregarCuentaBancaria(nuevaCuentaBancaria);
                System.out.println("Cuenta bancaria agregada al cliente: " + nuevaCuentaBancaria);
                break;
            default:
                System.out.println("Opcion no válida. Por favor, seleccione una opción válida.");
                break;
        }
    }

    public static void menuReservas(Scanner entrada, Cliente cliente) {
        Cliente.mostrarReservas(cliente.getReservas());
    }
}

import java.util.Calendar;
import java.util.Scanner;

public class Pasaje extends Producto {
    private Fecha fecha;
    private String horaSalida;
    private String horaLlegada;
    private String origen;
    private String destino;
    private int cantidadPasajeros; // Nueva variable para la cantidad de pasajeros

    // Constructor
    Pasaje(String nombre, double precio, Fecha fecha, String horaSalida, String horaLlegada, String origen, String destino, int cantidadPasajeros) {
        super(nombre, precio);
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.origen = origen;
        this.destino = destino;
        this.cantidadPasajeros = cantidadPasajeros; // Asignar la cantidad de pasajeros
    }

    // Getters específicos
    public Fecha getFecha() {
        return fecha;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }
    
    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void mostrarProductos() {
        System.out.println("1- Pasaje desde Argentina a Uruguay");
        System.out.println("2- Pasaje desde Uruguay a Argentina");
    }

    public void crearPasaje(Scanner entrada) {
        mostrarProductos();
        System.out.println("Seleccione su destino: ");
        int opcion = entrada.nextInt();
        entrada.nextLine(); // Limpiar el buffer del scanner
        switch (opcion) {
            case 1:
                // Lógica para la opción 1                                     
                Fecha fechaPasaje1 = null;
                while(fechaPasaje1 == null) {
                    System.out.print("Ingrese la Fecha para su pasaje: (dd/MM/aaaa): ");
                    fechaPasaje1 = Fecha.obtenerFecha(entrada.nextLine());
                }
                if (fechaPasaje1 != null) {
                    int añoPasaje1 = fechaPasaje1.getAño();
                    int mesPasaje1 = fechaPasaje1.getMes();
                    int diaPasaje1 = fechaPasaje1.getDia();

                    Calendar fechaPasaje = Calendar.getInstance();
                    fechaPasaje.set(añoPasaje1, mesPasaje1 - 1, diaPasaje1); // Restamos 1 al mes porque en Calendar, enero es 0
                    Calendar fechaActual = Calendar.getInstance();
                    fechaActual.add(Calendar.YEAR, 0);
                    if (fechaPasaje.before(fechaActual)) {
                        System.out.println("No puede ingresar un día que ya pasó.");
                        return;
                    }
                }
               
           
                System.out.print("Ingrese la cantidad de pasajeros: ");
                int cantidadPasajeros1 = entrada.nextInt();
                entrada.nextLine(); // Limpiar el buffer del scanner
                
                Pasaje pasajeAU = new Pasaje("Pasaje de Argentina a Uruguay", 100.0, fechaPasaje1, "08:00", "10:00", "Argentina", "Uruguay", cantidadPasajeros1);
                mostrarPasaje(pasajeAU);
                break;
            case 2:
                // Lógica para la opción 2
            	Fecha fechaPasaje2 = null;
                while(fechaPasaje2 == null) {
                    System.out.print("Ingrese la Fecha para su pasaje: (dd/MM/aaaa): ");
                    fechaPasaje2 = Fecha.obtenerFecha(entrada.nextLine());
                }
                if (fechaPasaje2 != null) {
                    int añoPasaje2 = fechaPasaje2.getAño();
                    int mesPasaje2 = fechaPasaje2.getMes();
                    int diaPasaje2 = fechaPasaje2.getDia();

                    Calendar fechaPasaje = Calendar.getInstance();
                    fechaPasaje.set(añoPasaje2, mesPasaje2 - 1, diaPasaje2); // Restamos 1 al mes porque en Calendar, enero es 0
                    Calendar fechaActual2 = Calendar.getInstance();
                    fechaActual2.add(Calendar.YEAR, 0);
                    if (fechaPasaje.before(fechaActual2)) {
                        System.out.println("No puede ingresar un día que ya pasó.");
                        return;
                    }
                }
                
                System.out.print("Ingrese la cantidad de pasajeros: ");
                int cantidadPasajeros2 = entrada.nextInt();
                entrada.nextLine(); // Limpiar el buffer del scanner
                
                Pasaje pasajeUA = new Pasaje("Pasaje de Uruguay a Argentina", 100.0, fechaPasaje2, "08:00", "10:00", "Uruguay", "Argentina", cantidadPasajeros2);
                mostrarPasaje(pasajeUA);
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                break;
        }
    }
    
    // Método para mostrar el pasaje creado
    private void mostrarPasaje(Pasaje pasaje) {
        System.out.println("Pasaje creado:");
        System.out.println("Nombre: " + pasaje.getNombre());
        System.out.println("Precio: " + pasaje.getPrecio());
        System.out.println("Fecha de Pasaje: " + pasaje.getFecha());
        System.out.println("Cantidad de pasajeros: " + pasaje.getCantidadPasajeros());
        System.out.println("Origen: " + pasaje.getOrigen());
        System.out.println("Destino: " + pasaje.getDestino());
    }
}

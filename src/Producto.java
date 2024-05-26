import java.util.Scanner;

// Clase principal Producto
public abstract class Producto {
    private String nombre;
    private double precio;

    // Constructor
    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    // Método abstracto para mostrar productos
    public abstract void mostrarProductos();

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    public static void seleccionarProducto(Scanner entrada) {
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
                System.out.println("Seleccionaste una experiencia");
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


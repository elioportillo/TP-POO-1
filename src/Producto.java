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
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public static Producto seleccionarProducto(Scanner entrada) {
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
	            return pasaje;
	        case 2:
	            Experiencia experiencia = new Experiencia("", 0, "", "");
	            experiencia = experiencia.crearExperiencia(entrada);
	            return experiencia;
	        case 3:
	            // Lógica para seleccionar un Day Tour
	            DayTour dayTour = new DayTour("Nombre del Day Tour", 0);
	            dayTour.mostrarProductos();
	            return dayTour;
	        case 4:
	            // Lógica para seleccionar un paquete
	            Paquete paquete = new Paquete("Nombre del paquete", 0);
	            paquete.mostrarProductos();
	            return paquete;
	        default:
	            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
	            return null;
        }
        
}

}


import java.util.Scanner;
class Experiencia extends Producto {
    private String lugar;
    private String descripcion;

    // Constructor
    public Experiencia(String nombre, double precio, String lugar, String descripcion) {
        super(nombre, precio);
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    // Getters específicos
    public String getLugar() {
        return lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Experiencia - " + getNombre();
    }

    // Método para mostrar las opciones de experiencia
    public void mostrarProductos() {
        System.out.println("Opciones de Experiencia:");
        System.out.println("1- Experiencia en Argentina");
        System.out.println("2- Experiencia en Uruguay");
    }

	
 // Método para crear una experiencia y devolver la instancia creada
    public Experiencia crearExperiencia(Scanner entrada) {
        mostrarProductos(); // Mostrar las opciones de experiencia
        System.out.print("Seleccione su experiencia: ");
        int opcion = entrada.nextInt();
        entrada.nextLine(); // Limpiar el buffer del scanner
        
        Experiencia experiencia = null;

        switch (opcion) {
            case 1:
                System.out.println("Ingrese la descripción de la experiencia en Argentina:");
                String descripcionArgentina = entrada.nextLine();
                experiencia = new Experiencia("Experiencia en Argentina", 100.0, "Argentina", descripcionArgentina);
                mostrarExperiencia(experiencia);
                break;
            case 2:
                System.out.println("Ingrese la descripción de la experiencia en Uruguay:");
                String descripcionUruguay = entrada.nextLine();
                experiencia = new Experiencia("Experiencia en Uruguay", 100.0, "Uruguay", descripcionUruguay);
                mostrarExperiencia(experiencia);
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
        
        return experiencia;
    }








    // Método para mostrar la experiencia creada
    public void mostrarExperiencia(Experiencia experiencia) {
        System.out.println("Experiencia creada:");
        System.out.println("Nombre: " + experiencia.getNombre());
        System.out.println("Precio: " + experiencia.getPrecio());
        System.out.println("Lugar: " + experiencia.getLugar());
        System.out.println("Descripción: " + experiencia.getDescripcion());
    }
}
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int idReserva;
    private String clienteNombre;
    private int cantidadBodega;
    private String estadoReserva;
    private Fecha fecha;
    private double valorFinal;
    private List<Producto> productos;
    private static int contadorId = 1;

    // Constructor
    public Reserva(String clienteNombre, int cantidadBodega, String estadoReserva, Fecha fecha, double valorFinal) {
        this.idReserva = contadorId++;
        this.clienteNombre = clienteNombre;
        this.cantidadBodega = cantidadBodega;
        this.estadoReserva = estadoReserva;
        this.fecha = fecha;
        this.valorFinal = valorFinal;
        this.productos = new ArrayList<>();
    }

    // Getters y setters
    public int getIdReserva() {
        return idReserva;
    }

    public int getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public String toString() {
        return "ID de Reserva = " + idReserva +
                ", Cliente = " + clienteNombre +
                ", Cantidad bodega = " + cantidadBodega +
                ", Productos = " + productos +
                ", Estado de la reserva = " + estadoReserva +
                ", Fecha = " + fecha +
                ", Valor final = " + valorFinal + "\n";
    }
    
    public Reserva crearReserva(Cliente cliente, Producto producto) {
        int cantidadBodega = 1;
        String estadoReserva = "Hecha";
        Fecha fecha = null;
        try {
            fecha = new Fecha("01/06/2024"); // Crear una nueva fecha (o recibirla como parámetro)
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Reserva nuevaReserva = new Reserva(cliente.getNombre(), cantidadBodega, estadoReserva, fecha, producto.getPrecio() + 200.0);
        nuevaReserva.agregarProducto(producto);
        return nuevaReserva;
    }

    
    
}
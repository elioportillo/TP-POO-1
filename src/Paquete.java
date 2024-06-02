import java.util.ArrayList;
import java.util.List;

public class Paquete extends Producto {
	private String hotel;
	private List<Producto> productos;
	
	// Constructor
	Paquete(String nombre, double precio, String hotel) {
		super(nombre, precio);
		this.hotel = hotel;
		this.productos = new ArrayList<>();
	}
	
	//Getters y setter
	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
    @Override
    public String toString() {
        return "Paquete - " + getNombre();
    }
 
	public void mostrarProductos(){
		System.out.println("Paquete de viajes en Argentina");
		System.out.println("Paquete de viajes en Uruguay");
	}

}